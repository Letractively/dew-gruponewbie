package upc.edu.pe.model;

public class Especialidad {

	private int idEspecialidad;
	private String nombreEspecialidad;
	
	public int getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad
				+ ", nombreEspecialidad=" + nombreEspecialidad + "]";
	}

	
}
