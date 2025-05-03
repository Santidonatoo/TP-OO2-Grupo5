package test;

import negocio.PersonaABM;

public class TestEliminarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		try {
			abmPersona.eliminar(3L);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Ok");
	}

}
