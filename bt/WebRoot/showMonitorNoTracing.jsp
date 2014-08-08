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
 	 view: new AMap.View2D({//������ͼ��ά�ӿ�
  	 center:position,//�������ĵ�����
     zoom:14, //���õ�ͼ���ż���
     rotation:0 //���õ�ͼ��ת�Ƕ�
   }),
   lang:"zh_cn"//���õ�ͼ�������ͣ�Ĭ�ϣ����ļ���
 });//������ͼʵ��
  
   
   circle = new AMap.Circle({
   center:new AMap.LngLat( "${myModel.longitude}", "${myModel.latitude}" ),// Բ��λ��
   radius: "${myModel.radius}"*1000, //�뾶
   strokeColor: "#F33", //����ɫ
   strokeOpacity: 1, //��͸����
   strokeWeight: 3, //�ߴ�ϸ��
   fillColor: "#ee2200", //�����ɫ
   fillOpacity: 0.35//���͸����
   });
   circle.setMap(mapObj);

//������Ұ�����ʵ�λ�ü�����                 
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