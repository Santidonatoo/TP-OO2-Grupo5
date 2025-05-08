package testEntrega;

import datos.Empleado;
import datos.Servicio;
import negocio.PersonaABM;
import negocio.ServicioABM;

public class TestCargaDatos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaABM abmPersona = new PersonaABM();
		ServicioABM abmServicio = new ServicioABM();
		
		//--- ESTE TEST LINKEA A LOS EMPLEADOS CON LOS SERVICIOS QUE SE OFRECEN ---
		Empleado emp1 = (Empleado)abmPersona.traer(3L); //Martin 
		Empleado emp2 = (Empleado)abmPersona.traer(4L); //Santino 
		Empleado emp3 = (Empleado)abmPersona.traer(5L); //Muriel 		
		Empleado emp4 = (Empleado)abmPersona.traer(6L); //Jose 
		
		Servicio ser1 =abmServicio.traer(1L);//Corte Estandar
		Servicio ser2 =abmServicio.traer(2L);//Aseo de Barba
		Servicio ser3 =abmServicio.traer(3L);//Decoloracion Global
		Servicio ser4 =abmServicio.traer(4L);//Decoloracion Mechas
		Servicio ser5 =abmServicio.traer(5L);//Alisado
		Servicio ser6 =abmServicio.traer(6L);//Perfilado de cejas
		Servicio ser7 =abmServicio.traer(7L);//Peinados para eventos


		try {
			emp1.agregar(ser1);
			emp1.agregar(ser2);
			emp1.agregar(ser6);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			abmPersona.modificar(emp1);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		try {
			ser3.agregar(emp2);//Santino
			ser3.agregar(emp4);//Jose		
			}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			abmServicio.modificar(ser3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ser4.agregar(emp2);//Santino
			ser4.agregar(emp4);//Jose		
			}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			abmServicio.modificar(ser4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			emp3.agregar(ser5);
			emp3.agregar(ser6);
			emp3.agregar(ser7);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			abmPersona.modificar(emp3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			emp4.agregar(ser1);
			emp4.agregar(ser2);
			emp4.agregar(ser5);
			emp4.agregar(ser6);
			emp4.agregar(ser7);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			abmPersona.modificar(emp4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
