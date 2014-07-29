package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;

public class Bid2uidDAOImpl extends BaseHibernateDAO implements Bid2uidDAO{
	
	public void add(Bid2uid buid)
	{
		super.add(buid);
	}
	public void delect(Bid2uid buid)
	{
		super.delete(buid);
	}
	
	public List searchBid(String bid)
	{
		String hql = "from Bid2uid a where a.id.bid =?";
		List params  =   new  ArrayList();
		params.add(bid.toString());
		Object[] objs = params.toArray();
		return search(hql, objs);
	}
	public List searchUid(String uid)
	{
		String hql = "from Bid2uid a where a.id.uid =?";
		List params  =   new  ArrayList();
		params.add(uid.toString());
		Object[] objs = params.toArray();
		return search(hql, objs);
	}
	public boolean searchBUid(String bid, String uid)
	{
		String hql = "from Bid2uid a where a.id.bid =? and a.id.uid =?";
		
		List params  =   new  ArrayList();
		params.add(bid.toString());
		params.add(uid.toString());
		Object[] objs = params.toArray();
		
		List list = search(hql, objs);
		
		if(list.size() > 0)
			return true;
		else
			return false;
		
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
}
