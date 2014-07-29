package com.browse.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.baseData.locusData;
import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.dao.Username2bidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;
import com.hibernate.entity.Locusinfo;
import com.hibernate.entity.LocusinfoId;
import com.hibernate.entity.Username2bid;
import com.hibernate.entity.Username2bidId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.LocusinfoDAOImpl;
import com.hibernate.impl.Username2bidDAOImpl;

public class bidMapController extends AbstractController{
	
	private String wrong;
	private String success;
	
	private String bid;
	
	private String info;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("locusDownload");
		Map<String, Object> model = new HashMap<String, Object>();
		String res = "";
		if(data == null)
		{
			res = "0"; //wrong input
			request.setAttribute("locus", res);
			return new ModelAndView(getWrong(), model);
		}
		else
		{
			String[] dataSplit = data.split(",");
			
			if(dataSplit.length != 2)
			{
				res = "0"; //wrong input
				request.setAttribute("locus", res);
				return new ModelAndView(getWrong(), model);
			}
			else
			{
				String type = dataSplit[0].toLowerCase();
				res = "";
				
				
				if(type.equals("bid"))
				{
					String bid = dataSplit[1];
					res = getLocus(bid, res);
				}
				else if(type.equals("uid"))
				{
					Bid2uidId buId = new Bid2uidId();
					Bid2uidDAO buDao = new Bid2uidDAOImpl();
					String uid = dataSplit[1];
										
					List bidList = buDao.searchUid(uid);
					for(int t = 0;bidList != null && t < bidList.size(); t ++)
					{
						buId = ((Bid2uid)bidList.get(t)).getId();
						res = getLocus(buId.getBid(), res);
					}
					
				}
				else
				{
					res = "0"; //wrong input
				}
				if(res.charAt(res.length() - 1) == ',')
				{
					res = res.substring(0, res.length() - 1);
				}
			}
		}
		request.setAttribute("locus", res);
		return new ModelAndView(getSuccess(), model);
		//response.getOutputStream().print(res);
	}

	private String getLocus(String bid, String res)
	{
		Username2bidId ubId = new Username2bidId();
		Username2bid ub = new Username2bid();
		Username2bidDAO ubDao = new Username2bidDAOImpl();
		List list, locus;
		
		String username;
		Long ID;
		
		LocusinfoId liId = new LocusinfoId();
		Locusinfo li = new Locusinfo();
		LocusinfoDAO liDao = new LocusinfoDAOImpl();
		
		list = ubDao.searchByBid(bid);
		for(int i = 0; list != null && i < list.size(); i++)
		{
			ub = (Username2bid)list.get(i);
			ubId = ub.getId();
			
			username = ubId.getUsername();
			ID = ubId.getId();
			
			locus = liDao.searchByUsernameID(username, ID);
			
			if(locus != null || locus.size() < 1)
			{
				
				for(int j = 0; locus != null && j < locus.size(); j++)
				{
					res += username + ",";
					li = (Locusinfo)locus.get(j);
					liId = li.getId();
					res += liId.getX().toString() + "," ;
					res += liId.getY().toString() + "," ;
					res += liId.getSerial().toString() + "," ;
					res += liId.getDateServer().toString() + "," ;
				}
			}
		}
		
		return res;
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
