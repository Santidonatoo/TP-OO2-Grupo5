package test;

import java.time.LocalDate;

import negocio.PersonaABM;

public class TestAgregarEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona =new PersonaABM();

		try {
			long empleado = abmPersona.agregar("Martin", "Echavarria", 46267265, LocalDate.of(2005,1,20), null, "Barbero");
			System.out.printf("Id Empelado: %d", empleado);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long empleado = abmPersona.agregar("Santino", "Donato", 46638634, LocalDate.of(2005,5,11), null, "Colorista");
			System.out.printf("Id Empelado: %d", empleado);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long empleado = abmPersona.agregar("Muriel", "Ramello", 46701858, LocalDate.of(2005,6,13), null, "Peluquera");
			System.out.printf("Id Empelado: %d", empleado);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long empleado = abmPersona.agregar("Jose", "Ruival", 43895400, LocalDate.of(2001,12,4), null, "Dueño");
			System.out.printf("Id Empelado: %d", empleado);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
