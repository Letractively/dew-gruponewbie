<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.TipoUsuario" %>
<%@page import="upc.edu.pe.model.Ofertante" %>
<%@page import="upc.edu.pe.model.Solicitante" %>
<%@page import="upc.edu.pe.model.Industria" %>
<%@page import="java.util.*" %>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
<center>
<table width="800" border="0"  align="center">
  <tr>
    <td align="center" class="texto_celeste_titulo">Busqueda de Postulantes por Criterio</td>
  </tr>
</table>
<form id="form1" name="form1" method="post" action="BuscarIndustriaServlet">
  <p class="texto_gris">Rubro: 
	<select name="industria">   
<%
List<Industria> lstIndustria = (ArrayList<Industria>)session.getAttribute(Constantes.SESSION_LISTA_INDUSTRIA);
if(lstIndustria != null) {
	for(int i=0; i<lstIndustria.size(); i++) {
			Industria ind=lstIndustria.get(i);
	%>	<option value="<% out.print(ind.getIdIndustria()); %>"><% out.print(ind.getNombreIndustria()); %></option>
	<%
		}
	} %>
	</select>

    <label>
    <input type="submit" name="button2" value="Buscar" />
    </label>
  </p>
</form>
<table width="550" height="65" border="1" cellpadding="0" cellspacing="0">
  <tr class="fondo_celeste">
  	<td class="texto_blanco" width="49" scope="col">Nro.</th>
    <td class="texto_blanco" width="120" scope="col">Nombre Empresa</th>
    <td class="texto_blanco" width="192" scope="col">Direcci&oacute;n</th>
    <td class="texto_blanco" width="150" scope="col">Correo Electr&oacute;nico</th>
  </tr>


<%
List<Ofertante> lstOferta = (ArrayList<Ofertante>)request.getAttribute(Constantes.SESSION_LISTA_OFERTANTE);
if(lstOferta != null) {
	for(int i=0; i<lstOferta.size(); i++) {
		Ofertante ofer=lstOferta.get(i);
	%>  
	  <tr>
	    <td class="texto_gris"><% out.print(i+1); %></td>
	    <td class="texto_gris"><% out.print(ofer.getRazonSocial()); %></td>
	    <td class="texto_gris"><% out.print(ofer.getDireccion()); %></td>
	    <td class="texto_gris"><% out.print(ofer.getCorreo()); %></td>
	  </tr>
	<%
	}
  }
  %>
  
</table>
</center>
<%@include file="/pages/comun/pie.jsp"%>