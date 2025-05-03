package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;


public class EmpleadoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public Empleado traerEmpleadoYServicio(long idEmpleado) {
		 Empleado objeto = null;
		 try {
			 iniciaOperacion();
			 String hql = "from Empleado e where e.idEmpleado =:idEmpleado";
			 objeto = (Empleado) session.createQuery(hql).setParameter("idEmpleado", idEmpleado)
					 .uniqueResult();
			 Hibernate.initialize(objeto.getServicios());
		 } finally {
			 session.close();
		 }
		 return objeto;
	}
}
