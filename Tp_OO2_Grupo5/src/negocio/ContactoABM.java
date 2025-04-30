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
	
	public int agregar(String email, String telefono, Persona persona){
		// Lanzar excepción si el cliente ya tiene un contacto
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
