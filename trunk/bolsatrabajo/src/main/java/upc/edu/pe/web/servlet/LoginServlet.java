package upc.edu.pe.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import upc.edu.pe.dao.consulta.ConsultaEmpresaDao;
import upc.edu.pe.dao.consulta.ConsultaPostulanteDao;
import upc.edu.pe.dao.consulta.ConsultaUsuarioLoginDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Ofertante;
import upc.edu.pe.model.Persona;
import upc.edu.pe.model.Solicitante;
import upc.edu.pe.model.TipoUsuario;
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String nombreUsuario = request.getParameter("usuario");
		String contrasenha = request.getParameter("clave");

		ConsultaUsuarioLoginDao consultaUsuarioDao = new ConsultaUsuarioLoginDao();

		try {
			Persona per = consultaUsuarioDao.validarUsuarioLogin(nombreUsuario, contrasenha);
			TipoUsuario tipoUsuario=null; 
			
			HttpSession session = request.getSession();
			//Existe usuario
			if (per!=null){
				tipoUsuario = new TipoUsuario();
				tipoUsuario.setIdTipoUsuario(per.getTipoUsuario().getIdTipoUsuario());
				
				//Verificar, que tipo de usuario
				if (per.getTipoPersona().equals(Constantes.C_PERSONA_NATURAL)){
					Solicitante sol = new Solicitante();
					sol.setId(per.getId());
					
					ConsultaPostulanteDao postDao = new ConsultaPostulanteDao();
					sol = postDao.obtenerDatosPersonales(sol);
					session.setAttribute(Constantes.SESSION_USUARIO, sol);
				}else{
					Ofertante ofer = new Ofertante();
					ofer.setId(per.getId());
					ConsultaEmpresaDao empDao = new ConsultaEmpresaDao();
					ofer = empDao.obtenerDatosEmpresa(ofer);
					session.setAttribute(Constantes.SESSION_USUARIO, ofer);
				}
				
				session.setAttribute(Constantes.SESSION_TIPO_USUARIO, tipoUsuario);
				
			}
			
			//response.sendRedirect("PortadaServlet");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/principal.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}

}
