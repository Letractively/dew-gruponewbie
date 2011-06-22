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
		String x = request.getParameter("razonsocial");
		String y = request.getParameter("nrodocumento");

		Ofertante r = new Ofertante();
		r.setRazonSocial(x);
		r.setNumeroDocumento(y);
		
		RegistroOfertanteDao dao = new RegistroOfertanteDao();
		try {
			dao.registrarOfertante(r);
			response.sendRedirect(request.getContextPath()
					+ "/RolBuscarServlet");
		} catch (DAOExcepcion e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	
	}

}