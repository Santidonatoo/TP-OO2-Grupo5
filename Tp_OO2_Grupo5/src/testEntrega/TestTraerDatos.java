package testEntrega;

import negocio.PersonaABM;
import negocio.ServicioABM;
import negocio.TurnoABM;
import datos.Empleado;
import datos.Persona;
import datos.Servicio;
import datos.Turno;

public class TestTraerDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		TurnoABM abmTurno = new TurnoABM();
		ServicioABM abmServicio = new ServicioABM();
		
		//Personas (Clientes y Empleados)
		for(Persona p: abmPersona.traer()) {
			System.out.println(p + "\n");
		}
		
		//Servicios
		for(Servicio s: abmServicio.traer()) {
			System.out.println(s + "\n");
		}
		
		//Turnos
		for(Turno t: abmTurno.traer()) {
			System.out.println(t + "\n");
		}
		
		System.out.println("--- Traemos los servicios del empleado con id = 4 ---");
		long idPersona = 4;
		
		Empleado e1 = (Empleado)abmPersona.traer(idPersona);
		System.out.println(e1);
		System.out.println("Servicios:");

		for(Servicio s1 : e1.getServicios()) {
			System.out.println(s1);
		}
		
		System.out.println("\n--- Traemos los empleados asignados en el servicio con id = 3 ---");
		long idServicio = 3;
		
		Servicio s2 = abmServicio.traer(idServicio);
		System.out.println(s2);
		System.out.println("Empleados:");

		for(Empleado e2 : s2.getEmpleados()) {
			System.out.println(e2);
		}

	}

}
