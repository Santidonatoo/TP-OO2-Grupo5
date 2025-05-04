package test;

import negocio.ServicioABM;

public class TestAgregarServicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicioABM abmServicio =new ServicioABM();
		
		try {
			long ultimoIdServicio = abmServicio.agregar("Corte Estandar", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Aseo de Barba", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Decoloracion Global", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Decoloracion Mechas", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Alisado", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Perfilado de cejas", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Peinados para eventos", null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
