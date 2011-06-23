package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.consulta.ConsultaDistritoDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Distrito;
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class PostulanteServlet
 */
@WebServlet("/PostulanteServlet")
public class PostulanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostulanteServlet() {
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
		
		ConsultaDistritoDao consultaDistritoDao = new ConsultaDistritoDao();
		
		try {
			List<Distrito> lstDistrito = consultaDistritoDao.listar();
			request.getSession().setAttribute(Constantes.SESSION_LISTA_DISTRITO, lstDistrito);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/registroPostulante.jsp");
			rd.forward(request, response);			
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}
}
