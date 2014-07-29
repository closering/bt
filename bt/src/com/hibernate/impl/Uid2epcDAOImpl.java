package com.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.BaseHibernateDAO;
import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.entity.Uid2epc;

public class Uid2epcDAOImpl extends BaseHibernateDAO implements Uid2epcDAO{

	@Override
	public void add(Uid2epc uepc) {
		// TODO Auto-generated method stub
		super.add(uepc);
		
	}

	@Override
	public void delect(Uid2epc uepc) {
		// TODO Auto-generated method stub
		super.delete(uepc);
		
	}

	@Override
	public List searchByUid(String uid) {
		// TODO Auto-generated method stub
		String hql = "from Uid2epc a where a.id.uid = ?";
		List params  =   new  ArrayList();
		params.add(uid.toString());
		Object[] objs = params.toArray();
		List list = (List)search(hql, objs);
		
		return list;
	}

	@Override
	public List searchByEpc(String epc) {
		// TODO Auto-generated method stub
		String hql = "from Uid2epc a where a.id.epc = ?";
		List params  =   new  ArrayList();
		params.add(epc.toString());
		Object[] objs = params.toArray();
		List list = (List)search(hql, objs);
		return list;
	}

	@Override
	public List searchUidEpc(String uid, String epc) {
		// TODO Auto-generated method stub
		String hql = "from Uid2epc a where a.id.uid =? and a.id.epc =?";
		List params  =   new  ArrayList();
		params.add(uid.toString());
		params.add(epc.toString());
		Object[] objs = params.toArray();
		List list = (List)search(hql, objs);
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
