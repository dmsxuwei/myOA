<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
var savesubtaskormaintask=0;
	function doSearch(taskid) {
		var selRows = $('#tasktb').datagrid('getChecked');
		$('#tasktb').datagrid('load', {
			projectid_search : $('#projectid_search').val(),
			userid_search : $('#userid_search').val(),
			state_search : $('#state_search').val(),
			department_search : $('#department_search').val(),
		//parentid : selRows[0].taskid,
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
		//================================添加任务对话框内表单===================================================		
		$('#log').textbox({
			multiline : true,
		});

		$('#recordtime').combobox({
			url : 'base/worktime.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#timeclass').combobox({
			url : 'base/timeclass.do',
			valueField : 'id',
			textField : 'text'
		/* 	onLoadSuccess : function() {
		 $("#timeclass").combobox("setValue", 0);
		 } */
		});

		$('#mydistributabletime').textbox({
			iconCls : 'icon-man',
			readonly : true,
			iconAlign : 'left'
		});
		$('#Completion').combobox({
			url : 'base/completion.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#logtime').datetimebox({
			required : true
		});
		var currTime = new Date();
		//var strDate=currTime.getFullYear()+"-"+(currTime.getMonth()+1);//+"-01"
		var strDate = currTime.getFullYear() + "-";
		strDate += currTime.getMonth() + 1 + "-";
		strDate += currTime.getDate() + "-";
		strDate += currTime.getHours() + ":";
		strDate += currTime.getMinutes() + ":";
		strDate += currTime.getSeconds();
		//alert(strDate);
		$('#logtime').datetimebox('setValue', strDate);
		/*添加任务*/

		$('#projectid').combobox({
			url : 'getProjectsByUser.do',
			valueField : 'id',
			textField : 'text'
		});

		$('#userid_mine').combobox({
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
		//================================任务Dialog===================================================	
		var dialog = $('#mytaskdialog');
		$('#mytaskdialog').dialog({
			title : '创建子任务',
			width : 380,
			height : 400,
			closed : true,
			cache : false,
		});


	/*打开添加主任务Dialog*/
		$('#add_mine').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			savesubtaskormaintask=0;
			$('#parentid').val(0);
			$.ajax({
				url : 'base/getPrivilege.do',
				type : 'post',//提交的方式
				//dataType : 'json',
				//data : data,
				async : false,
				success : function(msg) {
					var obj = JSON.parse(msg);
					if (obj.result == 0) {
						dialog.dialog('open');
					} else {
						$.messager.alert('Warning', '暂时没有权限');
					}
					return;//防止提交两次
				}

			});

		});

		//添加主任务
		$('#save').linkbutton({
			iconCls : 'icon-save',
		}).unbind("click").click(function() {
			var data = $('#mytaskform').serialize();
			$.ajax({
				url : 'mine/addtask.do',
				type : 'post',//提交的方式
				dataType : 'json',
				data : data,
				async : false,
				success : function(msg) {
					dialog.dialog({});
					// $("#center").load('toTask.do');
					if(savesubtaskormaintask==0){
						doSearch();
					}else{
						dosubSearch();
					}
					
					return false;//防止提交两次
				}

			});
			return false;//防止提交两次
		});
		//================================日志记录===================================================
		/*日志记录dialog*/
		var myrecorddialog = $('#myrecorddialog');
		$('#myrecorddialog').dialog({
			title : 'My Dialog',
			width : 360,
			height : 520,
			left : 800,
			closed : true,
			cache : false,
		});

		/*添加日志记录Dialog*/
		$('#record').linkbutton({
			iconCls : 'icon-edit'
		}).unbind("click").click(function() {
			var selRows = $('#subtasktb').datagrid('getChecked');
			if (selRows[0] == null) {
				$.messager.alert('Warning!','请选择子任务');
			}
			
			var selRows = $('#subtasktb').datagrid('getChecked');
			$("#record_taskid").val(selRows[0].taskid);

			var selRows = $('#tasktb').datagrid('getChecked');
			//alert(selRows[0].Completion);
			$("#Completion").combobox("setValue", selRows[0].Completion);

			$.ajax({
				url : 'distributabletime.do',
				type : 'post',//提交的方式
				dataType : 'json',
				data : {
					"userid" : selRows[0].userid
				},
				async : false,
				success : function(msg) {
					$('#mydistributabletime').textbox('setValue', msg[0].result + '小时');
					return false;//防止提交两次
				}

			});
			$('#myrecorddialog').dialog('open');
		});

		//日志记录	
		$('#saverecord').linkbutton({
			iconCls : 'icon-save',
		}).unbind("click").click(function() {
			$('#myrecorddialog').dialog({
			// closed: true,  
			});

			if ($("#log").val() == "") {
				alert("请填写工作日志");
				return;
			}

			/* 					if(parseFloat($("#recordtime").val())>6.5){
			 alert('工时请不要超过6.5小时');
			 return;
			 } */
			var selRows = $('#subtasktb').datagrid('getChecked');
			var completion = parseInt(selRows[0].Completion.replace('%', ''));
			if (completion > parseInt($("#Completion").val())) {
				alert('不能小于当前完成度！');
				return;
			}

			var mydistributabletime = parseFloat($("#mydistributabletime").val().replace('小时', ''));
			var recordtime = parseFloat($("#recordtime").val());
			if ((mydistributabletime - recordtime) < 0) {
				alert('可分配时间不够！');
				return;
			}

			/* var selRows1 = $('#tasktb').datagrid('getChecked');
			alert(selRows1[0].taskid);
			var selRows = $('#subtasktb').datagrid('getChecked');
			if(selRows2=="")alert(999); */

			var selRows1 = $('#subtasktb').datagrid('getChecked');
			var record_taskid;
			if (selRows1 == "") {
				//alert(111);
				record_taskid = $("#record_taskid").val();
			} else {
				record_taskid = selRows1[0].taskid;
			}

			var data = $('#recordform').serialize();
			//alert(2);
			$.ajax({
				url : 'recordtime.do',
				type : 'post',//提交的方式
				dataType : 'json',
				async : false,
				data : {
					"record_taskid" : record_taskid,
					"recordtime" : $("#recordtime").val(),
					"Completion" : $("#Completion").val(),
					"log" : $("#log").val(),
					"userid" : selRows[0].userid,
					"timeclass" : $("#timeclass").val(),
					"logtime" : $("#logtime").val()

				},
				success : function(msg) {
					//alert(msg[0].result);
					if (msg[0].result == 'OK') {
						$.messager.alert('Warning', '操作成功！');
					} else {
						$.messager.alert('Warning', '操作失败！');
					}

					//$("#center").load('toTask.do');
					doSearch();

					return false;//防止提交两次
				}
			});
			return false;//防止提交两次
		});
		//================================子任务===================================================
		//打开子任务框
		$('#subtask').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			savesubtaskormaintask=1;
			var selRows = $('#tasktb').datagrid('getChecked');
			if (selRows[0] == null) {
				$.messager.alert('Warning!','请选择主任务');
			}
			

			$('#parentid').val(selRows[0].taskid);
			//$('#projectid').combobox('setValue',selRows[0].projectid); 
			//alert(selRows[0].taskid); 
			$('#mytaskdialog').dialog('open');
		});

		//================================删除主任务===================================================		
		$('#del').linkbutton({
			iconCls : 'icon-remove'
		}).unbind("click").click(function() {
			
			$.messager.confirm('Confirm','是否真的删除?',function(r){
			    if (r){
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
							if(msg[0].result=='ERROR'){
								$.messager.alert('Warning','删除出错，请先删除主任务下的子任务！');
							}else{
								$.messager.alert('Message','删除成功！');
							}
							
							
							// location.reload("getUnittest.do");
							//  $("#center").load('toTask.do');
							doSearch();
						}
					});
			    }else{
			    	return;	
			    }
			    
			});
			
			
			
		});



	//================================删除子任务===================================================		
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
							if(msg[0].result=='ERROR'){
								$.messager.alert('Warning','删除出错，请先删除主任务下的子任务！');
							}else{
								$.messager.alert('Message','删除成功！');
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
		/*进入子任务按钮*/
		$('#looksubtask').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			dosubSearch();
		});

		//================================主任务表格===================================================			
		var url = 'mine/getTask.do';
		var tasktb = $('#tasktb');
		tasktb.datagrid({
			//url:'getGrid.do',    
			title : '演示表格使用',
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
				width : fixWidth(0.25),
			}, {
				field : 'chirldrencount',
				title : '子任务数',
				width : fixWidth(0.1),
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

	});

	//================================子任务表格===================================================		
	var url = 'mine/getsubTask.do';
	var subtasktb = $('#subtasktb');
	subtasktb.datagrid({
		//url:'getGrid.do',    
		title : '演示表格使用',
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
			width : fixWidth(0.25),
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

	//================================搜索===================================================	
	$('#projectid_search').combobox({
		url : 'projects.do',
		valueField : 'id',
		textField : 'text'
	});
	$('#department_search').combobox({
		url : 'department/department.do',
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
				//data: {id:selRows[0].taskid,style:2},
				success : function(msg) {
					$("#userid_search").combobox("setValue", msg[0].userid);
					doSearch();
				}
			});

		}
	});

	$('#state_search').combobox({
		url : 'base/state.do',
		valueField : 'id',
		textField : 'text'
	});

	/*查询*/
	$('#sertch').linkbutton({
		iconCls : 'icon-search'
	});
