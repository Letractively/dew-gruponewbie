package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.consulta.ConsultaPublicidadDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Publicidad;
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class ListadoPublicidadServlet
 */
@WebServlet("/ListadoPublicidadServlet")
public class ListadoPublicidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoPublicidadServlet() {
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
		
		ConsultaPublicidadDao consultaPublicidadDao = new ConsultaPublicidadDao();

		try {
			List<Publicidad> lstPublicidad = consultaPublicidadDao.listarPublicidad();
						
			request.setAttribute(Constantes.SESSION_LISTA_PUBLICIDAD, lstPublicidad);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pages/listadoPublicidad.jsp");
			rd.forward(request, response);
			
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}

}
