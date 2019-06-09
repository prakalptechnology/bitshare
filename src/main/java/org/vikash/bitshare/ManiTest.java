package org.vikash.bitshare;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vikash.dto.Users;

public class ManiTest {
	private static SessionFactory factory;
	public static void main(String ... arg)
	{
		Users u1=new Users();
		u1.setUser_id(1);
		u1.setFirst_Name("Vikash");
		u1.setLast_name("Kumar");
		u1.setActive(true);
		try {
	         factory = new Configuration().configure().buildSessionFactory();	
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(u1);
		session.getTransaction().commit();
		session.close();
		} catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
}
