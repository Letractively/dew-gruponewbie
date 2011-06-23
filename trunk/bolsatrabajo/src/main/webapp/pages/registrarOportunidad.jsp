<%@include file="/pages/comun/cabecera.jsp"%>
<html>
<head>
<script language="javascript">
function mis_datos(){
var key=window.event.keyCode;
if (key < 48 || key > 57){
window.event.keyCode=0;
}}
</script>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
<form id="form1" name="form1" method="post" action="RegistrarOportunidadServlet">
<table width="800" border="0" align="center">
  <tr>
    <td align="center" class="texto_celeste_titulo">Registrar Oportunidad</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table border=0 align="center">
	<tr>
		<td class="texto_gris">Cargo</td>
		<td><input type="text" name="cargo" value="" size="50" maxlength="100"></td>
	</tr>
	<tr>
		<td class="texto_gris">Fecha inicio:</td>
		<td><input type="text" name="fechainicio" value="" size="50" maxlength="100"></td>
	</tr>
	<tr>
		<td class="texto_gris">Fecha fin:</td>
		<td><input type="text" name="fechafin" value="" size="50" maxlength="100"></td>
	</tr>
	<tr>
		<td class="texto_gris">Descripcion:</td>
		<td><input type="text" name="descripcion" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td class="texto_gris">Jornada Laboral:</td>
		<td>
		<select name="jornada" >
		 	<option value="1">Diurna</option>
			<option value="2">Nocturna</option>
	     </select>
		</td>
	</tr>
	<tr>
		<td class="texto_gris">Disponibilidad:</td>
		<td>
		<select name="disponibilidad" >
		 	<option value="1">Tiempo Completo</option>
			<option value="2">Tiempo Parcial</option>
	     </select>
		</td>
	</tr>
	<tr>
		<td class="texto_gris">Requerimiento:</td>
		<td><input type="text" name="requerimiento" value="" size="20" maxlength="10"></td>
	</tr>
	<tr>
		<td class="texto_gris">Beneficios:</td>
		<td><input type="text" name="beneficios" value="" size="20" maxlength="10"></td>
	</tr>
	<tr class="texto_gris">
		<td>Sueldo:</td>
		<td><input type="text" name="sueldo" value="" size="20"  onKeypress="mis_datos()" maxlength="5"></td>
	</tr>
	<tr>
		<td class="texto_gris">Especialidad:</td>
		<td>
		 <select name="especialidad" >
		 	<option value="1">Administracion</option>
			<option value="7">Ingenieria Industrial</option>
			<option value="17">Tecnologia de Sistemas Informaticos</option>
	     </select>
		</td>
	</tr>
	<tr>
		<td colspan="2"> 
		<label>
	    	<input type="submit" name="button2" value="Registrar" class="texto_gris"/>
	    </label>
    	</td>
	</tr>
</table>
    <table width="800">
    <tr>
    <td class="texto_gris" align="right" colspan="8"><a href="<%=request.getContextPath()%>/pages/principal.jsp">Volver</a></td>
  	</tr>
	</table>
</form>
</body>
<%@include file="/pages/comun/pie.jsp"%>
</html>