<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registro de Empresa</title>
<script>
	
	function F_validar(){
		
		d = document.form1;
		Str = "";
		
		if (d.txtDepa.value==""){
			Str = Str + "-Debe registrar Nombre.\n";			
		}
		if (d.txtProv.value==""){
			Str = Str + "-Debe registrar Clave.\n";			
		}
		
		if (Str != ""){
			alert(Str);			
			return false;
		}
		else{
			return true;
		}
		
	}
	
</script>

</head>
<%
//int idper=0;
String email="";
String clave = "";
String DesEmp ="";
String razonSocial ="";
String ruc="";
String direccion ="";
String teleFijo="";
String teleCel="";
String provincia="";
String distrito="";

String depa="";
String id_tipper="2";
%>
<body>
<form id="form1" name="form1" method="post" action="RegistrarEmpresaServlet">
  <table width="200" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td><h2>Registro Empresa</h2></td>
    </tr>
  </table>
  
  <div style="padding-top:10px"> 
  <table width="600" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>Departamento</td>
    <td>
      <input name="txtDepa" type="text" maxlength="100" value="<%=depa%>"/>    </td>
    <td>&nbsp;</td>
    <td>Provincia</td>
    <td>
      <input name="txtProv" type="text" size="30px" maxlength="100" value="<%=provincia%>" />    </td>
    <td>&nbsp;</td>
    <td>Distrito</td>
    <td><input name="txtDis" type="text" size="25px" maxlength="100" value="<%=distrito%>"/></td>
  </tr>
  <%-- <tr>
    <td>Codigo</td>
    <td>
      <input name="txtidPer" type="text" maxlength="10" value="<%=idper%>"/>	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr> --%>
  <tr>
    <td>E-mail</td>
    <td colspan="4">
      <input name="txtEmail" type="text" size="59" maxlength="50" value="<%=email%>"/>	</td>
    <td>&nbsp;</td>
    <td>Password</td>
    <td><input name="txtPassword" type="password" size="25px" maxlength="50" value="<%=clave%>"/></td>
  </tr>
  <tr>
    <td>Resumen Em </td>
    <td colspan="4"><input name="txtResumenPer" type="text" size="59" maxlength="150" value="<%=DesEmp%>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Razon Social </td>
    <td colspan="4"><input name="txtRazonSocial" type="text" size = "59" maxlength="70" value="<%=razonSocial%>"/></td>
    <td>&nbsp;</td>
    <td>Ruc</td>
    <td><input name="txtRuc" type="text" size="25px" maxlength="11" value="<%=ruc%>"/></td>
  </tr>
  <tr>
    <td>Direcci&ograve;n</td>
    <td colspan="4"><input name="txtDireccion" type="text" size="59" maxlength="140" value="<%=direccion%>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Tel&eacute;fono</td>
    <td><input name="txtTelefonoFijo" type="text" size="30px" maxlength="10" value="<%=teleFijo%>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>Cel.</td>
    <td><input name="txtTelefonoCel" type="text" size="25px" maxlength="10" value="<%=teleCel%>"/></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="4">
    	<input type="submit" name="btnRegistrar" value="Registrar" onsubmit="return F_Validar();"/>
      	<input type="submit" name="btnCancelar" value="Cancelar" />      	</td>
    <!-- <td>&nbsp;</td> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>-->
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
    
  
  
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</div>
<input type="hidden" name="idpersona" value="<%=id_tipper%>">

</form>
</body>
</html>
