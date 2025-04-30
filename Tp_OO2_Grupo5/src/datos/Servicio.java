package datos;

public class Servicio {
	int idServicio;
	String nombre;
	
	public Servicio() {}
	
	public Servicio(int idServicio, String nombre) {
		this.idServicio = idServicio;
		this.nombre = nombre;
	}


	public int getIdServicio() {
		return idServicio;
	}
	protected void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + "]";
	}
	
	
}
