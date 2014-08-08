package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.MonitorInfoDAO;
import com.hibernate.entity.MonitorInfo;

public class MonitorInfoDAOImpl extends BaseHibernateDAO implements MonitorInfoDAO{
	@Override
	public void add(MonitorInfo mData) {
		// TODO Auto-generated method stub
		super.add(mData);
		
	}
	@Override
	public void delete(MonitorInfo mData) {
		// TODO Auto-generated method stub
		super.delete(mData);
	}
	public List searchByUsername(String username){
		String hql = "from MonitorInfo a where a.id.userName =?";
		List params  =   new  ArrayList();
		params.add(username);
		Object[] objs = params.toArray();
		return search(hql, objs);
	}
	public List searchByMonitorName(String monitorName){
		String hql = "from MonitorInfo a where a.id.monitorName =?";
		List params  =   new  ArrayList();
		params.add(monitorName);
		Object[] objs = params.toArray();
		return search(hql, objs);
	}
	public List searchByUsernameAndMonitorName(String userName, String monitorName){
		String hql = "from MonitorInfo a where a.id.userName =? and a.id.monitorName =?";
		List params  =   new  ArrayList();
		params.add(userName);
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
	public void update(MonitorInfo mData)
	{
		Session session=null;  
        Transaction transaction=null; 
        try{
        Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(mData);
		transaction.commit();
        }catch (HibernateException e) {
			// TODO: handle exception
        	if(transaction!=null)
        		transaction.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
		
	}
}
