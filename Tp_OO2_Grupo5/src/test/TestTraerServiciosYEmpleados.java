package test;

import datos.Empleado;
import datos.Servicio;
import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestTraerServiciosYEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		long idCliente = 4;
	
		Empleado e1 = (Empleado)abmPersona.traer(idCliente);
		System.out.println(e1);
		System.out.println("Servicios:");

		for(Servicio s1 : e1.getServicios()) {
			System.out.println(s1);
		}
		ServicioABM abmServicio = new ServicioABM();
		long idServicio = 6;
		
		Servicio s2 = abmServicio.traer(idServicio);
		System.out.println("\n" + s2);
		System.out.println("Empleados:");

		for(Empleado e2 : s2.getEmpleados()) {
			System.out.println(e2);
		}
	}

}
