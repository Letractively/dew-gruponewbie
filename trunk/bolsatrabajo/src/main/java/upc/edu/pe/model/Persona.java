package upc.edu.pe.model;

public class Persona {

	private String correo;
	private int id;
	private String contrasenhia;
	private String direccion;//TODO: AGREGAR DISTRITO, PROV Y DEP
	private String tipoDocumento;
	private String numeroDocumento;
	private String telefono;
	private String celular;
	private String tipoPersona;

	@Override
	public String toString() {
		return "Persona [correo=" + correo + ", id=" + id + ", contrasenhia="
				+ contrasenhia + ", direccion=" + direccion
				+ ", tipoDocumento=" + tipoDocumento + ", numeroDocumento="
				+ numeroDocumento + ", telefono=" + telefono + ", celular="
				+ celular + ", tipoPersona=" + tipoPersona + "]";
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasenhia() {
		return contrasenhia;
	}

	public void setContrasenhia(String contrasenhia) {
		this.contrasenhia = contrasenhia;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

}
