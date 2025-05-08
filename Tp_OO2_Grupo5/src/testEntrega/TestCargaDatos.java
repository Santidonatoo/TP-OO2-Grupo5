package testEntrega;

import java.time.LocalDate;

import negocio.ContactoABM;
import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestCargaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		ContactoABM abmContacto = new ContactoABM();
		ServicioABM abmServicio = new ServicioABM();

		
		//--- Agregando Clientes ---
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
		
		
		//--- Agregando Empleados ---
		try {
			long empleado = abmPersona.agregar("Martin", "Echavarria", 46267265, LocalDate.of(2005,1,20), null, "Barbero");
			System.out.printf("Id Empleado: %d", empleado);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			long empleado = abmPersona.agregar("Santino", "Donato", 46638634, LocalDate.of(2005,5,11), null, "Colorista");
			System.out.printf("Id Empleado: %d", empleado);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			long empleado = abmPersona.agregar("Muriel", "Ramello", 46701858, LocalDate.of(2005,6,13), null, "Peluquera");
			System.out.printf("Id Empleado: %d", empleado);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long empleado = abmPersona.agregar("Jose", "Ruival", 43895400, LocalDate.of(2001,12,4), null, "Dueño");
			System.out.printf("Id Empleado: %d", empleado);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			long empleado = abmPersona.agregar("Pepe", "Pepini", 22333444, LocalDate.of(2000,10,2), null, "Peluquero");
			System.out.printf("Id Empleado: %d", empleado);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//--- Agregando Contactos ---
		try {
			abmContacto.agregar("elfideo@gmail.com","1190901107", abmPersona.traer(1L));
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		try {
			abmContacto.agregar("martinechavarria05@gmail.com","1161610000", abmPersona.traer(3L));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			abmContacto.agregar("santinodonato@gmail.com","1112341234", abmPersona.traer(4L));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			abmContacto.agregar("muriel@gmail.com","1143214321", abmPersona.traer(5L));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//--- Agregando Servicios --- 
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
		
		try {
			long ultimoIdServicio = abmServicio.agregar("Servicio que no requiere empleado", false, null);
			System.out.printf("Id Servicio: %d", ultimoIdServicio);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
