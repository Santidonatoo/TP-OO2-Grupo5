package test;

import datos.Empleado;
import datos.Servicio;
import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestAgregarServiciosAEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		ServicioABM abmServicio = new ServicioABM();
		
		Empleado emp = (Empleado)abmPersona.traer(3L); //Martin 
		emp.agregar(abmServicio.traer(1L));
		emp.agregar(abmServicio.traer(2L));
		
		abmPersona.modificar(emp);
				//Por si quieren fijarse en la base de datos-->
				//SELECT s.* FROM servicio s JOIN servicioxempleado es 
				//ON s.idServicio = es.idServicio WHERE es.idEmpleado = 3;
		
		Servicio ser =abmServicio.traer(3L);//Decoloracion Global
		ser.agregar((Empleado)abmPersona.traer(4L));//Santino
		
		abmServicio.modificar(ser);
				//SELECT e.*, p.nombre FROM empleado e JOIN servicioxempleado es ON e.idEmpleado = es.idEmpleado 
				//JOIN persona p ON e.idEmpleado = p.idPersona
				//WHERE es.idServicio = 3;;
	}

}
