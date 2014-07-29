package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.ProductDAO;
import com.hibernate.entity.Product;

public class ProductDAOImpl extends BaseHibernateDAO implements ProductDAO{

	@Override
	public void add(Product pro) {
		// TODO Auto-generated method stub
		super.add(pro);
		
	}

	@Override
	public void delete(Product pro) {
		// TODO Auto-generated method stub
		super.delete(pro);
		
	}

	@Override
	public List searchByEpc(String epc) {
		// TODO Auto-generated method stub
		String hql = "from Product a where a.id.epc =?";
		
		List params  =   new  ArrayList();
		params.add(epc.toString());
		Object[] objs = params.toArray();
		
		List list = search(hql, objs);
		return list;
	}

	@Override
	public List searchByUsername(String userName) {
		// TODO Auto-generated method stub
		String hql = "from Product a where a.id.userName =?";
		
		List params  =   new  ArrayList();
		params.add(userName.toString());
		Object[] objs = params.toArray();
		
		List list = search(hql, objs);
		return list;
	}
	
	@Override
	public List searchByUsernameEpc(String epc, String userName) {
		// TODO Auto-generated method stub
		String hql = "from Product a where a.id.epc =? and a.id.userName =?";
		
		List params  =   new  ArrayList();
		params.add(epc.toString());
		params.add(userName.toString());
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
