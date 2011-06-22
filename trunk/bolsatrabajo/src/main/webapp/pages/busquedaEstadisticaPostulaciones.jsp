<%@page import="java.util.*" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.Aviso" %>
<%@include file="/pages/comun/cabecera.jsp"%>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
<body>
<form id="form1" name="form1" method="post" action="BuscarEstadisticaPostulacionesServlet">
<table width="800" border="0" align="center">
  <tr>
    <td align="center" class="texto_celeste_titulo">Cantidad de Postulantes por Oferta</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
	<table width="800" border="1">
  <tr class="fondo_celeste">
    <td>&nbsp;</td>
    <td class="texto_blanco" align="center">Cargo Aviso </td>
    <td class="texto_blanco" align="center">Fecha Inicio </td>
    <td class="texto_blanco" align="center">Fecha Fin </td>
    <td class="texto_blanco" align="center">Sueldo Ofrecido</td>
    <td class="texto_blanco" align="center">Cantidad Postulantes </td>
    </tr>
  <%
List<Aviso> listaEstadistica = (ArrayList<Aviso>)request.getAttribute(Constantes.SESSION_LISTA_ESTADISTICA);

if(listaEstadistica != null) {
	for(int i=0; i<listaEstadistica.size(); i++) {
		Aviso dap=listaEstadistica.get(i);
	%>  
	  <tr >
	    <td class="texto_gris"><% out.print(i+1); %></td>
	 	<td class="texto_gris"><% out.print(dap.getCargo()); %></td>
	   	<td class="texto_gris" align="center"><% out.print(dap.getFechaInicio()); %></td>
	   <td class="texto_gris" align="center"><% out.print(dap.getFechaFin()); %></td>
	   <td class="texto_gris" align="right"><% out.print(dap.getSueldo()); %></td>
	    <td class="texto_gris" align="right"><% out.print(dap.getTotalPostulantes()); %></td>
	  </tr>
	<%
	}
  }
  %>
</table>

	</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
</body>    
<%@include file="/pages/comun/pie.jsp"%>