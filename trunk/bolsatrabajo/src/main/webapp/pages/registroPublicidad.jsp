<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.HelperDate"%>
<%@page import="upc.edu.pe.model.Publicidad" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>

<%
Publicidad publi = (Publicidad)request.getAttribute(Constantes.SESSION_PUBLICIDAD);
int id=0;
String oper ="";
String descripcion="";
String cuerpo="";
String enlace="";
String fini="";
String ffin="";
String titulo="Registro de Publicidad";
if(publi != null) {
	titulo="Modificaci&oacute;n de Publicidad";
	oper=Constantes.C_OPERACION_MODIFICAR;
	id=publi.getIdpublicidad();
	descripcion=publi.getDescripcion();
	cuerpo=publi.getCuerpo();
	enlace=publi.getEnlace();
	fini=HelperDate.parseDateToString(publi.getFechainicial(),Constantes.FORMATO_FECHA_VIEW);
	ffin=HelperDate.parseDateToString(publi.getFechafin(),Constantes.FORMATO_FECHA_VIEW);
}
%>

<H2><%=titulo %></H2>
<form id="form1" name="form1" method="post" action="RegistroPublicidadServlet">
<table border=0>
	<tr>
		<td  class="texto_gris">Descripci&oacute;n:</td>
		<td><input type="text" name="descripcion" value="<%=descripcion %>" size="50" maxlength="100"></td>
		<td  class="texto_gris">Fecha Inicial(dd/mm/yyyy):</td>
		<td><input type="text" name="finicial" value="<%=fini %>" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td class="texto_gris">Enlace:</td>
		<td><input type="text" name="enlace" value="<%=enlace %>" size="50" maxlength="300"></td>
		<td class="texto_gris">Fecha Final(dd/mm/yyyy):</td>
		<td><input type="text" name="ffinal" value="<%=ffin %>" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td class="texto_gris">Cuerpo:</td>
		<td colspan="3"><textarea rows="4" cols="70" name="cuerpo"><%=cuerpo %></textarea></td>
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