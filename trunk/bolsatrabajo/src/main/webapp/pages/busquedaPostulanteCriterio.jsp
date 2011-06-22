<%@page import="java.util.*" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.DetalleAvisoPostulante" %>
<%@include file="/pages/comun/cabecera.jsp"%>
<script language="javascript">
function mis_datos(){
var key=window.event.keyCode;
if (key < 48 || key > 57){
window.event.keyCode=0;
}}
</script>

<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
<body>
<form id="form1" name="form1" method="post" action="BuscarPostulanteCriterioServlet">
<table width="800" border="0"  align="center">
  <tr>
    <td align="center" class="texto_celeste_titulo">Busqueda de Postulantes por Criterio</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
	<table width="800" border="0">
  <tr>
    <td>&nbsp;</td>
    <td class="texto_gris">Nombre Aviso </td>
    <td width="25">
	<select name="optAviso" >
		<option value="1" >Jefe de area Informatica</option>
		<option value="2">Jefe de area de Sistemas</option>
		<option value="3">Jefe de area Informatica</option>
	</select>
	</td>
    <td>&nbsp;</td>
    <td class="texto_gris">Disponibilidad</td>
    <td width="25">	
	<select name="optDisponibilidad">
		<option value="tiempo completo">Tiempo Completo</option>
		<option value="tiempo parcial">Tiempo Parcial</option>
	</select></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="texto_gris">Pretencion Salarial</td>
    <td><input type="text" name="txtSalario" onKeypress="mis_datos()" maxlength="5"></td>
    <td>&nbsp;</td>
    <td class="texto_gris">Edad Postulante </td>
    <td><input type="text" name="txtEdad" onKeypress="mis_datos()" maxlength="2"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><input type="submit" name="button2" value="Buscar" /></td>
    <td>&nbsp;</td>
  </tr>
</table>

	</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
	<table width="800" border="1">
  <tr class="fondo_celeste">
    <td>&nbsp;</td>
    <td class="texto_blanco" align="center">Apellido y Nombre</td>
    <td class="texto_blanco" align="center">Titulo</td>
    <td class="texto_blanco" align="center">Resumen</td>
    <td class="texto_blanco" align="center">Disponibilidad</td>
    <td class="texto_blanco" align="center">Pretencion Salarial</td>
    <td class="texto_blanco" align="center">Fecha Nacimiento</td>
  </tr>
  <%
List<DetalleAvisoPostulante> listaAvisoPostulante = (ArrayList<DetalleAvisoPostulante>)request.getAttribute(Constantes.SESSION_LISTA_AVISO_POSTULANTE);

if(listaAvisoPostulante != null) {
	for(int i=0; i<listaAvisoPostulante.size(); i++) {
		DetalleAvisoPostulante dap=listaAvisoPostulante.get(i);
	%>  
	  <tr>
	    <td class="texto_gris"><% out.print(i+1); %></td>
	    <td class="texto_gris"><% out.print(dap.getPersona().getApellidoPaterno()); %> <% out.print(dap.getPersona().getApellidoMaterno()); %></td>
	 	<td class="texto_gris"><% out.print(dap.getPersona().getTitulo()); %></td>
	   	<td class="texto_gris"><% out.print(dap.getPersona().getResumen()); %></td>
	   <td  class="texto_gris"><% out.print(dap.getPersona().getDisponibilidad()); %></td>
	 	<td  class="texto_gris" align="right"><% out.print(dap.getPersona().getSalario()); %></td>
	   	<td  class="texto_gris" align="center"><% out.print(dap.getPersona().getFechaNacimiento()); %></td>
	  </tr>
	<%
	}
  }
  %>
</table>
	</td>
  </tr>
</table>
</form>
</body>
<%@include file="/pages/comun/pie.jsp"%>