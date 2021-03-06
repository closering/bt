package com.conn.android;

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

public class locusDownload extends HttpServlet{

	public locusDownload() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("locusDownload");
		String res = "";
		if(data == null)
		{
			res = "{\"HEXLE\":\"0\"}"; //wrong input
		}
		else
		{
			String[] dataSplit = data.split(",");
			
			if(dataSplit.length != 2)
			{
				res = "{\"HEXLE\":\"0\"}"; //wrong input
			}
			else
			{
				String type = dataSplit[0].toLowerCase();
				res = "{\"HEXLE\":\"";
				
				
				if(type.equals("bid"))
				{
					String bid = dataSplit[1];
					res = getLocus(bid, res);
				}
				else if(type.equals("uid"))
				{
					Bid2uidId buId = new Bid2uidId();
					Bid2uidDAO buDao = new Bid2uidDAOImpl();
					String uid = dataSplit[1];
										
					List bidList = buDao.searchUid(uid);
					for(int t = 0;bidList != null && t < bidList.size(); t ++)
					{
						buId = ((Bid2uid)bidList.get(t)).getId();
						res = getLocus(buId.getBid(), res);
					}
					
				}
				else
				{
					res = "{\"HEXLE\":\"0"; //wrong input
				}
				if(res.charAt(res.length() - 1) == ';')
				{
					res = res.substring(0, res.length() - 1);
				}
				res += "\"}";
			}
		}
		response.getOutputStream().print(res);	
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	private String getLocus(String bid, String res)
	{
		//之前的代码，代码效率低
		/*Username2bidId ubId = new Username2bidId();
		Username2bid ub = new Username2bid();
		Username2bidDAO ubDao = new Username2bidDAOImpl();
		List list, locus;
		
		String username;
		Long ID;
		
		LocusinfoId liId = new LocusinfoId();
		Locusinfo li = new Locusinfo();
		LocusinfoDAO liDao = new LocusinfoDAOImpl();
		
		list = ubDao.searchByBid(bid);
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
		}*/
		//////////////////修改后的代码
		String hql = "from Locusinfo a where (a.id.username, a.id.id) in (select b.id.username, b.id.id from Username2bid as b where b.id.bid = ?)";
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		List list = null;
		try
		{
			Query qry = session.createQuery(hql);
			qry.setParameter(0, bid);
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
		
		System.out.println(list.size());
		
		for(int i = 0; list != null && i < list.size(); i++)
		{
			li = (Locusinfo)list.get(i);
			liId = li.getId();
			nowUsername = liId.getUsername();
			nowId = liId.getId();		
			if(nowUsername.equals(lastUsername) && nowId.equals(lastId)){
				
			}
			else{
				if(i>0){
					res += ";";
				}
				res += nowUsername;
			}
			res += "," + liId.getX().toString();
			res += "," + liId.getY().toString();
			res += "," + liId.getSerial().toString();
			res += "," + liId.getDateServer().toString();
			lastUsername = nowUsername;
			lastId = nowId;
		}
		res += ";";
		System.out.println(res);
		return res;
	}
	
}
