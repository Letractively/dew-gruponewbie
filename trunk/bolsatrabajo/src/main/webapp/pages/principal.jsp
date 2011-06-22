<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.TipoUsuario" %>
<%@page import="upc.edu.pe.model.Ofertante" %>
<%@page import="upc.edu.pe.model.Solicitante" %>

Bienvenido al sistema:  <b>
<%
 	//Ofertante
if(tipoUsuario.getIdTipoUsuario()==1) {
	Ofertante ofer=(Ofertante)session.getAttribute(Constantes.SESSION_USUARIO);
	out.print(ofer.getRazonSocial());
	//Imprimir Menú Ofertante
%>
<br/><br/>
	<table>
		<tr>
			<td>Opciones de Men&uacute; Ofertante</td>
		</tr>
		<tr>
			<td>Opciones 1</td>
		</tr>
		<tr>
			<td>Opciones 2</td>
		</tr>
		<tr>
			<td>Opciones 3</td>
		</tr>
		<tr>
			<td>Opciones 4</td>
		</tr>
	</table>
	
<%//Solicitante
}else if (tipoUsuario.getIdTipoUsuario()==2){
	Solicitante sol=(Solicitante)session.getAttribute(Constantes.SESSION_USUARIO);
	out.print(sol.getNombre()+" "+sol.getApellidoPaterno()+" "+sol.getApellidoMaterno());
	//Imprimir Menú Solicitante
	
%>
<br/><br/>
	<table>
		<tr>
			<td>Opciones de Men&uacute; Solicitante</td>
		</tr>
		<tr>
			<td><a href="<%=request.getContextPath()%>/BuscarEmpresaServlet">Buscar Empresa por Rubro</a></td>
		</tr>
		<tr>
			<td>Opciones 2</td>
		</tr>
		<tr>
			<td>Opciones 3</td>
		</tr>
		<tr>
			<td>Opciones 4</td>
		</tr>
	</table>
<%//ADMINISTRADOR
}else if (tipoUsuario.getIdTipoUsuario()==3){
	Solicitante sol=(Solicitante)session.getAttribute(Constantes.SESSION_USUARIO);
	out.print(sol.getResumen());
	//Imprimir Menú ADMINISTRADOR
%>
<br/><br/>
	<table>
		<tr>
			<td>Opciones de Men&uacute; ADMINISTRADOR</td>
		</tr>
		<tr>
			<td><a href="<%=request.getContextPath()%>/ListadoPublicidadServlet">Registro de Publicidad</a></td>
		</tr>
		<tr>
			<td>Opciones 2</td>
		</tr>
		<tr>
			<td>Opciones 3</td>
		</tr>
		<tr>
			<td>Opciones 4</td>
		</tr>
	</table>
<%
}
%></b><br/>  

<!-- <a href="rolBuscar.jsp">Mantenimiento de Roles</a><br/>
<a href="LogoutServlet">Salir del sistema</a> -->
<%@include file="/pages/comun/pie.jsp"%>