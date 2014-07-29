package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.entity.Uid2epc;
import com.hibernate.entity.Uid2epcId;
import com.hibernate.impl.Uid2epcDAOImpl;

public class uid_epcController extends AbstractController{
	private String wrong;
	private String success;
	
	private String epc;
	private String uid;
	private String recall;
	private String produceDate;
	private String isExpire;
	
	private String info;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		epc = request.getParameter("epc");
		uid = request.getParameter("uid");
		recall = request.getParameter("recall");
		produceDate = request.getParameter("producedate");
		isExpire = request.getParameter("isExpire");
		
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		
		if(userName == null)
		{
			return new ModelAndView(getWrong(), model);
		}
		Uid2epcId ueId = new Uid2epcId();
		
		if(setParameter(ueId))
		{
			Uid2epc ue = new Uid2epc();
			ue.setId(ueId);
			
			Uid2epcDAO ueDao = new Uid2epcDAOImpl();
			ueDao.add(ue);
			
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		else
		{
			model.put("Info", info);
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		
		
		

}
	
	private boolean setParameter(Uid2epcId ueId)
	{
		if(epc.equals(""))
		{
			info = "please input epc";
			return false;
		}
		if(uid.equals(""))
		{
			info = "please input uid";
			return false;
		}
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//参数为你要格式化时间日期的模式
		Date date = new Date();
		try {
			ueId.setProducedate(df.parse(produceDate));//将字符串按照定义的模式转换为Date对象
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			info = "please input the produce date as mm/dd/yy";
			e.printStackTrace();
			return false;
		}
		if(isExpire.equals("yes"))
		{
			ueId.setIsExpire(1);
		}
		else
			ueId.setIsExpire(0);
		
		if(recall.equals("yes"))
		{
			ueId.setRecall(1);
		}
		else
			ueId.setRecall(0);
		
		ueId.setEpc(epc);
		ueId.setUid(uid);
		
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
