<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>Project Management</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>demo.css">
	<%-- <link rel="stylesheet" type="text/css" href="<%=basePath%>amcharts/style.css"> --%>

        
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	
	<script src="<%=basePath%>amcharts/amcharts.js" type="text/javascript"></script>
    <script src="<%=basePath%>amcharts/pie.js" type="text/javascript"></script>
    <script src="<%=basePath%>amcharts/serial.js" type="text/javascript"></script>
    
    
	
<script type="text/javascript">
//显示当前日期
formatterDate = function (date) {
var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
+ (date.getMonth() + 1);
var hor = date.getHours();
var min = date.getMinutes();
var sec = date.getSeconds();
return date.getFullYear() + '-' + month + '-' + day+" "+hor+":"+min+":"+sec;
};
function fixWidth(percent)  
{  
    return document.body.clientWidth * percent ; //这里你可以自己做调整  
}
function fixHeight(percent)  
{  
    return document.body.clientHeight * percent ; //这里你可以自己做调整  
}
</script> 

       
	<style type="text/css">
		.hd{
		margin-top:40px;
		width:450px;
		height:50px;
		}

.til{
margin-top:40px;
margin-left:10px;
font-size:24px;
color:#4e4e4e;
font-family:"Georgia";
letter-spacing:3px;
}

	</style>
	<script type="text/javascript">
	
	$(document).ready(function(){

		
		
		$.fn.tree.defaults.loadFilter = function (data, parent) {
		    var opt = $(this).data().tree.options;
		    var idFiled,
		    textFiled,
		    parentField;
		    if (opt.parentField) {
		        idFiled = opt.idFiled || 'id';
		        textFiled = opt.textFiled || 'text';
		        parentField = opt.parentField;
		        var i,
		        l,
		        treeData = [],
		        tmpMap = [];
		        
		        for (i = 0, l = data.length; i < l; i++) {
		            tmpMap[data[i][idFiled]] = data[i];
		        }
		        
		        for (i = 0, l = data.length; i < l; i++) {
		            if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
		                if (!tmpMap[data[i][parentField]]['children'])
		                    tmpMap[data[i][parentField]]['children'] = [];
		                data[i]['text'] = data[i][textFiled];
		                tmpMap[data[i][parentField]]['children'].push(data[i]);
		            } else {
		                data[i]['text'] = data[i][textFiled];
		                treeData.push(data[i]);
		            }
		        }
		        return treeData;
		    }
		    return data;
		};
		
		$('#menuTree').tree({

		onLoadSuccess : function(node, data) {
									var t = $(this);
									t.tree('expandAll'); 
									if (data) {
										$(data).each(function(index, d) {
											if (this.id == '13') {
												$("#center").load(this.url);
											}
										}); 
									}
								},
								onClick : function(node) {
									if (node.url != "") {
										$("#center").load(node.url);
									}

								}

							});
		
		
		
		
		   $.ajax({
	           url: 'base/getUser.do',
	           type: 'post',//提交的方式
	           dataType:'json',
	           async:false,
	           contentType:"application/json",
	            //data: json,
	           success: function(msg) {	
	        	   $("#welcome").html($("#welcome").html()+msg.realname);
	        	 //alert($("#welcome").html());
	           // alert(msg.realname);
	           }
	       });
		   
});
function exit(){
	   $.ajax({
           url: 'loginout.do',
           type: 'post',//提交的方式
          // dataType:'json',
           async:false,
           //contentType:"application/json",
          // data: json,
           success: function(msg) {	
            window.location.href="tologin.do";
           }
       }); 
}	

	</script>
</head>
<body>
	<div id="cc" class="easyui-layout"   data-options="fit:true">
		<div data-options="region:'north'" style="height: 100px;background-color:#eff">
		<div>
		<div style="float:left">
		<p class="til">项目管理软件 </p>
		</div>
		<div style="float:right;font-size:16px"><p><a onclick="exit()">退出</a><P></div>
		<div style="float:right;font-size:12px;margin-right:50px"><p id="welcome">欢迎您!<P></div>		
		</div>
			
			<%-- <div class="hd"><img src="<%=basePath%>img/main.png" width="100%" height="100%" /></div> --%>
		
		</div>
		

		<div data-options="region:'west'" style="width: 150px;">
			<ul id="menuTree" class="easyui-tree" data-options="url:'getMenu.do',
		parentField:'pid',lines:true,onLoadSuccess:function(node, data){$(this)}"><!-- .tree('collapseAll') -->
		</ul>
		</div>
		<div id="center" data-options="region:'center'"></div>
	</div>
	
</body>
</html>