package test;

import datos.Empleado;
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
		
		//ME FALTA TERMINARLO
		abmPersona.modificar(emp);
	
	}

}
