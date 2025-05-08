package testEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Empleado;
import datos.Persona;
import datos.Servicio;
import negocio.ContactoABM;
import negocio.PersonaABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class TestExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		ContactoABM abmContacto = new ContactoABM();
		ServicioABM abmServicio = new ServicioABM();
		TurnoABM abmTurno = new TurnoABM();

		
		System.out.println("Intentar agregar una persona con un dni que ya existe");
		try {
			long ultimoIdCliente = abmPersona.agregar("Mismo", "DNI", 30300300, LocalDate.of(1988,2,14), null, LocalDate.now());
			System.out.printf("Id cliente: %d", ultimoIdCliente);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Intentar agregar un contacto a una persona que ya tiene");
		try {
			abmContacto.agregar("dimaria@gmail.com","1100000000", abmPersona.traer(1L));
		}catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("Intentar agregar un servicio con el mismo nombre");
		try {
			long ultimoIdServicio = abmServicio.agregar("Corte Estandar", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Intentar agregar un servicio a un empleado que ya lo tiene vinculado");
		Empleado emp1 = (Empleado)abmPersona.traer(3L); //Martin 
		Servicio ser1 =abmServicio.traer(1L);//Corte Estandar
		try {
			emp1.agregar(ser1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Intentar agregar un empleado a un servicio que ya lo tiene vinculado");
		try {
			ser1.agregar(emp1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Intentar agregar un turno con la misma fechahora que otro turno con el mismo cliente");

		try {
			long numTurno = abmTurno.agregar(LocalDate.of(2025, 9, 28), LocalTime.of(17, 00), "Pendiente", "Alsina 1261", (Cliente)abmPersona.traer(1L), null, abmServicio.traer(8L));
			System.out.printf("Id Turno: %d", numTurno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Elimino a Pepe Pepini, muestro que se elimino de la lista de empleados del servicio Decoloracion Global");
		Persona pepe = abmPersona.traer(7L);
		try {
			abmPersona.eliminar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n--- Traemos los empleados asignados en el servicio con id = 3 ---");
		long idServicio = 3;
		
		Servicio s2 = abmServicio.traer(idServicio);
		System.out.println(s2);
		System.out.println("Empleados:");

		for(Empleado e2 : s2.getEmpleados()) {
			System.out.println(e2);
		}
		System.out.println("Intentar eliminar a Pepe Pepini de nuevo");
		try {
			abmPersona.eliminar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Intentar modificar a Pepe Pepini(No existe mas)");
		try {
			abmPersona.modificar(pepe);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
