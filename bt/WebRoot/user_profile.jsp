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
    
    <title>user profile.jsp</title>
    
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
	 
	 <table style="position:absolute;left:350px;top:170px;">
	 	<tr>
	 		<td class = "tdright">username :</td>
	 		<td class = "tdleft"><font color = "#999">${profile.userName }</font></td>
	 		<td class = "tdright">company name :</td>
	 		<td class = "tdleftLine"><font color = "#999">${profile.name }</font></td>
	 	</tr>
	 	<tr>
	 		<td class = "tdright">email :</td>
	 		<td class = "tdleft"><font color = "#999">${profile.email }</font></td>
	 		<td class = "tdright">establish date :</td>
	 		<td class = "tdleftLine"><font color = "#999">${establishDate }</font></td>
	 	</tr>
	 	<tr>
	 		<td class = "tdright">contact person :</td>
	 		<td class = "tdleft"><font color = "#999">${profile.contactPerson }</font></td>
	 		<td class = "tdright">address :</td>
	 		<td class = "tdleftLine"><font color = "#999">${profile.address }</font></td>
	 	</tr>
	 	<tr>
	 		<td class = "tdright">contact phone :</td>
	 		<td class = "tdleft"><font color = "#999">${profile.phone }</font></td>
	 		<td class = "tdright">postcode :</td>
	 		<td class = "tdleftLine"><font color = "#999">${profile.postcode }</font></td>
	 	</tr>
	 	<tr>
	 		<td class = "tdright">user type :</td>
	 		<td class = "tdleft"><font color = "#999">${type }</font></td>
	 		<td class = "tdright">radius :</td>
	 		<td class = "tdleftLine"><font color = "#999">${profile.radius }</font></td>
	 	</tr>
	 	<tr>
	 		<td class = "tdright">longitude :</td>
	 		<td class = "tdleft"><font color = "#999">${profile.x }</font></td>
	 		<td class = "tdright">latitude :</td>
	 		<td class = "tdleftLine"><font color = "#999">${profile.y }</font></td>
	 	</tr>
	 </table>
  </body>
</html>
