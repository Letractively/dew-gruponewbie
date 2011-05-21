package upc.edu.pe.model;

import java.util.Date;

public class ExperienciaProfesional {

	private int idExperienciaProfesional;
	private String nombreOrganizacion;
	private Industria industria;
	private String cargo;
	private Date fechaInicio;
	private Date fechatermino;
	private String descripcionLaboral;
	
	public int getIdExperienciaProfesional() {
		return idExperienciaProfesional;
	}
	public void setIdExperienciaProfesional(int idExperienciaProfesional) {
		this.idExperienciaProfesional = idExperienciaProfesional;
	}
	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}
	public void setNombreOrganizacion(String Organizacion) {
		this.nombreOrganizacion = Organizacion;
	}
	public Industria getIndustria() {
		return industria;
	}
	public void setIndustria(Industria industria) {
		this.industria = industria;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechatermino() {
		return fechatermino;
	}
	public void setFechatermino(Date fechatermino) {
		this.fechatermino = fechatermino;
	}
	public String getDescripcionLaboral() {
		return descripcionLaboral;
	}
	public void setDescripcionLaboral(String descripcionLaboral) {
		this.descripcionLaboral = descripcionLaboral;
	}
	@Override
	public String toString() {
		return "ExperienciaProfesional \n nombreOrganizacion= "
				+ nombreOrganizacion + "\n industria= " + industria + "\n cargo= "
				+ cargo + "\n Fecha Inicio= " + fechaInicio + "\n Fecha Termino= "
				+ fechatermino + "\n Descripcion Laboral= " + descripcionLaboral
				+ " ";
	}
	
	
}
