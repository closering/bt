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
    
    <title>product.jsp' starting page</title>
    
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
		background-color:transparent;border-color:transparent;z-index:3">${myModel.productInfo}</div>
	 <form method="post" action="/bt/product.do">
		 <table style="position:absolute;left:400px;top:150px;">
		 	<tr>
		 		<td class = "tdright">input product data:</td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">EPC :</td>
		 		<td class = "tdleft"><input type = "text" name = "epc"><td>	 		
		 	</tr>
		 	<tr>
		 		<td class = "tdright">product name :</td>
		 		<td class = "tdleft"><input type = "text" name = "procuctName"></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">expireDays :</td>
		 		<td class = "tdleft"><input type = "text" name="expire" value="number of day" onclick="if(value==defaultValue){value='';this.style.color='#0000';}" style="color:#999" /></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">produceDate :</td>
		 		<td class = "tdleft"><input type = "text" name="produceDate" value="mm/dd/yy" onclick="if(value==defaultValue){value='';this.style.color='#0000';}" style="color:#999" /></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">category :</td>
		 		<td class = "tdleft"><a title = "input a number"><input type = "text" name="category" value="number" onclick="if(value==defaultValue){value='';this.style.color='#999';}" style="color:#999"/></a></td>
		 	</tr>
		 	<tr>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;<input type="submit" value = "add"><td>
				</tr>
		 </table>
	 </form>
 
  </body>
</html>
