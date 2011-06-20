<%@include file="/pages/comun/cabecera.jsp"%>

<form action="LoginServlet" method="post">
Usuario: <input type="text" name="usuario"/> <br/>
Clave: <input type="password" name="clave"/> <br/>
<input type="submit" value="Ingresar"/>
</form>

<%@include file="/pages/comun/pie.jsp"%>