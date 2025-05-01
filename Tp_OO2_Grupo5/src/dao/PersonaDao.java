package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Persona;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null; // Patrón Singleton
	
	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException {
	session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Persona objeto) {
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
	 
	public void actualizar(Persona objeto) {
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
	
	public void eliminar(Persona objeto) {
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
	
	public Persona traer(long idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traer(int dni) {
		Persona persona = null;
		try {
			iniciaOperacion();
			persona = (Persona) session.createQuery("from Persona p where p.dni= :dni").setParameter("dni", dni)
					.uniqueResult();
		// En este caso :dni es un marcador de posición para el parámetro.
		// Al utilizar el método setParameter para asignar el valor del parámetro dni esto ayuda a prevenir la inyección de SQL.
		} finally {
			session.close();
		}
		 return persona;
	}
	
	public List<Persona> traer() {
		List<Persona> lista = new ArrayList<Persona>();
		try {
			iniciaOperacion();
			Query<Persona> query = session.createQuery("from Persona p order by p.apellido asc, p.nombre asc", Persona.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	//metodo que se agrega con la relacion de persona-contacto
	public Persona traerPersonaYContacto(long idPersona) throws HibernateException{
		
		Persona objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Persona c inner join fetch c.contacto where c.idPersona = :idPersona";
			objeto = (Persona) session.createQuery(hql).setParameter("idPersona",idPersona).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
}
