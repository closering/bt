package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.Username2bidDAO;
import com.hibernate.entity.Username2bid;

public class Username2bidDAOImpl  extends BaseHibernateDAO implements Username2bidDAO{

	@Override
	public void add(Username2bid uBid) {
		// TODO Auto-generated method stub
		super.add(uBid);
		
	}

	@Override
	public void delete(Username2bid uBid) {
		// TODO Auto-generated method stub
		super.delete(uBid);
		
	}

	@Override
	public List searchByBid(String bid) {
		// TODO Auto-generated method stub
		String hql = "from Username2bid a where a.id.bid =?";
		
		List params  =   new  ArrayList();
		params.add(bid.toString());
		Object[] objs = params.toArray();
		List list = search(hql, objs);
		return list;
	}

	@Override
	public Long searchByUsername(String userName) {
		// TODO Auto-generated method stub
		String hql = "from Username2bid a where a.id.username =?";
		
		List params  =   new  ArrayList();
		params.add(userName.toString());
		Object[] objs = params.toArray();
		List list = search(hql, objs);
		if(list == null || list.size() < 1)
			return new Long(0);
		Long t1 = new Long(0);
		Long t = new Long(0);
		for(int i = 0; i < list.size(); i++)
		{
			t1 = ((Username2bid)list.get(i)).getId().getId();
			if( t1 > t)
				t = t1;
		}
		return t + 1;
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
