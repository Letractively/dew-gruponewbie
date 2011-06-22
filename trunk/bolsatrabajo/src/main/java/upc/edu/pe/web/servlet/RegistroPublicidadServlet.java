package upc.edu.pe.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upc.edu.pe.dao.registro.RegistroPublicidadDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Publicidad;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

/**
 * Servlet implementation class RegistroPublicidadServlet
 */
@WebServlet("/RegistroPublicidadServlet")
public class RegistroPublicidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroPublicidadServlet() {
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
		
		Publicidad publicidad = new Publicidad();
		String operacion ="";
		if(Integer.parseInt(request.getParameter("id"))>0){
			publicidad.setIdpublicidad(Integer.parseInt(request.getParameter("id")));
			operacion = request.getParameter("oper");
		}
		if (operacion.equals("") || operacion.equals(Constantes.C_OPERACION_MODIFICAR)){
			publicidad.setDescripcion(request.getParameter("descripcion"));
			publicidad.setEnlace(request.getParameter("enlace"));
			publicidad.setFechainicial(HelperDate.parseaDate(request.getParameter("finicial"),Constantes.FORMATO_FECHA_VIEW));
			publicidad.setFechafin(HelperDate.parseaDate(request.getParameter("ffinal"),Constantes.FORMATO_FECHA_VIEW));
			publicidad.setCuerpo(request.getParameter("cuerpo"));
			publicidad.setEstado(Constantes.C_PUBLICIDAD_PUBLICADO);
		}else{
			publicidad.setEstado(Constantes.C_PUBLICIDAD_NO_PUBLICADO);
		}

		RegistroPublicidadDao registroPublicidadDao = new RegistroPublicidadDao();

		try {
			if(operacion.equals("")){
				if(registroPublicidadDao.registrarPublicidad(publicidad)){
					//Registro satisfactorio
					response.sendRedirect("ListadoPublicidadServlet");
				}
			}else{
				
				if(operacion.equals(Constantes.C_OPERACION_MODIFICAR)){
					if(registroPublicidadDao.modificarPublicidad(publicidad)){
						//Modificación satisfactoria
						response.sendRedirect("ListadoPublicidadServlet");
					}
				}else if(operacion.equals(Constantes.C_OPERACION_ELIMINAR)){
					//registroPublicidadDao;
					if(registroPublicidadDao.anularPublicidad(publicidad)){
						response.sendRedirect("ListadoPublicidadServlet");
					}
				}
				
				
			}
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/comun/error.jsp");
			rd.forward(request, response);
		} 
	}
}
