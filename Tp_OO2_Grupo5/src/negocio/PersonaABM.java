package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Cliente;
import datos.Contacto;
import datos.Empleado;
import datos.Persona;

public class PersonaABM {
	private static PersonaABM instancia = null; // Patrón Singleton
	PersonaDao dao = new PersonaDao();
	
	public static PersonaABM getInstance() {
		if (instancia == null)
		instancia = new PersonaABM();
		return instancia;
	}
	
	public Persona traer(long idPersona) {
		return dao.traer(idPersona);
	}
	
	public Persona traer(int dni) {
		return dao.traer(dni);
	}
	
	//Agrega Empleado
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto, String puesto)throws Exception {
		if(traer(dni) != null) throw new Exception ("ERROR, ya existe un empleado con el dni: " + dni);
		Persona p = new Empleado(nombre, apellido, dni, fechaDeNacimiento, contacto, puesto);
		return dao.agregar(p);
	}
	
	//Agrega Cliente
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto, LocalDate fechaIngreso)throws Exception {
		if(traer(dni) != null) throw new Exception ("ERROR, ya existe un cliente con el dni: " + dni);
		Persona p = new Cliente(nombre, apellido, dni, fechaDeNacimiento, contacto, fechaIngreso);
		return dao.agregar(p);
	}
	public int agregar(Cliente cliente)throws Exception {
		if(traer(cliente.getDni()) != null) throw new Exception ("ERROR, ya existe un cliente con el dni: " + cliente.getDni());
		return dao.agregar(cliente);
	}
	
	
	//Modifica Clientes y Empleados
	public void modificar(Persona p)throws Exception {
		if(traer(p.getDni()) == null)throw new Exception ("Error, esta queriendo modificar una persona que no existe");
		dao.actualizar(p);
	}
	
	//Elimina Clientes y Empleados
	public void eliminar(long idPersona)throws Exception {
		Persona p = traer(idPersona);
		if(p == null)throw new Exception("ERROR, la persona con id " + idPersona +" que quiere eliminar no existe");
		dao.eliminar(p);
	}
	
	public List<Persona> traer(){
		return dao.traer();
	}
	
}
