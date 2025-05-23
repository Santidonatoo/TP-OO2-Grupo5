package datos;

import java.time.LocalDate;

public abstract class Persona {
	protected long idPersona;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected LocalDate fechaDeNacimiento;
	public Contacto contacto;
	
	public Persona() {}
	
	public Persona(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.contacto = contacto;
	}

	public long getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Contacto getContacto() {
		return contacto;
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "idPersona: " + idPersona + " - " + nombre + " " + apellido + " - dni: " + dni
				+ " - fechaDeNacimiento:" + fechaDeNacimiento;
	}
}
