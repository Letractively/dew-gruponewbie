package upc.edu.pe.model;

import java.math.BigDecimal;
import java.util.Date;

public class Aviso {

	private int id;
	private String cargo;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcion;
	private String jornadaLaboral;
	private String disponibilidad;
	private String requerimiento;
	private String beneficios;
	private BigDecimal sueldo;
	private String estado;
	private int contadorVisitas;
	private Especialidad especialidad;
	private int totalPostulantes;
	
	public int getTotalPostulantes() {
		return totalPostulantes;
	}
	public void setTotalPostulantes(int totalPostulantes) {
		this.totalPostulantes = totalPostulantes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getJornadaLaboral() {
		return jornadaLaboral;
	}
	public void setJornadaLaboral(String jornadaLaboral) {
		this.jornadaLaboral = jornadaLaboral;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getContadorVisitas() {
		return contadorVisitas;
	}
	public void setContadorVisitas(int contadorVisitas) {
		this.contadorVisitas = contadorVisitas;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	@Override
	public String toString() {
		return "Aviso [id=" + id + ", cargo=" + cargo + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", descripcion="
				+ descripcion + ", jornadaLaboral=" + jornadaLaboral
				+ ", disponibilidad=" + disponibilidad + ", requerimiento="
				+ requerimiento + ", beneficios=" + beneficios + ", sueldo="
				+ sueldo + ", estado=" + estado + ", contadorVisitas="
				+ contadorVisitas + ", especialidad=" + especialidad + "]";
	}
	
	
}
