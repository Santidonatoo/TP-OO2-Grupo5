package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import negocio.PersonaABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class TestAgregarTurno {
	
	public static void main(String[] args) {
		
		PersonaABM abmPersona = new PersonaABM();
		ServicioABM abmServicio = new ServicioABM();
		TurnoABM abmTurno = new TurnoABM();
		
		Empleado emp1 = (Empleado)abmPersona.traer(3L); //Martin 
		Cliente cl1 = (Cliente)abmPersona.traer(1L); //Di maria
		Servicio ser1 =abmServicio.traer(1L);//Corte Estandar
		
		try {
			long numTurno = abmTurno.agregar(LocalDate.of(2025, 9, 20), LocalTime.of(17, 00), "Pendiente", "Alsina 1261", cl1, emp1, ser1);
			System.out.printf("Id Turno: %d", numTurno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
