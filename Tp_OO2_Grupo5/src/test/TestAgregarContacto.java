package test;

import datos.Persona;
import negocio.ContactoABM;
import negocio.PersonaABM;

public class TestAgregarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonaABM abmPersona =new PersonaABM();
		ContactoABM abmContacto = new ContactoABM();
		Persona persona=abmPersona.traer(1L);
		System.out.println(persona);
		try {
		abmContacto.agregar("elfideo@gmail.com","1190901107", persona);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
