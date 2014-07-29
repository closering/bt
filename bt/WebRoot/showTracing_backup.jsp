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
   // alert("111");
   
   //trace start
   result = "${myModel.locusDownload}";
   resultData = result.split(";");
  // lineArr = new Array();//�����߸�����ڵ���������
 


// alert(result.length);
 // alert("2222");
 // alert(resultData[2]);
 var len=resultData.length;
 //alert(resultData.length);
 
 for(var i = 0; i < len; i++)
 {
 	var point_info = resultData[i].split(",");
 	 var lineArr = new Array();//�����߸�����ڵ���������
 	 lineArr.push(new AMap.LngLat(point_info[2],point_info[1]));
 	 trace_color=!trace_color;
 	/* marker = new AMap.Marker({               
        icon:"http://webapi.amap.com/images/marker_sprite.png",
        position:new AMap.LngLat(point_info[2],point_info[1])
    });
    marker.setMap(mapObj);  //�ڵ�ͼ����ӵ�*/
    
    
 	for(var j=5;j<point_info.length;j=j+4)
 	{
 		 lineArr.push(new AMap.LngLat(point_info[j+1],point_info[j]));
 	
 	}//end for(var j=1;j<point_info.length;j=j+4)
 	
 	if(trace_color==true)
 	{
 		 polyline = new AMap.Polyline({
   		 path:lineArr, //�����߸�����·��
   		 strokeColor:"#F00", //����ɫ
  		 strokeOpacity:1, //��͸����
   		 strokeWeight:2, //�߿�
   		 strokeStyle:"solid", //����ʽ
   		 strokeDasharray:[10,5] //��������ʽ
  		 });
 	}
 	else{
 		polyline = new AMap.Polyline({
   		 path:lineArr, //�����߸�����·��
   		 strokeColor:"#3366FF", //����ɫ
  		 strokeOpacity:1, //��͸����
   		 strokeWeight:2, //�߿�
   		 strokeStyle:"solid", //����ʽ
   		 strokeDasharray:[10,5] //��������ʽ
  		 });
 	}
 	
 	 polyline.setMap(mapObj);
 }//end for(var i = 0; i < len; i++)
 
//trace end

//mark start
 resultMark = "${myModel.locusMark}";
 resultDataMark = resultMark.split(",");
 //alert(resultMark.length);
// alert(resultDataMark.length);
   
 /*  if(resultDataMark.length>=5)
   {
    alert("2222");
   	for(var m = 0;m<resultDataMark.length;m=m+6)
   	{
   		marker = new AMap.Marker({               
        icon:"http://webapi.amap.com/images/marker_sprite.png",
        position:new AMap.LngLat(resultDataMark[m+5],resultDataMark[m+4])
    });
    var Scanner = "�����ˣ�" + resultDataMark[m]+"\n";
    var Content = resultDataMark[m+1] + "," + resultDataMark[m+2] + "," +resultDataMark[m+3];
    marker.setMap(mapObj);  //�ڵ�ͼ����ӵ�
     marker.setTitle(Scanner+Content); //������껮��������ʾ��������ʾ
   	}
   }*/

//mark end

marker = new AMap.Marker({               
        icon:"http://webapi.amap.com/images/marker_sprite.png",
        position:new AMap.LngLat(116.331387,39.999431)
    });
     var Scanner = "�����ˣ�"+"\n";
     var Content="�廪ΰ��¥"
      marker.setTitle(Scanner+Content); //������껮��������ʾ��������ʾ
        marker.setMap(mapObj);


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
	<div style="position:absolute;left:150px;top:122px;width:296px;height:425px;white-space:nowrap; 
background-color:transparent;border-color:transparent;z-index:1;overflow:scroll">
	<c:forEach var="item" items="${myModel.logisticsInfo}" varStatus="status"> 
	  ${item}&nbsp;&nbsp;
      <c:if test="${status.count%4==0}"><br/><br/></c:if>      
</c:forEach>
	</div>

 <div id="container" style="position:absolute;left:448px;top:122px;width:700px;height:425px;
background-color:transparent;border-color:transparent;z-index:1"></div>

  </body>
</html>