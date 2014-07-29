package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class BaseHibernateDAO {
	
	//add an object to table
	protected void add(Object object)
	{
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.save(object);
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
	}
	
	//delete an object to table
	protected void delete(Object obj)
	{
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.delete(obj);
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
	}

//	//update an object to table
//	protected void update(Object object)
//	{
//		Configuration config = new Configuration().configure();
//		SessionFactory sessionFactory = config.buildSessionFactory();
//		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		try
//		{
//			session.update(object);
//			//session.update(arg0, arg1)
//			tx.commit();
//		}catch(Exception e)
//		{
//			if(tx!=null)
//			{
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		finally
//		{
//			session.close();
//			sessionFactory.close();
//		}
//	}
	
		
}
