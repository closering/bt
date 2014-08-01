<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
    <link href="css/style.css" type="text/css" rel="stylesheet">

  
  	<div id="head" class="head_container"   >
		<div id="head_img" class="head_normal detectCanvas"></div>
	</div>
	
	<img src = "./image/vertical_line.png" style="position:absolute;left:570px;top:42px;">
	<img src = "./image/vertical_line.png" style="position:absolute;left:675px;top:42px;">
	<img src = "./image/vertical_line.png" style="position:absolute;left:765px;top:42px;">
	<img src = "./image/vertical_line.png" style="position:absolute;left:855px;top:42px;">
	<img src = "./image/vertical_line.png" style="position:absolute;left:579px;top:72px;">
	<img src="./image/logo.png" style="position:absolute;left:160px;top:30px;">
	<a href="searchHome.jsp" onclick="subgo()" style="position:absolute;left:440px;top:40px;"><font color="#FFFFFF" size="4px">Product Lookup</font></a>
	<a href="product.jsp" onclick="subgo()" style="position:absolute;left:575px;top:40px;"><font color="#FFFFFF" size="4px">Add Product</font></a>
	<a href="bid_uid.jsp" onclick="subgo()" style="position:absolute;left:680px;top:40px;"><font color="#FFFFFF" size="4px">Bid&nbsp;&amp;&nbsp;Uid</font></a>
	<a href="uid_epc.jsp" onclick="subgo()" style="position:absolute;left:770px;top:40px;"><font color="#FFFFFF" size="4px">Uid&nbsp;&amp;&nbsp;EPC</font></a>
	<a href="recall.jsp" onclick="subgo()" style="position:absolute;left:860px;top:40px;"><font color="#FFFFFF" size="4px">Recall&nbsp;&amp;&nbsp;Epc</font></a>
	
	<a href="tracing.jsp" onclick="subgo()" style="position:absolute;left:440px;top:70px;"><font color="#FFFFFF" size="4px">Product Tracing</font></a>
	<a href="monitor.jsp" onclick="subgo()" style="position:absolute;left:585px;top:70px;"><font color="#FFFFFF" size="4px">Monitor</font></a>
	
	<img src = "./image/horizontal_line.png" style="position:absolute;left:150px;top:112px;">
  
  	<div id="center" class="center_container" >
		<div id="center_img" class="center_normal detectCanvas"></div>
	</div>
