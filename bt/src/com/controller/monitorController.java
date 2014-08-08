package com.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import com.hibernate.dao.MonitorInfoDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.MonitorInfo;
import com.hibernate.entity.MonitorInfoId;
import com.hibernate.impl.MonitorInfoDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;
import coml.jpush.Jpush;

public class monitorController extends AbstractController{
	private String wrong;
	private String success;
	private String unLogin;
	
	private String pupilUsername;
	private String longitude;
	private String latitude;
	private String radius;
	private Timestamp time;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		pupilUsername = request.getParameter("pupilUsername");
		longitude = request.getParameter("longitude");
		latitude = request.getParameter("latitude");
		radius = request.getParameter("radius");
		
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		if(userName == null)
		{
			return new ModelAndView(getUnLogin(), model);
		}
		
		model.put("pupilUsername", pupilUsername);
		model.put("longitude", longitude);
		model.put("latitude", latitude);
		model.put("radius", radius);
		
		if(pupilUsername.trim().equals("") || longitude.trim().equals("") || latitude.trim().equals("") || radius.trim().equals("")){
			model.put("info", "monitor info can not be empty!!!");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		
		UserdataDAO useD = new UserdataDAOImpl();
		if(useD.searchByName(pupilUsername).size() < 1)
		{
			model.put("info", "Pupil UserName (" + pupilUsername + ") is not exist!!!");
			model.put("pupilUsername", "");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		
		if(Double.parseDouble(longitude)<(-180) || Double.parseDouble(longitude)>(180)){
			model.put("info", "The scope of longitude is -180 to 180");
			model.put("longitude", "");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		
		if(Double.parseDouble(latitude)<(-90) || Double.parseDouble(latitude)>(90)){
			model.put("info", "The scope of latitude is -90 to 90");
			model.put("latitude", "");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		if(Double.parseDouble(radius) <= 0){
			model.put("info", "The radius should more than 0");
			model.put("radius", "");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		MonitorInfoId moId = new MonitorInfoId();
		moId.setUserName(userName);
		moId.setMonitorName(pupilUsername);
		MonitorInfo mo = new MonitorInfo();
		mo.setId(moId);
		mo.setX(Double.parseDouble(latitude));
		mo.setY(Double.parseDouble(longitude));
		mo.setRadius(Double.parseDouble(radius));
		time = new Timestamp(System.currentTimeMillis());
		mo.setSetDate(time);
		
		MonitorInfoDAO moD = new MonitorInfoDAOImpl();
		List list = null;
		list = moD.searchByUsernameAndMonitorName(userName, pupilUsername);
		if(list==null || list.size()<1){
			//System.out.println("table monitorInfo does not exist (" + userName +"," + pupilUsername+")");
			moD.add(mo);
			model.put("pupilUsername", "");
			model.put("longitude", "");
			model.put("latitude", "");
			model.put("radius", "");
			model.put("info", "Add monitor successfully!!!");
			
			//给指定客户端发送添加monitor消息{"operation":"add","monitorName":"","longitude":"","latitude":"","radius":"","setDate":""}
			Jpush push = new Jpush();
			String message = "{\"operation\":\"add\",";
			message += "\"monitorName\":\"" + userName +"\",";
			message += "\"longitude\":\"" + longitude +"\",";
			message += "\"latitude\":\"" + latitude +"\",";
			message += "\"radius\":\"" + radius +"\",";
			message += "\"setDate\":\"" + time +"\"}";
			
			System.out.println(message);
			push.pushMessage(pupilUsername, message);
			
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		else{
			/*for(int i=0; i<list.size(); i++){
				mo = (MonitorInfo)list.get(i);
				System.out.println(mo.getId().getUserName());
				System.out.println(mo.getId().getMonitorName());
				System.out.println(mo.getX());
				System.out.println(mo.getY());
				System.out.println(mo.getRadius());
				System.out.println(mo.getSetDate());
			}*/
			model.put("pupilUsername", "");
			model.put("info", "table monitorInfo exists (" + userName +"," + pupilUsername+")");
			return new ModelAndView(getWrong(), "myModel", model);
		}
	}
	
	public String getUnLogin() {
		return unLogin;
	}

	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
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
