package testEntrega;

import datos.Turno;
import negocio.ClienteABM;
import negocio.TurnoABM;

public class TestConfirmarTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ClienteABM abmCliente = new ClienteABM();
		TurnoABM abmTurno = new TurnoABM();
		Turno t = abmTurno.traer(1L);
		
		System.out.println(t);
		
		try {
			abmCliente.confirmarTurno(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Turno Confirmado:\n");
		System.out.println(abmTurno.traer(1L));
	}

}
