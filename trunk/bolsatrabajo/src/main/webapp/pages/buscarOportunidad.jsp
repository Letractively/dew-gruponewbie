<%@page import="upc.edu.pe.web.comun.HelperDate"%>
<%@page import="java.util.*" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.Aviso" %>
<%@include file="/pages/comun/cabecera.jsp"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="800" border="0" align="center">
  <tr>
    <td align="center" class="texto_celeste_titulo">Lista de Oportunidades por Especialidad</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<form id="form1" name="form1" method="post" action="BuscarOportunidadServlet">
<table width="400" border="0" align="center">
  <tr>
    <td align="center" class="texto_gris">Oportunidad:</td>
    <td>
    	<select name="oportunidad" >
		<option value="17">Tecnologia de Sistemas Informaticos</option>
	     </select>
    </td>
    <td align="center" class="texto_celeste_titulo"><input type="submit" name="button2" value="Buscar" /></td>
  </tr>
  </table>
  <table width="900">
    <tr>
    <td class="texto_gris" align="right" colspan="8"><a href="<%=request.getContextPath()%>/pages/principal.jsp">Volver</a></td>
  </tr>
</table>
</form>
<table width="900" height="65" border="1" cellpadding="0" cellspacing="0" align="center">
  <tr class="fondo_celeste">
    <td scope="col" class="texto_blanco"  align="center">&nbsp;</td>
  	<td scope="col" class="texto_blanco"  align="center">Cargo</td>
    <td scope="col" class="texto_blanco" align="center">Fecha inicio</td>
    <td scope="col" class="texto_blanco" align="center">Fecha fin</td>
    <td scope="col" class="texto_blanco" align="center">Descripcion</td>
    <td scope="col" class="texto_blanco" align="center">Jornada Laboral</td>
    <td scope="col" class="texto_blanco" align="center">Disponibilidad</td>
    <td scope="col" class="texto_blanco" align="center">Requerimiento</td>
    <td scope="col" class="texto_blanco" align="center">Beneficios</td>
    <td scope="col" class="texto_blanco" align="center">Sueldo</td>
    <td scope="col" class="texto_blanco" align="center">Especialidad</td>
  </tr>

<%
List<Aviso> lstAviso = (ArrayList<Aviso>)request.getAttribute(Constantes.SESSION_LISTA_AVISO);
if(lstAviso != null) {
	for(int i=0; i<lstAviso.size(); i++) {
		Aviso aviso=lstAviso.get(i);
	%>  
	  <tr> 
	    <td class="texto_gris"><% out.print(i+1); %></td>
	    <td class="texto_gris"><% out.print(aviso.getCargo()); %></td>
	    <td class="texto_gris"><% out.print(HelperDate.parseDateToString(aviso.getFechaInicio(),Constantes.FORMATO_FECHA_VIEW)); %></td>
	    <td class="texto_gris"><% out.print(HelperDate.parseDateToString(aviso.getFechaFin(),Constantes.FORMATO_FECHA_VIEW)); %></td>
	    <td class="texto_gris"><% out.print(aviso.getDescripcion()); %></td>
	    <td class="texto_gris"><% out.print(aviso.getJornadaLaboral()); %></td>
	    <td class="texto_gris"><% out.print(aviso.getDisponibilidad()==null?"---":aviso.getDisponibilidad()); %></td>
	    <td class="texto_gris"><% out.print(aviso.getRequerimiento()); %></td>
	    <td class="texto_gris"><% out.print(aviso.getBeneficios()); %></td>
	    <td class="texto_gris"><% out.print(aviso.getSueldo()); %></td>
	    <td class="texto_gris"><% out.print(aviso.getEspecialidad().getNombreEspecialidad()); %></td>
	  </tr>
	<%
	}
  }
  %>
  
</table>
</body>
<%@include file="/pages/comun/pie.jsp"%>
</html>