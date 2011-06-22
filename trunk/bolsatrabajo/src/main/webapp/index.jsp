<%@include file="/pages/comun/cabecera.jsp"%>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
<center>
<form action="LoginServlet" method="post">
<table align="center" width="500" border="0">
	<tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
     <td colspan="2" align="center" class="texto_celeste_titulo">Login de Usuario</td>
  </tr>
  <tr>
      <td colspan="2">&nbsp;</td>
  </tr>
  
  <tr>
    <td class="texto_gris">Usuario</td>
    <td align="left"><input type="text" size="50" name="usuario"/> </td>
  </tr>
  <tr>
    <td class="texto_gris">Contraseña</td>
    <td align="left"><input type="password" size="50" name="clave"/></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="Ingresar"/></td>
  </tr>
    <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" class="texto_gris">Si no se encuentra registrado:</td>
  </tr>
    <tr>
    <td colspan="2" align="center" class="texto_gris"><a href="pages/datosEmpresa.jsp">Reg&iacute;strese como empresa</a><br/></td>
  </tr>
      <tr>
    <td colspan="2" align="center" class="texto_gris"><a href="<%=request.getContextPath()%>/PostulanteServlet">Reg&iacute;strese como solicitante</a></td>
  </tr>
</table>
</form>
</center>

<%@include file="/pages/comun/pie.jsp"%>