package com.conn.android;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;
import com.hibernate.impl.Bid2uidDAOImpl;

public class searchBid extends HttpServlet{
	
	public searchBid() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("bid");
		String res = "";
		
		if(data != null)
		{
			res = "{\"HEXLE\":\"";
			Bid2uidDAO buDao = new Bid2uidDAOImpl();
			List list = buDao.searchBid(data);
			Bid2uidId buId;
			
			for(int i = 0; list != null && i < list.size(); i++)
			{
				buId = ((Bid2uid)list.get(i)).getId();
				res += buId.getUid() + ",";
			}
			if(res.charAt(res.length() - 1) == ',')
				res = res.substring(0, res.length() - 1);
			res += "\"}";
		}
		else
		{
			res = "{\"HEXLE\":\"-1\"}"; //wrong input
		}
		response.getOutputStream().print(res);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
