package test;

import negocio.ServicioABM;

public class TestAgregarServicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicioABM abmServicio =new ServicioABM();
		
		try {
			long ultimoIdServicio = abmServicio.agregar("Corte Estandar", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Aseo de Barba", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Decoloracion Global", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Decoloracion Mechas", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Alisado", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Perfilado de cejas", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long ultimoIdServicio = abmServicio.agregar("Peinados para eventos", true, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
