<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>recall.jsp' starting page</title>
    
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
	
	<div style="position:absolute;left:600px;top:180px;width:400px;height:25px;
background-color:transparent;border-color:transparent;z-index:1">${myModel.Info}</div>

	<form action="/bt/recall.do" method = post>
		<table style="position:absolute;left:550px;top:200px;">
			<tr>
				<td class = "tdright">EPC :</td>
				<td class = "tdleft"><input type = "text" name = "epc"></td>
			</tr>
			<tr>
				<td class = "tdright">Begin :</td>
				<td class = "tdleft"><input type = "text" name = "begin" value="mm/dd/yy" onclick="if(value==defaultValue){value='';this.style.color='#000';}" onBlur="if(!value){value=defaultValue;this.style.color='#999';}" style="color:#999"/></td>
			</tr>
			<tr>
				<td class = "tdright">end :</td>
				<td class = "tdleft"><input type = "text" name = "end" value="mm/dd/yy" onclick="if(value==defaultValue){value='';this.style.color='#000';}" onBlur="if(!value){value=defaultValue;this.style.color='#999';}" style="color:#999"/></td>
			</tr>
			<tr>
				<td></td>
				<td class = "tdcenter"><input type = "submit" value = "recall"></td>
			</tr>
		</table>
	</form>
	
  </body>
</html>
