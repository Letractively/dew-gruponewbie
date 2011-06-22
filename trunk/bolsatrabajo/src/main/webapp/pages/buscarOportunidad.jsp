<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
	    <td><% out.print(aviso.getfechainicio()); %></td>
	    <td><% out.print(aviso.getfechafin()); %></td>
	    <td><% out.print(aviso.getdescripcion()); %></td>
	    <td><% out.print(aviso.getjornadaLaboral()); %></td>
	    <td><% out.print(aviso.getdisponibilidad()); %></td>
	    <td><% out.print(aviso.getrequerimiento()); %></td>
	    <td><% out.print(aviso.getbeneficios()); %></td>
	    <td><% out.print(aviso.getsueldo()); %></td>
	    <td><% out.print(aviso.getespecialidad()); %></td>
	  </tr>
	<%
	}
  }
  %>
  
</table>

</body>
</html>