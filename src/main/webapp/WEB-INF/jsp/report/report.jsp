<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
function doSearch(){
	$('#reporttb').datagrid('load',{
		date:$('#sertchtime').val()
	});
}

$(document).ready(function(){
	
 	$('#sertchtime').datebox({    
	    required:true   
	});  
 	
	 var currTime=new Date();
     var strDate=currTime.getFullYear()+"-"+(currTime.getMonth()+1);//+"-01"
     $('#sertchtime').datebox({formatter:function(date){
         var y = date.getFullYear();
         var m = date.getMonth() + 1;
         m = m < 10 ? '0' + m : m;
         return y.toString() + '-' + m.toString();
     },parser:function(date){
         console.log(date);
         if (date) {
             return new Date(String(date).substring(0, 4) + '-'
                     + String(date).substring(5,7));
         } else {
             return new Date();
         }
     }}); 
     $('#sertchtime').datebox('setValue', strDate);
     
 $('#sertch').linkbutton({
		iconCls : 'icon-save',
	});
	

$('#Export').linkbutton({
	iconCls : 'icon-save',
}).unbind("click").click(function() {
	$.ajax({
		url : 'report/Export.do',
		type : 'post',//提交的方式
		dataType : 'json',
		async : false,
		data : {
			"date" :$('#sertchtime').val()
		},
		success : function(msg) {
			return false;//防止提交两次
		}
	});
	return false;//防止提交两次
});
	
	
	
	/*表格*/
	var url='report/opertortimestatic.do';//?date='+$('#sertchtime').datebox('getValue');
				var dg=$('#reporttb');
				dg.datagrid({    
				    //url:'getGrid.do',    
				    title: '演示表格使用',
				    pageSize:15,        //设置默认分页大小
		            pageList:[3,6,9,12,15],   //设置分页大小
				    rownumbers: true,
				    queryParams: {          
		                date:$('#sertchtime').datebox('getValue')            
		              },    
				    columns:[[   
						{field:'ck',width:fixWidth(0.083),checkbox:true}, 
						{field:'id',title:'',width:0},
				        {field:'realname',title:'员工姓名',width:fixWidth(0.1)},   
						{field:'projectname',title:'所属项目',width:fixWidth(0.2)},    
				        {field:'usetime',title:'本周工时',width:fixWidth(0.50)}
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
	
});

</script>

	
<div style="magrin-top:3px;">
			<!-- <span style="color:#666;magrin-left:20px">所属项目:</span><input id="projectid_search" name="projectid_search"  value="" style="width:100px">
			<span style="color:#666;magrin-left:20px">任务负责人:</span><input id="userid_search" name="userid_search"  value="" style="width:100px">
			<span style="color:#666;magrin-left:20px">第几周:</span><input id="week_search" name="week_search"  value="" style="width:100px">    -->
			<!-- <a id="sertch" href="#" onclick="doSearch()">查询</a>  -->
			
			<input id="sertchtime" type="text"></input>  
			<a id="sertch" href="#" onclick="doSearch()">搜索</a> 
			<a id="Export" href="#" onclick="doSearch()">导出Excel</a> 
</div>
		 <table id="reporttb" style="width:100%;height:95%"></table> 

