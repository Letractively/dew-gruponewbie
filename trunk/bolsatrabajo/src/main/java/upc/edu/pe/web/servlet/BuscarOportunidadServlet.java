package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.consulta.ConsultaAvisoDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.Especialidad;
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class BuscarIndustriaServlet
 */
@WebServlet("/BuscarOportunidadServlet")
public class BuscarOportunidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarOportunidadServlet() {
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

		String oportunidad = request.getParameter("oportunidad");
		Especialidad esp = new Especialidad();
		esp.setIdEspecialidad(Integer.parseInt(oportunidad));
		ConsultaAvisoDao consultaAvisoDao = new ConsultaAvisoDao();
		//ConsultarIndistriaDao ConsultarIndistriaDao = new ConsultarIndistriaDao();
		try {
			List<Aviso> lstAviso = consultaAvisoDao.listarAvisosPorEspecialidad(esp);
			//List<Industria> lstIndustria = ConsultarIndistriaDao.listarIndustria();
			//HttpSession session = request.getSession();
		
			//request.getSession().setAttribute(Constantes.SESSION_LISTA_INDUSTRIA, lstIndustria);
			request.setAttribute(Constantes.SESSION_LISTA_AVISO, lstAviso);
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
