<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	
$(document).ready(function(){
	/*Dialog上的控件*/
	$('#rosoucename').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#addr').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#parentid').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	
$('#save').linkbutton({    
	    iconCls: 'icon-save',   
	}).unbind("click").click(function(){
		//alert($('#rolename').val());
		//$("#resourceform").submit();
		var data=$('#resourceform').serialize();
	    $.ajax({
            url: 'addResource.do',
            type: 'post',//提交的方式
            dataType:'json',
            async:false,
            data: data,
            success: function(msg) {
               // alert(msg[1].id);
                dialog.dialog({ 
					// closed: true,  
				});
  			 $("#center").load('toResources.do');
            }
        }); 
	    return false;//防止提交两次
	});
	
	
	$('#close').linkbutton({    
	    iconCls: 'icon-cancel',   
	}).unbind("click").click(function(){	
		$('#resourcedialog').hide();
	});
	
/*Dialog*/
	var dialog=$('#resourcedialog');
			$('#resourcedialog').dialog({    
			    title: 'My Dialog',    
			    width: 380,    
			    height: 300,    
			    closed: true,    
			    cache: false,    
			});
			

/*添加打开Dialog*/			
	$('#add').linkbutton({    
			    iconCls: 'icon-add'   
			}).unbind("click").click(function(){
				$('#resourcedialog').dialog('open');
			});
/*删除记录*/			
  $('#del').linkbutton({    
			    iconCls: 'icon-remove'   
			}).unbind("click").click(function(){
				   var selRows = $('#dg').datagrid('getChecked');  
				   // alert(selRows[0].unittestid);
				    $.ajax({
			            url: 'delResources.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: {id:selRows[0].resourceid},
			            success: function(msg) {
			               // alert(msg[0].result);
			               // location.reload("getUnittest.do");
			              $("#center").load('toResources.do');
			            }
			        }); 
			}); 
	
/*查询*/
$('#sertch').linkbutton({    
			    iconCls: 'icon-search'   
}); 
		

/*表格*/
var url='getResources.do';
			var dg=$('#dg');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '演示表格使用',
			    pageSize:3,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:100,checkbox:true}, 
					{field:'resourceid',title:'资源ID',width:0},
					{field:'resoucename',title:'资源名称',width:300},
					{field:'addr',title:'资源地址',width:400},
			        {field:'parentid',title:'资源父ID',width:200}		        
			    ]],
			    singleSelect: false,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    pagination:true
			});
			
			dg.datagrid({ 
				url:url,	
			});
			//dg.datagrid('hideColumn','roleid');
	
			dg.datagrid("getPager").pagination({   
			    beforePageText: '第',  
			          afterPageText: '页    共 {pages} 页', 
			    displayMsg:"显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
			            });
			
		$("form").submit(function(e){
				    e.preventDefault();
				    $.ajax({
			            url: 'addResource.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: $('#resourceform').serialize(),
			            success: function(msg) {
			               // alert(msg[1].id);
						$('#resourcedialog').dialog('close');
			  			 $("#center").load('toResources.do');
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
		<table id="dg" style="width:100%;height:95%"></table>  
		
<div id="resourcedialog">
  <form id="resourceform">
    <input  name ="userid" type="text" style="display:none">
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="">资源名称:</div>
			<input id="rosoucename" name ="rosoucename" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="">资源地址:</div>
			<input id="addr" name ="addr" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="">资源父ID:</div>
			<input id="parentid" name ="parentid" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="">是否叶子:</div>
			<input id="isend" name ="isend" type="text" style="width:300px">
		</div>
		
		<div style="margin-left: 20px; margin-top: 20px;padding-left:200px">
			 <a id="save" href="#">提交</a>
		</div>
			
	</form>

</div>

</body>
</html>