package org.vikash.bitshare;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.vikash.dto.Password;
import org.vikash.dto.Projects;
import org.vikash.dto.Users;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class AbstractDao {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();	
	//SessionFactory factory;
	public String getPasswordByUserName(String uName)
	{
		String password="";
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session= factory.openSession();
	 	session.beginTransaction();
		Password psw=(Password) session.get(Password.class,uName);
	 	//Users psw=(Users) session.get(Users.class,1);
		session.close();
		if(psw!=null)
			password=psw.getPassword();
		return password;
	}
	public int getMaxUserId()
	{
		Session session= factory.openSession();
		 session.beginTransaction();
		 String hql = "select max(user_id) FROM Users " ;
	             
		 			Query query = session.createQuery(hql);
		 			
		 			List<Integer> userId = (List<Integer>)query.list();
		 			//Users psw=(Users) session.get(Users.class,1);
		session.close();
		return userId.get(0);
	}
	public boolean register(Users user,String password)
	{
		Session session= factory.openSession();
		Password psw=new Password();
		psw.setUsername(user.getUsername());
		psw.setPassword(password);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.beginTransaction();
		session.save(psw);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	 public List<Projects> getProjectbyUserId(int userId) 
	 {
		 Session session= factory.openSession();
		 session.beginTransaction();
		 String hql = "FROM Projects "  + 
	             "WHERE user_id = :userId";
		 Query query = session.createQuery(hql);
		 query.setParameter("userId", userId);
		 List<Projects> projectlist = (List<Projects>)query.list();
		 //Users psw=(Users) session.get(Users.class,1);
		session.close();
		for(int i=0;i<projectlist.size();i++)
		{
			System.out.println( projectlist.get(i).getProject_name());
		}
		return projectlist;
	}
	 public Users getUserByUserName(String username)
	 {
		
	    Session session= factory.openSession();
	 	session.beginTransaction();
	 	String hql = "FROM Users "  + 
	             "WHERE username = :username";
		 Query query = session.createQuery(hql);
		 query.setParameter("username", username);
		 List<Users> userList = (List<Users>)query.list();
		 //Users psw=(Users) session.get(Users.class,1);
		 session.close();
		 return userList.get(0);
	 }
	public static void main(String ...args)
	{
		AbstractDao ab=new AbstractDao();
		System.out.println("max="+ab.getUserByUserName("vikash5").getFirst_Name());
		//System.out.print(ab.getProjectbyUserId(1));
		//Date date=new Date();
		//System.out.println("time"+date);
	}
}
