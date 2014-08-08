package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.MonitorInfoDAO;
import com.hibernate.dao.MonitorPositionDAO;
import com.hibernate.entity.MonitorPositionId;
import com.hibernate.entity.MonitorPosition;
import com.hibernate.impl.MonitorPositionDAOImpl;
import com.hibernate.impl.MonitorInfoDAOImpl;

public class monitorTracingController extends AbstractController{

	private String unLogin;
	private String monitorNotExist;
	private String monitorExist;
	private String monitorNoTrace;
	
	private String monitorName;
	private String longitude;
	private String latitude;
	private String radius;
	
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
		MonitorInfoDAO moD = new MonitorInfoDAOImpl();
		List list = null;
		list = moD.searchByUsernameAndMonitorName(userName, monitorName);
		if(list != null && list.size() > 0)
		{
			MonitorPositionDAO moPositionDao = new MonitorPositionDAOImpl();
			List listTrace = moPositionDao.searchByMonitorName(monitorName);
			MonitorPositionId monitorPositionId = new MonitorPositionId();
			String locusDownload="";
			model.put("latitude", latitude);
			model.put("longitude",longitude);
			model.put("radius",radius);
			if(listTrace!=null && listTrace.size() > 0)
			{
				for(int i = 0;listTrace!=null && i<listTrace.size();i++)
				{
					monitorPositionId =( (MonitorPosition)listTrace.get(i)).getId();
					locusDownload+=monitorPositionId.getLatitude()+",";
					locusDownload+=monitorPositionId.getLongitude()+",";
				}
				if(locusDownload.charAt(locusDownload.length()-1 ) == ',')
				{
					locusDownload = locusDownload.substring(0, locusDownload.length() - 1);
				}
				
				
				model.put("locusDownload", locusDownload);
				
				return new ModelAndView( getMonitorExist(), "myModel",model);
			}
			else {
				model.put("info", "the monitor \""+monitorName+"\" doesn't have trace!");
				return new ModelAndView( getMonitorNoTrace(),"myModel", model);
			}
		}
		else
		{
			model.put("info", "the monitor \""+monitorName+"\" doesn't exist!");
			return new ModelAndView( getMonitorNotExist(),"myModel", model);
		}
	}
	
	public String getUnLogin() {
		return unLogin;
	}
	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
	}
	public String getMonitorNotExist() {
		return monitorNotExist;
	}
	public void setMonitorNotExist(String monitorNotExist) {
		this.monitorNotExist = monitorNotExist;
	}
	public String getMonitorExist() {
		return monitorExist;
	}
	public void setMonitorExist(String monitorExist) {
		this.monitorExist = monitorExist;
	}

	public String getMonitorNoTrace() {
		return monitorNoTrace;
	}

	public void setMonitorNoTrace(String monitorNoTrace) {
		this.monitorNoTrace = monitorNoTrace;
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
