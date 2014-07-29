<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<% request.setCharacterEncoding("GBK");%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <jsp:include page="header.jsp" flush="true">
		<jsp:param name="pageTitle" value="header.jsp"/>
  		<jsp:param name="pageSlogan" value="header" />
	</jsp:include>
	
	<a href = "register.jsp" onclick="subgo()" style="position:absolute;left:1000px;top:40px;"><font color="#FFFFFF" size="4px">register</font></a>
	<div style="position:absolute;left:570px;top:163px;width:400px;height:25px;
		background-color:transparent;border-color:transparent;z-index:3">${myModel.loginInfo}</div>
		
	<form method="post" action="/bt/login.do">
		<table style="position:absolute;left:500px;top:202px;">
			<tr>
				<td class = "tdright">username:</td>
				<td class = "tdleft"><input type = "text" name = "userName"></input></td>
			</tr>
			<tr>
				<td class = "tdright">password:</td>
				<td class = "tdleft"><input type = "password" name = "password"></input></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;<input type="submit" value = "login"><td>
			</tr>
		</table>
	</form>
  </body>
</html>
