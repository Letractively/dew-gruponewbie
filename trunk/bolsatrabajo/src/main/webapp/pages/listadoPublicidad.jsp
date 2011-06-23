<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.web.comun.HelperDate"%>
<%@page import="upc.edu.pe.model.Publicidad" %>
<%@page import="java.util.*" %>

<p><strong>Lista de Publicidad:</strong></p>
<% 
	if(request.getAttribute(Constantes.C_MENSAJE_ERROR)!=null){			
%>
	<p class="texto_gris">Mensaje Error:<%=request.getAttribute(Constantes.C_MENSAJE_ERROR) %></p>
<% 
	}	
%>
<p class="texto_gris">
<a href="<%=request.getContextPath() %>/EditarPublicidadServlet?id=0">Nuevo</a></p>
<table width="550" height="65" border="1" cellpadding="0" cellspacing="0">
  <tr class="fondo_celeste">
  	<th class="texto_blanco" width="40" scope="col">Nro.</th>
    <th class="texto_blanco" width="120" scope="col">Descripci&oacute;n</th>
    <th class="texto_blanco" width="80" scope="col">Fecha Inicial</th>
    <th class="texto_blanco" width="80" scope="col">Fecha Final</th>
    <th class="texto_blanco" width="60" scope="col">Estado</th>
    <th class="texto_blanco" width="120" scope="col">acci&oacute;n</th>
  </tr>


<%
List<Publicidad> lstPublic = (ArrayList<Publicidad>)request.getAttribute(Constantes.SESSION_LISTA_PUBLICIDAD);
if(lstPublic != null) {
	for(int i=0; i<lstPublic.size(); i++) {
		Publicidad publi =lstPublic.get(i);
	%>  
	  <tr>
	    <td class="texto_gris"><% out.print(i+1); %></td>
	    <td class="texto_gris"><% out.print(publi.getDescripcion()); %></td>
	    <td class="texto_gris"><% out.print(HelperDate.parseDateToString(publi.getFechainicial(),Constantes.FORMATO_FECHA_VIEW)); %></td>
	    <td class="texto_gris"><% out.print(HelperDate.parseDateToString(publi.getFechafin(),Constantes.FORMATO_FECHA_VIEW)); %></td>
	    <td class="texto_gris"><% out.print(publi.getEstado()); %></td>
	    <td class="texto_gris"><a href="<%=request.getContextPath() %>/EditarPublicidadServlet?id=<%=publi.getIdpublicidad() %>&oper=<%=Constantes.C_OPERACION_MODIFICAR %>">Editar</a> - <a href="<%=request.getContextPath()%>
		/RegistroPublicidadServlet?id=<%=publi.getIdpublicidad() %>&oper=<%=Constantes.C_OPERACION_ELIMINAR %>" onclick="return confirm('¿Está seguro que desea eliminar el registro?');">Eliminar</a></td>
	  </tr>
	<%
	}
  }
  %>
  
</table>
<%@include file="/pages/comun/pie.jsp"%>