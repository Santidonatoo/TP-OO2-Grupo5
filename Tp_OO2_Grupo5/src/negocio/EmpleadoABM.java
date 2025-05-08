package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.Servicio;
import datos.Turno;

public class EmpleadoABM {
	PersonaABM abmPersona = new PersonaABM();
	EmpleadoDao dao = new EmpleadoDao();
	TurnoABM abmTurno = new TurnoABM();
	
	public Empleado traerEmpleadoDisponible(LocalDate fecha, LocalTime hora, Servicio servicio) {
		return dao.traerEmpleadoDisponible(fecha, hora, servicio);
	}
	
	public void modificarFechaHora(Turno turno, LocalDate fecha, LocalTime hora)throws Exception {
		turno.setFecha(fecha);
		turno.setHora(hora);
		abmTurno.modificar(turno);
	}
}
