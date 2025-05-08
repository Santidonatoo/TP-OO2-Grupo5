package datos;

import java.util.Iterator;
import java.util.Set;

public class Servicio {
	private long idServicio;
	private String nombre;
	private boolean requiereEmpleado;
	private Set<Empleado> empleados;
	
	public Servicio() {}
	
	public Servicio(String nombre, boolean requiereEmpleado, Set<Empleado> empleados) {
		this.nombre = nombre;
		this.requiereEmpleado = requiereEmpleado;
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
	public boolean isRequiereEmpleado() {
		return requiereEmpleado;
	}
	public void setRequiereEmpleado(boolean requiereEmpleado) {
		this.requiereEmpleado = requiereEmpleado;
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
	public Empleado traerEmpleadoPorDni(int dni) {
		Empleado encontrado = null;
	    for (Empleado empleado : empleados) {
	        if (empleado.getDni() == dni) {
	            encontrado = empleado;
	        }
	    }
	    return encontrado;
	}
	
	
	
	public boolean agregar(Empleado empleado)throws Exception{
		if(traerEmpleadoPorDni(empleado.getDni())!=null)throw new Exception
		("ERROR el empleado con dni: "+ empleado.getDni() + " ya esta vinculado con este servicio") ;
		boolean agregar=false;
		if (! (empleados.contains(empleado))) {
			agregar=empleados.add(empleado);
		}
		return agregar;
	}
	public boolean eliminar(Empleado empleado)throws Exception{
		if(traerEmpleadoPorDni(empleado.getDni())==null)throw new Exception
		("ERROR el empleado no esta vinculado") ;
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
		return "Servicio | idServicio: " + idServicio + " - " + nombre + " - requiereEmpleado:" + requiereEmpleado;
	}
}
