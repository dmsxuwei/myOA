<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	var chart;
	var legend;

	$(document).ready(function() {
		//***************************char**********************
		$('#sertch').linkbutton({
			iconCls : 'icon-save',
		}).unbind("click").click(function() {
			//alert($('#testproject').val());
			//$("#projectform").submit();
			$.ajax({
				url : 'static/getProjectTimeProportion.do',
				//type: 'post',//提交的方式
				dataType : 'json',
				async : false,
				// data: data,
				success : function(msg) {
					//alert(msg[0].country);
					chart = new AmCharts.AmPieChart();
					chart.addTitle("本周工时占比(%)", 16);
					chart.dataProvider = msg;
					chart.titleField = "project";
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
				}
			});
			return false;//防止提交两次
		});
		
	//	$('#sertch').click();
		/***************************charend**********************/

		/***************************添加**********************/

		//Dialog
		$('#userid').combobox({
			url : 'users.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#projectname').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left'
		});

		$('#projectdescripton').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left'
		});

		$('#createtime').datetimebox({
			// value: '3/4/2016 2:3',    
			required : true,
			showSeconds : false
		})

		$('#createtime').datetimebox('setValue', formatterDate(new Date()));
		$('#begintime').datetimebox({
			required : true,
			showSeconds : false
		})
		$('#begintime').datetimebox('setValue', formatterDate(new Date()));

		$('#save').linkbutton({
			iconCls : 'icon-save',
		}).unbind("click").click(function() {
			var data = $('#projectform').serialize();
			$.ajax({
				url : 'addproject.do',
				type : 'post',//提交的方式
				dataType : 'json',
				async : false,
				data : data,
				success : function(msg) {
					// alert(msg[1].id);
					dialog.dialog({
					// closed: true,  
					});
					$("#center").load('toProject.do');
				}
			});
			return false;//防止提交两次
		});

		var dialog = $('#projectdialog');
		$('#projectdialog').dialog({
			title : '添加项目',
			width : 380,
			height : 400,
			closed : true,
			cache : false,
		});
		
		//添加打开Dialog
		$('#addproject').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			$('#projectdialog').dialog('open');
		});

		/***************************添加OK**********************/

		/***************************删除记录**********************/
		$('#delproject').linkbutton({
			iconCls : 'icon-remove'
		}).unbind("click").click(function() {
			var selRows = $('#projecttb').datagrid('getChecked');
			//alert(selRows[0].unittestid);
			$.ajax({
				url : 'delProject.do',
				type : 'post',//提交的方式
				dataType : 'json',
				async : false,
				data : {
					id : selRows[0].projectid
				},
				success : function(msg) {
					// alert(msg[0].result);
					// location.reload("getUnittest.do");
					$("#center").load('toProject.do');
				}
			});
		});

		/***************************删除OK**********************/

		/*查询*/
		$('#sertch').linkbutton({
			iconCls : 'icon-search'
		});

		/*表格*/
		var url = 'getProject.do';
		var projecttb = $('#projecttb');
		projecttb.datagrid({
			//url:'getGrid.do',    
			title : '项目列表',
			pageSize : 15, //设置默认分页大小
			pageList : [ 3, 6, 9, 12, 15 ], //设置分页大小
			rownumbers : true,
			columns : [ [ {
				field : 'ck',
				width : 100,
				checkbox : true
			}, {
				field : 'projectid',
				title : '',
				width : 0
			}, {
				field : 'userid',
				title : '项目负责人',
				width : 80
			}, {
				field : 'projectname',
				title : '项目名称',
				width : 160
			},
			// {field:'projectstate',title:'项目状态',width:60}, 
			{
				field : 'createtime',
				title : '创建时间',
				sortable : true,
				width : 150,
				formatter : function(value, row, index) {
					var date = new Date(value);
					var year = date.getFullYear().toString();
					var month = (date.getMonth() + 1);
					var day = date.getDate().toString();
					var hour = date.getHours().toString();
					var minutes = date.getMinutes().toString();
					var seconds = date.getSeconds().toString();
					if (month < 10) {
						month = "0" + month;
					}
					if (day < 10) {
						day = "0" + day;
					}
					if (hour < 10) {
						hour = "0" + hour;
					}
					if (minutes < 10) {
						minutes = "0" + minutes;
					}
					if (seconds < 10) {
						seconds = "0" + seconds;
					}
					return year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;
				}
			}, {
				field : 'begintime',
				title : '开始时间',
				sortable : true,
				width : 150,
				formatter : function(value, row, index) {
					var date = new Date(value);
					var year = date.getFullYear().toString();
					var month = (date.getMonth() + 1);
					var day = date.getDate().toString();
					var hour = date.getHours().toString();
					var minutes = date.getMinutes().toString();
					var seconds = date.getSeconds().toString();
					if (month < 10) {
						month = "0" + month;
					}
					if (day < 10) {
						day = "0" + day;
					}
					if (hour < 10) {
						hour = "0" + hour;
					}
					if (minutes < 10) {
						minutes = "0" + minutes;
					}
					if (seconds < 10) {
						seconds = "0" + seconds;
					}
					return year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;
				}
			}, {
				field : 'projectdescripton',
				title : '项目描述',
				width : 260
			}

			] ],
			singleSelect : true,
			selectOnCheck : true,
			checkOnSelect : true,
			pagination : true
		});

		projecttb.datagrid({
			url : url,
		});
		projecttb.datagrid('hideColumn', 'projectid');

		projecttb.datagrid("getPager").pagination({
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : "显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
		});

		
	});
</script>

</head>
<body>
	<div>
		<a id="addproject" href="#">添加</a> <a id="delproject" href="#">删除</a> <a id="sertch" href="#">查询</a>
	</div>
	<table id="projecttb" style="width: 100%; height: 50%"></table>

	<div id="projectdialog">
		<form id="projectform">
			<input name="projectid" type="text" style="display: none">
			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">项目负责人</div>
				<input id="userid" name="userid" type="text" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">项目名称:</div>
				<input id="projectname" type="text" name="projectname" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">创建时间:</div>
				<input id="createtime" type="text" name="createtime" style="width: 300px;">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">开始时间:</div>
				<input id="begintime" type="text" name="begintime" style="width: 300px;">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">项目描述:</div>
				<!-- <input id="result" type="text" style="width:300px"> -->
				<input id="projectdescripton" name="projectdescripton" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 20px; padding-left: 200px">
				<a id="save" href="#">提交</a>
			</div>

		</form>

	</div>



	<div id="chartdiv" style="width: 100%; height: 45%"></div>

</body>
</html>

