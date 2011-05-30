package upc.edu.pe.model;

public class DetalleAvisoPostulante {

	private int id_avi;
	private int id_per;
	private String estado_avi;
	private Aviso aviso;
	private Persona persona;
	
	public int getId_avi() {
		return id_avi;
	}
	public void setId_avi(int id_avi) {
		this.id_avi = id_avi;
	}
	public int getId_per() {
		return id_per;
	}
	public void setId_per(int id_per) {
		this.id_per = id_per;
	}
	public String getEstado_avi() {
		return estado_avi;
	}
	public void setEstado_avi(String estado_avi) {
		this.estado_avi = estado_avi;
	}
	public Aviso getAviso() {
		return aviso;
	}
	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
