<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.Constantes"%>

<form action="RegistrarEmpresaServlet" method="post">

Raz�n Social: <input type="text" name="usuario"/> <br/>
Ruc: <input type="password" name="clave"/> <br/>

<input type="submit" value="Registrar Empresa"/>

<table border=1>
	<tr>
		<td>Raz�n Social</td>
		<td>RUC</td>
	</tr>
</table>
</form>
