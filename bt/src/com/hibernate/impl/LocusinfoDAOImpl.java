package com.hibernate.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.entity.Locusinfo;

public class LocusinfoDAOImpl  extends BaseHibernateDAO implements LocusinfoDAO{

	@Override
	public void add(Locusinfo locus) {
		// TODO Auto-generated method stub
		super.add(locus);
		
	}

	@Override
	public void delete(Locusinfo locus) {
		// TODO Auto-generated method stub
		super.delete(locus);
		
	}

	@Override
	public List searchByUsernameID(String userName, Long ID) {
		// TODO Auto-generated method stub
		String hql = "from Locusinfo a where a.id.username =? and a.id.id =?";

		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		List list = null;
		
		try
		{
			Query qry = session.createQuery(hql);
			qry.setParameter(0, userName);
			qry.setParameter(1, ID);
			list =qry.list();	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			session.close();
			sessionFactory.close();
		}
		return list;
	}
	
	private List search(String hql, Object[] objs)
	{
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		List list = null;
		
		try
		{
			Query qry = session.createQuery(hql);
			if (objs.length > 0 )
				for  ( int  i  =   0 ; i  <  objs.length; i ++ )
				{
					//qry.setString(i, objs[i].toString());
					qry.setParameter(i, objs[i]);
				}
			list =qry.list();	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			session.close();
			sessionFactory.close();
		}
		return list;
	}

}
