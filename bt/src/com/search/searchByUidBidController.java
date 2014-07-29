package com.search;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.impl.Bid2uidDAOImpl;

public class searchByUidBidController extends AbstractController{

	private String wrong;
	private String sucess;
	
	
	private String uid;
	private String bid;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		
		if(userName == null)
		{
			return new ModelAndView(getWrong(), model);
		}
		
		uid = request.getParameter("uid");
		bid = request.getParameter("bid");
		
		System.out.print(uid + bid);
		
		Bid2uidDAO buDao = new Bid2uidDAOImpl();
		String info = null;
		
		if(buDao.searchBUid(bid, uid))
		{
			info = "YES,  this uid in bid";
			//request.setAttribute("info", info);
			//return new ModelAndView(getSucessSearch(), model);
		}
		else
		{
			info = "NO,  this uid does not in bid";
			//request.setAttribute("info", info);
			//return new ModelAndView(getWrongSearch(), model);
		}
		
		request.setAttribute("info", info);
		return new ModelAndView(getSucess(), model);
	}

	public String getWrong() {
		return wrong;
	}

	public void setWrong(String wrong) {
		this.wrong = wrong;
	}

	public String getSucess() {
		return sucess;
	}

	public void setSucess(String sucess) {
		this.sucess = sucess;
	}
	
	

}
