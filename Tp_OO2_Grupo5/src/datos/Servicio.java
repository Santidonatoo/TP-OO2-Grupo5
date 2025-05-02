package datos;

import java.util.Iterator;
import java.util.Set;

public class Servicio {
	private long idServicio;
	private String nombre;
	private Set<Empleado> empleados;
	
	public Servicio() {}
	
	public Servicio(String nombre, Set<Empleado> empleados) {
		this.nombre = nombre;
		this.empleados = empleados;
	}


	public long getIdServicio() {
		return idServicio;
	}
	protected void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	public boolean equals(Servicio servicio){
		return (idServicio==servicio.getIdServicio());
	}

	public boolean agregar(Empleado empleado){
		boolean agregar=false;
		if (! (empleados.contains(empleado))) {
			agregar=empleados.add(empleado);
		}
		return agregar;
	}
	public boolean eliminar(Empleado empleado){
		Empleado borrar=null;
		boolean eliminar=false;
		Iterator<Empleado> it = empleados.iterator();
		while ((it.hasNext()) && (borrar==null)){
			Empleado e=it.next();
			if (e.equals(empleado) ) borrar=e;
		}
		eliminar=empleados.remove(borrar);
		return eliminar;
	}
	
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + "]";
	}
	
	
}
