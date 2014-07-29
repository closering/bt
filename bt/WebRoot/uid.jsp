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
    
    <title>uid.jsp</title>
    
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
	
	<form action="/bt/uid.do" method = post>
		<table style="position:absolute;left:550px;top:200px;">
			<tr>
				<td class = "tdright">UID :</td>
				<td class = "tdcenter"><input type = "text" name = "uid"></td>
			</tr>
			<tr>
				<td></td>
				<td class = "tdcenter"><input type = "submit" value = "search"></td>
			</tr>
		</table>
	</form>
	
	<table class = "tabletail" style="position:absolute;left:150px;top:570px;"  rules=cols   cellspacing=0   align=left>
		<c:if test = "${epcLen > 0}">
			<tr>
				<th>UId</th><th>EPC</th><th>recall</th><th>is expire</th><th>produce date</th>
			</tr>
			<c:forEach items="${uidEpc}" var="li" varStatus="loop">
				<tr>
					<td class = "tdcenter">${li.uid}</td>
					<td class = "tdcenter">${li.epc }</td>
					<td class = "tdcenter">${li.recall }</td>
					<td class = "tdcenter">${li.isExpire }</td>
					<td class = "tdcenter">${li.producedate }</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td></td>
		<tr>
		<c:if test = "${bidLen > 0}">
			<tr>
				<th colspan = 2>UID : ${uid }</th>
			</tr>
			<c:forEach items="${bid}" var="li" varStatus="loop">
				<tr>
					<td class = "tdright">BID ${loop.count }</td>
					<td class = "tdleft"><a href ="/bt/bidMap.do?locusDownload=bid,${li }">${li }</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
  </body>
</html>
