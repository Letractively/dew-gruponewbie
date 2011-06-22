package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.consulta.ConsultaEmpresaDao;
import upc.edu.pe.dao.consulta.ConsultarIndistriaDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Industria;
import upc.edu.pe.model.Ofertante;
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class BuscarEmpresaServlet
 */
@WebServlet("/BuscarEmpresaServlet")
public class BuscarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarEmpresaServlet() {
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

		ConsultaEmpresaDao consultaEmpresaDao = new ConsultaEmpresaDao();
		ConsultarIndistriaDao ConsultarIndistriaDao = new ConsultarIndistriaDao();
		try {
			List<Ofertante> lstOferta = consultaEmpresaDao.listadoGeneral();
			List<Industria> lstIndustria = ConsultarIndistriaDao.listarIndustria();
		
			request.getSession().setAttribute(Constantes.SESSION_LISTA_INDUSTRIA, lstIndustria);
			request.setAttribute(Constantes.SESSION_LISTA_OFERTANTE, lstOferta);
			//response.sendRedirect("PortadaServlet");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/empresaPorIndustria.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}
}
