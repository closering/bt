package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;
import com.hibernate.impl.Bid2uidDAOImpl;

public class bid_uidController extends AbstractController{
	
	private String wrong;
	private String success;
	
	private String bid;
	private String uid;
	
	private String info;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		bid = request.getParameter("bid");
		uid = request.getParameter("uid");
		
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		
		if(userName == null)
		{
			return new ModelAndView(getWrong(), model);
		}
		if(bid.equals(""))
		{
			info = "please input bid";
			model.put("Info", info);
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		
		if(uid .equals(""))
		{
			info = "please input uid";
			model.put("Info", info);
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		
		Bid2uidDAO buid = new Bid2uidDAOImpl();
		if(buid.searchBUid(bid, uid))
		{
			info = "this package have been update in database";
			model.put("Info", info);
			return new ModelAndView(getSuccess(), "myModel", model);
		}
		else
		{
			Bid2uidId buId = new Bid2uidId();
			Bid2uid bu = new Bid2uid();
			buId.setBid(bid);
			buId.setUid(uid);
			bu.setId(buId);
			buid.add(bu);
			return new ModelAndView(getSuccess(), "myModel", model);
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
	
	

}
