package negocio;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import datos.Turno;

public class ClienteABM {
	
	EmpleadoABM abmEmpleado = new EmpleadoABM();
	TurnoABM abmTurno = new TurnoABM();
	ServicioABM abmServicio = new ServicioABM();
	PersonaABM abmPersona = new PersonaABM();
	
	//Elimina un turno
	public void cancelarTurno(Turno turno) throws Exception {
		
		if(abmTurno.traer(turno.getIdTurno()) == null) throw new Exception("ERROR, el turno no existe");

		if (Duration.between(LocalDateTime.now(), LocalDateTime.of(turno.getFecha(), turno.getHora())).toHours() < 24) 
			throw new Exception("ERROR, no se puede cancelar al turno faltando menos de 24 horas");
		
		 abmTurno.eliminar(turno.getIdTurno());
	}
	
	//Cambia el estado del turno a confirmado
	public void confirmarTurno(Turno turno)throws Exception {
		turno.setEstado("Confirmado");
		abmTurno.modificar(turno);
	}
	
	public void solicitarTurno(LocalDate fecha, LocalTime hora, Servicio servicio, Cliente cliente) throws Exception{
		
		if(abmServicio.traer(servicio.getIdServicio()) == null) throw new Exception("ERROR, el servicio no existe");
		
		Empleado empleado = null;
		if(servicio.isRequiereEmpleado() == true) {
			
			empleado = abmEmpleado.traerEmpleadoDisponible(fecha, hora, servicio);
			if(empleado == null)throw new Exception("Lo sentimos :(  No contamos con empleados disponibles en este momento");
		}
		
		//si la persona no esta cargada en la base de datos la agrega
		if(abmPersona.traer(cliente.getDni()) == null) {
			
			abmPersona.agregar(cliente);
		}
		abmTurno.agregar(fecha, hora, "Pendiente", "Alsina 1261",cliente  , empleado, servicio);
		
		
	}

}
