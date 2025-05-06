package negocio;

import dao.ContactoDao;
import datos.Contacto;
import datos.Persona;

public class ContactoABM {

	ContactoDao dao = new ContactoDao();
	
	public Contacto traer(long idContacto) {
		Contacto c = dao.traer(idContacto);
		return c;
	}
	
	public int agregar(String email, String telefono, Persona persona)throws Exception{
		// Lanza excepción si la persona  ya tiene un contacto
		if(persona.getContacto() != null) throw new Exception("ERROR, la persona ya tiene un contacto ");
		Contacto c = new Contacto(email, telefono, persona);
		return dao.agregar(c);
	}
	
	public void modificar(Contacto c) {
		dao.actualizar(c);
	}
	
	public void eliminar(long idContacto) {
		Contacto c = dao.traer(idContacto);
		dao.eliminar(c);
	}


}
