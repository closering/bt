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
  
   //trace start
   result = "${myModel.locusDownload}";
   
    //alert("111");
   if(result.length!=0)
   {
   		resultData = result.split(",");
   		// alert(resultData.length);
   	 	lineArr = new Array();//�����߸�����ڵ���������
   	  	var len=resultData.length;
   	  	for(var i = 0; i < len; i+=2)
 		{
 			lineArr.push(new AMap.LngLat(resultData[i+1],resultData[i]));
 	
 		}//end for(var i = 0; i < len; i++)
 		 polyline = new AMap.Polyline({
   			 path:lineArr, //�����߸�����·��
   			 strokeColor:"#F00", //����ɫ
  		 	 strokeOpacity:1, //��͸����
   		 	 strokeWeight:2, //�߿�
   			 strokeStyle:"solid", //����ʽ
   			 strokeDasharray:[10,5] //��������ʽ
  		 });
  		 polyline.setMap(mapObj);
 
 var lnglatXY = new AMap.LngLat(resultData[len-1],resultData[len-2]);

    var MGeocoder;
    //���ص��������
    mapObj.plugin(["AMap.Geocoder"], function() {       
        MGeocoder = new AMap.Geocoder({
            radius: 1000,
            extensions: "all"
        });
        //���ص��������
        AMap.event.addListener(MGeocoder, "complete", geocoder_CallBack);
        //��������
        MGeocoder.getAddress(lnglatXY);
    });

 marker = new AMap.Marker({               
        icon:"http://webapi.amap.com/images/marker_sprite.png",
        position:lnglatXY
    });
        marker.setMap(mapObj);
  		
  		// alert("11");
  		//�ص�����
function geocoder_CallBack(data) {
    var address;
    //���ص�ַ����
     //alert("22");
   address = data.regeocode.formattedAddress;
   
   //alert(address);
      marker.setTitle(address); //������껮��������ʾ��������ʾ
} 
  		
  		
   }//end if
		
  
//trace end
//������Ұ�����ʵ�λ�ü�����                 
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