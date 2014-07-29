package com.browse.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.entity.Biduid2scan;
import com.hibernate.entity.Biduid2scanId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.Biduid2scanDAOImpl;

public class uidTracingController extends AbstractController {
	private String unLogin;
	private String uidNotExist;
	private String uidExist;
	private String uid;
	private String logisticsInfo;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		if(userName == null)
		{
			return new ModelAndView(getUnLogin(), model);
		}
		uid = request.getParameter("uid");
		Bid2uidDAO buid = new Bid2uidDAOImpl();
		List list = null;
		list = (List)buid.searchUid(uid);
		if(list != null && list.size() > 0)
		{
			list.clear();
			Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
			list = busDao.searchByUid(uid, 1);
			if(list != null)
			{
				Biduid2scanId busId;
				logisticsInfo = "";
				for(int i = 0; i< list.size(); i++)
				{
					busId = ((Biduid2scan)list.get(i)).getId();
					logisticsInfo += busId.getUsername() +",";
					logisticsInfo += busId.getScanDate() + ",";
					logisticsInfo += busId.getX() + ",";
					logisticsInfo += busId.getY() + ",";
				}
				model.put("logisticsInfo", logisticsInfo);
				System.out.println(logisticsInfo);
			}
			return new ModelAndView(getUidExist(), model);
		}
		else
		{
			model.put("searchInfo", "this uid is not exit.");
			return new ModelAndView(getUidNotExist(),  "myModel", model);
		}
	}
	public String getUnLogin() {
		return unLogin;
	}

	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
	}

	public String getUidNotExist() {
		return uidNotExist;
	}
	
	public void setUidNotExist(String uidNotExist) {
		this.uidNotExist = uidNotExist;
	}
	public String getUidExist() {
		return uidExist;
	}
	
	public void setUidExist(String uidExist) {
		this.uidExist = uidExist;
	}
}
