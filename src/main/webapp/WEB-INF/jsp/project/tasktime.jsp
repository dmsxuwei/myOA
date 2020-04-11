<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">

$(document).ready(function(){
	$('input:radio:first').attr('checked', 'true');
	/*手动加一天*/			
	/* $('#add').linkbutton({    
			 iconCls: 'icon-add'   
		}).unbind("click").click(function(){
			 var selRows = $('#tasktimetb').datagrid('getChecked');  
			   //alert(selRows[0].unittestid);
			    $.ajax({
		            url: 'addTasktime.do',
		            type: 'post',//提交的方式
		            dataType:'json',
		            async:false,
		            data: {id:selRows[0].id},
		            success: function(msg) {
		               // alert(msg[0].result);
		               // location.reload("getUnittest.do");
		              $("#center").load('toTasktime.do');
		            }
		        }); 
	});
	
	/*手动减一天*/			
/* 	$('#dec').linkbutton({    
			 iconCls: 'icon-cut'   
		}).unbind("click").click(function(){
			 var selRows = $('#tasktimetb').datagrid('getChecked');  
			   //alert(selRows[0].unittestid);
			    $.ajax({
		            url: 'decTasktime.do',
		            type: 'post',//提交的方式
		            dataType:'json',
		            async:false,
		            data: {id:selRows[0].id},
		            success: function(msg) {
		               // alert(msg[0].result);
		               // location.reload("getUnittest.do");
		              $("#center").load('toTasktime.do');
		            }
		        }); 
	});  */


	
$('#worktime').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
});	
	
$('#cased').combobox({
		url : 'base/case.do',
		valueField : 'id',
		textField : 'text'
});	

$('#bak ').textbox({
	multiline : true,
});


$('#save').linkbutton({    
	    iconCls: 'icon-save',   
	}).unbind("click").click(function(){
		var selRows = $('#tasktimetb').datagrid('getChecked'); 
		
		var timetaskString = '[';
		   //alert(roletbselRows.length);
		   for(var i=0;i<selRows.length;i++){
			  if(i==selRows.length-1) {
				  timetaskString+=(selRows[i].id);			 
			  }else{
				  timetaskString+=(selRows[i].id+",");
			  }
		   }
		   timetaskString+=']';
		   
	    $.ajax({
            url: 'adjustmenttime.do',
            type: 'post',//提交的方式
            dataType:'json',
            async:false,
	            data: {
	            	id:timetaskString,
	            	timeflag : $('input:radio:checked').val(),
	            	worktime : $("#worktime").val(),
	            	cased: $("#cased").val(),
	            	bak: $("#bak").val()
	            	},
            success: function(msg) {
               // alert(msg[1].id);
                dialog.dialog({ 
					// closed: true,  
				});
  			 $("#center").load('toTasktime.do');
            }
        }); 
	    return false;//防止提交两次
	});	
	
	/*Dialog*/
var dialog=$('#adjustmentdialog');
			$('#adjustmentdialog').dialog({    
			    title: 'My Dialog',    
			    width: 260,    
			    height: 380,    
			    closed: true,    
			    cache: false,    
});	

/*添加打开Dialog*/			
$('#adjustment').linkbutton({    
	 iconCls: 'icon-add'   
}).unbind("click").click(function(){
	var selRows = $('#tasktimetb').datagrid('getChecked'); 
	if(selRows[0]==null){
		alert('请选译记录！');
		return;
	}
	$('#adjustmentdialog').dialog('open');
});

$('#init').linkbutton({    
	 iconCls: 'icon-add'   
}).unbind("click").click(function(){
	 $.ajax({
         url: 'inittime.do',
         type: 'post',//提交的方式
         dataType:'json',
         async:false,
         success: function(msg) {
        	 $("#center").load('toTasktime.do');
         }
     }); 
	});	
		
			


/*表格*/
var url='getTasktime.do';
			var tasktimetb=$('#tasktimetb');
			tasktimetb.datagrid({    
			    //url:'getGrid.do',    
			    title: '演示表格使用',
			    pageSize:3,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:100,checkbox:true}, 
					{field:'id',title:'',width:0},
			        {field:'userid',title:'姓名',width:100},    
			        {field:'time',title:'未分配时间',width:200}, 
			        {field:'alltime',title:'累计工作时间',width:200} 
			    ]],
			    singleSelect: false,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    pagination:true
			});
			
			tasktimetb.datagrid({ 
				url:url,	
			});
			tasktimetb.datagrid('hideColumn','id');
	
			tasktimetb.datagrid("getPager").pagination({   
			    beforePageText: '第',  
			          afterPageText: '页    共 {pages} 页', 
			    displayMsg:"显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
			            });

});



</script>

</head>
<body>	
		<div>
<!-- 			<a id="add" href="#">手动加一天</a>  
			<a id="dec" href="#">手动减一天</a>  -->
			<a id="adjustment" href="#">工时调整</a> 
			<a id="init" href="#">更新初始化</a> 
		</div>
		<table id="tasktimetb" style="width:100%;height:95%"></table>  
		
<div id="adjustmentdialog">
  <form id="adjustmentform">
    <input  name ="projectid" type="text" style="display:none">
    <div style="margin-left:10px;margin-top:10px">
        <input type="radio"  name="timeflag" value="0">增工时</input>
        <input type="radio" name="timeflag" value="1">减工时</input>
    </div>

	<div style="margin-left:20px;margin-top:20px">
			<div class="inputtab">调整原因:</div>
			<input id="cased" type="text" name="cased" style="width:200px">
	</div>	
	
		<div style="margin-left:20px;margin-top:10px">
			<div class="inputtab">工时:</div>
			<input id="worktime" type="text" name="worktime" style="width:200px">
		</div>

		<div style="margin-left:20px;margin-top:10px">
			<div class="inputtab">备注:</div>
			<input id="bak" type="text" name="bak" style="height:100px;width:200px">
		</div>		


		<div style="margin-left: 20px; margin-top: 20px;padding-left:140px">
			 <a id="save" href="#">提交</a>
		</div>
			
	</form>

</div>
</body>
</html>