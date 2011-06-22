package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import upc.edu.pe.dao.consulta.ConsultaDetalleAvisoPostulanteDao;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.DetalleAvisoPostulante;
import upc.edu.pe.model.Persona;
import upc.edu.pe.web.comun.Constantes;

@WebServlet("/BuscarPostulanteCriterioServlet")
public class BuscarPostulanteCriterioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPostulanteCriterioServlet() {
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
		
		ConsultaDetalleAvisoPostulanteDao cdapDAO = new ConsultaDetalleAvisoPostulanteDao();
		DetalleAvisoPostulante dap = new DetalleAvisoPostulante();
		Aviso aviso = new Aviso();
		Persona persona = new Persona();
		int edad=0;
		double sueldo=0;
		
		try {
			System.out.println("***** BuscarPostulanteCriterioServlet *****");
			
			if(request.getParameter("txtEdad")!=null){
				edad = Integer.valueOf(request.getParameter("txtEdad")).intValue();
			}
			if((request.getParameter("txtSalario")!=null)||(request.getParameter("txtSalario")!="")){
				sueldo = Double.valueOf(request.getParameter("txtSalario")).doubleValue();
				persona.setSalario(new BigDecimal(sueldo));
			}
			if((request.getParameter("optAviso")!=null) || (request.getParameter("optAviso")!="")){
				dap.setId_avi(Integer.valueOf(request.getParameter("optAviso")).intValue());
			}
			if(request.getParameter("optDisponibilidad")!=null){
				persona.setDisponibilidad(request.getParameter("optDisponibilidad"));
			}
			System.out.println("edad : "+edad);
			System.out.println("sueldo : "+sueldo);
			System.out.println("aviso : "+request.getParameter("optAviso"));
			System.out.println("disponibilidad : "+request.getParameter("optDisponibilidad"));
						
			dap.setAviso(aviso);			
			dap.setPersona(persona);			
			
			List<DetalleAvisoPostulante> listaAvisoPostulante = cdapDAO.buscarPostulantesAviso(dap, edad);
			System.out.println("listaAvisoPostulante : "+listaAvisoPostulante.size());
			request.setAttribute(Constantes.SESSION_LISTA_AVISO_POSTULANTE, listaAvisoPostulante);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pages/busquedaPostulanteCriterio.jsp");
			rd.forward(request, response);			
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		}
	}
}
