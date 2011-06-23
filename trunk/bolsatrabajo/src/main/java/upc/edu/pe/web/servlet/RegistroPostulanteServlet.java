package upc.edu.pe.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.registro.RegistroPostulanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Distrito;
import upc.edu.pe.model.Solicitante;
import upc.edu.pe.model.TipoUsuario;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

/**
 * Servlet implementation class RegistroPostulanteServlet
 */
@WebServlet("/RegistroPostulanteServlet")
public class RegistroPostulanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroPostulanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Solicitante solicitante = new Solicitante();
		boolean flagError=false;
		String contrasenha =request.getParameter("contrasena").toString();
		String contrasenha2=request.getParameter("confircontrasena").toString();
		
		if(request.getParameter("correo")==""){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "Debe ingresar correo");
			flagError=true;
		}
		solicitante.setCorreo(request.getParameter("correo"));
		//validar claves
		if(!contrasenha.equalsIgnoreCase(contrasenha2) && !flagError){
			//Error claves
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "Las contraseñas son diferentes");
			flagError=true;
		}
		
		if(contrasenha.length()<3 && !flagError){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "La contraseña debe tener mínimo 4 caracteres.");
			flagError=true;
		}
		solicitante.setContrasenhia(request.getParameter("contrasena"));
		
		if(request.getParameter("nombre")=="" && !flagError){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "Debe ingresar nombre.");
			flagError=true;
		}
		solicitante.setNombre(request.getParameter("nombre"));
		
		if(request.getParameter("apepat")=="" && !flagError){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "Debe ingresar apellido paterno.");
			flagError=true;
		}
		solicitante.setApellidoPaterno(request.getParameter("apepat"));
		solicitante.setApellidoMaterno(request.getParameter("apemat"));
		solicitante.setDireccion(request.getParameter("direccion"));
		solicitante.setSexo(request.getParameter("sexo"));
		solicitante.setTelefono(request.getParameter("telefono"));
		solicitante.setCelular(request.getParameter("celular"));
		
		if(request.getParameter("numdoc")=="" && !flagError){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "Debe ingresar número de documento.");
			flagError=true;
		}
		solicitante.setNumeroDocumento(request.getParameter("numdoc"));
		
		if(request.getParameter("distrito")=="" && !flagError){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "Debe seleccionar un Distrito");
			flagError=true;
		}else{
			Distrito dis = new Distrito();
			dis.setId_distrito(request.getParameter("distrito"));
			solicitante.setDistrito(dis);
		}
		if(request.getParameter("fecnac").length()<10 && !flagError){
			request.setAttribute(Constantes.C_MENSAJE_ERROR, "La fecha debe tener 10 dígitos bajo el siguiente formato dd/mm/yyyy");
			flagError=true;
		}
		if(!flagError){
			try{
				HelperDate.parseaDate(request.getParameter("fecnac"),Constantes.FORMATO_FECHA_VIEW);
				solicitante.setFechaNacimiento(HelperDate.parseaDate(request.getParameter("fecnac"),Constantes.FORMATO_FECHA_VIEW));
			} catch (Exception e) {		
				request.setAttribute(Constantes.C_MENSAJE_ERROR, "Formato de fecha erronero debe ser dd/mm/yyyy");
				flagError=true;
			}
		}
		
		if(flagError){
			solicitante.setContrasenhia("");
			request.setAttribute(Constantes.SESSION_POSTULANTE, solicitante);
			redireccion(request,response);
			return;
		}
		
		solicitante.setTipoPersona(Constantes.C_PERSONA_NATURAL);
		solicitante.setTipoDocumento(Constantes.C_TIPO_DOCUMENTO_DNI);
		TipoUsuario tipousuario = new TipoUsuario();
		tipousuario.setIdTipoUsuario(2);
		solicitante.setTipoUsuario(tipousuario);
		
		//Enviamos los datos a la capa service
		RegistroPostulanteDao registroPosDao = new RegistroPostulanteDao();
		try {
			int idPersona = registroPosDao.registrarSolicitante(solicitante);
			solicitante.setId(idPersona);
			System.out.println("Se registró el Solicitante correctamente:-->"+solicitante.toString());
			response.sendRedirect(request.getContextPath()+"/LoginServlet?usuario="+solicitante.getCorreo()+"&clave="+solicitante.getContrasenhia());
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	
	private void redireccion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/registroPostulante.jsp");
		rd.forward(request, response);
	}

}
