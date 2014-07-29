<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
    <script src="./script/head.js"></script>
    
    
   	<%
		if(session.getAttribute("userName")==null)
		{
			out.print("<script type='text/javascript'>alert('login in first!');document.location.href='login.jsp';</script>");
		}
		else
		{%>
			<ul id="rr">
	   		<li class="dd" id="gg" style="position:absolute;top:20;left:1000;z-index:999;" onmouseover="onMouseover()" onmouseout="onMouseout()"><font color="#FFFFFF"><%=session.getAttribute("userName")%></font>
	        		<ul id="tt">
	             		<li><a href="profile.do"><font color="#FFFFFF">user profile</font></a></li>
	             		<li><a href="reset.do"><font color="#FFFFFF">reset info</font></a></li>
	             		<li><a href="logout.jsp"><font color="#FFFFFF">logout</font></a></li>
	        		</ul>
	   		</li>
			</ul>
		<%}
	 %>