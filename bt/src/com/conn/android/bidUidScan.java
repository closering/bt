package com.conn.android;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.entity.Biduid2scan;
import com.hibernate.entity.Biduid2scanId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.Biduid2scanDAOImpl;

public class bidUidScan extends HttpServlet{

	 
	public bidUidScan() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("scan");
		String res = "";
		if(data != null)
		{
			String[] dataSplit = data.split(",");
			
			if(dataSplit.length < 6)
			{
				res = "{\"HEXLE\":\"-1\"}"; //wrong input
			}
			else
			{
				Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
				Bid2uidDAO buDao = new Bid2uidDAOImpl();
				ArrayList<String> uidArr = new ArrayList<String>();
				
				String bid = dataSplit[4];
				String uid;
				String x = dataSplit[0];
				String y = dataSplit[1];
				String UserName = dataSplit[2];
				String type = dataSplit[3];
				
				Biduid2scan bus = new Biduid2scan();
				Biduid2scanId busId = new Biduid2scanId();
				
				busId.setBid(bid);
				
				java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
		        
				busId.setScanDate(sqlDate);
				busId.setOperationType(Integer.parseInt(type));
				busId.setX(Double.parseDouble(x));
				busId.setY(Double.parseDouble(y));
				busId.setUsername(UserName);
				
				//ArrayList<Boolean> match = new ArrayList<Boolean>();
				boolean all = true;
				boolean temp;
				
				res += "{\"HEXLE\":\"";
				for(int i = 5; i < dataSplit.length; i++)
				{
					uid = dataSplit[i];	
					temp = buDao.searchBUid(bid, uid);
					if(temp)
					{
						res += "1,";
						all = all && true;
					}
					else
					{
						res += "0,";
						all = all && false;
					}
				}
				if(res.charAt(res.length() - 1) == ',')
					res = res.substring(0, res.length() - 1);
				res += "\"}";
				
				busId.setUid("#");
				busId.setIsMatch(Integer.parseInt("0"));
				bus.setId(busId);
				busDao.add(bus);
				
				for(int i = 5; i < dataSplit.length; i++)
				{
					uid = dataSplit[i];
					//temp = buDao.searchBUid(bid, uid);
					busId.setUid(uid);
					
					if(all)
					{
						busId.setIsMatch(Integer.parseInt("1"));
					}
					else
					{
						busId.setIsMatch(Integer.parseInt("0"));
					}
					bus.setId(busId);
					busDao.add(bus);
				}			
			}
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
