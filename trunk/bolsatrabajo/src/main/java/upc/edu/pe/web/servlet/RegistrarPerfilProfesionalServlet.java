package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.registro.RegistroPostulanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.PerfilProfesional;
import upc.edu.pe.model.Solicitante;

/**
 * Servlet implementation class RegistrarPerfilProfesionalServlet
 */
@WebServlet("/RegistrarPerfilProfesionalServlet")
public class RegistrarPerfilProfesionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPerfilProfesionalServlet() {
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
		String tituloProfesional = request.getParameter("tituloProfesional");
		String resumenProfesional = request.getParameter("resumenProfesional");
		String disponibilidad = request.getParameter("disponibilidad");
		String pretencionEco = request.getParameter("pretencionEco");
		int id = Integer.parseInt(request.getParameter("id"));
		Solicitante solicitante =new Solicitante();
		
		
		RegistroPostulanteDao registroPostulanteDao = new RegistroPostulanteDao();
		try {
			PerfilProfesional pp =new PerfilProfesional(); 
			pp.setTituloProfesional(tituloProfesional);
			pp.setResumenProfesional(resumenProfesional);
			pp.setDisponibilidadHoraria(disponibilidad);
			pp.setPretencionEconomica(new BigDecimal(pretencionEco));
			solicitante.setId(id);
			solicitante.setPerfilProfesional(pp);
			int rpta=registroPostulanteDao.registrarPerfilProfesional(solicitante);
			
			if(rpta==1){

				RequestDispatcher rd = request.getRequestDispatcher("/pages/principal.jsp");
				rd.forward(request, response);
			}else{
				System.err.println("Error");
				RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
				rd.forward(request, response);
			}
			return;			
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}

}
