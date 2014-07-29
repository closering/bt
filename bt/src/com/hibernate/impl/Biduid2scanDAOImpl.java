package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.entity.Biduid2scan;

public class Biduid2scanDAOImpl extends BaseHibernateDAO implements Biduid2scanDAO{

	@Override
	public void add(Biduid2scan bus) {
		// TODO Auto-generated method stub
		super.add(bus);
		
	}

	@Override
	public void delect(Biduid2scan bus) {
		// TODO Auto-generated method stub
		super.delete(bus);
		
	}

	@Override
	public List searchByBidUid(String Bid, String Uid) {
		// TODO Auto-generated method stub
		String hql = "from Biduid2scan a where a.id.bid =? and a.id.uid =?";
		
		List params  =   new  ArrayList();
		params.add(Bid.toString());
		params.add(Uid.toString());
		Object[] objs = params.toArray();
		
		List list = search(hql, objs);
		return list;
	}
	
	@Override
	public List searchByUid(String uid, Integer isMatch) {
		// TODO Auto-generated method stub
		String hql = "from Biduid2scan a where a.id.uid =? and a.id.isMatch =?";
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		List list = null;
		
		try
		{
			Query qry = session.createQuery(hql);
			qry.setParameter(0, uid);
			qry.setParameter(1, isMatch);
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
	
	@Override
	public List searchByBid(String bid, Integer isMatch) {
		// TODO Auto-generated method stub
		String hql = "from Biduid2scan a where a.id.bid =? and a.id.isMatch =?";
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		List list = null;
		
		try
		{
			Query qry = session.createQuery(hql);
			qry.setParameter(0, bid);
			qry.setParameter(1, isMatch);
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
	
	//search hql use hibernate
		private List search(String hql, Object[] objs)
		{
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			
			Session session = sessionFactory.openSession();
		
			List list = null;
			
			try
			{
				Query qry = session.createQuery(hql);
				//if(objs.length > 0)  //  判断是否确认参数名称 
				//{
					if (objs.length > 0 )
						for  ( int  i  =   0 ; i  <  objs.length; i ++ )
						{
							//qry.setString(i, objs[i].toString());
							qry.setParameter(i, objs[i]);
						}
				//} 
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

		@Override
		public List searchByBidUid(String Bid, String Uid, Integer isMatch) {
			// TODO Auto-generated method stub
			String hql = "from Biduid2scan a where a.id.bid =? and a.id.uid =? and a.id.isMatch =?";
			
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			
			Session session = sessionFactory.openSession();
		
			List list = null;
			
			try
			{
				Query qry = session.createQuery(hql);
				qry.setParameter(0, Bid);
				qry.setParameter(1, Uid);
				qry.setParameter(2, isMatch);
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
