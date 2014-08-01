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
    
    <title>monitor</title>
    
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
	<div style="position:absolute;left:540px;top:140px;"><h3>input monitor info</h3></div>
	<div style="position:absolute;left:440px;top:380px;">
		${myModel.info}</br>
	</div>
	<form method="post" action="/bt/monitor.do">
		 <table style="position:absolute;left:430px;top:200px;">
		 	<tr>
		 		<td class = "tdright">Pupil UserName:</td>
		 		<td class = "tdleft"><input type = "text" name = "pupilUsername" value = ${myModel.pupilUsername}><td>	 		
		 	</tr>
		 	<tr>
		 		<td class = "tdright">Longitude :</td>
		 		<td class = "tdleft"><input type = "text" name = "longitude" value = ${myModel.longitude}></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">Latitude :</td>
		 		<td class = "tdleft"><input type = "text" name="latitude" value = ${myModel.latitude}></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">Radius :</td>
		 		<td class = "tdleft"><input type = "text" name="radius" value = ${myModel.radius}> km</td>
		 	</tr>
		 	<tr>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;<input type="submit" value = "add"><td>
			</tr>
		 </table>
	 </form>
  </body>
</html>
