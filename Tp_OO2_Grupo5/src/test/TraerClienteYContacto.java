package test;

import datos.Persona;
import negocio.PersonaABM;

public class TraerClienteYContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		long idCliente = 1;
		Persona p = abmPersona.traerPersonaYContacto(idCliente);
		System.out.println(p);
	}

}
