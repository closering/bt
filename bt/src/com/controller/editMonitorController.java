package com.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.MonitorInfoDAO;
import com.hibernate.entity.MonitorInfo;
import com.hibernate.entity.MonitorInfoId;
import com.hibernate.impl.MonitorInfoDAOImpl;
import coml.jpush.Jpush;

public class editMonitorController extends AbstractController {
	private String wrong;
	private String success;
	private String unLogin;
	
	private String monitorName;
	private String longitude;
	private String latitude;
	private String radius;
	private Timestamp time;
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		if(userName == null)
		{
			return new ModelAndView(getUnLogin(), model);
		}
		
		monitorName = request.getParameter("monitorName");
		longitude = request.getParameter("longitude");
		latitude = request.getParameter("latitude");
		radius = request.getParameter("radius");
		//System.out.println(monitorName);
		
		MonitorInfoDAO moD = new MonitorInfoDAOImpl();
		List list = null;
		list = moD.searchByUsernameAndMonitorName(userName, monitorName);
		if(list != null && list.size() > 0)
		{
			MonitorInfo mo = new MonitorInfo();
			MonitorInfoId moId = new MonitorInfoId();
			moId.setUserName(userName);
			moId.setMonitorName(monitorName);
			mo.setId(moId);
			mo.setX(Double.parseDouble(latitude));
			mo.setY(Double.parseDouble(longitude));
			mo.setRadius(Double.parseDouble(radius));
			time = new Timestamp(System.currentTimeMillis());
			mo.setSetDate(time);
			moD.update(mo);
			
			model.put("info", "user \"" + userName+ "\" alter monitor \""+monitorName+"\" success!");
			
			Jpush push = new Jpush();
			String message = "{\"operation\":\"edit\",";
			message += "\"monitorName\":\"" + userName +"\",";
			message += "\"longitude\":\"" + longitude +"\",";
			message += "\"latitude\":\"" + latitude +"\",";
			message += "\"radius\":\"" + radius +"\",";
			message += "\"setDate\":\"" + time +"\"}";
			push.pushMessage(monitorName, message);
			System.out.println(message);
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		
		else {
			model.put("info", "user \"" + userName+ "\" alter monitor \""+monitorName+"\" failed!");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		
		
		
		
		//model.put("monitorName", monitorName);
		//model.put("info", userName+" edit monitor "+monitorName+" successfully!!!");
		//return new ModelAndView(getSuccess(), "myModel", model);
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

	public String getUnLogin() {
		return unLogin;
	}

	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
	}

	

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	
}
