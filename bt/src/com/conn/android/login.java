package com.conn.android;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.UserdataDAOImpl;
import java.lang.Math;

public class login extends HttpServlet{
	
	public login() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
				
		String data = request.getParameter("login");
		String res = "";
		if(data != null)
		{
			String[] dataSplit = data.split(",");
			if(dataSplit.length != 2)
			{
				res = "{\"HEXLE\":\"0\"}";
			}
			else
			{
				String username = dataSplit[0];
				String password = dataSplit[1];
				
				//Userdata ud = new Userdata();
				UserdataDAO uDao = new UserdataDAOImpl();
				
				if(uDao.searchByName(username).size() < 1)
				{
					res = "{\"HEXLE\":\"-1\"}"; //no username;
				}
				else if(uDao.searchByNamePassword(username, password))
				{
					res = "{\"HEXLE\":\"1\"}"; //success
				}
				else
				{
					res = "{\"HEXLE\":\"-2\"}"; //wrong password
				}
			}
		}
		else
		{
			res = "{\"HEXLE\":\"0\"}";//wrong input
		}
		response.getOutputStream().print(res);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private double calDistance(double longA, double latA, double longB, double latB)
	{	
		double C = java.lang.Math.sin(latA) * java.lang.Math.sin(latB) + java.lang.Math.cos(latA) * java.lang.Math.cos(latB) * java.lang.Math.cos(longA-longB);

		return 6356.755 * 1000 * java.lang.Math.acos(C) * java.lang.Math.PI /180;
	}

}


