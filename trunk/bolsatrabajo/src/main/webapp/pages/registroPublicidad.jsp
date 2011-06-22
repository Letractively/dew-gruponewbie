<%@include file="/pages/comun/ValidarSession.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Publicidad - Administrador</title>
</head>
<body>

<form action="RegistroPublicidadServlet" method="post">
<table border=1>
	<tr>
		<td>Descripci&oacute;n:</td>
		<td><input type="text" name="descripcion"></td>
		<td>Fecha Inicial:</td>
		<td><input type="text" name="finicial"></td>
	</tr>
	<tr>
		<td>Enlace:</td>
		<td><input type="text" name="enlace"></td>
		<td>Fecha Final:</td>
		<td><input type="text" name="ffinal"></td>
	</tr>
	<tr>
		<td>Cuerpo:</td>
		<td colspan="3"><textarea rows="4" cols="4"></textarea></td>
	</tr>
</table>
</form>

</body>
</html>