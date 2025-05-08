package testEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Turno;
import negocio.EmpleadoABM;
import negocio.TurnoABM;

public class TestModificarFechaHoraTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmpleadoABM abmEmpleado = new EmpleadoABM();
		TurnoABM abmTurno = new TurnoABM();
		
		Turno turno = abmTurno.traer(1L);
		
		System.out.println(turno);
		try {
			abmEmpleado.modificarFechaHora(turno, LocalDate.of(2025, 9, 24), LocalTime.of(15,00));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(abmTurno.traer(1L));
		
		
		System.out.println("Testeando la excepcion cuando el empleado ya se encuentra ocupado en esa franja horaria\n");
		try {
			abmEmpleado.modificarFechaHora(turno, LocalDate.of(2025, 9, 24), LocalTime.of(15,30));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
