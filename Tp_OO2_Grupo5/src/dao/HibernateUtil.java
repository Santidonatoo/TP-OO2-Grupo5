package dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				String USERNAME = System.getenv("USERNAME");
				String PASSWORD = System.getenv("PASSWORD");
				String NOMBREBD = System.getenv("NOMBRE-BD");
				
				if(USERNAME == null || PASSWORD == null || NOMBREBD == null) {
					throw new RuntimeException("Faltan variables de entorno: username, password o nombrebd");
				}
				
				String url = "jdbc:mysql://localhost:3306/" + NOMBREBD + "?serverTimezone=GMT-3";
				
				Map<String, String> settingsOverride = new HashMap<>();
                settingsOverride.put("hibernate.connection.username", USERNAME);
                settingsOverride.put("hibernate.connection.password", PASSWORD);
                settingsOverride.put("hibernate.connection.url", url);
				
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();
				Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
		} catch (HibernateException he) {
			System.err.println("ERROR en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		return sessionFactory;
	}
}
