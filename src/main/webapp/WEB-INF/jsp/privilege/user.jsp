<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<script type="text/javascript">	
$(document).ready(function(){
	$('#saverole').linkbutton({
		iconCls : 'icon-add'
	});
	$('#removerole').linkbutton({
		iconCls : 'icon-remove'
	});
	
	var dialog = $('#addroledialog');
	$('#addroledialog').dialog({
		title : '用户角色管理',
		width : 420,
		height : 400,
		closed : true,
		cache : false,
	});
	
/*项目添加角色*/	
	$('#saverole').unbind("click").click(function() {
		var selRows= $('#usertb').datagrid('getChecked');
		var userdataString = '[';//3,4];
		//alert(roletbselRows.length);
		for (var i = 0; i < selRows.length; i++) {
			if (i == selRows.length - 1) {
				userdataString += (selRows[i].userid);
			} else {
				userdataString += (selRows[i].userid + ",");
			}
		}
		userdataString += ']';
		//alert(userdataString);
		
		
		//alert(selRows[0].userid);
		var roletbselRows = $('#addroletb').datagrid('getChecked');
		// alert(roletbselRows[0].roleid);
		var dataString = '[';//3,4];
		//alert(roletbselRows.length);
		for (var i = 0; i < roletbselRows.length; i++) {
			if (i == roletbselRows.length - 1) {
				dataString += (roletbselRows[i].roleid);
			} else {
				dataString += (roletbselRows[i].roleid + ",");
			}
		}
		dataString += ']';
		
		//alert(dataString + '');
		//var jsonString = JSON.stringify(dataString);
		var json = {
			userids : userdataString,
			roleids : dataString
		};
		$.ajax({
			url : 'UserAddRole.do',
			type : 'post',//提交的方式
			dataType : 'json',
			//contentType:"application/json",
			data : json,
			//async:false,
			success : function(msg) {
				// alert(msg[0].result);
				// location.reload("getUnittest.do");
				// $("#center").load('toUnittest.do');
		/* 		dialog.dialog({ 
					// closed: true,  
				}); */
				var selRows = $('#usertb').datagrid('getChecked');
				var userid=selRows[0].userid;
				$('#addroletb').datagrid('reload',{
					userid: userid
				});
				$('#haveroletb').datagrid('reload',{
					userid: userid
				});
			}
		});

	});


/*删除角色*/
	$('#removerole').unbind("click").click(function() {
		var selRows= $('#usertb').datagrid('getChecked');
		var userdataString = '[';//3,4];
		//alert(roletbselRows.length);
		for (var i = 0; i < selRows.length; i++) {
			if (i == selRows.length - 1) {
				userdataString += (selRows[i].userid);
			} else {
				userdataString += (selRows[i].userid + ",");
			}
		}
		userdataString += ']';
		//alert(userdataString);
		
		
		//alert(selRows[0].userid);haveroletb
		var roletbselRows = $('#haveroletb').datagrid('getChecked');
		// alert(roletbselRows[0].roleid);
		var dataString = '[';//3,4];
		//alert(roletbselRows.length);
		for (var i = 0; i < roletbselRows.length; i++) {
			if (i == roletbselRows.length - 1) {
				dataString += (roletbselRows[i].roleid);
			} else {
				dataString += (roletbselRows[i].roleid + ",");
			}
		}
		dataString += ']';
		
		//alert(dataString + '');
		//var jsonString = JSON.stringify(dataString);
		var json = {
			userids : userdataString,
			roleids : dataString
		};
		$.ajax({
			url : 'UserRemoveRole.do',
			type : 'post',//提交的方式
			dataType : 'json',
			//contentType:"application/json",
			data : json,
			//async:false,
			success : function(msg) {
				var selRows = $('#usertb').datagrid('getChecked');
				var userid=selRows[0].userid;
				$('#addroletb').datagrid('reload',{
					userid: userid
				});
				$('#haveroletb').datagrid('reload',{
					userid: userid
				});
/* 				dialog.dialog({ 
					// closed: true,  
				}); */
				// alert(msg[0].result);
				// location.reload("getUnittest.do");
				// $("#center").load('toUnittest.do');
			}
		});

	});
	
/*删除记录*/			
  $('#del').linkbutton({    
			    iconCls: 'icon-remove'   
			}).unbind("click").click(function(){
				   var selRows = $('#usertb').datagrid('getChecked');  
				   // alert(selRows[0].unittestid);
				    $.ajax({
			            url: 'delUser.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: {id:selRows[0].userid},
			            success: function(msg) {
			               // alert(msg[0].result);
			               // location.reload("getUnittest.do");
			              $("#center").load('toUser.do');
			            }
			        }); 
			}); 
	
/*Dialog*/






/*点击添加角色*/	
	$('#addrole').linkbutton({
			iconCls : 'icon-add'
		}).unbind("click").click(function() {
			var selRows = $('#usertb').datagrid('getChecked');
			if (selRows[0] == null) {
				alert('请选择用户！');
				return;
			}

			$('#addroledialog').dialog('open');
			// alert(selRows[0].userid);
			/*表格*/
			var userid=selRows[0].userid;
			var url = "getNoHavedRole.do?userid=" + userid;
			var dg = $('#addroletb');
			dg.datagrid({
				//url:url,    
				title : '可增加角色列表',
				width : 200,
				height : 300,
				pageSize : 3, //设置默认分页大小
				pageList : [ 3, 6, 9, 12, 15 ], //设置分页大小
				rownumbers : true,
				columns : [ [ {
					field : 'ck',
					width : 80,
					checkbox : true
				}, {
					field : 'roleid',
					title : '',
					width : 0
				}, {
					field : 'rolename',
					title : '用户名',
					width : 120
				} ] ],
				singleSelect : false,
				selectOnCheck : true,
				checkOnSelect : true,
			//pagination:true
			});

			 dg.datagrid({
				url : url,
			}); 
			dg.datagrid('hideColumn', 'roleid');

			

			
			/*表格*/
			var userid=selRows[0].userid;
			var url = "getHavedRole.do?userid=" + userid;
			var dg = $('#haveroletb');
			dg.datagrid({
				//url:'getGrid.do',    
				title : '已存在角色列表',
				width : 200,
				height : 300,
				pageSize : 3, //设置默认分页大小
				pageList : [ 3, 6, 9, 12, 15 ], //设置分页大小
				rownumbers : true,
				columns : [ [ {
					field : 'ck',
					width : 100,
					checkbox : true
				}, {
					field : 'roleid',
					title : '',
					width : 0
				}, {
					field : 'rolename',
					title : '用户名',
					width : 100
				} ] ],
				singleSelect : false,
				selectOnCheck : true,
				checkOnSelect : true,
			//pagination:true
			});

			dg.datagrid({
				url : url,
			});
			dg.datagrid('hideColumn', 'roleid');


		});

	
/* 		$('#delrole').linkbutton({
			iconCls : 'icon-remove'
		}); */

		/*表格*/
		var url = 'getUser.do';
		var usertb = $('#usertb');
		usertb.datagrid({
			//url:'getGrid.do',    
			title : '',
			pageSize : 3, //设置默认分页大小
			pageList : [ 3, 6, 9, 12, 15 ], //设置分页大小
			rownumbers : true,
			columns : [ [ {
				field : 'ck',
				width : 100,
				checkbox : true
			}, {
				field : 'userid',
				title : '',
				width : 0
			}, {
				field : 'username',
				title : '用户名',
				width : 200
			}, {
				field : 'age',
				title : '年龄',
				width : 200
			}, {
				field : 'realname',
				title : '真实姓名',
				width : 100
			}, {
				field : 'sex',
				title : '性别',
				width : 100
			}, {
				field : 'tel',
				title : '电话',
				width : 250,
				align : 'center'
			}, {
				field : 'department',
				title : '部门',
				width : 250,
				align : 'center'
			} ] ],
			singleSelect : true,
			selectOnCheck : true,
			checkOnSelect : true,
			pagination : true
		});

		usertb.datagrid({
			url : url,
		});
		usertb.datagrid('hideColumn', 'userid');

		usertb.datagrid("getPager").pagination({
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : "显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
		});

	});
</script>


		<div>
			<a id="addrole" href="#">用户角色</a> 
			<a id="del" href="#">删除</a> 
			<!-- <a id="delrole" href="#">删除角色</a>  -->
		</div>
		<table id="usertb" style="width:100%;height:95%"></table>  
		
		
<div id="addroledialog">
	<div style="float:left"><table id="addroletb"></table></div>
	<div><table id="haveroletb"></table></div>
	<div>
	<a id="saverole" style="margin-left:50px;margin-top:30px" href="#">添加角色</a> 
	<a id="removerole" style="margin-left:100px;margin-top:30px" href="#">删除角色</a> 
	</div>
</div>


