package negocio;

import java.time.LocalDate;

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
	
	//Agrega Empleado
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto, String puesto)throws Exception {
		if(dao.traer(dni) != null) throw new Exception ("ERROR, ya existe un empleado con el dni: " + dni);
		Persona p = new Empleado(nombre, apellido, dni, fechaDeNacimiento, contacto, puesto);
		return dao.agregar(p);
	}
	
	//Agrega Cliente
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto, LocalDate fechaIngreso)throws Exception {
		if(dao.traer(dni) != null) throw new Exception ("ERROR, ya existe un cliente con el dni: " + dni);
		Persona p = new Cliente(nombre, apellido, dni, fechaDeNacimiento, contacto, fechaIngreso);
		return dao.agregar(p);
	}
	
}
