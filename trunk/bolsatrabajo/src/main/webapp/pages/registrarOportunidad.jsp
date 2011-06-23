<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>

<H2><%//=titulo %></H2>
<form id="form1" name="form1" method="post" action="RegistrarOportunidadServlet">
<table border=1>
	<tr>
		<td>Cargo</td>
		<td><input type="text" name="cargo" value="" size="50" maxlength="100"></td>
	</tr>
	<tr>
		<td>Fecha inicio:</td>
		<td><input type="text" name="fechainicio" value="" size="50" maxlength="100"></td>
	</tr>
	<tr>
		<td>Fecha fin:</td>
		<td><input type="text" name="fechafin" value="" size="50" maxlength="100"></td>
	</tr>
	<tr>
		<td>Descripcion:</td>
		<td><input type="text" name="descripcion" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td>Jornada Laboral:</td>
		<td><input type="text" name="jornada" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td>Disponibilidad:</td>
		<td><input type="text" name="disponibilidad" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td>Requerimiento;:</td>
		<td><input type="text" name="requerimiento" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td>Beneficios:</td>
		<td><input type="text" name="beneficios" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td>Sueldo:</td>
		<td><input type="text" name="sueldo" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td>Especialidad:</td>
		<td><input type="text" name="especialidad" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td colspan="2">
		<label>
	    	<input type="submit" name="button2" value="Registrar" />
	    </label>
    	</td>
	</tr>
</table>
</form>

<%@include file="/pages/comun/pie.jsp"%>