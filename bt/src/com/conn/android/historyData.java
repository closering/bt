package com.conn.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Biduid2scan;
import com.hibernate.entity.Biduid2scanId;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.Biduid2scanDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;

public class historyData extends HttpServlet{

	public historyData() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setHeader("content-type","text/html;charset=GBK");
		
		String data = request.getParameter("historyData");
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
					res = getHistoty(dataSplit[1],"#", res);
//					List list = null;
//					Bid2uidDAO buDao = new Bid2uidDAOImpl();
//					list = buDao.searchBid(dataSplit[1]);
//					if(list == null || list.size() < 1)
//					{
//						res = "{\"HEXLE\":\"0"; //wrong input
//					}
//					else
//					{
//						String uid = ((Bid2uid)list.get(0)).getId().getUid();
//						res = getHistoty(dataSplit[1], res);
//					}
				}
				else if(type.equals("uid"))
				{
					res = getHistoty(dataSplit[1], res);										
				}
				else
				{
					res = "{\"HEXLE\":\"0"; //wrong input
				}
				
				if(res.charAt(res.length() - 1) == ',')
				{
					res = res.substring(0, res.length() - 1);
				}
				res += "\"}";
			}
		}
		response.getWriter().print(res);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private String getHistoty(String uid, String res)
	{
		Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
		Biduid2scan bus;
		Biduid2scanId busId;
		List list = null, uList = null;
		UserdataDAO uDao = new UserdataDAOImpl();
		UserdataId uId;
		String user;
		
		list =  busDao.searchByUid(uid, 1);
		for(int i = 0; list != null && i < list.size(); i++)
		{
			busId = ((Biduid2scan)list.get(i)).getId();
			user = busId.getUsername();
			uList = uDao.searchByName(user);
			if(uList == null || uList.size() < 1)
			{
				res = "{\"HEXLE\":\"0"; //wrong input
				break;
			}
			res += busId.getScanDate().toString() + ",";
			res += ((Userdata)uList.get(0)).getId().getAddress() + ",";
			res += busId.getUsername() + ",";
			res += busId.getOperationType().toString() + ",";
		}
		return res;
	}
	
	private String getHistoty(String bid, String uid, String res)
	{
		Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
		Biduid2scan bus;
		Biduid2scanId busId;
		List list = null, uList = null;
		UserdataDAO uDao = new UserdataDAOImpl();
		UserdataId uId;
		String user;
		
		list =  busDao.searchByBidUid(bid,uid, 1);
		for(int i = 0; list != null && i < list.size(); i++)
		{
			busId = ((Biduid2scan)list.get(i)).getId();
			user = busId.getUsername();
			uList = uDao.searchByName(user);
			if(uList == null || uList.size() < 1)
			{
				res = "{\"HEXLE\":\"0"; //wrong input
				break;
			}
			res += busId.getScanDate().toString() + ",";
			res += ((Userdata)uList.get(0)).getId().getAddress() + ",";
			res += busId.getUsername() + ",";
			res += busId.getOperationType().toString() + ",";
		}
		return res;
	}
}