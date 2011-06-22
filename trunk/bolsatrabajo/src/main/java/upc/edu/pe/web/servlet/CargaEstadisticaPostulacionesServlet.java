package upc.edu.pe.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.consulta.ConsultaEstadisticaAvisoDao;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.DetalleAvisoPostulante;
import upc.edu.pe.web.comun.Constantes;

@WebServlet("/CargaEstadisticaPostulacionesServlet")
public class CargaEstadisticaPostulacionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaEstadisticaPostulacionesServlet() {
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
		ConsultaEstadisticaAvisoDao ceaDAO = new ConsultaEstadisticaAvisoDao();
		Aviso aviso = new Aviso();
		try {
			System.out.println("***** BuscarEstadisticaPostulacionesServlet *****");
			List<Aviso> lstEstadistica = ceaDAO.estadisticaPostulantesAviso(aviso);
			
			System.out.println("lstEstadistica : "+lstEstadistica.size());
			request.setAttribute(Constantes.SESSION_LISTA_ESTADISTICA, lstEstadistica);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pages/busquedaEstadisticaPostulaciones.jsp");
			rd.forward(request, response);			
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		}
	}
}
