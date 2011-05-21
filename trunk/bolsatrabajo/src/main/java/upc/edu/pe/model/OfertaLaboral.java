package upc.edu.pe.model;

import java.util.Date;

public class OfertaLaboral {

	@Override
	public String toString() {
		return "OfertaLaboral [id=" + id_avi + ", cargo=" + cargo_avi
				+ ", inicio		=" + inicio_avi + ", fin=" + fin_avi
				+ ", descripcion	=" + descripcion_avi + ", jornada="
				+ jornadaLaboral_avi + ", disponibilidad=" + disponibilidad_avi
				+ ", requerimientos=" + requerimientos_avi + ", beneficios	="
				+ beneficios_avi + ", estado=" + estado_avi
				+ ", conteoLectura=" + conteoLectura_avi + ", persona="
				+ id_per + ", especialidad=" + id_Especialidad + "]";
	}

	private int id_avi;
	private String cargo_avi;
	private Date inicio_avi;
	private Date fin_avi;
	private String descripcion_avi;
	private String jornadaLaboral_avi;
	private String disponibilidad_avi;
	private String requerimientos_avi;
	private String beneficios_avi;
	private String estado_avi;
	private String conteoLectura_avi;
	private String id_per;
	private String id_Especialidad;	

	public int getId_avi() {
		return id_avi;
	}

	public void setId_avi(int id_avi) {
		this.id_avi = id_avi;
	}

	public String getCargo_avi() {
		return cargo_avi;
	}

	public void setCargo_avi(String cargo_avi) {
		this.cargo_avi = cargo_avi;
	}

	public Date getInicio_avi() {
		return inicio_avi;
	}

	public void setInicio_avi(Date inicio_avi) {
		this.inicio_avi = inicio_avi;
	}

	public Date getFin_avi() {
		return fin_avi;
	}

	public void setFin_avi(Date fin_avi) {
		this.fin_avi = fin_avi;
	}

	public String getDescripcion_avi() {
		return descripcion_avi;
	}

	public void setDescripcion_avi(String descripcion_avi) {
		this.descripcion_avi = descripcion_avi;
	}

	public String getJornadaLaboral_avi() {
		return jornadaLaboral_avi;
	}

	public void setJornadaLaboral_avi(String jornadaLaboral_avi) {
		this.jornadaLaboral_avi = jornadaLaboral_avi;
	}

	public String getDisponibilidad_avi() {
		return disponibilidad_avi;
	}

	public void setDisponibilidad_avi(String disponibilidad_avi) {
		this.disponibilidad_avi = disponibilidad_avi;
	}

	public String getRequerimientos_avi() {
		return requerimientos_avi;
	}

	public void setRequerimientos_avi(String requerimientos_avi) {
		this.requerimientos_avi = requerimientos_avi;
	}

	public String getBeneficios_avi() {
		return beneficios_avi;
	}

	public void setBeneficios_avi(String beneficios_avi) {
		this.beneficios_avi = beneficios_avi;
	}

	public String getEstado_avi() {
		return estado_avi;
	}

	public void setEstado_avi(String estado_avi) {
		this.estado_avi = estado_avi;
	}

	public String getConteoLectura_avi() {
		return conteoLectura_avi;
	}

	public void setConteoLectura_avi(String conteoLectura_avi) {
		this.conteoLectura_avi = conteoLectura_avi;
	}

	public String getId_per() {
		return id_per;
	}

	public void setId_per(String id_per) {
		this.id_per = id_per;
	}

	public String getId_Especialidad() {
		return id_Especialidad;
	}

	public void setId_Especialidad(String id_Especialidad) {
		this.id_Especialidad = id_Especialidad;
	}	

}
