<%@include file="/pages/comun/cabecera.jsp"%>
<%@page import="upc.edu.pe.web.comun.HelperDate"%>
<%@page import="upc.edu.pe.model.Distrito" %>
<%@page import="upc.edu.pe.model.Solicitante" %>
<%@page import="upc.edu.pe.web.comun.Constantes"%>
<%@page import="java.util.*" %>

<%
Solicitante postulante = (Solicitante)request.getAttribute(Constantes.SESSION_POSTULANTE);
int id=0;
String oper ="";
String correoUsuario="";
String contrasenhia="";
String nombreUsuario="";
String apepat="";
String apemat="";
String direccion="";
String tipdoc="";
String numdoc="";
String fecnac="";
String telefono="";
String celular="";
String sexo="";
String distrito="";
String titulo="Registro Postulante";
if(postulante != null) {
	titulo="Modificaci&oacute;n de Postulante";
	oper=Constantes.C_OPERACION_MODIFICAR;
	id=postulante.getId();
	correoUsuario=postulante.getCorreo();
	contrasenhia=postulante.getContrasenhia();
	nombreUsuario=postulante.getNombre();
	apepat=postulante.getApellidoPaterno();
	apemat=postulante.getApellidoMaterno();
	direccion=postulante.getDireccion();
	tipdoc=postulante.getTipoDocumento();
	numdoc=postulante.getNumeroDocumento();
	try{
		fecnac=HelperDate.parseDateToString(postulante.getFechaNacimiento(),Constantes.FORMATO_FECHA_VIEW);
	} catch (Exception e) {		
		fecnac="";
	}
	telefono=postulante.getTelefono();
	celular=postulante.getCelular();
	sexo=postulante.getSexo();
	try{
		distrito=postulante.getDistrito().getId_distrito();
	} catch (Exception e) {
	}	
	
	/*cuerpo=publi.getCuerpo();
	enlace=publi.getEnlace();
	fini=HelperDate.parseDateToString(publi.getFechainicial(),Constantes.FORMATO_FECHA_VIEW);
	ffin=HelperDate.parseDateToString(publi.getFechafin(),Constantes.FORMATO_FECHA_VIEW);*/
}
//List<Distrito> dist = (ArrayList<Distrito>)request.getAttribute(Constantes.SESSION_LISTA_DISTRITO);
%>

<H2><%=titulo %></H2>
<form id="form1" name="form1" method="post" action="RegistroPostulanteServlet">
<table border=1>
	<% 
		if(request.getAttribute(Constantes.C_MENSAJE_ERROR)!=null){
			
	%>
	<tr>
		<td>Mensaje Error:</td>
		<td colspan="3"><p><%=request.getAttribute(Constantes.C_MENSAJE_ERROR) %></p></Label></td>
	</tr>
	<% 
	}	
	%>
	<tr>
		<td>Correo:</td>
		<td colspan="3"><input type="text" name="correo" value="<%=correoUsuario %>" size="60" maxlength="100">(Usuario)</td>
	</tr>
	<tr>
		<td>Contrase&ntilde;a:</td>
		<td><input type="password" name="contrasena" value="<%=contrasenhia %>" size="20" maxlength="50"></td>
		<td>Confirmar Contrase&ntilde;a:</td>
		<td><input type="password" name="confircontrasena" value="<%=contrasenhia %>" size="20" maxlength="50"></td>
	</tr>
	<tr>
		<td>Nombre:</td>
		<td><input type="text" name="nombre" value="<%=nombreUsuario %>" size="20" maxlength="70"></td>
		<td>Apellido Paterno:</td>
		<td><input type="text" name="apepat" value="<%=apepat %>" size="20" maxlength="70"></td>
	</tr>
	<tr>
		<td>Apellido Materno:</td>
		<td><input type="text" name="apemat" value="<%=apemat %>" size="20" maxlength="70"></td>
		<td>Direcci&oacute;n:</td>
		<td><input type="text" name="direccion" value="<%=direccion %>" size="50" maxlength="150"></td>
	</tr>
	<tr>
		<td>Número Doc. DNI:</td>
		<td><input type="text" name="numdoc" value="<%=numdoc %>" size="15" maxlength="20"></td>
		<td>Sexo:</td>
		<td><select name="sexo">
				<option value="F">Femenino</option>   
				<option value="M">Masculino</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Fecha Nacimiento:</td>
		<td><input type="text" name="fecnac" value="<%=fecnac %>" size="15" maxlength="10"></td>
		<td>Tel&eacute;fono:</td>
		<td><input type="text" name="telefono" value="<%=telefono %>" size="15" maxlength="15"></td>
	</tr>
	<tr>
		<td>Celular:</td>
		<td><input type="text" name="celular" value="<%=celular %>" size="15" maxlength="20"></td>
		<td>Distrito:</td>
		<td>
		<select name="distrito">   
		<%
		List<Distrito> lstDistrito = (ArrayList<Distrito>)session.getAttribute(Constantes.SESSION_LISTA_DISTRITO);
		if(lstDistrito != null) {
			for(int i=0; i<lstDistrito.size(); i++) {
				Distrito dis=lstDistrito.get(i);
			%>	<option value="<% out.print(dis.getId_distrito()); %>"><% out.print(dis.getNombre()); %></option>
			<%
				}
			} %>
	</select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<label>
	    	<input type="submit" name="button2" value="Registrar" />
	    </label>
    	</td>
	</tr>
</table>
<input type="hidden" name="id" value="<%=id%>">
<input type="hidden" name="oper" value="<%=oper%>">
</form>

<%@include file="/pages/comun/pie.jsp"%>