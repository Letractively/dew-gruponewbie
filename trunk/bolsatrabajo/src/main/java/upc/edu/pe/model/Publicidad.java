package upc.edu.pe.model;

import java.util.Date;

public class Publicidad {
	private int idpublicidad;
	private String descripcion;
	private String cuerpo;
	private String enlace;
	private Date fechainicial;
	private Date fechafin;
	private String estado;

	public int getIdpublicidad() {
		return idpublicidad;
	}

	public void setIdpublicidad(int idpublicidad) {
		this.idpublicidad = idpublicidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Date getFechainicial() {
		return fechainicial;
	}

	public void setFechainicial(Date fechainicial) {
		this.fechainicial = fechainicial;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Publicidad [idpublicidad=" + idpublicidad + ", descripcion="
				+ descripcion + ", cuerpo=" + cuerpo + ", enlace=" + enlace
				+ ", fechainicial=" + fechainicial + ", fechafin=" + fechafin
				+ ", estado=" + estado + "]";
	}
	
	

}
