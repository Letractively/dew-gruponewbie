package upc.edu.pe.web.servlet;

import java.io.IOException;

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
@WebServlet("/EditarPublicidadServlet")
public class EditarPublicidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPublicidadServlet() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			Publicidad publicidad = consultaPublicidadDao.obtenerPublicidadPorId(id);
						
			request.setAttribute(Constantes.SESSION_PUBLICIDAD, publicidad);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pages/registroPublicidad.jsp");
			rd.forward(request, response);
			
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}

}
