package net.kzn;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.kzn.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final Logger logger = LoggerFactory.getLogger(App.class); 
    public static void main( String[] args )
    {
       Session session = null;
       Transaction tx = null;
       try {
    	   session = HibernateUtil.getSessionFactory().openSession();
    	   tx = session.getTransaction();
    	   
    	   tx.begin();
    	   
    	   String hql = "SELECT version()";    	   
    	   String version = session.createNativeQuery(hql).getSingleResult().toString();
    	   logger.info(version);
    	       	   
    	   tx.commit();
       }
       catch(Exception ex) {
    	   logger.error("Exception - ",ex);
    	   if(tx!=null) {
    		   tx.rollback();
    	   }
       }
       finally {
    	   if(session!=null) {
    		   session.close();
    	   }
       }
       HibernateUtil.shutdown();
    }
}
