package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.UserdataDAOImpl;

public class profileController extends AbstractController{
	
	private String username;
	private String wrong;
	private String success;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		username = (String) request.getSession().getAttribute("userName");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(username == null)
			return new ModelAndView(getWrong(),model);
		
		UserdataDAO uDao = new UserdataDAOImpl();
		List list = uDao.searchByName(username);
		if(list.size() < 1)
		{
			return new ModelAndView(getWrong(),model);
		}
		else
		{
			UserdataId uId = ((Userdata)list.get(0)).getId();
			request.setAttribute("profile", uId);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			request.setAttribute("establishDate", df.format(uId.getEstablishDate()));
			if(uId.getType().equals(1))
				request.setAttribute("type", "Manufacturing");
			else if(uId.getType().equals(3))
				request.setAttribute("type", "Processing");
			else if(uId.getType().equals(5))
				request.setAttribute("type", "Transporting");
			else
				request.setAttribute("type", "Retailer");
			
			return new ModelAndView(getSuccess(),model);
		}
	}

	public String getWrong() {
		return wrong;
	}

	public void setWrong(String wrong) {
		this.wrong = wrong;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
