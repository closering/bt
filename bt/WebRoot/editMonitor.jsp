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
    
    <title> edit monitor</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<STYLE type=text/css> 
.inputstyle{width:200px;height:28px;border:#C1C1C1 1px solid;font-size:14px;padding:4px 5px 4px;background-color:#FBFBFB;background-position:0 -72px;font-size: 16px;color:#adadad}
</STYLE>
    <script language="javascript" src="http://webapi.amap.com/maps?v=1.3&key=f6b31a9af1679d3d11baa29a064a086c"></script>
	 <style type="text/css">
	html{height:100%}
	body{height:100%;margin:0px;padding:0px}
	#container{height:100%}
	</style>
	<script type="text/javascript">
    
    var  mapObj;
    window.onload= function initialize(){
  
     var position=new AMap.LngLat(116.331394,39.999438);
  	 mapObj=new AMap.Map("container",{
 	 view: new AMap.View2D({//������ͼ��ά�ӿ�
  	 center:position,//�������ĵ�����
     zoom:13, //���õ�ͼ���ż���
     rotation:0 //���õ�ͼ��ת�Ƕ�
   }),
   lang:"zh_cn"//���õ�ͼ�������ͣ�Ĭ�ϣ����ļ���
 });//������ͼʵ��
 
  circle = new AMap.Circle({
   center:new AMap.LngLat( document.getElementById("longitude").value,document.getElementById("latitude").value),// Բ��λ��
   radius:document.getElementById("radius").value*1000, //�뾶
   strokeColor: "#F33", //����ɫ
   strokeOpacity: 1, //��͸����
   strokeWeight: 3, //�ߴ�ϸ��
   fillColor: "#ee2200", //�����ɫ
   fillOpacity: 0.35//���͸����
   });
   circle.setMap(mapObj);
   
    var clickCircleEventListener=AMap.event.addListener(circle,'click',function(e){
    document.getElementById("longitude").value=e.lnglat.getLng();
        document.getElementById("latitude").value=e.lnglat.getLat(); 
    });
 
 //Ϊ��ͼע��click�¼���ȡ��������ľ�γ������
    var clickEventListener=AMap.event.addListener(mapObj,'click',function(e){
    // circle.setMap(null);
        document.getElementById("longitude").value=e.lnglat.getLng();
        document.getElementById("latitude").value=e.lnglat.getLat(); 
        
    });
    
    
    
//������Ұ�����ʵ�λ�ü�����                 
mapObj.setFitView();  
    
 }
  	
 
  function updateCircle(){
  //��Բ������
  /*var circleoptions={      
   center:new AMap.LngLat(document.getElementById("longitude").value,document.getElementById("latitude").value),// ��Բ��λ��
   radius:document.getElementById("radius").value*1000, //�°뾶
   strokeColor: "#0000FF", //����ɫ
   strokeOpacity: 0.8, //��͸����
   strokeWeight: 5, //�ߴ�ϸ��
   fillColor: "#ee2200", //�����ɫ
   fillOpacity: 0.35//���͸����
  };
    circle.setOptions(circleoptions);//����Բ����*/
    circle1 = new AMap.Circle({
   center:new AMap.LngLat( document.getElementById("longitude").value,document.getElementById("latitude").value),// Բ��λ��
   radius:document.getElementById("radius").value*1000, //�뾶
   strokeColor: "#0000FF", //����ɫ
   strokeOpacity: 1, //��͸����
   strokeWeight: 3, //�ߴ�ϸ��
   fillColor: "#ee2200", //�����ɫ
   fillOpacity: 0.35//���͸����
   });
   circle1.setMap(mapObj);
    var clickCircleEventListener=AMap.event.addListener(circle1,'click',function(e){
    document.getElementById("longitude").value=e.lnglat.getLng();
        document.getElementById("latitude").value=e.lnglat.getLat(); 
    });
    mapObj.setFitView();  
 }
 </script>
	
	<script type="text/javascript">
function check()
{
	if(document.getElementById("longitude").value.length==0)
	{
		alert('please clik the map to get longitude!');
		document.getElementById("longitude").focus();
		return false;
	}
	
	if(document.getElementById("latitude").value.length==0)
	{
		alert('please clik the map to get latitude!');
		document.getElementById("latitude").focus();
		return false;
	}
	
	if(document.getElementById("radius").value.length==0)
	{
		alert('please input the radius!');
		document.getElementById("radius").focus();
		return false;
	}

}
</script>
	
	
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
	<div style="position:absolute;left:250px;top:140px;"><h3>edit monitor info</h3></div>
	  <div style="position:absolute;left:180px;top:460px;">
		<h4>${myModel.info}</h4></br> 
	</div>
	
	<form method="post" action="/bt/editMonitor.do">
		 <table style="position:absolute;left:150px;top:200px;">
		 	<tr>
		 		<td class = "tdright">Pupil UserName:</td>
		 		
		 		<td class = "tdleft">
		 		<% if(request.getParameter("monitorName")!=null)
		 		{%>
		 		<input  type = "text" name = "monitorName" readonly="readonly" value=<%=request.getParameter("monitorName") %>>
		 		<%}else{%>
		 		<input  type = "text" name = "monitorName" readonly="readonly" value=${myModel.monitorName}>
		 		<%} %>
		 		<td>	 		
		 	</tr>
		 	<tr>
	      			<td>&nbsp;</td>
	      			<td>
	      				<font style="font-size: 15px;color:#adadad">please click the map to get <br>the longitude and latitude.</font>
	      			</td>
	      		</tr>
		 	<tr>
		 		<td class = "tdright">Longitude :</td>
		 		<td class = "tdleft"><input class="inputstyle" type = "text" id = "longitude" name = "longitude" readonly="readonly" value=<%=request.getParameter("longitude") %> ></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">Latitude :</td>
		 		<td class = "tdleft"><input class="inputstyle" type = "text" id="latitude" name="latitude" readonly="readonly" value=<%=request.getParameter("latitude") %>></td>
		 	</tr>
		 	<tr>
		 		<td class = "tdright">Radius :</td>
		 		<td class = "tdleft"><input type = "text"  id = "radius" name="radius" value=<%=request.getParameter("radius") %>> km</td>
		 	</tr>
		 	<tr>
				
					<td>&nbsp;</td>
					<td><input type="submit" value = "edit" style="width:70px;height:30px;" onclick="return check();">
					<input type="button" value = "cancel" style="width:70px;height:30px;" onclick="javascript:history.back(-1);">
						<input type="button" value = "check" style="width:70px;height:30px;" onclick="javascript:updateCircle()">
					<td>
			</tr>
		 </table>
	 </form>
	 
	 <div id="container" style="position:absolute;left:550px;top:122px;width:598px;height:425px;
background-color:transparent;border-color:transparent;z-index:1"></div>
	 
  </body>
</html>
