package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Turno;

public class TestModificarFechaHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmpleadoABM abmEmpleado = new EmpleadoABM();
		TurnoABM abmTurno = new TurnoABM();
		
		Turno turno = abmTurno.traer(5L);
		try {
			abmEmpleado.modificarFechaHora(turno, LocalDate.of(2025, 9, 24), LocalTime.of(19,00));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
