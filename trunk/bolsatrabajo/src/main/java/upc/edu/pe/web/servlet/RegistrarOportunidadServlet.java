package upc.edu.pe.web.servlet;

import java.io.IOException;
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
import upc.edu.pe.web.comun.Constantes;

/**
 * Servlet implementation class BuscarEmpresaServlet
 */
@WebServlet("/BuscarEmpresaServlet")
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
		aviso.setcargo(request.getParameter("cargo"));
		aviso.setfechaInicio(request.getParameter("fechainicio"));
		aviso.setfechaFin(request.getParameter("fechafin"));
		aviso.setdescripcion(request.getParameter("descripcion"));
		aviso.setjornadaLaboral(request.getParameter("jornada"));
		aviso.setdisponibilidad(request.getParameter("disponibilidad"));
		aviso.setrequerimiento(request.getParameter("requerimiento"));
		aviso.setbeneficios(request.getParameter("beneficios"));
		aviso.setsueldo(request.getParameter("sueldo"));
		aviso.setestado("1");
		aviso.setcontadorVisitas("0");
		aviso.setespecialidad(request.getParameter("especialidad"));
		aviso.settotalPostulantes("0");
		
		RegistroAvisoDao registroAvisoDao = new RegistroAvisoDao();
		try{
			if (registroAvisoDao.registrarAviso(aviso, "1")){
				RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
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