</script>

</head>
<body>
	<div>
		<a id="add_mine" href="#">创建任务</a> <a id="subtask" href="#">创建子任务</a>
		<!-- <a id="addsub" href="#">创建子任务</a> -->
		<!-- <a id="start" href="#">开始</a>  -->
		<!-- <a id="pause" href="#">暂停</a> -->
		<!-- <a id="complete" href="#">完成</a>  -->
		<a id="looksubtask" href="#">进入子任务</a> 
		<a id="del" href="#">删除任务</a>
		<a id="delsubtask" href="#">删除子任务</a>
		<a id="record" href="#">工作日志</a>
		<div style="float: right; margin-right: 50px; magrin-top: 3px;">
			<!-- 	<span style="color:#666;magrin-left:20px">所属部门:</span><input id="department_search" name="department_search"  value="" style="width:100px"> -->
			<span style="color: #666; magrin-left: 20px">所属项目:</span><input
				id="projectid_search" name="projectid_search" value=""
				style="width: 100px"> <span
				style="color: #666; magrin-left: 20px">任务负责人:</span><input
				id="userid_search" name="userid_search" value=""
				style="width: 100px"> 
<!-- 				<span
				style="color: #666; magrin-left: 20px">状态:</span><input
				id="state_search" name="state_search" value="" style="width: 100px"> -->
				
			<a id="sertch" href="#" onclick="doSearch()">查询</a>
		</div>
	</div>


	<div id="mytaskdialog">
		<form id="mytaskform">
			<input name="taskid" type="text" style="display: none">

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">所属项目</div>
				<input id="projectid" name="projectid" type="text"
					style="width: 300px">
			</div>

			<div id="useriddiv" style="margin-left: 20px; margin-top: 10px;">
				<div class="inputtab">任务负责人</div>
				<input id="userid_mine" name="userid" type="text"
					style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">任务名称:</div>
				<input id="taskname" type="text" name="taskname"
					style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">任务描述:</div>
				<!-- <input id="result" type="text" style="width:300px"> -->
				<input id="taskdescripton" name="taskdescripton"
					style="width: 300px">
			</div>

			<div style="margin-left: 20px; margin-top: 10px">
				<div class="inputtab">总用时:</div>
				<!-- <input id="testtime" type="text" style="width:300px"> -->
				<input id="alltime" type="text" name="alltime" style="width: 300px"></input>
			</div>

			<div style="margin-left: 20px; margin-top: 10px;">
				<div class="inputtab">父任务:</div>
				<!-- <input id="testtime" type="text" style="width:300px"> -->
				<input id="parentid" type="text" name="parentid"
					style="width: 300px"></input>
			</div>

			<!-- 		<div style="margin-left:20px;margin-top:10px">
			<div class="inputtab">审核 人:</div>
			<input id="auditor" type="text" name="auditor" style="width:300px;">
		</div> -->


			<div style="margin-left: 20px; margin-top: 20px; padding-left: 200px">
				<a id="save" href="#">提交</a>
			</div>

		</form>

	</div>


	<div id="myrecorddialog">
		<!--  <form id="recordform"> -->
		<input id="record_taskid" name="record_taskid" type="text"
			style="display: none">

		<div style="margin-left: 20px; margin-top: 10px">
			<div class="inputtab">可分配时间:</div>
			<input id="mydistributabletime" type="text"
				name="mydistributabletime" style="width: 300px">
			<div class="inputtab">记录时间:</div>
			<input id="logtime" type="text" name="logtime" style="width: 300px">
			<div class="inputtab">工时分类:</div>
			<input id="timeclass" type="text" name="timeclass"
				style="width: 300px">
			<div class="inputtab">工时:</div>
			<input id="recordtime" type="text" name="recordtime"
				style="width: 300px">
			<div class="inputtab">完成度:</div>
			<input id="Completion" type="text" name="Completion"
				style="width: 300px">
			<div class="inputtab">日志:</div>
			<input id="log" name="log" style="width: 300px; height: 180px" />
		</div>

		<div style="margin-left: 20px; margin-top: 20px; padding-left: 200px">
			<a id="saverecord" href="javaScript:void(0)">提交</a>
		</div>
		<!-- </form> -->
	</div>
	<table id="tasktb" style="width: 100%; height: 40%"></table>
	<!--  -->
	<table id="subtasktb" style="width: 100%; height: 55%"></table>
</body>
</html>