package negocio;

import java.time.Duration;
import java.time.LocalDateTime;

import dao.PersonaDao;
import datos.Turno;

public class ClienteABM {
	
	PersonaDao dao = new PersonaDao();
	TurnoABM abmTurno = new TurnoABM();
	
	//Elimina un turno
	public void cancelarTurno(Turno turno) throws Exception {
		
		if(abmTurno.traer(turno.getIdTurno()) == null) throw new Exception("ERROR, el turno no existe");

		if (Duration.between(LocalDateTime.now(), LocalDateTime.of(turno.getFecha(), turno.getHora())).toHours() < 24) throw new Exception("ERROR, no se puede cancalar al turno faltando menos de 24 horas");
		
		 abmTurno.eliminar(turno.getIdTurno());
	}
	
	//Cambia el estado del turno a confirmado
	public void confirmarTurno(Turno turno)throws Exception {
		//if(abmTurno.traer(turno.getIdTurno()) == null) throw new Exception("ERROR, el turno no existe");
		turno.setEstado("Confirmado");
		abmTurno.modificar(turno);
	}

}
