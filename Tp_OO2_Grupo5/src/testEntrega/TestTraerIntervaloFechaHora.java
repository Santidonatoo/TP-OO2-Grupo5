package testEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

import negocio.TurnoABM;

public class TestTraerIntervaloFechaHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
TurnoABM abmTurno = new TurnoABM();
		
		System.out.println(abmTurno.traerXIntervaloDeHora(LocalDate.of(2025, 9, 24), LocalTime.of(17, 00), LocalTime.of(19, 00)));
		
		System.out.println(abmTurno.traerXIntervaloDeFecha(LocalDate.of(2025, 9, 25), LocalDate.of(2025, 9, 30)));

	}

}
