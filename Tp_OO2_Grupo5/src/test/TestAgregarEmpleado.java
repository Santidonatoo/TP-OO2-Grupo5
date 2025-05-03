package test;

import java.time.LocalDate;

import negocio.PersonaABM;

public class TestAgregarEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona =new PersonaABM();

		try {
			long empleado = abmPersona.agregar("Echavarria", "Martin", 46267265, LocalDate.of(2005,1,20), null, "Barbero");
			System.out.printf("Id Empelado: %d", empleado);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long empleado = abmPersona.agregar("Donato", "Santino", 46638634, LocalDate.of(2005,5,11), null, "Colorista");
			System.out.printf("Id Empelado: %d", empleado);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
