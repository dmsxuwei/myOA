<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>amCharts examples</title>
        <link rel="stylesheet" href="<%=basePath%>amcharts/style.css" type="text/css">
        <script src="<%=basePath%>amcharts/amcharts.js" type="text/javascript"></script>
        <script src="<%=basePath%>amcharts/pie.js" type="text/javascript"></script>
		<style type="text/css">
		body {
			font-family: Tahoma, Arial, Verdana;
			font-size: 12px;
			color: black;
		}
		
		a:link {
			color: #84c4e2;
		}
		
		a:visited {
			color: #84c4e2;
		}
		
		a:hover {
			color: #cd82ad;
		}
		
		a:active {
			color: #84c4e2;
		}
		</style>
<script type="text/javascript">
            var chart;
            var legend;

            var chartData = [
                {
                    "country": "Lithuania",
                    "value": 260
                },
                {
                    "country": "Ireland",
                    "value": 201
                },
                {
                    "country": "Germany",
                    "value": 65
                },
                {
                    "country": "Australia",
                    "value": 39
                },
                {
                    "country": "UK",
                    "value": 19
                },
                {
                    "country": "Latvia",
                    "value": 10
                }
            ];
	alert(2);
            AmCharts.ready(function () {
            	alert(1);
                // PIE CHART
                chart = new AmCharts.AmPieChart();
                chart.dataProvider = chartData;
                chart.titleField = "country";
                chart.valueField = "value";
                chart.outlineColor = "#FFFFFF";
                chart.outlineAlpha = 0.8;
                chart.outlineThickness = 2;
                chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
                // this makes the chart 3D
                chart.depth3D = 15;
                chart.angle = 30;

                // WRITE
                chart.write("chartdiv");
            });
        </script>
    </head>
<body>
 <div id="chartdiv" style="width: 100%; height: 400px;"></div>
 </body>
</html>