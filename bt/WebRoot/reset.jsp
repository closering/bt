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
    
    <title>user profile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	 <jsp:include page="header.jsp" flush="true">
		<jsp:param name="pageTitle" value="header.jsp"/>
  		<jsp:param name="pageSlogan" value="header" />
	</jsp:include>
	
	<jsp:include page="info.jsp" flush="true">
		<jsp:param name="pageTitle" value="header.jsp"/>
  		<jsp:param name="pageSlogan" value="header" />
	</jsp:include>
	
	<div style="position:absolute;left:500px;top:125px;width:450px;height:30px;
background-color:transparent;border-color:transparent;z-index:1">${myModel.loginInfo}</div>
	 
	 <form method="post" action="/bt/resetInfo.do">
		<table style="position:absolute;left:300px;top:140px;">
			<tr>
				<td class = "tdright">username :</td>
				<td><input type = "text" value = "<%=(String)request.getAttribute("username") %>" name = "username"></td>
				<td class = "tdright">company name :</td>
				<td><input type = "text" value = "<%=(String)request.getAttribute("name") %>" name = "name"></td>
			</tr>
			<tr>
				<td class = "tdright">password :</td>
				<td><input type = "text" value = "<%=(String)request.getAttribute("password") %>" name = "password"></td>
				<td class = "tdright">establish date :</td>
				<td><input type = "text" name = "establishDate" value = "<%=(String)request.getAttribute("establishDate") %>" name="produceDate"></td>
				
			</tr>
			<tr>
				<td class = "tdright">email :</td>
				<td><input type = "text" name = "email" value = "<%=(String)request.getAttribute("email") %>"></td>
				<td class = "tdright">address :</td>
				<td><input type = "text" value ="<%=(String)request.getAttribute("address") %>" name = "address"></td>
			</tr>
			<tr>
				<td class = "tdright">contact person :</td>
				<td><input type = "text" value = "<%=(String)request.getAttribute("person") %>" name = "contacter"></td>
				<td class = "tdright">postcode :</td>
				<td><input type = "text" value = "<%=(String)request.getAttribute("postcode") %>" name = "postcode"></td>
			</tr>
			<tr>
				<td class = "tdright">contact phone :</td>
				<td><input type = "text" value = "<%=(String)request.getAttribute("phone") %>" name = "phone"></td>
				<td class = "tdright">longitude :</td>
				<td><input type = "text" value = ${userInfo.x } name = "ldegree"></td>
			</tr>
			<tr>
				<td class = "tdright">user type :</td>
				<td>
					<SELECT  style="width:180" name = "type">
						<OPTION selected value=${type1 }>${type1 }</OPTION>
						<OPTION  value=${type2 }>${type2 }</OPTION>
						<OPTION  value=${type3 }>${type3 }</OPTION>
						<OPTION  value=${type4 }>${type4 }</OPTION>
					</SELECT>
				</td>
				<td class = "tdright">latitude :</td>
				<td><input type = "text" value = ${userInfo.y} name = "degree" ></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td class = "tdright">radius :</td>
				<td><input type = "text" value = ${userInfo.radius} name = "radius"></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;&nbsp;&nbsp;<input type="reset" value = "recover"></td>
				<td colspan = "2">&nbsp;<input type="submit" value = "reset"></td>
			</tr>
		</table>
		
	</form>
	 
  </body>
</html>
