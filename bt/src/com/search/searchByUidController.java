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
import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Uid2epc;
import com.hibernate.entity.Uid2epcId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.Uid2epcDAOImpl;

public class searchByUidController extends AbstractController{
	
	private String wrong;
	private String sucess;
	
	private String uid;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		
		if(userName == null)
		{
			return new ModelAndView(getWrong(), model);
		}
		
		uid = request.getParameter("uid");
		
		Bid2uidDAO buid = new Bid2uidDAOImpl();
		Uid2epcDAO ueDao = new Uid2epcDAOImpl();
		
		List list = buid.searchUid(uid);
		
		if(list != null && list.size() > 0)
		{
			List<String> bid = new ArrayList<String>();
			for(int i = 0; i < list.size(); i++)
			{
				bid.add(((Bid2uid)(list.get(i))).getId().getBid());
			}
			request.setAttribute("bid", bid);
			request.setAttribute("bidLen", bid.size());
			request.setAttribute("uid", uid);
		}
		
		list.clear();
		list = ueDao.searchByUid(uid);
		
		if(list != null && list.size() > 0)
		{
			List<Uid2epcId> uidEpc = new ArrayList<Uid2epcId>();
			for(int i = 0; i < list.size(); i++)
			{
				uidEpc.add(((Uid2epc)(list.get(i))).getId());
			}
			
			request.setAttribute("uidEpc", uidEpc);
			request.setAttribute("epcLen", uidEpc.size());
		}
		
		
		return new ModelAndView(getSucess(), "myModel", model);
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
