<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	var tasktype = 0;
	function doSearch() {
		$('#tasktb').datagrid('load', {
			projectid_search : $('#projectid_search').val(),
			userid_search : $('#userid_search').val(),
			state_search : $('#state_search').val(),
			department_search : $('#department_search').val(),
		});
	}

	function dosubSearch() {
		var selRows = $('#tasktb').datagrid('getChecked');
		$('#subtasktb').datagrid('load', {
			userid_search : $('#userid_search').val(),
			parentid : selRows[0].taskid,
		});
	}

	$(document).ready(function() {

		/**************************************查询************************/
		$('#sertch').linkbutton({
			iconCls : 'icon-search'
		});

		$('#projectid_search').combobox({
			url : 'projects.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#userid_search').combobox({
			url : 'users.do',
			valueField : 'id',
			textField : 'text',
			onLoadSuccess : function() {
				$.ajax({
					url : 'base/getUserid.do',
					type : 'post',//提交的方式
					dataType : 'json',
					async : false,
					success : function(msg) {

					}
				});
			}
		});

		$('#state_search').combobox({
			url : 'base/state.do',
			valueField : 'id',
			textField : 'text'
		});

		/**************************************创建任务Dialog************************/
		$('#addtask').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			tasktype = 0;
			$('#parentid1').val("0");
			$('#taskdialog').dialog('open');
		});

		/*添加任务*/
		$('#projectid').combobox({
			url : 'projects.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#userid').combobox({
			url : 'users.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#taskname').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left'
		});

		$('#taskdescripton').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left'
		});

		$('#alltime').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left'
		});

		$('#auditor').combobox({
			url : 'users.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#savetask').linkbutton({
			iconCls : 'icon-save',
		}).unbind("click").click(function() {
			var data = $('#taskform').serialize();
			$.ajax({
				url : 'addtask.do',
				type : 'post',//提交的方式
				dataType : 'json',
				data : data,
				async : false,
				success : function(msg) {
					$('#taskdialog').dialog('close');
					doSearch();
					return false;//防止提交两次
				}

			});
			return false;//防止提交两次
		});

		$('#taskdialog').dialog({
			title : '创建任务',
			width : 380,
			height : 400,
			closed : true,
			cache : false,
		});

		/**************************************创建任务Dialog OK************************/

		/**************************************删除主任务************************/
		$('#del').linkbutton({
			iconCls : 'icon-remove'
		}).unbind("click").click(function() {

			$.messager.confirm('Confirm', '是否真的删除?', function(r) {
				if (r) {
					var selRows = $('#tasktb').datagrid('getChecked');
					//alert(selRows[0].unittestid);
					//alert('没有权限');//可以自定义拦截器查找是否有权限
					//return;
					$.ajax({
						url : 'delTask.do',
						type : 'post',//提交的方式
						dataType : 'json',
						async : false,
						data : {
							id : selRows[0].taskid
						},
						success : function(msg) {
							//alert(msg[0].result);
							if (msg[0].result == 'ERROR') {
								$.messager.alert('Warning', '删除出错，请先删除主任务下的子任务！');
							} else {
								$.messager.alert('Message', '删除成功！');
							}

							// location.reload("getUnittest.do");
							//  $("#center").load('toTask.do');
							doSearch();
						}
					});
				} else {
					return;
				}

			});

		});

		/**************************************删除主任务OK************************/

		/**************************************开始主任务************************/
		$('#start').linkbutton({
			iconCls : 'icon-reload'
		}).unbind("click").click(function() {
			var selRows = $('#tasktb').datagrid('getChecked');
			if (selRows[0].state == '进行中') {
				$.messager.alert('Warning', '进行中');
				return;
			}
			if (selRows[0].state == '已完成') {
				$.messager.alert('Warning', '已完成');
				return;
			}

			$.ajax({
				url : 'startTask.do',
				type : 'post',//提交的方式
				dataType : 'json',
				async : false,
				data : {
					id : selRows[0].taskid,
					style : 1
				},
				success : function(msg) {

					doSearch();
				}
			});
		});

		/**************************************完成主任务************************/
		$('#complete').linkbutton({
			iconCls : 'icon-cut'
		}).unbind("click").click(function() {
			var selRows = $('#tasktb').datagrid('getChecked');
			if (selRows[0].state == '未开始') {
				$.messager.alert('Warning', '未开始');
				return;
			}
			if (selRows[0].state == '已完成') {
				$.messager.alert('Warning', '已完成');
				return;
			}

			$.messager.confirm('Confirm', 'Are you sure you want to complete task?', function(r) {
				if (r) {
					$.ajax({
						url : 'startTask.do',
						type : 'post',//提交的方式
						dataType : 'json',
						async : false,
						data : {
							id : selRows[0].taskid,
							style : 2
						},
						success : function(msg) {

							doSearch();
						}
					});
				} else {
					return;
				}

			});
			//alert(selRows[0].unittestid);

		});

		/**************************************完成主任务OK************************/

		/**************************************创建子任务************************/
		$('#addsubtask').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			tasktype = 1;
			var selRows = $('#tasktb').datagrid('getChecked');
			//alert(selRows[0].taskid);
			$('#parentid1').val(selRows[0].taskid);
			//$('#projectid').combobox('setValue',selRows[0].projectid); 
			//alert(selRows[0].taskid); 
			$('#taskdialog').dialog('open');
		});

		/**************************************删除子任务************************/
		$('#delsubtask').linkbutton({
			iconCls : 'icon-remove'
		}).unbind("click").click(function() {

			$.messager.confirm('Confirm', '是否真的删除?', function(r) {
				if (r) {
					var selRows = $('#subtasktb').datagrid('getChecked');
					//alert(selRows[0].unittestid);
					//alert('没有权限');//可以自定义拦截器查找是否有权限
					//return;
					$.ajax({
						url : 'delTask.do',
						type : 'post',//提交的方式
						dataType : 'json',
						async : false,
						data : {
							id : selRows[0].taskid
						},
						success : function(msg) {
							if (msg[0].result == 'ERROR') {
								$.messager.alert('Warning', '删除出错，请先删除主任务下的子任务！');
							} else {
								$.messager.alert('Message', '删除成功！');
							}
							// alert(msg[0].result);
							// location.reload("getUnittest.do");
							//  $("#center").load('toTask.do');
							dosubSearch();
						}
					});
				} else {
					return;
				}

			});

		});

		/**************************************日志记录************************/

		// 1.打开Dialog*/
		$('#record').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			var selRows = $('#tasktb').datagrid('getChecked');
			$("#record_taskid").val(selRows[0].taskid);
			$('#recorddialog').dialog('open');
		});

		//2. Dialog Items	
		$('#recordtime').datetimebox({
			// value: '3/4/2016 2:3',    
			required : true,
			showSeconds : false
		})
		$('#recordtime').datetimebox('setValue', formatterDate(new Date()));

		$('#consumption_record').combobox({
			url : 'base/worktime.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#completion_record').combobox({
			url : 'base/completion.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#log_record').textbox({
			multiline : true,
		});

		//3. submit	
		$('#saverecord').linkbutton({
			iconCls : 'icon-save',
		}).unbind("click").click(function() {
			var selRows = $('#tasktb').datagrid('getChecked');
			var selRows1 = $('#subtasktb').datagrid('getChecked');

			var record_taskid;
			var userid;
			if (selRows1 == "") {
				record_taskid = selRows[0].taskid;
				userid = selRows[0].userid;
			} else {
				record_taskid = selRows1[0].taskid;
				userid = selRows1[0].userid;
			}

			$.ajax({
				url : 'recordtime.do',
				type : 'post',//提交的方式
				dataType : 'json',
				async : false,
				data : {
					"record_taskid" : record_taskid,
					"recordtime" : $("#recordtime").val(),
					"consumption" : $("#consumption_record").val(),
					"completion" : $("#completion_record").val(),
					"log" : $("#log_record").val(),
					"userid" : userid
				},
				success : function(msg) {
					$('#recorddialog').dialog('close');
					doSearch();
					return false;//防止提交两次
				}
			});

			return false;//防止提交两次
		});

		//4.Dialog config
		var recorddialog = $('#recorddialog');
		$('#recorddialog').dialog({
			title : '日志记录',
			width : 360,
			height : 450,
			left : 800,
			closed : true,
			cache : false,
		});

		/**************************************主任务表格************************/
		var url = 'getTask.do';
		var tasktb = $('#tasktb');
		tasktb.datagrid({
			//url:'getGrid.do',    
			title : '任务列表',
			pageSize : 9, //设置默认分页大小
			pageList : [ 3, 6, 9, 12, 15, 18 ], //设置分页大小
			rownumbers : true,
			fitColumns : true,
			columns : [ [ {
				field : 'ck',
				width : 100,
				checkbox : true
			}, {
				field : 'projectid',
				title : '所属项目',
				width : 100,
			}, {
				field : 'taskid',
				title : '',
				width : 0
			}, {
				field : 'userid',
				title : '任务负责人',
				width : fixWidth(0.08),
				formatter : function(value, row, index) {
					return value.split(',')[1];
				}

			}, {
				field : 'taskname',
				title : '任务名称',
				width : fixWidth(0.14),
			}, {
				field : 'alltime',
				title : '总用时',
				width : fixWidth(0.048),
			}, {
				field : 'currenttime',
				title : '已用时',
				width : fixWidth(0.048),
			}, {
				field : 'completeness',
				title : '耗时比例',
				width : fixWidth(0.056),
			}, {
				field : 'Completion',
				title : '完成度',
				width : fixWidth(0.056),
			}, {
				field : 'state',
				title : '状态',
				width : fixWidth(0.048),
			}, {
				field : 'begintime',
				title : '开始时间',
				sortable : true,
				width : fixWidth(0.14),
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
				field : 'taskdescription',
				title : '任务描述',
				width : fixWidth(0.25),
			}, {
				field : 'chirldrencount',
				title : '子任务数',
				width : fixWidth(0.04),
			} ] ],
			onDblClickRow : function(index, row) {
				dosubSearch();
			},
			singleSelect : true,
			selectOnCheck : true,
			checkOnSelect : true,
			pagination : true
		});

		tasktb.datagrid({
			url : url,
		});
		tasktb.datagrid('hideColumn', 'taskid');

		tasktb.datagrid("getPager").pagination({
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : "显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
		});

		/**************************************子任务表格************************/
		var url = 'getsubTask.do';
		var subtasktb = $('#subtasktb');
		subtasktb.datagrid({
			//url:'getGrid.do',    
			title : '子任务列表',
			pageSize : 12, //设置默认分页大小
			pageList : [ 3, 6, 9, 12, 15 ], //设置分页大小
			rownumbers : true,
			fitColumns : true,
			columns : [ [ {
				field : 'ck',
				width : 100,
				checkbox : true
			}, {
				field : 'projectid',
				title : '所属项目',
				width : 100,
			}, {
				field : 'taskid',
				title : '',
				width : 0
			}, {
				field : 'userid',
				title : '任务负责人',
				width : fixWidth(0.06),
				formatter : function(value, row, index) {
					return value.split(',')[1];
				}

			}, {
				field : 'taskname',
				title : '任务名称',
				width : fixWidth(0.14),
			}, {
				field : 'alltime',
				title : '预计总用时',
				width : fixWidth(0.048),
			}, {
				field : 'currenttime',
				title : '已用时',
				width : fixWidth(0.048),
			}, {
				field : 'completeness',
				title : '耗时比例',
				width : fixWidth(0.056),
			}, {
				field : 'Completion',
				title : '完成度',
				width : fixWidth(0.056),
			}, {
				field : 'state',
				title : '状态',
				width : fixWidth(0.048),
			}, {
				field : 'begintime',
				title : '开始时间',
				sortable : true,
				width : fixWidth(0.12),
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
				field : 'taskdescription',
				title : '任务描述',
				width : fixWidth(0.28),
			} ] ],
			/* 				onDblClickRow: function (index, row) {  
							doSearch(); 
				        }, */
			singleSelect : true,
			selectOnCheck : true,
			checkOnSelect : true,
			pagination : true
		});

		subtasktb.datagrid({
			url : url,
		});
		subtasktb.datagrid('hideColumn', 'taskid');

		subtasktb.datagrid("getPager").pagination({
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : "显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
		});
		/**************************************子任务表格OK************************/

	});
