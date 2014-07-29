package com.conn.android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.ProductDAO;
import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Product;
import com.hibernate.entity.ProductId;
import com.hibernate.entity.Uid2epc;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.ProductDAOImpl;
import com.hibernate.impl.Uid2epcDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;

public class searchEpc extends HttpServlet{
	
	public searchEpc() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("epc");
		String res = "";
		if(data != null)
		{
			String[] dataSplit = data.split(",");
			if(dataSplit.length < 1)
			{
				res = "{\"HEXLE\":\"0\"}"; //no epc
			}
			else
			{
				res = "{\"HEXLE\":\"";
				
				String epc = dataSplit[0];
				
				ProductDAO pdao = new ProductDAOImpl();
				
				List list = pdao.searchByEpc(epc);
				if(list != null && list.size() > 0)
				{
					//ArrayList<ProductId> li = new ArrayList<ProductId>();
					//ArrayList<String> companyName = new ArrayList<String>();
					
					ProductId pId;
					UserdataId uId;
					
					UserdataDAO uDao = new UserdataDAOImpl();
					
					for(int i = 0;list != null &&  i < list.size(); i++)
					{
						pId = ((Product)list.get(i)).getId();
						
						//li.add(pId);
						uId = ((Userdata)uDao.searchByName(pId.getUserName()).get(0)).getId();
						//companyName.add(uId.getName());
						
						res += pId.getEpc() + ",";
						res += pId.getProductName()  + ",";
						res += uId.getName()  + ",";
						res += pId.getProductTime()  + ",";
						res += pId.getExpireDays()  + ",";
					}
					
//					request.setAttribute("product", li);
//					request.setAttribute("company", companyName);
//					request.setAttribute("productLength", li.size());
					
					Uid2epcDAO uedao = new Uid2epcDAOImpl();
					
					list.clear();
					list = uedao.searchByEpc(epc);
					
					
//					request.setAttribute("uidLength", list.size());
					
//					List<String> listResult = new ArrayList<String>();
					Uid2epc uei = null;
					if(res.charAt(res.length() - 1) == ',')
						res = res.substring(0, res.length() - 1);
					res += ";";
					for(int i = 0; list != null && i < list.size(); i++)
					{	
						uei = (Uid2epc)list.get(i);
						res += uei.getId().getUid()  + ",";
						//listResult.add(uei.getId().getUid());
					}
					if(res.charAt(res.length() - 1) == ',')
						res = res.substring(0, res.length() - 1);
					
					
					//request.setAttribute("listResult", listResult);
				}
			}
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
