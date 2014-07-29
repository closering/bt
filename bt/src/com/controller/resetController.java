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

public class resetController extends AbstractController{
	
	private String sucess;
	private String wrong;
	
	private String userName;
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		userName = (String) request.getSession().getAttribute("userName");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(userName == null)
		{
			return new ModelAndView(getWrong(), model);
		}
		UserdataDAO userD = new UserdataDAOImpl();
		List list = userD.searchByName(userName);
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		if(list.size() > 0)
		{
			UserdataId user = ((Userdata)list.get(0)).getId();
			request.setAttribute("userInfo", user);
			request.setAttribute("address", user.getAddress());
			request.setAttribute("username", user.getUserName());
			request.setAttribute("name", user.getName());
			request.setAttribute("password", user.getPassword());
			request.setAttribute("establishDate", df.format(user.getEstablishDate()));
			request.setAttribute("email", user.getEmail());
			request.setAttribute("person", user.getContactPerson());
			request.setAttribute("postcode", user.getPostcode());
			request.setAttribute("phone", user.getPhone());
			switch(user.getType())
			{
			case 1:
				request.setAttribute("type1", "manufacturer");
				request.setAttribute("type2", "producer");
				request.setAttribute("type3", "warehouse");
				request.setAttribute("type4", "retailer");
				break;
			case 3:
				request.setAttribute("type1", "producer");
				request.setAttribute("type2", "manufacturer");
				request.setAttribute("type3", "warehouse");
				request.setAttribute("type4", "retailer");
				break;
			case 5:
				request.setAttribute("type1", "warehouse");
				request.setAttribute("type3", "producer");
				request.setAttribute("type2", "manufacturer");
				request.setAttribute("type4", "retailer");
				break;
			default:
				request.setAttribute("type1", "retailer");
				request.setAttribute("type2", "manufacturer");
				request.setAttribute("type3", "producer");
				request.setAttribute("type4", "warehouse");
				break;
			}
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			//request.setAttribute("establishDate", df.format(user.getEstablishDate()));
			return new ModelAndView(getSucess(), model);
		}
		else
		{
			return new ModelAndView(getSucess(), model);
		}
	}


	public String getSucess() {
		return sucess;
	}


	public void setSucess(String sucess) {
		this.sucess = sucess;
	}


	public String getWrong() {
		return wrong;
	}


	public void setWrong(String wrong) {
		this.wrong = wrong;
	}
}
