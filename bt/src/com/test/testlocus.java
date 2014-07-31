package com.test;

import com.hibernate.entity.Username2bidId;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.dao.Username2bidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;
import com.hibernate.entity.Locusinfo;
import com.hibernate.entity.LocusinfoId;
import com.hibernate.entity.Username2bid;
import com.hibernate.entity.Username2bidId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.LocusinfoDAOImpl;
import com.hibernate.impl.Username2bidDAOImpl;
public class testlocus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x,y,z;
		x = System.currentTimeMillis();
		String str1 = a();
		y = System.currentTimeMillis();
		String str2 = b();
		z = System.currentTimeMillis();
		if(str1.equals(str2)){
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(y-x);
			System.out.println(z-y);
		}
	}
	public static String a(){
		String res="";
		Username2bidId ubId = new Username2bidId();
		Username2bid ub = new Username2bid();
		Username2bidDAO ubDao = new Username2bidDAOImpl();
		List list, locus;
		
		String username;
		Long ID;
		
		LocusinfoId liId = new LocusinfoId();
		Locusinfo li = new Locusinfo();
		LocusinfoDAO liDao = new LocusinfoDAOImpl();
		
		list = ubDao.searchByBid("187992361049861");
		for(int i = 0; list != null && i < list.size(); i++)
		{
			ub = (Username2bid)list.get(i);
			ubId = ub.getId();
			
			username = ubId.getUsername();
			ID = ubId.getId();
			
			locus = liDao.searchByUsernameID(username, ID);
			
			if(locus != null && locus.size() > 0)
			{
				res += username;
				for(int j = 0; locus != null && j < locus.size(); j++)
				{
					li = (Locusinfo)locus.get(j);
					liId = li.getId();
					res += "," + liId.getX().toString();
					res += "," + liId.getY().toString();
					res += "," + liId.getSerial().toString();
					res += "," + liId.getDateServer().toString();
				}
				res += ";";
			}
		}
		return res;
	}
	public static String b(){
		String res="";
		String hql = "from Locusinfo a where (a.id.username, a.id.id) in (select b.id.username, b.id.id from Username2bid as b where b.id.bid = ?)";
		//String hql = "from Locusinfo";
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		List list = null;
		try
		{
			Query qry = session.createQuery(hql);
			qry.setParameter(0, "187992361049861");
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
		LocusinfoId liId = new LocusinfoId();
		Locusinfo li = new Locusinfo();
		String lastUsername = null;
		Long lastId = (long)(-1);
		String nowUsername = null;
		Long nowId = (long)(-1);
		
		//System.out.println(list.size());
		
		for(int i = 0; list != null && i < list.size(); i++)
		{
			li = (Locusinfo)list.get(i);
			liId = li.getId();
			nowUsername = liId.getUsername();
			nowId = liId.getId();		
			
			//System.out.println(lastUsername+"   "+lastId);
			//System.out.println(nowUsername+"   "+nowId);
			//System.out.println("");
			if(nowUsername.equals(lastUsername) && nowId.equals(lastId)){
				
			}
			else{
				if(i>0){
					res += ";";
				}
				res += nowUsername;
			}
			//res += nowUsername;
			//res += ","+nowId;
			res += "," + liId.getX().toString();
			res += "," + liId.getY().toString();
			res += "," + liId.getSerial().toString();
			res += "," + liId.getDateServer().toString();
			
			lastUsername = nowUsername;
			lastId = nowId;
		}
		res += ";";
		return res;
	}
}
