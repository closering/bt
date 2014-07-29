package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hibernate.dao.ProductDAO;
import com.hibernate.entity.Product;
import com.hibernate.entity.ProductId;
import com.hibernate.impl.ProductDAOImpl;

public class productController extends AbstractController{
	
	private String epc;
	private String userName;
	private String productName;
	private String expierDays;
	private String produceDate;
	private String category;
	
	private String info;
	
	private String wrong;
	private String sucess;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		epc = request.getParameter("epc");
		userName = (String) request.getSession().getAttribute("userName");
		productName = request.getParameter("procuctName");
		expierDays = request.getParameter("expire");
		produceDate = request.getParameter("produceDate");
		category = request.getParameter("category");
		
		ProductDAO pDao = new ProductDAOImpl();
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(pDao.searchByUsernameEpc(epc, userName).size() > 0)
		{
			model.put("productInfo", "you have added this product already");
			return new ModelAndView(getWrong(), "myModel", model);
		}
		else
		{
			ProductId pId = new ProductId();
			if(setParam(pId))
			{
				Product p = new Product();
				p.setId(pId);
				pDao.add(p);
				
				model.put("productInfo", "");
				return new ModelAndView(getSucess(), "myModel", model);
			}
			else
			{
				model.put("productInfo", info);
				return new ModelAndView(getWrong(), "myModel", model);
			}
		}
	}
	
	private boolean setParam(ProductId pId)
	{
		if(epc.length() < 1)
		{
			info = "please input epc";
			return false;
		}
		if(productName.length() < 1)
		{
			info = "please input produce name";
			return false;
		}
		pId.setCategory(category);
		pId.setProductName(productName);
		pId.setEpc(epc);
		
		try{
			pId.setExpireDays(Integer.parseInt(expierDays));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			info = "please input the expire days as an integer number";
			e.printStackTrace();
			return false;
		}
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//参数为你要格式化时间日期的模式
		Date date = new Date();
		try {
			pId.setProductTime(df.parse(produceDate));//将字符串按照定义的模式转换为Date对象
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			info = "please input the date as mm/dd/yyyy format";
			e.printStackTrace();
			return false;
		}
		pId.setUserName(userName);
		
		return true;
		
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
