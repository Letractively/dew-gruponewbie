<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.TipoUsuario" %>
<%

TipoUsuario tipoUsuario = (TipoUsuario)session.getAttribute(Constantes.SESSION_TIPO_USUARIO);
if (tipoUsuario == null){
	request.getRequestDispatcher("comun/error.jsp").forward(request, response);
	return;
}

%>