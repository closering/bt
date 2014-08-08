package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.MonitorInfoDAO;
import com.hibernate.entity.MonitorInfo;
import com.hibernate.impl.MonitorInfoDAOImpl;

public class monitorManageController extends AbstractController {
	private String wrong;
	private String success;
	private String unLogin;
	String monitorInfo = "";
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
		
		MonitorInfoDAO moD = new MonitorInfoDAOImpl();
		List list = null;
		list = moD.searchByUsername(userName);
		MonitorInfo mo = new MonitorInfo();
		monitorInfo = "";
		//System.out.println("33333333");
		if(list != null && list.size() > 0)
		{
			//System.out.println("111111");
			for(int i=0; i<list.size(); i++){
				mo = (MonitorInfo)list.get(i);
				monitorInfo += mo.getId().getMonitorName() +",";
				monitorInfo += mo.getX() +",";
				monitorInfo += mo.getY() +",";
				monitorInfo += mo.getRadius() +",";
				monitorInfo += mo.getSetDate() +",";
			}
			if(monitorInfo.charAt(monitorInfo.length()-1 ) == ',')
			{
				monitorInfo = monitorInfo.substring(0, monitorInfo.length() - 1);
			}
			request.setAttribute("monitorInfo", monitorInfo);
			//model.put("info", "query monitor successfully!!!");
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		else {
			//System.out.println("22221");
			//System.out.println("monitorInfo:"+monitorInfo);
			request.setAttribute("monitorInfo", monitorInfo);
			model.put("info", "user:" + userName+" doesn't have monitor! ");
			return new ModelAndView(getWrong(), "myModel", model);
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

	public String getUnLogin() {
		return unLogin;
	}

	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
	}

	
}
