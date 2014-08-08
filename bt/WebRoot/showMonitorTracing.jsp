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
  
   //trace start
   result = "${myModel.locusDownload}";
   
    //alert("111");
   if(result.length!=0)
   {
   		resultData = result.split(",");
   		// alert(resultData.length);
   	 	lineArr = new Array();//创建线覆盖物节点坐标数组
   	  	var len=resultData.length;
   	  	for(var i = 0; i < len; i+=2)
 		{
 			lineArr.push(new AMap.LngLat(resultData[i+1],resultData[i]));
 	
 		}//end for(var i = 0; i < len; i++)
 		 polyline = new AMap.Polyline({
   			 path:lineArr, //设置线覆盖物路径
   			 strokeColor:"#F00", //线颜色
  		 	 strokeOpacity:1, //线透明度
   		 	 strokeWeight:2, //线宽
   			 strokeStyle:"solid", //线样式
   			 strokeDasharray:[10,5] //补充线样式
  		 });
  		 polyline.setMap(mapObj);
 
 var lnglatXY = new AMap.LngLat(resultData[len-1],resultData[len-2]);

    var MGeocoder;
    //加载地理编码插件
    mapObj.plugin(["AMap.Geocoder"], function() {       
        MGeocoder = new AMap.Geocoder({
            radius: 1000,
            extensions: "all"
        });
        //返回地理编码结果
        AMap.event.addListener(MGeocoder, "complete", geocoder_CallBack);
        //逆地理编码
        MGeocoder.getAddress(lnglatXY);
    });

 marker = new AMap.Marker({               
        icon:"http://webapi.amap.com/images/marker_sprite.png",
        position:lnglatXY
    });
        marker.setMap(mapObj);
  		
  		// alert("11");
  		//回调函数
function geocoder_CallBack(data) {
    var address;
    //返回地址描述
     //alert("22");
   address = data.regeocode.formattedAddress;
   
   //alert(address);
      marker.setTitle(address); //设置鼠标划过点标记显示的文字提示
} 
  		
  		
   }//end if
		
  
//trace end
//调整视野到合适的位置及级别                 
mapObj.setFitView(polyline);   	
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
	
 <div id="container" style="position:absolute;left:148px;top:122px;width:1000px;height:425px;
background-color:transparent;border-color:transparent;z-index:1">

</div>

  </body>
</html>