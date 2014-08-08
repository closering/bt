package com.browse.map;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.Biduid2scanDAO;
import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.dao.Username2bidDAO;
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

public class bidTracingController extends AbstractController {
	private String unLogin;
	private String bidNotExist;
	private String bidExist;
	private String bid;
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
		bid = request.getParameter("bid");
		Bid2uidDAO buid = new Bid2uidDAOImpl();
		List list = null;
		list = (List)buid.searchBid(bid);
		if(list != null && list.size() > 0)
		{
			list.clear();
			Biduid2scanDAO busDao = new Biduid2scanDAOImpl();
			list = busDao.searchByBid(bid, 1);
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
				request.setAttribute("logisticsInfo", logisticsInfo);
			}
			////////////////////////////////get trace start
			String res = "";
			String locusDownload="";
			String hql = "from Locusinfo a where (a.id.username, a.id.id) in (select b.id.username, b.id.id from Username2bid as b where b.id.bid = ?)";
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			List list1 = null;
			try
			{
				Query qry = session.createQuery(hql);
				qry.setParameter(0, bid);
				list1 =qry.list();	
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally
			{
				session.close();
				sessionFactory.close();
			}
			LocusinfoId liId = new LocusinfoId();
			Locusinfo li = new Locusinfo();
			String lastUsername = null;
			Long lastId = (long)(-1);
			String nowUsername = null;
			Long nowId = (long)(-1);
			
			for(int i = 0; list1 != null && i < list1.size(); i++)
			{
				li = (Locusinfo)list1.get(i);
				liId = li.getId();
				nowUsername = liId.getUsername();
				nowId = liId.getId();		
				if(nowUsername.equals(lastUsername) && nowId.equals(lastId)){
					
				}
				else{
					if(i>0){
						res += ";";
					}
					res += nowUsername;
				}
				res += "," + liId.getX().toString();
				res += "," + liId.getY().toString();
				res += "," + liId.getSerial().toString();
				res += "," + liId.getDateServer().toString();
				lastUsername = nowUsername;
				lastId = nowId;
			}
			res += ";";
			locusDownload = res;
			if(locusDownload.charAt(locusDownload.length()-1 ) == ';')
			{
				locusDownload = locusDownload.substring(0, locusDownload.length() - 1);
			}
			model.put("locusDownload", locusDownload);
			//get trace end
			//get marker start
			List listMark;
			listMark = list;
			
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
			//shaoshan-end
			return new ModelAndView(getBidExist(), "myModel", model);
		}
		else
		{
			model.put("searchInfo", "this bid is not exit.");
			return new ModelAndView(getBidNotExist(),  "myModel", model);
		}
	}
	public String getUnLogin() {
		return unLogin;
	}

	public void setUnLogin(String unLogin) {
		this.unLogin = unLogin;
	}

	public String getBidNotExist() {
		return bidNotExist;
	}
	
	public void setBidNotExist(String bidNotExist) {
		this.bidNotExist = bidNotExist;
	}
	public String getBidExist() {
		return bidExist;
	}
	
	public void setBidExist(String bidExist) {
		this.bidExist = bidExist;
	}
}
