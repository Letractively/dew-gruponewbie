<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registro de Empresa</title>
<link href="<%=request.getContextPath()%>/theme/sidCSS.css" rel="stylesheet" type="text/css">
<script>
	
	function F_Validar(){
		
		d = document.form1;
		Str = "";
		
		if (d.txtEmail.value==""){
			Str = Str + "-Debe registrar mail.\n";			
		}
		if (d.txtPassword.value==""){
			Str = Str + "-Debe registrar Clave.\n";			
		}
		if (d.txtRazonSocial.value==""){
			Str = Str + "-Debe registrar Razón Social.\n";
		}
		if (d.txtRuc.value==""){
			Str = Str + "-Debe registrar Ruc.\n";
		}
		if (d.txtTelefonoFijo.value==""){
			Str = Str + "-Debe registrar Teléfono.\n";
		}
		
		if (Str != ""){
			alert(Str);			
			return false;
		}
		else{
			return true;
		}
		
	}
	
	function F_Limpiar(){
		d=document.form1;
		
		d.txtEmail.value="";
		d.txtPassword.value="";
		d.txtRazonSocial.value="";
		d.txtRuc.value="";
		d.txtTelefonoFijo.value="";
		
	}
	
</script>

</head>
<%

String email="";
String clave = "";
String razonSocial ="";
String ruc="";
String direccion ="";
String teleFijo="";
String teleCel="";
String id_tipper="2";
String id_tipusu="1";
String id_tipdoc="2";
%>
<body>
<form id="form1" name="form1" method="post" action="RegistrarEmpresaServlet">
  <table width="200" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td class="texto_celeste_titulo">Registro Empresa</td>
    </tr>
  </table>
  
  <div style="padding-top:10px"> 
  <table width="600" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="texto_gris">E-mail</td>
    <td colspan="4">
      <input name="txtEmail" type="text" size="59" maxlength="50" value="<%=email%>"/>	</td>
    <td>&nbsp;</td>
    <td class="texto_gris">Password</td>
    <td><input name="txtPassword" type="password" size="25px" maxlength="50" value="<%=clave%>"/></td>
  </tr>
  <tr>
    <td class="texto_gris">Razon Social </td>
    <td colspan="4"><input name="txtRazonSocial" type="text" size = "59" maxlength="70" value="<%=razonSocial%>"/></td>
    <td>&nbsp;</td>
    <td class="texto_gris">Ruc</td>
    <td><input name="txtRuc" type="text" size="25px" maxlength="11" value="<%=ruc%>"/></td>
  </tr>
  
  <tr>
    <td class="texto_gris">Tel&eacute;fono</td>
    <td><input name="txtTelefonoFijo" type="text" size="30px" maxlength="10" value="<%=teleFijo%>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
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
  <tr>
    <td>&nbsp;</td>
    <td colspan="4">
    	<input type="submit" name="btnRegistrar" value="Registrar" />
      	<input type="reset" name="btnCancelar" value="Cancelar" onclick="F_Limpiar();"/>      	</td>
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
<input type="hidden" name="tipoPer" value="<%=id_tipper%>">
<input type="hidden" name="idTipousu" value="<%=id_tipusu%>">
<input type="hidden" name="idTipoDoc" value="<%=id_tipdoc%>">
</form>
</body>
</html>
