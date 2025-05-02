package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Persona;
import datos.Servicio;
import datos.Turno;

public class TurnoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Turno objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	 
	public void actualizar(Turno objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	public void eliminar(Turno objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	public Turno traer(long idTurno) {
		Turno objeto = null;
	 	try {
	 		iniciaOperacion();
	 		objeto = (Turno) session.get(Turno.class, idTurno);
	 	} finally {
	 		session.close();
	 	}
	 	return objeto;
	}
	
	
	public List<Turno> traer(){
		List<Turno> lista = new ArrayList<Turno>();
		try {
			iniciaOperacion();
			Query<Turno> query = session.createQuery("from Turno t order by t.idTurno asc", Turno.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerXCliente(int idCliente) {
	    List<Turno> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t where t.cliente.idCliente = :idCliente order by t.fecha asc, t.hora asc", Turno.class);
	        query.setParameter("idCliente", idCliente);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	public List<Turno> traerXEmpleado(int idEmpleado) {
	    List<Turno> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t where t.empleado.idEmpleado = :idEmpleado order by t.fecha asc, t.hora asc", Turno.class);
	        query.setParameter("idEmpleado", idEmpleado);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
}
