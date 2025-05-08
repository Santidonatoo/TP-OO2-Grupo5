package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Persona;
import datos.Servicio;
import negocio.ClienteABM;
import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestSolicitarTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonaABM abmPersona = new PersonaABM();
		ClienteABM abmCliente = new ClienteABM();
		ServicioABM abmServicio = new ServicioABM();
		
		Cliente cliente1 = (Cliente) abmPersona.traer(1L);
		Cliente cliente2 = new Cliente("Enzo", "Fernandez", 40258905, LocalDate.of(2001, 1, 17),null, LocalDate.now());
		Cliente cliente3 = (Cliente) abmPersona.traer(2L);
		Cliente cliente4 = new Cliente("Rodrigo", "De Paul", 38254019, LocalDate.of(1994, 5, 24),null, LocalDate.now());

		Servicio servicio1 =  abmServicio.traer(6L);
		
		try {
			abmCliente.solicitarTurno(LocalDate.of(2025, 9, 24), LocalTime.of(17, 00), servicio1, cliente1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			abmCliente.solicitarTurno(LocalDate.of(2025, 9, 24), LocalTime.of(17, 00), servicio1, cliente2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			abmCliente.solicitarTurno(LocalDate.of(2025, 9, 24), LocalTime.of(17, 00), servicio1, cliente3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			abmCliente.solicitarTurno(LocalDate.of(2025, 9, 24), LocalTime.of(17, 00), servicio1, cliente4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			abmCliente.solicitarTurno(LocalDate.of(2025, 9, 24), LocalTime.of(18,00), servicio1, cliente4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
