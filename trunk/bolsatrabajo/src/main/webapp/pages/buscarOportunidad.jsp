<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="upc.edu.pe.model.Aviso" %>
<%@page import="java.util.*" %>
<p><strong>Lista de Oportunidades:</strong></p>

<form id="form1" name="form1" method="post" action="BuscarOportunidadServlet">
  <p>Oportunidad: 
	<input type="text" name="oportunidad" value="" size="50" maxlength="100">
    <label>
    <input type="submit" name="button2" value="Buscar" />
    </label>
  </p>
</form>
<table width="550" height="65" border="1" cellpadding="0" cellspacing="0">
  <tr>
  	<th width="49" scope="col">Cargo</th>
    <th width="120" scope="col">Fecha inicio</th>
    <th width="192" scope="col">Fecha fin</th>
    <th width="192" scope="col">Descripcion</th>
    <th width="192" scope="col">Jornada Laboral</th>
    <th width="192" scope="col">Disponibilidad</th>
    <th width="192" scope="col">Requerimiento</th>
    <th width="192" scope="col">Beneficios</th>
    <th width="192" scope="col">Sueldo</th>
    <th width="150" scope="col">Especialidad</th>
  </tr>

<%
List<Aviso> lstAviso = (ArrayList<Aviso>)request.getAttribute(Constantes.SESSION_LISTA_AVISO);
if(lstAviso != null) {
	for(int i=0; i<lstAviso.size(); i++) {
		Aviso aviso=lstAviso.get(i);
	%>  
	  <tr>
	    <td><% out.print(i+1); %></td>
	    <td><% out.print(aviso.getCargo()); %></td>
	    <td><% out.print(aviso.getFechaInicio()); %></td>
	    <td><% out.print(aviso.getFechaFin()); %></td>
	    <td><% out.print(aviso.getDescripcion()); %></td>
	    <td><% out.print(aviso.getJornadaLaboral()); %></td>
	    <td><% out.print(aviso.getDisponibilidad()); %></td>
	    <td><% out.print(aviso.getRequerimiento()); %></td>
	    <td><% out.print(aviso.getBeneficios()); %></td>
	    <td><% out.print(aviso.getSueldo()); %></td>
	    <td><% out.print(aviso.getEspecialidad()); %></td>
	  </tr>
	<%
	}
  }
  %>
  
</table>
<%@include file="/pages/comun/pie.jsp"%>