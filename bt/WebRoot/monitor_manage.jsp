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

	<link href="css/gridview.css" rel="stylesheet" type="text/css" />
	<STYLE type=text/css> 
	.addMonitor{
		padding-left:10px;
	}
	.addMonitor a{
		TEXT-ALIGN: center; COLOR: #135294; font-family: Arial, Helvetica, sans-serif; font-size: 16px;
	}
	.addMonitor a:VISITED{
		TEXT-ALIGN: center; COLOR: #135294; font-family: Arial, Helvetica, sans-serif; font-size: 16px;
	}
	.addMonitor a:HOVER{
		TEXT-ALIGN: center; COLOR: #ff6600; font-family: Arial, Helvetica, sans-serif; font-size: 16px;
	}
	</STYLE>
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
	<div style="position:absolute;left:40%;top:110px;"><h1>user: <%=(String) request.getSession().getAttribute("userName") %>'s monitor info</h1></div>
  <div style="position:absolute;left:20%;top:240px;">
		<h2>${myModel.info}</h2>
		</div>
	<table style=" position:absolute;left:20%;top:140px;">
	<tr>
		<td class=addMonitor>
      		<img src="image/monitor_add.gif">&nbsp;<a href="monitor.jsp">add monitor</a>
      	</td>
     </tr>
	</table>
	
	<table class=gridView style=" position:absolute;left:20%;top:200px;BORDER-COLLAPSE: collapse;display:block;overflow:auto"cellSpacing=0 rules=all border=1>
	<tr>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>pupil</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>latitude</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>longitude</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>radius</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>setDate</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>edit</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>tracing</td>
	<td class=gridViewHeader style="WIDTH: 80px" scope=col>delete</td>
	</tr>
	<%
	
		String monitorInfo = (String)request.getAttribute("monitorInfo");
		if(monitorInfo!=null&&!monitorInfo.equals(""))
		{
		String str[] = monitorInfo.split(",");
		for(int i=0; i<str.length; i+=5){
		
		%>
	 <tr >
	  <TD class=gridViewItem ><%=str[i] %></TD>
	  <TD class=gridViewItem ><%=str[i+1] %></TD>
	  <TD class=gridViewItem ><%=str[i+2] %></TD>
	  <TD class=gridViewItem ><%=str[i+3] %></TD>
	  <TD class=gridViewItem ><%=str[i+4] %></TD>
	  <TD class=gridViewItem ><img src="image/monitor_edit.gif">&nbsp;<A 
	            href="javascript:void(0);" onclick="location.href='editMonitor.jsp?monitorName=<%=str[i] %>&latitude=<%=str[i+1] %>&longitude=<%=str[i+2] %>&radius=<%=str[i+3] %>'">edit</A></TD>
	  <TD class=gridViewItem ><A 
	            href="javascript:void(0);" onclick="location.href='monitorTracing.do?monitorName=<%=str[i] %>&latitude=<%=str[i+1] %>&longitude=<%=str[i+2] %>&radius=<%=str[i+3] %>'">tracing</A></TD>
	  <TD class=gridViewItem ><img src="image/monitor_delete.gif">&nbsp;<A href="deleteMonitor.do?monitorName=<%=str[i] %>&latitude=<%=str[i+1] %>&longitude=<%=str[i+2] %>&radius=<%=str[i+3] %>&setDate=<%=str[i+4] %>" target="_self" onClick="return confirm('are you sure to delete it?')">delete</A></TD>
	</tr>
	<%} 
	}%>
	    
	</table>
	
	 
  </body>
</html>
