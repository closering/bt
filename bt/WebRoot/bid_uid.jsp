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
    
    <title>bid_uid.jsp' starting page</title>
    
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
	 
	 <div style="position:absolute;left:570px;top:163px;width:400px;height:25px;
		background-color:transparent;border-color:transparent;z-index:3">${myModel.Info}</div>
	 
	 <form action="/bt/bid_uid.do" method = post>
	  <table style="position:absolute;left:550px;top:200px;">
	  	<tr>
	  		<td class = "tdright">BID:</td>
	  		<td class = "tdleft"><input type = "text" name = "bid"></td>
	  	</tr>
	  	<tr>
	  		<td class = "tdright">UID:</td>
	  		<td class = "tdleft"><input type = "text" name = "uid"></td>
	  	</tr>
	  	<tr>
	  		<td></td>
	  		<td><input type = "submit" value = "submit"></td>
	  	</tr>
	  </table>
	</form>
  </body>
</html>
