package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.MonitorPositionDAO;
import com.hibernate.entity.MonitorInfo;
import com.hibernate.entity.MonitorPosition;

public class MonitorPositionDAOImpl extends BaseHibernateDAO implements MonitorPositionDAO{
	@Override
	public void add(MonitorPosition mData) {
		// TODO Auto-generated method stub
		super.add(mData);
		
	}
	@Override
	public void delete(MonitorPosition mData) {
		// TODO Auto-generated method stub
		super.delete(mData);
	}
	public List searchByMonitorName(String monitorName)
	{
		String hql = "from MonitorPosition a where a.id.monitorName =?";
		List params  =   new  ArrayList();
		params.add(monitorName);
		Object[] objs = params.toArray();
		return search(hql, objs);
	}
	
	public List search(String hql, Object[] objs){
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
