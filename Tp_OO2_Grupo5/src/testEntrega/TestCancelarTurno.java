package testEntrega;

import negocio.ClienteABM;
import negocio.TurnoABM;

public class TestCancelarTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM abmCliente = new ClienteABM();
		TurnoABM abmTurno = new TurnoABM();
		
		try {
			abmCliente.cancelarTurno(abmTurno.traer(2L));
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
