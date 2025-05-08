package testEntrega;

import negocio.PersonaABM;
import negocio.TurnoABM;

public class TestTraerTurnoPorClienteYEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TurnoABM abmTurno = new TurnoABM();
		PersonaABM abmPersona = new PersonaABM();
		
		System.out.println(abmTurno.traerPorCliente(1L));
		
		System.out.println(abmTurno.traerPorEmpleado(3L));
		
		System.out.println(abmTurno.traerPorServicio(6L));
	}

}
