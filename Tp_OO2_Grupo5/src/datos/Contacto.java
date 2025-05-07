package datos;

public class Contacto {
	
	private long idContacto;
	private String email;
	private String telefono;
	private Persona persona;
	
	public Contacto(){}
	
	public Contacto(String email, String telefono, Persona persona) {
		this.email = email;
		this.telefono = telefono;
		this.persona = persona;
	
	}
	
	public long getIdContacto() {
		return idContacto;
	}
	
	protected void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
	
	
	
}
