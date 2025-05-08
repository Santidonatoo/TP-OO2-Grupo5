package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	
	private long idTurno;
	private LocalDate fecha;
	private LocalTime hora;
	private String estado;
	private String ubicacion;
	private Cliente cliente;
	private Empleado empleado;
	private Servicio servicio;
	
	public Turno() {}
	
	public Turno(LocalDate fecha, LocalTime hora, String estado, String ubicacion, Cliente cliente, Empleado empleado, Servicio servicio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.ubicacion = ubicacion;
		this.cliente = cliente;
		this.empleado = empleado;
		this.servicio = servicio;
	}
	
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUbicacion() {
	    return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
	    this.ubicacion = ubicacion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
	
	public String toString() {
		return "Turno | idTurno: " + idTurno + " - fecha: " + fecha + " - hora: " + hora + " - estado: " + estado
				+ " - ubicacion: " + ubicacion
		+ "\n\tServicio: " + servicio.getNombre() + "\n\tEmpleado: " + empleado.getNombre() + " " +  empleado.getApellido() + "\n\tCliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\n";
	}
	
}
