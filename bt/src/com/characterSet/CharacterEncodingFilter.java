package com.characterSet;

import java.io.IOException; 

import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServlet; 

@SuppressWarnings("serial") 
public class CharacterEncodingFilter extends HttpServlet implements Filter { 

    public CharacterEncodingFilter() { 
  // TODO Auto-generated constructor stub 
    } 

    public void doFilter(ServletRequest arg0, ServletResponse arg1, 
      FilterChain arg2) throws IOException, ServletException { 
  //��������������������Ŀ��ʹ�õ������ַ�ȷ�� 
	  arg0.setCharacterEncoding("UTF-8"); 
	  arg1.setCharacterEncoding("UTF-8"); 
	  arg2.doFilter(arg0, arg1); 
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	} 
}
