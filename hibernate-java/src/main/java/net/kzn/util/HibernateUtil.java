package net.kzn.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static StandardServiceRegistry registry = null;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {			
			
			registry = new StandardServiceRegistryBuilder().build();
						
			sessionFactory = new MetadataSources()
								.addPackage("net.kzn.entity")
								.getMetadataBuilder()
								.build()
								.buildSessionFactory();
								

		}
		return sessionFactory;
	}
	
	public static void shutdown() {
		if(registry!=null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	
}
