package upc.edu.pe.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.registro.RegistroOfertanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Ofertante;
import upc.edu.pe.model.TipoUsuario;
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class RegistrarEmpresaServlet
 */
@WebServlet("/RegistrarEmpresaServlet")
public class RegistrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nSocial = request.getParameter("txtRazonSocial");
		String email = request.getParameter("txtEmail");
		String clave = request.getParameter("txtPassword");		
		String tipDoc = request.getParameter("idTipoDoc");
		String nRuc = request.getParameter("txtRuc");		
		String Fijo = request.getParameter("txtTelefonoFijo");		
		String tipPer = request.getParameter("tipoPer");		
				
		Ofertante r = new Ofertante();
		r.setRazonSocial(nSocial);		
		r.setCorreo(email);
		r.setContrasenhia(clave);		
		r.setTipoDocumento(tipDoc);	
		r.setNumeroDocumento(nRuc);		
		r.setTelefono(Fijo);		
		r.setTipoPersona(tipPer);
		TipoUsuario tipousuario = new TipoUsuario();
		tipousuario.setIdTipoUsuario(1);
		r.setTipoUsuario(tipousuario);
			
		RegistroOfertanteDao dao = new RegistroOfertanteDao();
		try {
			r.setId(dao.registrarOfertante(r));
			//response.sendRedirect(request.getContextPath()+ "/RolBuscarServlet");
			System.out.println("Se registró el Solicitante correctamente:-->"+r.toString());
			response.sendRedirect(request.getContextPath()+"/LoginServlet?usuario="+r.getCorreo()+"&clave="+r.getContrasenhia());
		} catch (DAOExcepcion e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	
	}

}
