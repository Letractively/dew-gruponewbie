<%@include file="/pages/comun/cabecera.jsp"%>

<form action="LoginServlet" method="post">
Usuario: <input type="text" name="usuario"/> <br/>
Clave: <input type="password" name="clave"/> <br/>
<input type="submit" value="Ingresar"/>

<br/><br/>

Si no se encuentra registrado:<br/>
<a href="pages/datosEmpresa.jsp">Reg&iacute;strese como empresa</a><br/>
<a href="<%=request.getContextPath()%>/PostulanteServlet">Reg&iacute;strese como solicitante</a>

</form>

<%@include file="/pages/comun/pie.jsp"%>