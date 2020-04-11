<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
            var chart;
            var legend;
	$(document).ready(function(){
	    /*Dialog*/
/* $("#projecttb").height(fixHeight(0.5));
$("#chartdiv").height(fixHeight(0.5)); */
$('#sertch').linkbutton({    
    iconCls: 'icon-save',   
}).unbind("click").click(function(){
	//alert($('#testproject').val());
	//$("#projectform").submit();
    $.ajax({
        url: 'analysis/getProjectProgress.do',
        //type: 'post',//提交的方式
        dataType:'json',
        async:false,
       // data: data,
        success: function(msg) {
 		//alert(msg[0].country);
        chart = new AmCharts.AmSerialChart();
        chart.addTitle("项目进度(%)", 16);
        chart.dataProvider = msg;
        chart.categoryField = "taskname";
        chart.startDuration = 1;

        // AXES
        // category
        var categoryAxis = chart.categoryAxis;
        categoryAxis.labelRotation = 0;
        categoryAxis.gridPosition = "start";

        // value
        // in case you don't want to change default settings of value axis,
        // you don't need to create it, as one value axis is created automatically.

        // GRAPH
        var graph = new AmCharts.AmGraph();
        graph.valueField = "value";
        graph.balloonText = "[[category]]: <b>[[value]]%</b>";
        graph.type = "column";
        graph.lineAlpha = 0;
        graph.fillAlphas = 0.8;
        chart.addGraph(graph);

        // CURSOR
        var chartCursor = new AmCharts.ChartCursor();
        chartCursor.cursorAlpha = 0;
        chartCursor.zoomable = false;
        chartCursor.categoryBalloonEnabled = false;
        chart.addChartCursor(chartCursor);

        chart.creditsPosition = "top-right";
        // WRITE
        chart.write("chartdiv"); 
        }
    }); 
    return false;//防止提交两次
});

        
        		
	});
        </script>

</head>
<body>
<div>
			<a id="add" href="#">添加</a>  
			<a id="del" href="#">删除</a> 
			<a id="sertch" href="#">查询</a> 
			<a id="adduser" href="#">项目成员管理</a>  
</div>




 <div id="chartdiv" style="width: 100%;height:80%"></div>
 
 </body>
 </html>
 
 