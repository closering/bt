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
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZfUIWi1jZRZyg53zt1xVo7KWMOEJdOV8&sensor=false"
  type="text/javascript"></script>
    <script type="text/javascript">
      window.onload=function initialize() {
      	
      	var result = "${locus}";
	  	
	  	var resultData = result.split(",");
	  	var xPre, yPre, xEnd, yEnd;
	  	
	  	if(resultData.length > 4)
  		{
  			xPre = resultData[1];
  			yPre = resultData[2];
 
        var mapOptions = {
          center: new google.maps.LatLng(xPre, yPre),
          zoom: 12,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
        
        for(var i = 6; i < resultData.length; i= i + 5)
	  	{
	  		xEnd = resultData[i];
	  		yEnd = resultData[i + 1];
	  		
	  		
	  		 var LatLngStr=[
			new google.maps.LatLng(xPre, yPre),
			new google.maps.LatLng(xEnd, yEnd)];
			
			xPre = xEnd;
	  		yPre = yEnd;
			var LatLngLine=new google.maps.Polyline({
			path:LatLngStr,
			strokeColor:"#FF0000",
			strokeOpacity:0.8,
			strokeWeight:3
			 });
			LatLngLine.setMap(map);
	  	}
		}
	};
    </script>
  </head>
  <body>
    <div id="map_canvas" style="width:100%; height:100%"></div>
  </body>
</html>