package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.UserdataDAO;
import com.hibernate.impl.UserdataDAOImpl;

public class loginController extends AbstractController{
	//private String type;
	private String userName;
	private String password;
	
	private String wrongLogin;
	private String sucessLogin;
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		//type = request.getParameter("type");
		userName = request.getParameter("userName");
		password = request.getParameter("password");
		
		UserdataDAO userD = new UserdataDAOImpl();
		
		if(userD.searchByName(userName).size() > 0)
		{
			if(userD.searchByNamePassword(userName, password))
			{
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("loginInfo", "");
				//request.setAttribute("userName", userName);
				request.getSession().setAttribute("userName", userName);
				request.getSession().setMaxInactiveInterval(900);//five minutes
				
				return new ModelAndView(sucessLogin, "myModel", model);
			}
			else
			{
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("loginInfo", "wrong password.");
				return new ModelAndView(wrongLogin, "myModel", model);
			}
		}
		else
		{
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("loginInfo", userName + " doesn't exist, please register first.");
			return new ModelAndView(wrongLogin, "myModel", model);
		}
		
		
	}


	public String getWrongLogin() {
		return wrongLogin;
	}

	public void setWrongLogin(String wrongLogin) {
		this.wrongLogin = wrongLogin;
	}


	public String getSucessLogin() {
		return sucessLogin;
	}


	public void setSucessLogin(String sucessLogin) {
		this.sucessLogin = sucessLogin;
	}

}
