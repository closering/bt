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
    
    <title>searchHome.jsp' starting page</title>
    
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
	 
	<INPUT type="submit" value="BID"   onclick="javascript:location.href='bid.jsp'" style="position:absolute;left:300px;top:200px;">
	<INPUT type="submit" value="EPC"   onclick="javascript:location.href='epc.jsp'" style="position:absolute;left:500px;top:200px;">
  	<INPUT type="submit" value="UID"   onclick="javascript:location.href='uid.jsp'" style="position:absolute;left:700px;top:200px;">
  	<INPUT type="submit" value="UID in BID"   onclick="javascript:location.href='uidInBid.jsp'" style="position:absolute;left:300px;top:300px;">
  </body>
</html>
