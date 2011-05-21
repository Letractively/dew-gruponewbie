package upc.edu.pe.model;

import java.math.BigDecimal;

public class PerfilProfesional {

	private String tituloProfesional;
	private String resumenProfesional;
	private String disponibilidadHoraria;
	private BigDecimal pretencionEconomica;
	//private boolean trabajoFuera;
	
	public String getTituloProfesional() {
		return tituloProfesional;
	}
	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}
	public String getResumenProfesional() {
		return resumenProfesional;
	}
	public void setResumenProfesional(String resumenProfesional) {
		this.resumenProfesional = resumenProfesional;
	}
	public String getDisponibilidadHoraria() {
		return disponibilidadHoraria;
	}
	public void setDisponibilidadHoraria(String disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}
	public BigDecimal getPretencionEconomica() {
		return pretencionEconomica;
	}
	public void setPretencionEconomica(BigDecimal pretencionEconomica) {
		this.pretencionEconomica = pretencionEconomica;
	}
	@Override
	public String toString() {
		return "PerfilProfesional \n Titulo Profesional= " + tituloProfesional
				+ "\n Resumen Profesional= " + resumenProfesional
				+ "\n Disponibilidad Horaria= " + disponibilidadHoraria
				+ "\n Pretencion Economica= " + pretencionEconomica + " ";
	}
	/*public boolean isTrabajoFuera() {
		return trabajoFuera;
	}
	public void setTrabajoFuera(boolean trabajoFuera) {
		this.trabajoFuera = trabajoFuera;
	}*/
	
}
