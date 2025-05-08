package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Empleado;
import datos.Servicio;


public class EmpleadoDao {
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
	
	
	public Empleado traerEmpleadoDisponible(LocalDate fecha, LocalTime hora, Servicio servicio) {

        Empleado empleado = null;
        try {
            iniciaOperacion();

            Query<Empleado> query = session.createQuery(
                    "SELECT e FROM Empleado e " +
                    		"WHERE e.idPersona NOT IN ( " +
                    		"  SELECT t.empleado.idPersona FROM Turno t " +
                    		"  WHERE t.fecha = :fecha " +
                    		"    AND t.hora BETWEEN :horaInicio AND :horaFin " +
                    		") " +
                    		"AND e IN ( " +
                    		"  SELECT em FROM Servicio s JOIN s.empleados em " +
                    		"  WHERE s.idServicio = :servicio " +
                    		") " +
                    		"ORDER BY RAND()",

                Empleado.class);

            query.setParameter("fecha", fecha);
            query.setParameter("horaInicio", hora.minusMinutes(59));
            query.setParameter("horaFin", hora.plusMinutes(59));
            query.setParameter("servicio", servicio.getIdServicio());

            query.setMaxResults(1);
            List<Empleado> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                empleado = resultados.get(0);
            }
        } finally {
            session.close();
        }

        return empleado;
    }
	
	
	
	
}
