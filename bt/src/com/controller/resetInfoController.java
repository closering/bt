package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class resetInfoController extends AbstractController{
	private String type;
	private String username;
	private String password;
	private String name;
	private String email;
	private String address;
	private String establishDate;
	private String phone;
	private String postcode;
	private String contacter;
	private String ldegree;

	private String degree;

	private String radius;
	
	private String sucess;
	private String wrong;
	private String reset;
	
	private String info;
	private String userNamePre;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		userNamePre = (String) request.getSession().getAttribute("userName");
		
		Map<String, Object> model = new HashMap<String, Object>();
		if(userNamePre == null)
		{
			return new ModelAndView(getWrong(), "myModel", model);
		}
		
		type = request.getParameter("type");		
		username = request.getParameter("username");
		password = request.getParameter("password");
		name = request.getParameter("name");
		email = request.getParameter("email");
		address = request.getParameter("address");
		establishDate = request.getParameter("establishDate");
		phone = request.getParameter("phone");
		postcode = request.getParameter("postcode");
		contacter = request.getParameter("contacter");
		ldegree = request.getParameter("ldegree");

		degree = request.getParameter("degree");

		radius = request.getParameter("radius");

		
		UserdataDAO useD = new UserdataDAOImpl();
		
		if(useD.searchByName(username).size() > 0 && !userNamePre.equals(username))
		{//username has been registered
			recover(request, userNamePre);
			model.put("loginInfo", username + " exist");
			return new ModelAndView(getReset(), "myModel", model);
		}
		else
		{
			UserdataId userId = new UserdataId();	
			boolean setp = setParameter(userId);
			if(setp)
			{//insert user data to data base
				Userdata userPre = (Userdata)useD.searchByName(userNamePre).get(0);
				useD.delete(userPre);
				
				
				Userdata user = new Userdata();
				user.setId(userId);
				
				useD.add(user);
				if(useD.searchByName(user.getId().getUserName()).size() < 1)
				{
					useD.add(userPre);
					info = "the information should be less than 100 characters";
					model.put("loginInfo", info);
					return new ModelAndView(getReset(), "myModel", model);
				}
				
				model.put("loginInfo", "");
							
				request.getSession().setAttribute("userName", username);
				request.getSession().setMaxInactiveInterval(900);//five minutes
				return new ModelAndView(getSucess(), "myModel", model);
				
			}
			else
			{//illegal user data
				model.put("loginInfo", info);
				recover(request, userNamePre);
				return new ModelAndView(getReset(), "myModel", model);
			}
		}
					
	}
	
	private boolean setParameter(UserdataId userId)
	{
		if(username.length() < 1)
		{
			info = "please input username";
			return false;
		}
		if(password.length() < 1)
		{
			info = "please input password";
			return false;
		}
		if(email.length() < 1)
		{
			info = "please input email";
			return false;
		}
		if(contacter.length() < 1)
		{
			info = "please input contacter";
			return false;
		}
		if(phone.length() < 1)
		{
			info  = "please input phone";
			return false;
		}
		if(name.length() < 1)
		{
			info = "please input company name";
			return false;
		}
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//参数为你要格式化时间日期的模式
		Date date = new Date();
		try {
			userId.setEstablishDate(df.parse(establishDate));//将字符串按照定义的模式转换为Date对象
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			info = "please input the establish date as mm/dd/yy";
			e.printStackTrace();
			return false;
		}
		
		if(address.length() < 1)
		{
			info = "please input address";
			return false;
		}
		
		if(postcode.length() < 1)
		{
			info  = "please input postcode";
			return false;
		}
		
		try {
			userId.setRadius(Integer.parseInt(radius));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			info = "please input the radius as an Integer";
			e.printStackTrace();
			return false;
		}
		try {
			userId.setX(Double.parseDouble(ldegree));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			info = "please input the longitude as an Double";
			e.printStackTrace();
			return false;
		}
		try {
			userId.setY(Double.parseDouble(degree));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			info = "please input the lantitude as an Double";
			e.printStackTrace();
			return false;
		}

		userId.setAddress(address);
		userId.setContactPerson(contacter);
		userId.setEmail(email);
		userId.setName(name);
		userId.setPassword(password);
		userId.setPostcode(postcode);
		
		//userId.setSn(ns.equals("s"));
		Integer t;
		if(type.equals("manufacturer"))
		{
			t = 1;
		}
		else if(type.equals("producer"))
		{
			t = 3;
		}
		else if(type.equals("warehouse"))
		{
			t = 5;
		}
		else
		{
			t = 7;
		}
		userId.setType(t);
		userId.setUserName(username);
		userId.setPhone(phone);
		
		return true;
	}
	
	private void recover(HttpServletRequest request, String userName)
	{
		UserdataDAO userD = new UserdataDAOImpl();
		List list = userD.searchByName(userName);
		
		if(list.size() > 0)
		{
			UserdataId user = ((Userdata)list.get(0)).getId();
			request.setAttribute("userInfo", user);
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
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			request.setAttribute("establistDate", df.format(user.getEstablishDate()));
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

	public String getReset() {
		return reset;
	}

	public void setReset(String reset) {
		this.reset = reset;
	}
	
	
	
}
