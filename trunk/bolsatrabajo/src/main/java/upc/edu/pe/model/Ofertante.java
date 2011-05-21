package upc.edu.pe.model;

import java.util.List;

public class Ofertante  extends Persona {

	private String razonSocial;	
	private List<Aviso> list;

	
	
	public List<Aviso> getList() {
		return list;
	}
	public void setList(List<Aviso> list) {
		this.list = list;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	@Override
	public String toString() {
		return "Ofertante [razonSocial=" + razonSocial + ", getCorreo()="
				+ getCorreo() + ", getId()=" + getId() + ", getContrasenhia()="
				+ getContrasenhia() + ", getTipoDocumento()="
				+ getTipoDocumento() + ", getNumeroDocumento()="
				+ getNumeroDocumento() + ", getTelefono()=" + getTelefono()
				+ ", getTipoPersona()=" + getTipoPersona() + "]";
	}
	
}
