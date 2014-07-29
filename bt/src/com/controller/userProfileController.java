package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.UserdataDAOImpl;

public class userProfileController extends AbstractController{

	private String success;
	private String failed;
	private String userName;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		userName = (String)request.getSession().getAttribute("userName");
		
		UserdataDAO userD = new UserdataDAOImpl();
		Map<String, Object> model = new HashMap<String, Object>();
		
		List list = userD.searchByName(userName);
		
		if(list.size() > 0)
		{
			UserdataId user = ((Userdata)list.get(0)).getId();
			request.setAttribute("userInfo", user);
			switch(user.getType())
			{
			case 1:
				request.setAttribute("type", "manufacturer");
				break;
			case 3:
				request.setAttribute("type", "producer");
				break;
			case 5:
				request.setAttribute("type", "warehouse");
				break;
			default:
				request.setAttribute("type", "retailer");
				break;
			}
			return new ModelAndView(getSuccess(), model);
		}
		else
		{
			return new ModelAndView(getFailed(), model);
		}
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFailed() {
		return failed;
	}

	public void setFailed(String failed) {
		this.failed = failed;
	}
}
