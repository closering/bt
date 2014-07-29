package com.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.ProductDAO;
import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Product;
import com.hibernate.entity.ProductId;
import com.hibernate.entity.Uid2epc;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.ProductDAOImpl;
import com.hibernate.impl.Uid2epcDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;

public class searchByEpcController extends AbstractController{

	private String wrong;
	private String sucess;
	
	private String epc;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = (String) request.getSession().getAttribute("userName");
		
		if(userName == null)
		{
			return new ModelAndView(getWrong(), model);
		}
		
		epc = request.getParameter("epc");
		
		request.setAttribute("epc", epc);
		
		ProductDAO pdao = new ProductDAOImpl();
		
		List list = pdao.searchByEpc(epc);
		if(list != null && list.size() > 0)
		{
			ArrayList<ProductId> li = new ArrayList<ProductId>();
			ArrayList<String> companyName = new ArrayList<String>();
			
			ProductId pId;
			UserdataId uId;
			
			
			UserdataDAO uDao = new UserdataDAOImpl();
			
			for(int i = 0;list != null &&  i < list.size(); i++)
			{
				pId = ((Product)list.get(i)).getId();
				li.add(pId);
				uId = ((Userdata)uDao.searchByName(pId.getUserName()).get(0)).getId();
				companyName.add(uId.getName());
			}
			
			request.setAttribute("product", li);
			request.setAttribute("company", companyName);
			request.setAttribute("productLength", li.size());
			
			Uid2epcDAO uedao = new Uid2epcDAOImpl();
			
			list.clear();
			list = uedao.searchByEpc(epc);
			
			
			request.setAttribute("uidLength", list.size());
			
			List<String> listResult = new ArrayList<String>();
			Uid2epc uei = null;
			
			for(int i = 0; list != null && i < list.size(); i++)
			{	
				uei = (Uid2epc)list.get(i);
				listResult.add(uei.getId().getUid());
			}
			
			request.setAttribute("listResult", listResult);
			
			return new ModelAndView(getSucess(), "myModel", model);
		}
		else
		{
			model.put("info", "this epc does not exist. please input another");
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
