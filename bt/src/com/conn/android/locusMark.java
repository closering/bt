package com.conn.android;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Biduid2scan;
import com.hibernate.entity.Biduid2scanId;
import com.hibernate.entity.Userdata;
import com.hibernate.impl.Biduid2scanDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;

public class locusMark  extends HttpServlet{
	
	public locusMark() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("locusMark");
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
				List list;
				Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
				
				if(type.equals("bid"))
				{
					list = busDao.searchByBid(dataSplit[1], 1);
					res = getInfo(list, res);
				}
				else if(type.equals("uid"))
				{
					list = busDao.searchByUid(dataSplit[1], 1);
					res = getInfo(list, res);
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
		response.getOutputStream().print(res);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private String getInfo(List list, String res)
	{
		UserdataDAO uDao = new UserdataDAOImpl();
		List list1 = null;
		Biduid2scanId busId;
		String username;
		
		for(int i = 0; list!=null && i < list.size(); i++)
		{
			busId = ((Biduid2scan)list.get(i)).getId();
			username =busId.getUsername();
			
			res += username + ",";
			res += busId.getScanDate() + ",";
			if(busId.getOperationType().equals(1))
			{
				res += "enter" + ",";
			}
			else
			{
				res += "out"  + ",";
			}
			list1 = uDao.searchByName(username);
			
			if(list1 == null)
			{
				res += ",";
			}
			else
			{
				res += ((Userdata)list1.get(0)).getId().getAddress() + ",";
			}
			res += busId.getX() + ",";
			res += busId.getY() + ",";
		}
		
		return res;
		
	}
}
