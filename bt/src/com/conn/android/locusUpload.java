package com.conn.android;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.entity.Locusinfo;
import com.hibernate.entity.LocusinfoId;
import com.hibernate.impl.LocusinfoDAOImpl;

public class locusUpload extends HttpServlet {
	
	public locusUpload() {
		super();
	}
	//http://localhost:8080/bt/com/conn/android/locusUpload?upload=aa,1,1,1,1,2014-04-24%202022:54:42
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		
		String data = request.getParameter("upload");
		
		String res = "";
		if(data == null)
		{
			res = "{\"HEXLE\":\"0\"}";
		}
		else
		{
			String[] dataSplit = data.split(",");
			
			if(dataSplit.length < 6 || (dataSplit.length - 2) % 4 != 0)
			{
				res = "{\"HEXLE\":\"0\"}";
			}
			else
			{
				String username = dataSplit[0];
				Long id = Long.parseLong(dataSplit[1]);
				
				Double x, y;
				Long serial;
				
				Timestamp  serverTime;
				Timestamp phoneTime;
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				LocusinfoDAO liDao = new LocusinfoDAOImpl();
				LocusinfoId liId = new LocusinfoId();
				Locusinfo li = new Locusinfo();
				
				liId.setId(id);
				liId.setUsername(username);			
	//			
	//			Timestamp ts = new Timestamp(System.currentTimeMillis());  
	//	        String tsStr = "2011-05-09 11:49:45";  
	//	        try {  
	//	            ts = Timestamp.valueOf(tsStr);  
	//	            System.out.println(ts);  
	//	        } catch (Exception e) {  
	//	            e.printStackTrace();  
	//	        }  
				int i;
				for(i = 2; i < dataSplit.length; i += 4)
				{				 
			        try 
			        {
			        	res = "{\"HEXLE\":\"0\"}";
			        	phoneTime = Timestamp.valueOf(dataSplit[i + 3]); 
			        	liId.setDatePhone(phoneTime);
			        } catch (IllegalArgumentException  e)
			        {  
			            e.printStackTrace(); 
			            break;
			        }
			        
			        try
			        {
			        	
			        	x = Double.parseDouble(dataSplit[i]);
			        	liId.setX(x);
			        } catch (NumberFormatException  e)
			        {  
			            e.printStackTrace(); 
			            break;
			        }
			        
			        try
			        {
			        	y = Double.parseDouble(dataSplit[i + 1]);
			        	liId.setY(y);
			        } catch (NumberFormatException  e)
			        {  
			            e.printStackTrace(); 
			            break;
			        }
			        
			        try
			        {
			        	serial = Long.parseLong(dataSplit[i + 2]);
			        	liId.setSerial(serial);
					} catch (NumberFormatException  e)
			        {  
			            e.printStackTrace();  
			            break;
			        }
	
			        
			        serverTime = new Timestamp(new java.util.Date().getTime());
			        
			        liId.setDateServer(serverTime);
	            		        
			        li.setId(liId);
			        liDao.add(li);
			 
				}
				if(i < dataSplit.length)
				{
					res = "{\"HEXLE\":\"0\"}";
				}
				else
					res = "{\"HEXLE\":\"1\"}";
			}
		}
		response.getOutputStream().print(res);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
