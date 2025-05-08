package testEntrega;

import java.time.LocalDate;

import datos.Cliente;
import datos.Empleado;
import negocio.PersonaABM;
import negocio.TurnoABM;

public class TestTraerClienteYEmpleadoPorFecha {
	
	public static void main(String[] args) {
		
		TurnoABM abmTurno = new TurnoABM();
		PersonaABM abmPersona = new PersonaABM();
		
		System.out.println(abmTurno.traerPorClienteEnFecha((Cliente)abmPersona.traer(1L), LocalDate.of(2025,9,24)));
		
		System.out.println(abmTurno.traerPorEmpleadoEnFecha((Empleado)abmPersona.traer(3L), LocalDate.of(2025,9,20)));
	}
}
