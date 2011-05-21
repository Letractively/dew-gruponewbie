package upc.edu.pe.model;

import java.util.Date;

public class EstudioProfesional {

	private int idEstudioProfesional;
	private String tituloEstudio;
	private Date fechaInicio;
	private Date fechaTermino;
	private String estadoEstudio;//TODO: CENTROESTUDIO
	private Especialidad especialidad;
	
	public int getIdEstudioProfesional() {
		return idEstudioProfesional;
	}
	public void setIdEstudioProfesional(int idEstudioProfesional) {
		this.idEstudioProfesional = idEstudioProfesional;
	}
	public String getTituloEstudio() {
		return tituloEstudio;
	}
	public void setTituloEstudio(String tituloEstudio) {
		this.tituloEstudio = tituloEstudio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public String getEstadoEstudio() {
		return estadoEstudio;
	}
	public void setEstadoEstudio(String estadoEstudio) {
		this.estadoEstudio = estadoEstudio;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	} 
	
	@Override
	public String toString() {
		return "EstudioProfesional \n Titulo Estudio= " + tituloEstudio
				+ "\n Fecha Inicio= " + fechaInicio + "\n Fecha Termino= "
				+ fechaTermino + "\n Estado Estudio=" + estadoEstudio
				+ "\n Especialidad= " + especialidad + " ";
	}
}
