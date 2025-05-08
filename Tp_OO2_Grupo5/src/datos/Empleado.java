package datos;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Empleado extends Persona {
	private String puesto;
	private Set<Servicio> servicios;
	
	public Empleado() {}

	public Empleado(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto, String puesto) {
		super(nombre, apellido, dni, fechaDeNacimiento, contacto);
		this.puesto = puesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}
	@Override
	public boolean equals(Object obj) {
		Empleado other = (Empleado) obj;
		return idPersona == other.idPersona;
	}
	
	public Servicio traerServicioPorNombre(String nombre) {
	    for (Servicio servicio : servicios) {
	        if (servicio.getNombre().equalsIgnoreCase(nombre)) {
	            return servicio;
	        }
	    }
	    return null;
	}

	public boolean agregar(Servicio servicio)throws Exception{
		if(traerServicioPorNombre(servicio.getNombre())!=null)throw new Exception
		("ERROR el servicio: "+ servicio.getNombre() + " ya esta vinculado con este empleado");
		boolean agregar=false;
		if (! (servicios.contains(servicio))) {
			agregar=servicios.add(servicio);
		}
		return agregar;
	}
	public boolean eliminar(Servicio servicio)throws Exception{
		if(traerServicioPorNombre(servicio.getNombre())==null)throw new Exception
		("ERROR el servicio no esta vinculado");
		Servicio borrar = null;
		boolean eliminar = false;
		Iterator<Servicio> it = servicios.iterator();
		while ((it.hasNext()) && (borrar==null)){
			Servicio s = it.next();
			if (s.equals(servicio)) borrar = s;
		}
		eliminar=servicios.remove(borrar);
		return eliminar;
	}
	
	@Override
	public String toString() {
		return "Empleado | " + super.toString() + " - Puesto: " + puesto + "\nContacto: " + super.getContacto();
	}

	
}
