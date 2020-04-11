<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
function doSearch() {
	//alert(1);
$('#weeklytb').datagrid('load', {
		projectid_search : $('#projectid_search').val(),
		userid_search : $('#userid_search').val(),
		week_search : $('#week_search').val(),
		department_search : $('#department_search').val(),
	});
}

$(document).ready(function(){

		$.ajax({
			url : 'base/getThisWeek.do',
			type : 'post',//提交的方式
			dataType : 'json',
			async : false,
			success : function(msg) {
				//alert(msg.thisweek);
				$("#week_search").val(msg.thisweek);
				return false;//防止提交两次
			}
		});	
	
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
/* 		$.ajax({
			url : 'base/getUserid.do',
			type : 'post',//提交的方式
			dataType : 'json',
			async : false,
			//data: {id:selRows[0].taskid,style:2},
			success : function(msg) {
				//$("#userid_search").combobox("setValue", msg[0].userid);
				//doSearch();
			}
		}); */

	}
});

$('#week_search').textbox({      
   // iconCls:'icon-man',
    iconAlign:'left'      
});

/*查询*/
 $('#sertch').linkbutton({    
			    iconCls: 'icon-search'   
});

 $('#Export').linkbutton({
		iconCls : 'icon-save',
	}).unbind("click").click(function() {
 		$.ajax({
			url : 'weekly/Export.do',
			type : 'post',//提交的方式
			dataType : 'json',
			async : false,
			data : {
				"projectid_search" : $('#projectid_search').val(),
				"userid_search" : $('#userid_search').val(),
				"week_search" : $('#week_search').val(),
				"department_search" : $('#department_search').val(),
			},
			success : function(msg) {
				return false;//防止提交两次
			}
		}); 
 		
 		$('#download').click();
	});

/*表格*/
var url='weekly/getWeekly.do';
			var dg=$('#weeklytb');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '演示表格使用',
			    pageSize:15,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:fixWidth(0.083),checkbox:true}, 
					{field:'id',title:'',width:0},
					{field:'projectid',title:'所属项目',width:fixWidth(0.068)}, 
			        {field:'week',title:'第几周',width:fixWidth(0.04)},
			        {field:'weekday',title:'星期几',width:fixWidth(0.04)},
					{
						field : 'taskname',
						title : '父任务',
						width : fixWidth(0.06)
					},
					{field:'taskid',title:'所属任务',width:fixWidth(0.068),								
						formatter: function(value,row,index){
						return value.split(',')[1];
					}
					}, 
			        {field:'content',title:'内容',width:fixWidth(0.30)},

			        {field:'usetime',title:'用时',width:fixWidth(0.035)}, 
			        {field:'completion',title:'完成度',width:fixWidth(0.035)},
			        {
                        field: 'recordtime', title: '记录时间', sortable: true,width:fixWidth(0.12),
                        formatter: function (value, row, index) {
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
                    },
			        {field:'opertor',title:'负责人',width:fixWidth(0.05),								
                    	formatter: function(value,row,index){
						return value.split(',')[1];
					}
                    }

			    ]],
			    singleSelect: false,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    pagination:true
			});
			
			dg.datagrid({ 
				url:url,	
			});
			dg.datagrid('hideColumn','id');
	
			dg.datagrid("getPager").pagination({   
			    beforePageText: '第',  
			          afterPageText: '页    共 {pages} 页', 
			    displayMsg:"显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
			});
			
/*删除记录*/
			$('#dellog').linkbutton({
				iconCls : 'icon-remove'
			}).unbind("click").click(function() {
				var selRows = $('#weeklytb').datagrid('getChecked');
				//alert(selRows[0].unittestid);
				//alert('没有权限');//可以自定义拦截器查找是否有权限
				//return;
				$.ajax({
					url : 'weekly/dellog.do',
					type : 'post',//提交的方式
					dataType : 'json',
					async : false,
					data : {
						id : selRows[0].id,
						taskid : selRows[0].taskid,
						opertor: selRows[0].opertor,
						usetime: selRows[0].usetime,
						completion: selRows[0].completion						
					},
					success : function(msg) {
						// alert(msg[0].result);
						// location.reload("getUnittest.do");
						//  $("#center").load('toTask.do');
						alert(msg[0].result);
						doSearch();
					}
				});
			});			
			
			
});
</script>


<div style="magrin-top: 3px;">
	<span style="color: #666; magrin-left: 20px">所属项目:</span><input id="projectid_search" name="projectid_search" value=""
		style="width: 100px">
	<!-- <span style="color:#666;magrin-left:20px">所属部门:</span><input id="department_search" name="department_search"  value="" style="width:100px"> -->
	<span style="color: #666; magrin-left: 20px">任务负责人:</span><input id="userid_search" name="userid_search" value=""
		style="width: 100px"> <span style="color: #666; magrin-left: 20px">第几周:</span><input id="week_search"
		name="week_search" value="" style="width: 100px"> <a id="sertch" href="#" onclick="doSearch()">查询</a> <a
		id="Export" href="#" onclick="doSearch()">导出Excel</a> <a id="dellog" href="#" onclick="doSearch()">删除</a>
</div>
<table id="weeklytb" style="width: 100%; height: 95%"></table>
<a id="down" href="/oa/report/report.xls"><span id="download" style="display: none">下一步</span></a>
