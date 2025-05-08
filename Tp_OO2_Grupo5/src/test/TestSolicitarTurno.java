package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
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
		Servicio servicio1 =  abmServicio.traer(6L);
		
		
		try {
			abmCliente.solicitarTurno(LocalDate.of(2025, 9, 24), LocalTime.of(17, 00), servicio1, cliente1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
