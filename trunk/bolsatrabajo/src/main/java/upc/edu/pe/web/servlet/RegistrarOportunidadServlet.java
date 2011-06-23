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

import upc.edu.pe.dao.registro.RegistroAvisoDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.Especialidad;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

/**
 * Servlet implementation class BuscarEmpresaServlet
 */
@WebServlet("/RegistrarOportunidadServlet")
public class RegistrarOportunidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarOportunidadServlet() {
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

		Aviso aviso = new Aviso();
		aviso.setCargo(request.getParameter("cargo"));
		aviso.setFechaInicio(HelperDate.parseaDate(request.getParameter("fechainicio"),Constantes.FORMATO_FECHA_VIEW));
		aviso.setFechaFin(HelperDate.parseaDate(request.getParameter("fechafin"),Constantes.FORMATO_FECHA_VIEW));
		aviso.setDescripcion(request.getParameter("descripcion"));
		aviso.setJornadaLaboral(request.getParameter("jornada"));
		aviso.setDisponibilidad(request.getParameter("disponibilidad"));
		aviso.setRequerimiento(request.getParameter("requerimiento"));
		aviso.setBeneficios(request.getParameter("beneficios"));
		aviso.setSueldo(new BigDecimal(request.getParameter("sueldo")));
		aviso.setEstado("1");
		aviso.setContadorVisitas(0);
		Especialidad especialidad =new Especialidad();
		especialidad.setIdEspecialidad(Integer.valueOf(request.getParameter("especialidad")).intValue());
		aviso.setEspecialidad(especialidad);
		
		
		RegistroAvisoDao registroAvisoDao = new RegistroAvisoDao();
		try{
			if (registroAvisoDao.registrarAviso(aviso, 1)){
				RequestDispatcher rd = request.getRequestDispatcher("/pages/registrarOportunidad.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
				rd.forward(request, response);
			}		
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		}		
	}		
}
