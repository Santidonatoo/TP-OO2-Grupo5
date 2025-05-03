package test;

import java.time.LocalDate;

import negocio.PersonaABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona =new PersonaABM();
		
		try {
			long ultimoIdCliente = abmPersona.agregar("Angel", "Di Maria", 30300300, LocalDate.of(1988,2,14), null, LocalDate.now());
			System.out.printf("Id cliente: %d", ultimoIdCliente);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			long cliente = abmPersona.agregar("Lionel", "Messi", 11111111, LocalDate.of(1987,6,24), null, LocalDate.now());
			System.out.printf("Id cliente: %d", cliente);

		}catch(Exception e) {
			e.printStackTrace();
		}

		
		
		

	}

}
