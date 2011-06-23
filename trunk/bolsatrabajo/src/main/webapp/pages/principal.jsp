<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.TipoUsuario" %>
<%@page import="upc.edu.pe.model.Ofertante" %>
<%@page import="upc.edu.pe.model.Solicitante" %>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
<body>


	<table align="center" width="500" border="1">
		<tr>
		<td></td>
		</tr>
		<tr>
			<td align="right"><b class="texto_grisb14">Bienvenido al sistema:
						<%
 	//Ofertante
	if(tipoUsuario.getIdTipoUsuario()==1) {
		Ofertante ofer=(Ofertante)session.getAttribute(Constantes.SESSION_USUARIO);
		out.print(ofer.getRazonSocial());
	%></b>	
			</td>
		</tr>
	</table>
<br/><br/>
	<table align="center" width="500" >
		<tr>
			<td class="texto_gris13"><a href="<%=request.getContextPath()%>/CargaRegistrarOportunidadServlet">Registrar Oportunidad</a></td>
		</tr>
		<tr>
			<td class="texto_gris13"><a href="<%=request.getContextPath()%>/CargaBuscarPostulanteCriterioServlet">Buscar Postulantes por Criterio</a></td>
		</tr>
		<tr>
			<td class="texto_gris13"><a href="<%=request.getContextPath()%>/CargaEstadisticaPostulacionesServlet">Cantidad de Postulantes por Oferta</a></td>
		</tr>
		<tr>
				<td><a href="index.jsp">Salir</a></td>
		</tr>
	</table>
	
<%//Solicitante
}else if (tipoUsuario.getIdTipoUsuario()==2){
	Solicitante sol=(Solicitante)session.getAttribute(Constantes.SESSION_USUARIO);
	out.print(sol.getNombre()+" "+sol.getApellidoPaterno()+" "+sol.getApellidoMaterno());
	//Imprimir Menú Solicitante
	
%>
<br/><br/>
	<table align="center" width="500">
		<tr>
			<td class="texto_gris13" align="center"><a href="<%=request.getContextPath()%>/CargaBuscarOportunidadServlet">Buscar Oportunidad</a></td>
		</tr>
		<tr>
			<td class="texto_gris13" align="center"><a href="<%=request.getContextPath()%>/BuscarEmpresaServlet">Buscar Empresa por Rubro</a></td>
		</tr>
		<tr>
			<td class="texto_gris13" align="center"><a href="<%=request.getContextPath()%>/PerfilProfesionalServlet">Registrar Perfil Profesional</a></td>
		</tr>
		<tr>
			<td class="texto_gris13" align="center"><a href="<%=request.getContextPath()%>/ExperienciaProfesionalServlet">Registrar Experiencia Profesional</a></td>
		</tr>
		<tr>
			<td class="texto_gris13" align="center"><a href="index.jsp">Salir</a></td>
		</tr>
	</table>
<%//ADMINISTRADOR
}else if (tipoUsuario.getIdTipoUsuario()==3){
	Solicitante sol=(Solicitante)session.getAttribute(Constantes.SESSION_USUARIO);
	out.print(sol.getResumen());
	//Imprimir Menú ADMINISTRADOR
%>
<br/><br/>
	<table align="center" width="500">
		<tr>
			<td class="texto_gris13">Opciones de Men&uacute; ADMINISTRADOR</td>
		</tr>
		<tr>
			<td class="texto_gris13"><a href="<%=request.getContextPath()%>/ListadoPublicidadServlet">Registro de Publicidad</a></td>
		</tr>
	</table>
<%
}
%></b><br/>  
</body>
<!-- <a href="rolBuscar.jsp">Mantenimiento de Roles</a><br/>
<a href="LogoutServlet">Salir del sistema</a> -->
<%@include file="/pages/comun/pie.jsp"%>