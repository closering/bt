package com.conn.android;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Username2bidDAO;
import com.hibernate.entity.Username2bid;
import com.hibernate.entity.Username2bidId;
import com.hibernate.impl.Username2bidDAOImpl;

public class locusInit extends HttpServlet{
	
	public locusInit() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("init");
		String res = "";
		if(data != null)
		{
			String[] dataSplit = data.split(",");
			
			if(dataSplit.length < 2)
			{
				res = "{\"HEXLE\":\"-1\"}";
			}
			else
			{
				String username = dataSplit[0];
				
				Username2bidDAO ubDao = new Username2bidDAOImpl();
				Long t = ubDao.searchByUsername(username);
				
				Username2bid ub = new Username2bid();
				Username2bidId ubId = new Username2bidId();
				
				ubId.setId(t);
				ubId.setUsername(username);
				for(int i = 1; i < dataSplit.length; i++)
				{
					ubId.setBid(dataSplit[i]);
					ub.setId(ubId);
					
					ubDao.add(ub);
				}
				
				res = "{\"HEXLE\":\"" + t.toString() + "\"}";
			}
		}
		else
		{
			res = "{\"HEXLE\":\"-1\"}";
		}
		response.getOutputStream().print(res);
			
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
