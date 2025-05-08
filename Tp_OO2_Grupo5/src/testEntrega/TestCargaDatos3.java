package testEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import negocio.PersonaABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class TestCargaDatos3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		ServicioABM abmServicio = new ServicioABM();
		TurnoABM abmTurno = new TurnoABM();
		
		//--- ESTE TEST AGREGA LOS TURNOS A LA BASE DE DATOS ---
		Empleado emp1 = (Empleado)abmPersona.traer(3L); //Martin
		Cliente cl1 = (Cliente)abmPersona.traer(1L); //Di maria
		Servicio ser1 = abmServicio.traer(1L);//Corte Estandar
		Servicio ser2 = abmServicio.traer(8L); //Servicio sin emp

		try {
			long numTurno = abmTurno.agregar(LocalDate.of(2025, 9, 20), LocalTime.of(17, 00), "Pendiente", "Alsina 1261", cl1, emp1, ser1);
			System.out.printf("Id Turno: %d", numTurno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			long numTurno = abmTurno.agregar(LocalDate.of(2025, 9, 23), LocalTime.of(17, 00), "Pendiente", "Alsina 1261", cl1, emp1, ser1);
			System.out.printf("Id Turno: %d", numTurno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			long numTurno = abmTurno.agregar(LocalDate.of(2025, 9, 28), LocalTime.of(17, 00), "Pendiente", "Alsina 1261", cl1, null, ser2);
			System.out.printf("Id Turno: %d", numTurno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
