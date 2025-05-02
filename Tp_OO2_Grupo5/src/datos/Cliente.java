package datos;

import java.time.LocalDate;

public class Cliente extends Persona{
	private LocalDate fechaIngreso;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto, LocalDate fechaIngreso) {
		super(nombre, apellido, dni, fechaDeNacimiento, contacto);
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Cliente [fechaIngreso=" + fechaIngreso + "]";
	}
	
}
