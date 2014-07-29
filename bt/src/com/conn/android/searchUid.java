package com.conn.android;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.dao.ProductDAO;
import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Biduid2scan;
import com.hibernate.entity.Biduid2scanId;
import com.hibernate.entity.Product;
import com.hibernate.entity.ProductId;
import com.hibernate.entity.Uid2epc;
import com.hibernate.entity.Uid2epcId;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.Biduid2scanDAOImpl;
import com.hibernate.impl.ProductDAOImpl;
import com.hibernate.impl.Uid2epcDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;

public class searchUid extends HttpServlet{
	
	public searchUid() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html; charset=gbk");
		response.setCharacterEncoding("GBK");
		
		String uid = request.getParameter("uid");
		String res = "";
		
		if(uid != null)
		{
			res = "{\"HEXLE\":\"";
			
			Uid2epcDAO ueDao = new Uid2epcDAOImpl();
			Uid2epcId ueId;
			List list = ueDao.searchByUid(uid);
			
			if(list != null && list.size() > 0)
			{
				ueId = ((Uid2epc)list.get(0)).getId();
				String epc = ueId.getEpc();
				
				res += ueId.getEpc() + ",";
				res += ueId.getProducedate() + ",";
				if(ueId.getRecall().equals(1))
				{
					res += "YES,";
				}
				else
				{
					res += "NO,";
				}
				
				list.clear();
				
				ProductDAO pDao = new ProductDAOImpl();
				list = pDao.searchByEpc(epc);
				
				ProductId pId;
				
				if(list != null)
				{
					pId = ((Product)list.get(0)).getId();
					res += pId.getProductName() + ","; //product name
					res += pId.getExpireDays() + ",";
					list.clear();
					
					
					UserdataId uId;					
					UserdataDAO uDao = new UserdataDAOImpl();
					list = uDao.searchByName(pId.getUserName());
					uId = ((Userdata)list.get(0)).getId();
					
					
					res += uId.getName() + ",";
					res += uId.getAddress() + ",";
					
					Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
					list = busDao.searchByUid(uid, 1);
					
					if(res.charAt(res.length() - 1) == ',')
						res = res.substring(0, res.length() - 1);
					
					if(list != null)
					{
						res += ";";
						Biduid2scanId busId;
						for(int i = 0; i< list.size(); i++)
						{
							busId = ((Biduid2scan)list.get(i)).getId();
							res += busId.getUsername() +",";
							res += busId.getScanDate() + ",";
							res += busId.getX() + ",";
							res += busId.getY() + ",";
						}
					}
				}
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
