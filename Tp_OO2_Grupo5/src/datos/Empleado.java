package datos;

import java.time.LocalDate;

public class Empleado extends Persona {
	private String puesto;
	
	public Empleado() {}

	public Empleado(String nombre, String apellido, long dni, LocalDate fechaDeNacimiento, String puesto) {
		super(nombre, apellido, dni, fechaDeNacimiento);
		this.puesto = puesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return super.toString() + "Empleado [puesto=" + puesto + "]";
	}

	
}
