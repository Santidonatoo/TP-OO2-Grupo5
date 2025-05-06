package negocio;

import java.util.List;
import java.util.Set;
import dao.ServicioDao;
import datos.Empleado;
import datos.Servicio;

public class ServicioABM {
	ServicioDao dao = new ServicioDao();
	
	public Servicio traer(long idServicio) {
		return dao.traer(idServicio);
	}
	public Servicio traer(String nombre) {
		return dao.traer(nombre);
	}
	 
	public int agregar(String nombre, Set<Empleado> empleados)throws Exception{
		if(traer(nombre)!= null)throw new Exception("Ya existe este servicio: " + nombre);
		Servicio s = new Servicio(nombre, empleados);
		return dao.agregar(s);
	}
	 
	public void modificar(Servicio s) {
		dao.actualizar(s);
	}
		
	public void eliminar(long idServicio)throws Exception {

		Servicio s = dao.traer(idServicio);
		if(s == null)throw new Exception("El servicio no existe");
		if(s.getEmpleados()!=null)throw new Exception("No se puede eliminar, el servicio tiene empleados enlazados");
		dao.eliminar(s);
	}
	
	public List<Servicio> traer() {
		return dao.traer();
	}
	
}
