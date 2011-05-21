package upc.edu.pe.model;

import java.util.Date;
import java.util.List;

public class Solicitante extends Persona {
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String sexo;
	private Date fechaNacimiento;
	private PerfilProfesional perfilProfesional;
	private List<ExperienciaProfesional> listExperienciaProfesional;
	private List<EstudioProfesional> listEstudioProfesional;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public PerfilProfesional getPerfilProfesional() {
		return perfilProfesional;
	}
	public void setPerfilProfesional(PerfilProfesional perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	}
	public List<ExperienciaProfesional> getListExperienciaProfesional() {
		return listExperienciaProfesional;
	}
	public void setListExperienciaProfesional(
			List<ExperienciaProfesional> listExperienciaProfesional) {
		this.listExperienciaProfesional = listExperienciaProfesional;
	}
	public List<EstudioProfesional> getListEstudioProfesional() {
		return listEstudioProfesional;
	}
	public void setListEstudioProfesional(
			List<EstudioProfesional> listEstudioProfesional) {
		this.listEstudioProfesional = listEstudioProfesional;
	}
	@Override
	public String toString() {
		return "\n Nombre= " + nombre + "\n Apellido Paterno= "
				+ apellidoPaterno + "\n Apellido Materno= " + apellidoMaterno
				+ "\n Sexo= " + sexo + "\n Fecha Nacimiento= " + fechaNacimiento
				+ "\n Perfil Profesional= " + perfilProfesional
				+ "\n listExperienciaProfesional= " + listExperienciaProfesional
				+ "\n listEstudioProfesional= " + listEstudioProfesional + " ";
	}
	
}
