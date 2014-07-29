package com.controller;

import java.sql.Timestamp;
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

import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.entity.Uid2epc;
import com.hibernate.impl.Uid2epcDAOImpl;

public class recallController  extends AbstractController{
	
	private String wrong;
	private String success;
	private String epc;
	private Date begin;
	private Date end;
	private String beginDate;
	private String endDate;
	private String info;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		epc = request.getParameter("epc");
		beginDate = request.getParameter("begin");
		endDate = request.getParameter("end");
		boolean setP = setParameter();
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(setP)
		{
			Uid2epcDAO ueDao = new Uid2epcDAOImpl();
			Uid2epc ue;
			List list = ueDao.searchByEpc(epc);
			for(int i = 0; list != null && i < list.size(); i++)
			{
				ue = (Uid2epc)list.get(i);
				ueDao.delect(ue);
				ue.getId().setRecall(1);
				ueDao.add(ue);
			}
			model.put("Info", info);
			return new ModelAndView(getWrong(), "myModel", model);
		}
		else
		{
			model.put("Info", info);
			return new ModelAndView(getWrong(), "myModel", model);
		}
		
	}
	
	private boolean setParameter()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//参数为你要格式化时间日期的模式
		try
		{
			begin = df.parse(beginDate);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			info = "please input the begin date as mm/dd/yy";
			e.printStackTrace();
			return false;
		}
		
		try
		{
			end = df.parse(endDate);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			info = "please input the end date as mm/dd/yy";
			e.printStackTrace();
			return false;
		}
		
		return true;
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
