package test;

import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestEliminarEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		try {
			abmPersona.eliminar(5L);
		}catch(Exception e) {
			e.printStackTrace();
		}
		ServicioABM abmServicio = new ServicioABM();
		try {
			abmServicio.eliminar(3L);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
