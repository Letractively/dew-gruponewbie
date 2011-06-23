<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.HelperDate"%>
<%@page import="upc.edu.pe.model.Distrito" %>
<%@page import="upc.edu.pe.model.Solicitante" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="java.util.*" %>

<%
Solicitante postulante = (Solicitante)request.getAttribute(Constantes.SESSION_POSTULANTE);
int id=0;
String oper ="";
String tituloProfesional="";
String resumenProfesional="";
String disponibilidad="";
String pretencionEco="";
if(postulante != null) {
	tituloProfesional=postulante.getPerfilProfesional().getTituloProfesional();
	id=postulante.getId();
	resumenProfesional=postulante.getPerfilProfesional().getResumenProfesional();
	disponibilidad=postulante.getPerfilProfesional().getDisponibilidadHoraria();
	try{
		pretencionEco=postulante.getPerfilProfesional().getPretencionEconomica().toString();		
	}catch(Exception e){
		pretencionEco="";
	}
}

%>

<H2>Perfil Profesional</H2>
<form id="form1" name="form1" method="post" action="RegistrarPerfilProfesionalServlet">
<table border=1>
	<tr>
		<td>Titulo Profesional:</td>
		<td><input type="text" name="tituloProfesional" value="<%=tituloProfesional %>" size="50" maxlength="80"></td>
	</tr>
	<tr>
		<td>Resumen Profesional:</td>
		<td><input type="text" name="resumenProfesional" value="<%=resumenProfesional %>" size="100" maxlength="200"></td>
	</tr>
	<tr>
		<td>Disponibilidad Horaria:</td>
		<td><input type="text" name="disponibilidad" value="<%=disponibilidad %>" size="20" maxlength="50"></td>
	</tr>
	<tr>
		<td>Pretencion Econ&oacute;mica:</td>
		<td><input type="text" name="pretencionEco" value="<%=pretencionEco %>" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td colspan="2">
		<label>
	    	<input type="submit" name="button2" value="Registrar" />
	    </label>
    	</td>
	</tr>
</table>
<input type="hidden" name="id" value="<%=id%>">
<input type="hidden" name="oper" value="<%=oper%>">
</form>

<%@include file="/pages/comun/pie.jsp"%>