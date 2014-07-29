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
    
    <title>register</title>
    
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
	
	<a href = "login.jsp" onclick="subgo()" style="position:absolute;left:1000px;top:60px;"><font color="#FFFFFF" size="4px">Login</font></a>
	
	<div style="position:absolute;left:437px;top:120px;width:400px;height:25px;
background-color:transparent;border-color:transparent;z-index:1">${myModel.loginInfo}</div>
	
	<form method="post" action="/bt/register.do">
		<table style="position:absolute;left:300px;top:140px;">
			<tr>
				<td>username :</td>
				<td><input type = "text" name = "username"></td>
				<td>company name :</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>password :</td>
				<td><input type = "text" name = "password"></td>
				<td>establish date :</td>
				<td><input type = "text" name = "establishDate" type = "text" name="produceDate" value="mm/dd/yy" onclick="if(value==defaultValue){value='';this.style.color='#000';}" onBlur="if(!value){value=defaultValue;this.style.color='#999';}" style="color:#999"/></td>
				
			</tr>
			<tr>
				<td>email :</td>
				<td><input type = "text" name = "email"></td>
				<td>address :</td>
				<td><input type = "text" name = "address"></td>
			</tr>
			<tr>
				<td>contact person :</td>
				<td><input type = "text" name = "contacter"></td>
				<td>postcode :</td>
				<td><input type = "text" name = "postcode"></td>
			</tr>
			<tr>
				<td>contact phone :</td>
				<td><input type = "text" name = "phone"></td>
				<td>longitude :</td>
				<td><input type = "text" name = "ldegree" value="number" onclick="if(value==defaultValue){value='';this.style.color='#000';}" onBlur="if(!value){value=defaultValue;this.style.color='#999';}" style="color:#999"/></td>
			</tr>
			<tr>
				<td>user type :</td>
				<td>
					<SELECT  style="width:180" name = "type">
						<OPTION selected value="manufacturer">Manufacturing</OPTION>
						<OPTION  value="producer">Processing</OPTION>
						<OPTION  value="warehouse">Transporting</OPTION>
						<OPTION  value="retailer">Retailer</OPTION>
					</SELECT>
				</td>
				<td>latitude :</td>
				<td><input type = "text" name = "degree" value="number" onclick="if(value==defaultValue){value='';this.style.color='#000';}" onBlur="if(!value){value=defaultValue;this.style.color='#999';}" style="color:#999"/></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>radius :</td>
				<td><input type = "text" name = "radius" value="number" onclick="if(value==defaultValue){value='';this.style.color='#000';}" onBlur="if(!value){value=defaultValue;this.style.color='#999';}" style="color:#999"/></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;&nbsp;&nbsp;<input type="reset" value = "clear"></td>
				<td colspan = "2">&nbsp;<input type="submit" value = "register"></td>
			</tr>
		</table>
		
	</form>
  </body>
</html>
