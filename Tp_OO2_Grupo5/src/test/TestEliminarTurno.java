package test;

import datos.Turno;
import negocio.TurnoABM;

public class TestEliminarTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TurnoABM abmTurno = new TurnoABM();
		
		//Antes de probar el eliminar usar el TestAgregarTurno!
		
		try {
			abmTurno.eliminar(1L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
