package com.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.impl.Bid2uidDAOImpl;

public class searchByBidController extends AbstractController{
	
	private String wrong;
	private String sucess;
	
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
		
		bid = request.getParameter("bid");
		
		Bid2uidDAO buid = new Bid2uidDAOImpl();
		List list = null;
		List<String> listResult = new ArrayList<String>();
		list = (List)buid.searchBid(bid);
		
		Bid2uid b = null;
		
		if(list != null && list.size() > 0)
		{
			
			for(int i = 0; i < list.size(); i++)
			{
				b = (Bid2uid)list.get(i);			
				listResult.add(b.getId().getUid());
			}
			request.setAttribute("length", listResult.size());
			request.setAttribute("listResult", listResult);
			request.setAttribute("bid", bid);
			
			return new ModelAndView(getSucess(), "myModel", model);
		}
		else
		{
			model.put("searchInfo", "this bid not exit.");
			return new ModelAndView(getSucess(), "myModel", model);
		}
		
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
