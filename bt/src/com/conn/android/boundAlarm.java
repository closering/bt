package com.conn.android;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coml.jpush.Jpush;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class boundAlarm extends HttpServlet {
	private String username;//�໤���û���
	private String message;//�û���������Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		String data = request.getParameter("alarm");
		
		System.out.println(data);
		
		String[] dataSplit = data.split(";");
		username = dataSplit[0];//�໤���û���
		message = dataSplit[1];//�û���������Ϣ
		
		Jpush push = new Jpush();
		push.pushAlert(username, message);	
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