</script>

</head>
<body>
	<div>
		<a id="addtask" href="#">创建任务</a> <a id="del" href="#">删除任务</a> <a id="start" href="#">开始</a> <a id="complete"
			href="#">完成</a> <a id="addsubtask" href="#">创建子任务</a> <a id="delsubtask" href="#">删除子任务</a> <a id="record" href="#">记录工作日志</a>

		<div style="float: right; margin-right: 50px; magrin-top: 3px;">
			<span style="color: #666; magrin-left: 20px">所属项目:</span><input id="projectid_search" name="projectid_search"
				value="" style="width: 100px"> <span style="color: #666; magrin-left: 20px">任务负责人:</span><input
				id="userid_search" name="userid_search" value="" style="width: 100px"> <span
				style="color: #666; magrin-left: 20px">状态:</span><input id="state_search" name="state_search" value=""
				style="width: 100px"> <a id="sertch" href="#" onclick="doSearch()">查询</a>
		</div>
	</div>
	<table id="tasktb" style="width: 100%; height: 45%"></table>
	<table id="subtasktb" style="width: 100%; height: 50%"></table>

	<div id="taskdialog">
		<form id="taskform">
			<input name="taskid" type="text" style="display: none">

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">所属项目</div>
				<input id="projectid" name="projectid" type="text" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">任务负责人</div>
				<input id="userid" name="userid" type="text" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">任务名称:</div>
				<input id="taskname" type="text" name="taskname" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">任务描述:</div>
				<!-- <input id="result" type="text" style="width:300px"> -->
				<input id="taskdescripton" name="taskdescripton" style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">总用时:</div>
				<!-- <input id="testtime" type="text" style="width:300px"> -->
				<input id="alltime" type="text" name="alltime" style="width: 300px"></input>
			</div>

			<div style="margin-left: 20px; margin-top: 10px; display: none;">
				<div class="inputtab">父任务:</div>
				<input id="parentid1" type="text" name="parentid" style="width: 300px"></input>
			</div>
			<div style="margin-left: 20px; margin-top: 20px; padding-left: 200px">
				<a id="savetask" href="#">提交</a>
			</div>

		</form>

	</div>


	<div id="recorddialog">
		<!--  <form id="recordform"> -->
		<input id="record_taskid" name="record_taskid" type="text" style="display: none">

		<div style="margin-left: 20px; margin-top: 10px">
			<div class="inputtab">工作记录时间:</div>
			<input id="recordtime" type="text" name="createtime" style="width: 300px;">
			<div class="inputtab">消耗时间(小时):</div>
			<input id="consumption_record" type="text" name="consumption_record" style="width: 300px">
			<div class="inputtab">完成度:</div>
			<input id="completion_record" type="text" name="completion_record" style="width: 300px">
			<div class="inputtab">日志:</div>
			<input id="log_record" name="log_record" style="width: 300px; height: 180px" />
		</div>

		<div style="margin-left: 20px; margin-top: 20px; padding-left: 200px">
			<a id="saverecord" href="javaScript:void(0)">提交</a>
		</div>
		<!-- </form> -->
	</div>

</body>
</html>