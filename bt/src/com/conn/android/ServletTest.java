package com.conn.android;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.UserdataDAO;
import com.hibernate.impl.UserdataDAOImpl;


public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	public ServletTest() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password = request.getParameter("password");
		
		UserdataDAO userD = new UserdataDAOImpl();
		String res;
		if(userD.searchByNamePassword(userName,password))
		{
			res = "{\"HEXLE\":\"1\"}";
		}
		else
		{
			res = "{\"HEXLE\":\"0\"}";
		}
		
		//response.getOutputStream().print(result);
		response.getOutputStream().print(res);
		
	}	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}