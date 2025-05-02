package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ContactoABM;
import negocio.PersonaABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona =new PersonaABM();
		
		try {
			long ultimoIdCliente = abmPersona.agregar("Di Maria", "Angel", 30300300, LocalDate.of(1988,2,14), null, LocalDate.now());
			System.out.printf("Id cliente: %d", ultimoIdCliente);

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
