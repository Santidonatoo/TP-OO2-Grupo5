package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
import datos.Empleado;
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
	 		Query<Turno> query = session.createQuery(
	 			    "select t from Turno t " +
	 			    "join fetch t.servicio " +
	 			    "left join fetch t.empleado " +
	 			    "join fetch t.cliente " +
	 			    "where t.id = :id", Turno.class);
	 			query.setParameter("id", idTurno);
	 			objeto = query.uniqueResult();
	 	} finally {
	 		session.close();
	 	}
	 	return objeto;
	}
	
	
	public List<Turno> traer(){
		List<Turno> lista = new ArrayList<Turno>();
		try {
			iniciaOperacion();
			Query<Turno> query = session.createQuery(
					"from Turno t " +
	 			    "join fetch t.servicio " +
	 			    "left join fetch t.empleado " +
	 			    "join fetch t.cliente " +
					"order by t.idTurno asc", Turno.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Turno> traerXCliente(long idCliente) {
	    List<Turno> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t " +
	        		"join fetch t.servicio " +
	 			    "left join fetch t.empleado " +
	 			    "join fetch t.cliente " +
	        		"WHERE t.cliente.idPersona = :idCliente order by t.fecha asc, t.hora asc", Turno.class);
	        query.setParameter("idCliente", idCliente);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	public List<Turno> traerXEmpleado(long idEmpleado) {
	    List<Turno> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t " +
	        		"join fetch t.servicio " +
	 			    "left join fetch t.empleado " +
	 			    "join fetch t.cliente " +
	        		"WHERE t.empleado.idPersona = :idEmpleado order by t.fecha asc, t.hora asc", Turno.class);
	        query.setParameter("idEmpleado", idEmpleado);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	public List<Turno> traerXServicio(long idServicio) {
	    List<Turno> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t " +
	        		"join fetch t.servicio " +
	 			    "left join fetch t.empleado " +
	 			    "join fetch t.cliente " +
	        		"WHERE t.servicio.idServicio = :idServicio order by t.fecha asc, t.hora asc", Turno.class);
	        query.setParameter("idServicio", idServicio);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	public List<Turno> traerXIntervaloDeHora(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
		List<Turno> lista = new ArrayList<>();
		try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t " 
	        		+ "join fetch t.servicio "
	        		+ "left join fetch t.empleado "
	        		+ "join fetch t.cliente " 
	        		+ "WHERE t.fecha = :fecha and t.hora BETWEEN :horaInicio AND :horaFin"
	        		, Turno.class);
	        query.setParameter("fecha", fecha);
	        query.setParameter("horaInicio", horaInicio);
	        query.setParameter("horaFin", horaFin);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	public List<Turno> traerXIntervaloDeFecha(LocalDate fechaInicio, LocalDate fechaFin){
		List<Turno> lista = new ArrayList<>();
		try {
	        iniciaOperacion();
	        Query<Turno> query = session.createQuery("from Turno t "
	        		+ "join fetch t.servicio "
	        		+ "left join fetch t.empleado "
	        		+ "join fetch t.cliente "
	        		+ "WHERE t.fecha BETWEEN :fechaInicio and :fechaFin", Turno.class);
	        query.setParameter("fechaInicio", fechaInicio);
	        query.setParameter("fechaFin", fechaFin);
	        lista = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	public boolean existeTurnoEnRangoXEmpleado(Empleado empleado, LocalDate fecha, LocalTime hora) {
		Long conteo = null;
		try {
	        iniciaOperacion();
	        Query<Long> query = session.createQuery("SELECT COUNT(t) FROM Turno t WHERE t.empleado = :empleado AND t.fecha = :fecha AND t.hora BETWEEN :horaInicio AND :horaFin", Long.class);
	        query.setParameter("empleado", empleado);
	        query.setParameter("fecha", fecha);
	        query.setParameter("horaInicio", hora.minusMinutes(59));
	        query.setParameter("horaFin", hora.plusMinutes(59));
	         conteo = query.getSingleResult();
	    } finally {
	        session.close();
	    }
	    return conteo > 0;
	}
	
	public boolean existeTurnoEnRangoXCliente(Cliente cliente, LocalDate fecha, LocalTime hora) {
		Long conteo = null;
		try {
	        iniciaOperacion();
	        Query<Long> query = session.createQuery("SELECT COUNT(t) FROM Turno t WHERE t.cliente = :cliente AND t.fecha = :fecha AND t.hora BETWEEN :horaInicio AND :horaFin", Long.class);
	        query.setParameter("cliente", cliente);
	        query.setParameter("fecha", fecha);
	        query.setParameter("horaInicio", hora.minusMinutes(59));
	        query.setParameter("horaFin", hora.plusMinutes(59));
	         conteo = query.getSingleResult();
	    } finally {
	        session.close();
	    }
	    return conteo > 0;
	}
	
}
