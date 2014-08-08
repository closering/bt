package com.conn.android;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.MonitorPositionDAO;
import com.hibernate.entity.MonitorPosition;
import com.hibernate.entity.MonitorPositionId;
import com.hibernate.impl.MonitorPositionDAOImpl;

public class uploadPosition extends HttpServlet {
	private String monitorName;
	private Double longitude;
	private Double latitude;
	private Timestamp time;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		monitorName = request.getParameter("monitorName");
		longitude = Double.parseDouble(request.getParameter("longitude"));
		latitude = Double.parseDouble(request.getParameter("latitude"));
		time = new Timestamp(System.currentTimeMillis());
		
		System.out.println("uploadPos:"+monitorName+", "+longitude+", "+latitude+", "+time);
		
		MonitorPosition mp = new MonitorPosition();
		MonitorPositionId mpId = new MonitorPositionId();
		MonitorPositionDAO mpD = new MonitorPositionDAOImpl();
		mpId.setMonitorName(request.getParameter("monitorName"));
		mpId.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		mpId.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		mpId.setTime(time);
		mp.setId(mpId);
		mpD.add(mp);
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
