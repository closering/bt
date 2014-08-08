<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    
   
   <script language="javascript" src="http://webapi.amap.com/maps?v=1.3&key=f6b31a9af1679d3d11baa29a064a086c"></script>
   <style type="text/css">
	html{height:100%}
	body{height:100%;margin:0px;padding:0px}
	#container{height:100%}
	</style>
    <script type="text/javascript">
    
    var  mapObj;
    var polyline
    var trace_color=true;
    window.onload= function initialize(){
  
     var position=new AMap.LngLat(116.331394,39.999438);
  	 mapObj=new AMap.Map("container",{
 	 view: new AMap.View2D({//创建地图二维视口
  	 center:position,//创建中心点坐标
     zoom:14, //设置地图缩放级别
     rotation:0 //设置地图旋转角度
   }),
   lang:"zh_cn"//设置地图语言类型，默认：中文简体
 });//创建地图实例
  
   
   circle = new AMap.Circle({
   center:new AMap.LngLat( "${myModel.longitude}", "${myModel.latitude}" ),// 圆心位置
   radius: "${myModel.radius}"*1000, //半径
   strokeColor: "#F33", //线颜色
   strokeOpacity: 1, //线透明度
   strokeWeight: 3, //线粗细度
   fillColor: "#ee2200", //填充颜色
   fillOpacity: 0.35//填充透明度
   });
   circle.setMap(mapObj);

//调整视野到合适的位置及级别                 
mapObj.setFitView();   	
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
	
	<jsp:include page="tail.jsp" flush="true">
		<jsp:param name="pageTitle" value="header.jsp"/>
  		<jsp:param name="pageSlogan" value="header" />
	</jsp:include>
	<div style="position:absolute;left:150px;top:122px;width:400px;height:425px;white-space:nowrap; 
background-color:transparent;border-color:transparent;z-index:1;overflow:auto">
<h4>${myModel.info}</h4>
</div>

 <div id="container" style="position:absolute;left:550px;top:122px;width:598px;height:425px;
background-color:transparent;border-color:transparent;z-index:1">

</div>

  </body>
</html>