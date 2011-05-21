package upc.edu.pe.model;

public class Industria {

	private int idIndustria;
	private String nombreIndustria;
	
	public int getIdIndustria() {
		return idIndustria;
	}
	public void setIdIndustria(int idIndustria) {
		this.idIndustria = idIndustria;
	}
	public String getNombreIndustria() {
		return nombreIndustria;
	}
	public void setNombreIndustria(String nombreIndustria) {
		this.nombreIndustria = nombreIndustria;
	}
	
	@Override
	public String toString() {
		return "\n Nombre Industria= " + nombreIndustria + "]";
	}
	
}
