package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Userdata;

public class UserdataDAOImpl extends BaseHibernateDAO implements UserdataDAO{

	@Override
	public void add(Userdata uData) {
		// TODO Auto-generated method stub
		super.add(uData);
		
	}

	@Override
	public void delete(Userdata uData) {
		// TODO Auto-generated method stub
		super.delete(uData);
	}

	@Override
	public boolean searchByNamePassword(String name, String password) {
		// TODO Auto-generated method stub
		String hql = "from Userdata a where a.id.userName =? and a.id.password = ?";
		
		List params  =   new  ArrayList();
		params.add(name.toString());
		params.add(password.toString());
		Object[] objs = params.toArray();
		
		List list = search(hql, objs);
		
		if(list.size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public List searchByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Userdata a where a.id.userName =?";
		
		List params  =   new  ArrayList();
		params.add(name.toString());
		Object[] objs = params.toArray();
		
		List list = search(hql, objs);
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
