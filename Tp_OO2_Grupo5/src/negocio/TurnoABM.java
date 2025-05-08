package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.TurnoDao;
import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import datos.Turno;

public class TurnoABM {
	
	TurnoDao dao = new TurnoDao();
	
	public int agregar(LocalDate fecha, LocalTime hora, String estado, String ubicacion, Cliente cliente, Empleado empleado, Servicio servicio) throws Exception {
		
		if(empleado != null) {
			if(dao.existeTurnoEnRangoXEmpleado(empleado, fecha, hora)) throw new Exception("ERROR, el empleado ya tiene ocupado este horario!");
		}
		
		if(dao.existeTurnoEnRangoXCliente(cliente, fecha, hora)) throw new Exception("ERROR, usted ya tiene un turno en este horario!");
		
		Turno t = new Turno(fecha, hora, estado, ubicacion, cliente, empleado, servicio);
		return dao.agregar(t);
	}
	
	public void modificar(Turno t) throws Exception {
		Turno turno = dao.traer(t.getIdTurno());
		if(turno == null) throw new Exception("ERROR, el turno que desea modificar no existe!");
		
		if(!turno.getFecha().equals(t.getFecha()) || !turno.getHora().equals(t.getHora())) {
			if(t.getEmpleado() != null) {
				if(dao.existeTurnoEnRangoXEmpleado(t.getEmpleado(), t.getFecha(), t.getHora())) throw new Exception("ERROR, el empleado ya tiene ocupado este horario!");	
			}
			if(dao.existeTurnoEnRangoXCliente(t.getCliente(), t.getFecha(), t.getHora())) throw new Exception("ERROR, usted ya tiene un turno en este horario!");
			
		}
		
		dao.actualizar(t);
	}
	
	public void eliminar(long idTurno)throws Exception {

		Turno t = dao.traer(idTurno);
		if(t == null)throw new Exception("El turno no existe");
		dao.eliminar(t);
		
	}
	
	public Turno traer(long idTurno) {
		return dao.traer(idTurno);
	}
	
	public List<Turno> traer() {
		return dao.traer();
	}
	
	public List<Turno> traerPorCliente(long idCliente) {
		return dao.traerXCliente(idCliente);
	}
	
	public List<Turno> traerPorEmpleado(long idEmpleado) {
		return dao.traerXEmpleado(idEmpleado);
	}
	
	public List<Turno> traerPorServicio(long idServicio) {
		return dao.traerXServicio(idServicio);
	}
	
	public List<Turno> traerXIntervaloDeHora(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
		return dao.traerXIntervaloDeHora(fecha, horaInicio, horaFin);
	}
	
	public List<Turno> traerXIntervaloDeFecha(LocalDate fechaInicio, LocalDate fechaFin) {
		return dao.traerXIntervaloDeFecha(fechaInicio, fechaFin);
	}
	
}
