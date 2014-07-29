<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setCharacterEncoding("GBK");%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>epc.jsp</title>
    
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
	
	<jsp:include page="tail.jsp" flush="true">
		<jsp:param name="pageTitle" value="header.jsp"/>
  		<jsp:param name="pageSlogan" value="header" />
	</jsp:include>
	
	<div style="position:absolute;left:600px;top:180px;width:400px;height:25px;
background-color:transparent;border-color:transparent;z-index:1">${myModel.info}</div>
		
	<form action="/bt/epc.do" method = post>
		<table style="position:absolute;left:550px;top:200px;">
			<tr>
				<td class = "tdright">EPC :</td>
				<td class = "tdleft"><input type = "text" name = "epc"></td>
			</tr>
			<tr>
				<td></td>
				<td class = "tdcenter"><input type = "submit" value = "search"></td>
			</tr>
		</table>
	</form>
	
	
		<table class = "tabletail" style="position:absolute;left:150px;top:570px;"  rules=cols   cellspacing=0   align=left>
			<c:if test = "${productLength > 0}">
				<tr>
					<th>epc</th><th>company name</th><th>expire days</th><th>product time</th><th>product name</th>
				</tr>
				<c:forEach items="${product}" var="li" varStatus="loop">
		   			<tr>
		   				<td class = "tdcenter">${li.epc}</td>
		   				<td class = "tdcenter">${company[loop.count-1]}</td>
		   				<td class = "tdcenter">${li.expireDays}</td>
		   				<td class = "tdcenter">${li.productTime}</td>
		   				<td class = "tdcenter">${li.productName}</td>
		   			</tr>
		   		</c:forEach>
	   		</c:if>
	   		
	   		<tr>
	   			<td>&nbsp;<td>
	   		</tr>
	   		<tr>
	   			<td>&nbsp;<td>
	   		</tr>
	   		<c:if test = "${uidLength > 0}">
	   			<th colspan = "2">epc : ${epc}</th>
				<c:forEach items="${listResult}" var="li" varStatus="loop">
					<tr>
						<td class = "tdright">UID ${loop.count }</td>
						<td class = "tdleft">${li }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	

	
  </body>
</html>
