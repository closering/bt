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
import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.dao.Username2bidDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;
import com.hibernate.entity.Biduid2scan;
import com.hibernate.entity.Biduid2scanId;
import com.hibernate.entity.Locusinfo;
import com.hibernate.entity.LocusinfoId;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.Username2bid;
import com.hibernate.entity.Username2bidId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.Biduid2scanDAOImpl;
import com.hibernate.impl.LocusinfoDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;
import com.hibernate.impl.Username2bidDAOImpl;

public class uidTracingController extends AbstractController {
	private String unLogin;
	private String uidNotExist;
	private String uidExist;
	private String uid;
	private String logisticsInfo;
	private String bid;
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
				//model.put("logisticsInfo", logisticsInfo);
				request.setAttribute("logisticsInfo", logisticsInfo);
				//System.out.println(logisticsInfo);
			}
			//shao shan start
			Bid2uidDAO buDao = new Bid2uidDAOImpl();
			Bid2uidId buId = new Bid2uidId();
			List bidList = buDao.searchUid(uid);					
				for(int t = 0;bidList != null && t < bidList.size(); t ++)
				{
					buId = ((Bid2uid)bidList.get(t)).getId();
					bid = buId.getBid();
					
					//trace start
					Username2bidId ubId = new Username2bidId();
					Username2bid ub = new Username2bid();
					Username2bidDAO ubDao = new Username2bidDAOImpl();
					List listTrace, locus;
					
					String username;
					Long ID;
					
					LocusinfoId liId = new LocusinfoId();
					Locusinfo li = new Locusinfo();
					LocusinfoDAO liDao = new LocusinfoDAOImpl();
					
					listTrace = ubDao.searchByBid(bid);
					String locusDownload="";
					for(int i = 0; listTrace != null && i < listTrace.size(); i++)
					{
						ub = (Username2bid)listTrace.get(i);
						ubId = ub.getId();
						
						username = ubId.getUsername();
						ID = ubId.getId();
						
						locus = liDao.searchByUsernameID(username, ID);
						
						if(locus != null && locus.size() > 0)
						{
							locusDownload += username;
							for(int j = 0; locus != null && j < locus.size(); j++)
							{
								li = (Locusinfo)locus.get(j);
								liId = li.getId();
								//locusDownload += username;
								locusDownload += "," + liId.getX().toString();
								locusDownload += "," + liId.getY().toString();
								locusDownload += "," + liId.getSerial().toString();
								locusDownload += "," + liId.getDateServer().toString();
								//locusDownload += "," + liId.getDateServer().toString()+",";
							}
							locusDownload += ";";
							//locusDownload += ",";
						}
					}
					if(locusDownload.charAt(locusDownload.length()-1 ) == ';')
					{
						locusDownload = locusDownload.substring(0, locusDownload.length() - 1);
					}
					
					
					String ll[] = locusDownload.split(";");
					//String l[]=ll.split(",");
					model.put("locusDownload", locusDownload);
					
					//trace end
					
					//get marker start
					List listMark;
					Biduid2scanDAO busDaoMark = new Biduid2scanDAOImpl();
					listMark = busDaoMark.searchByUid(uid, 1);
					
					UserdataDAO uDao = new UserdataDAOImpl();
					List listMark1 = null;
					Biduid2scanId busId;
					String usernameMark;
					String locusMark="";
					
					for(int i = 0; listMark!=null && i < listMark.size(); i++)
					{
						busId = ((Biduid2scan)listMark.get(i)).getId();
						usernameMark =busId.getUsername();
						
						locusMark += usernameMark + ",";
						locusMark += busId.getScanDate() + ",";
						if(busId.getOperationType().equals(1))
						{
							locusMark += "enter" + ",";
						}
						else
						{
							locusMark += "out"  + ",";
						}
						listMark1 = uDao.searchByName(usernameMark);
						
						if(listMark1 == null)
						{
							locusMark += ",";
							
						}
						else
						{
							locusMark += ((Userdata)listMark1.get(0)).getId().getAddress() + ",";
						}
						locusMark += busId.getX() + ",";
						locusMark += busId.getY() + ",";
					}
					
					if(locusMark.charAt(locusMark.length()-1 ) == ',')
					{
						locusMark = locusMark.substring(0, locusMark.length() - 1);
					}
					
					String l[] = locusMark.split(",");
					//String l[]=ll.split(",");
					model.put("locusMark", locusMark);
					
					
					//get marker end
					
					
				}
				return new ModelAndView(getUidExist(),  "myModel", model);
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
