<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	
	
$(document).ready(function(){
	/*Dialog上的控件*/
	$('#testproject').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#testunit').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#result').combobox({    
	    url:'result.do',    
	    valueField:'id',    
	    textField:'text'   
	});
	$('#testtime').datetimebox({    
	   // value: '3/4/2016 2:3',    
	    required: true,    
	    showSeconds: false   
	})
	
	$('#testtime').datetimebox('setValue', formatterDate(new Date()));
	
	$('#save').linkbutton({    
	    iconCls: 'icon-save',   
	}).click(function(){
		alert($('#testproject').val());
		//$("#unittestform").submit();
		var data=$('#unittestform').serialize();
	    $.ajax({
            url: 'addunittest.do',
            type: 'post',//提交的方式
            dataType:'json',
            async:false,
            data: data,
            success: function(msg) {
               // alert(msg[1].id);
                dialog.dialog({ 
					// closed: true,  
				});
  			 $("#center").load('toUnittest.do');
            }
        }); 

	});
	
/*Dialog*/
	var dialog=$('#unittestdialog');
			$('#unittestdialog').dialog({    
			    title: 'My Dialog',    
			    width: 380,    
			    height: 450,    
			    closed: true,    
			    cache: false,    
			});
			

/*添加打开Dialog*/			
	$('#add').linkbutton({    
			    iconCls: 'icon-add'   
			}).click(function(){
				$('#unittestdialog').dialog('open');
			});
/*删除记录*/			
  $('#del').linkbutton({    
			    iconCls: 'icon-remove'   
			}).click(function(){
				   var selRows = $('#dg').datagrid('getChecked');  
				   // alert(selRows[0].unittestid);
				    $.ajax({
			            url: 'delUnittest.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: {id:selRows[0].unittestid},
			            success: function(msg) {
			               // alert(msg[0].result);
			               // location.reload("getUnittest.do");
			              $("#center").load('toUnittest.do');
			            }
			        }); 
			}); 
	
/*查询*/
$('#sertch').linkbutton({    
			    iconCls: 'icon-search'   
}); 
		

/*表格*/
var url='getUnittest.do';
			var dg=$('#dg');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '演示表格使用',
			    width: 1202,
			    height: 500,
			    pageSize:3,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:100,checkbox:true}, 
					{field:'unittestid',title:'',width:0},
			        {field:'testproject',title:'测试项目',width:200},    
			        {field:'testunit',title:'测试单元',width:200},    
			        {
                        field: 'testtime', title: '测试时间', sortable: true,width:280,
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
			        {field:'result',title:'测试结果',width:100}, 
			        {field:'user',title:'测试人',width:100}, 
			        {field:'bak',title:'备注',width:250,align:'center'}    
			    ]],
			    singleSelect: false,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    pagination:true
			});
			
			dg.datagrid({ 
				url:url,	
			});
			dg.datagrid('hideColumn','unittestid');
	
			dg.datagrid("getPager").pagination({   
			    beforePageText: '第',  
			          afterPageText: '页    共 {pages} 页', 
			    displayMsg:"显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
			            });
			
		$("form").submit(function(e){
				    e.preventDefault();
				    $.ajax({
			            url: 'addunittest.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: $('#unittestform').serialize(),
			            success: function(msg) {
			               // alert(msg[1].id);
						$('#unittestdialog').dialog('close');
			  			 $("#center").load('toUnittest.do');
			            }
			        });     
		});
	
});
</script>

</head>
<body>	
		<div>
			<a id="add" href="#">添加</a>  
			<a id="del" href="#">删除</a> 
			<a id="sertch" href="#">查询</a> 
		</div>
		<table id="dg"></table>  
		
<div id="unittestdialog">
  <form id="unittestform">
    <input  name ="userid" type="text" style="display:none">
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">测试项目:</div>
			<input id="testproject" name ="testproject" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">测试单元:</div>
			<input id="testunit" type="text" name="testunit" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">测试结果:</div>
			<!-- <input id="result" type="text" style="width:300px"> -->
			<input id="result" name="result" value="通过" style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">测试时间:</div>
			<!-- <input id="testtime" type="text" style="width:300px"> -->
			<input id="testtime" type="text" name="testtime" style="width:300px"></input>  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">备注:</div>
			<input id="bak" type="text" name="bak" style="width:300px;height:100px">
		</div>
		
		<div style="margin-left: 20px; margin-top: 20px;padding-left:200px">
			 <a id="save" href="#">提交</a>
		</div>
			
	</form>

</div>

</body>
</html>