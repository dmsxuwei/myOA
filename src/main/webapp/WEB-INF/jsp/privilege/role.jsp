<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	
$(document).ready(function(){
	/*Dialog*/
var dialog=$('#roledialog');
/*Dialog上的控件*/
	$('#rolename').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	/*添加角色*/	
/*添加角色*/	
$('#save').linkbutton({    
	    iconCls: 'icon-save' 
	}).unbind("click").click(function(){
		//alert($('#rolename').val());
		var data=$('#roleform').serialize();
	    $.ajax({
            url: 'addRole.do',
            type: 'post',//提交的方式
            dataType:'json',
            async:false,
            data: data,
            success: function(msg) {
            	$('#roledialog').dialog({ 
					// closed: true,  
				});
  			 $("#center").load('toRole.do');
            }
        }); 
	    return false;//防止提交两次
});
	

$('#roledialog').dialog({    
    title: 'My Dialog',    
    width: 380,    
    height: 180,    
    closed: true,    
    cache: false,    
});	

/*角色添加资源*/	
 $('#saveresource').unbind("click").click(function(){
	   //alert(selRows[0].userid);
	   var roletbselRows = $('#dg').datagrid('getChecked'); 
	  // alert(roletbselRows[0].roleid);
	   var roledataString = '[';//3,4];
	   //alert(roletbselRows.length);
	   for(var i=0;i<roletbselRows.length;i++){
		  if(i==roletbselRows.length-1) {
			  roledataString+=(roletbselRows[i].roleid);			 
		  }else{
			  roledataString+=(roletbselRows[i].roleid+",");
		  }
	   }
	   roledataString+=']';
	 //alert(roledataString);

		   //alert(selRows[0].userid);
		   var resourcetbselRows = $('#addresourcetb').datagrid('getChecked'); 
		  // alert(roletbselRows[0].roleid);
		   var dataString = '[';//3,4];
		  // alert(resourcetbselRows.length);
		   for(var i=0;i<resourcetbselRows.length;i++){
			  if(i==resourcetbselRows.length-1) {
				  dataString+=(resourcetbselRows[i].resourceid);			 
			  }else{
				  dataString+=(resourcetbselRows[i].resourceid+",");
			  }
		   }
		   dataString+=']';
		   
		   
		//alert(dataString+'');
		//var jsonString = JSON.stringify(dataString);
		  // var json={id:selRows[0].roleid,ids:dataString};
			var json = {
					roleids : roledataString,
					resourceids : dataString
				};
			
		   $.ajax({
	            url: 'RoleAddResource.do',
	            type: 'post',//提交的方式
	            dataType:'json',
	            async:false,
	            //contentType:"application/json",
	            data: json,
	            success: function(msg) {
	               // alert(msg[0].result);
	               // location.reload("getUnittest.do");
	             // $("#center").load('toUnittest.do');
	            	var selRows = $('#dg').datagrid('getChecked');
					var roleid=selRows[0].roleid;
					$('#addresourcetb').datagrid('reload',{
						roleid: roleid
					});
					$('#removeresourcetb').datagrid('reload',{
						roleid: roleid
					});
	            }
	        }); 
		   
		   
	   });

 /*删除角色下的资源*/
 $('#removeresource').unbind("click").click(function(){
	   //alert(selRows[0].userid);
	   var roletbselRows = $('#dg').datagrid('getChecked'); 
	  // alert(roletbselRows[0].roleid);
	   var roledataString = '[';//3,4];
	   //alert(roletbselRows.length);
	   for(var i=0;i<roletbselRows.length;i++){
		  if(i==roletbselRows.length-1) {
			  roledataString+=(roletbselRows[i].roleid);			 
		  }else{
			  roledataString+=(roletbselRows[i].roleid+",");
		  }
	   }
	   roledataString+=']';
	// alert(roledataString);

		   //alert(selRows[0].userid);
		   var resourcetbselRows = $('#removeresourcetb').datagrid('getChecked'); 
		  // alert(roletbselRows[0].roleid);
		   var dataString = '[';//3,4];
		   //alert(resourcetbselRows.length);
		   for(var i=0;i<resourcetbselRows.length;i++){
			  if(i==resourcetbselRows.length-1) {
				  dataString+=(resourcetbselRows[i].resourceid);			 
			  }else{
				  dataString+=(resourcetbselRows[i].resourceid+",");
			  }
		   }
		   dataString+=']';
		   
		   
		//alert(dataString+'');
		//var jsonString = JSON.stringify(dataString);
		  // var json={id:selRows[0].roleid,ids:dataString};
			var json = {
					roleids : roledataString,
					resourceids : dataString
				};
			
		   $.ajax({
	            url: 'RoleRemoveResource.do',
	            type: 'post',//提交的方式
	            dataType:'json',
	            async:false,
	            //contentType:"application/json",
	            data: json,
	            success: function(msg) {
	               // alert(msg[0].result);
	               // location.reload("getUnittest.do");
	             // $("#center").load('toUnittest.do');
	            	var selRows = $('#dg').datagrid('getChecked');
					var roleid=selRows[0].roleid;
					$('#addresourcetb').datagrid('reload',{
						roleid: roleid
					});
					$('#removeresourcetb').datagrid('reload',{
						roleid: roleid
					});
	             
	            }
	        }); 
		   
		   
	   });
	   

	
	

			

/*添加打开Dialog*/			
$('#add').linkbutton({    
			    iconCls: 'icon-add'   
			}).unbind("click").click(function(){
				$('#roledialog').dialog('open');
		});
			

/*Dialog*/
var dialog=$('#addresourcedialog');
			$('#addresourcedialog').dialog({    
			    title: '角色资源管理',    
			    width: 750,    
			    height: 550,    
			    closed: true,    
			    cache: false,    
			});


	$('#saveresource').linkbutton({    
			    iconCls: 'icon-add'   
	});
			
	$('#removeresource').linkbutton({    
	    iconCls: 'icon-remove'   
});
	
/*添加角色*/
	$('#addresource').linkbutton({    
	    iconCls: 'icon-add'   
	}).unbind("click").click(function(){
		 var selRows = $('#dg').datagrid('getChecked');  
		   if(selRows[0]==null){		   
			   alert('请选择角色！');
			   return;
		   }
	/*取角色下可添加的资源*/	   
	var roleid=selRows[0].roleid;
	var url = "getremoveResources.do?roleid=" + roleid;
			var dg=$('#addresourcetb');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '可增加资源列表',
			    width: 355,
			    height: 450,
			    pageSize:3,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:60,checkbox:true}, 
					{field:'resourceid',title:'资源ID',width:0},
					{field:'resoucename',title:'资源名称',width:90},
					{field:'addr',title:'资源地址',width:155},
			        //{field:'parentid',title:'资源父ID',width:200}		        
			    ]],
			    singleSelect: false,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    //pagination:true
			});
			
			dg.datagrid({ 
				url:url,	
			});
			
	/*取角色下可删除的资源*/	
	var roleid=selRows[0].roleid;
	var url = "getAddResources.do?roleid=" + roleid;
			var dg=$('#removeresourcetb');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '已存在资源列表',
			    width: 355,
			    height: 450,
			    pageSize:3,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:60,checkbox:true}, 
					{field:'resourceid',title:'资源ID',width:0},
					{field:'resoucename',title:'资源名称',width:90},
					{field:'addr',title:'资源地址',width:155},
			        //{field:'parentid',title:'资源父ID',width:200}		        
			    ]],
			    singleSelect: false,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    //pagination:true
			});
			
			dg.datagrid({ 
				url:url,	
			});
			
		  $('#addresourcedialog').dialog('open');
		  
		  

		  
		   
	});
	
/* 	$('#delresource').linkbutton({    
	    iconCls: 'icon-remove'   
	}).unbind("click").click(function(){
		//$('#roledialog').dialog('open');
	}); */
	
/*删除记录*/			
  $('#del').linkbutton({    
			    iconCls: 'icon-remove'   
			}).unbind("click").click(function(){
				   var selRows = $('#dg').datagrid('getChecked');  
				   // alert(selRows[0].unittestid);
				    $.ajax({
			            url: 'delRole.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: {id:selRows[0].roleid},
			            success: function(msg) {
			               // alert(msg[0].result);
			               // location.reload("getUnittest.do");
			              $("#center").load('toRole.do');
			            }
			        }); 
			}); 
	

		

/*表格*/
var url='getRole.do';
			var dg=$('#dg');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '演示表格使用',
			    pageSize:3,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			    columns:[[   
					{field:'ck',width:100,checkbox:true}, 
					{field:'roleid',title:'',width:0},
			        {field:'rolename',title:'用户名',width:200}		        
			    ]],
			    singleSelect: true,
			    selectOnCheck: true,
			    checkOnSelect: true,
			    pagination:true
			});
			
			dg.datagrid({ 
				url:url,	
			});
			dg.datagrid('hideColumn','roleid');
	
			dg.datagrid("getPager").pagination({   
			    beforePageText: '第',  
			          afterPageText: '页    共 {pages} 页', 
			    displayMsg:"显示 {from} 到 {to} 条记录 ,  共 {total} 条记录"
			            });
			
		$("form").submit(function(e){
				    e.preventDefault();
				    $.ajax({
			            url: 'addRole.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: $('#roleform').serialize(),
			            success: function(msg) {
			               // alert(msg[1].id);
						$('#roledialog').dialog('close');
			  			 $("#center").load('toRole.do');
			            }
			        });     
		});
	
});
</script>

</head>
<body>	
		<div>
			<a id="add" href="#">添加</a>  
			<a id="addresource" href="#">角色资源</a> 
			<a id="del" href="#">删除</a> 
			<!-- <a id="delresource" href="#">删除资源</a>  -->
		</div>
		<table id="dg" style="width:100%;height:95%"></table>  
		
<div id="roledialog">
  <form id="roleform">
    <input  name ="userid" type="text" style="display:none">
		<div style="margin-left:20px;margin-top:10px">
			<div class="">角色名称:</div>
			<input id="rolename" name ="rolename" type="text" style="width:300px">
		</div>
		
		<div style="margin-left: 20px; margin-top: 20px;padding-left:200px">
			 <a id="save" href="#">提交</a>
		</div>			
	</form>

</div>


<div id="addresourcedialog">
	<div style="float:left"><table id="addresourcetb"></table></div>
	<div><table id="removeresourcetb"></table></div>
	<a id="saveresource" style="margin-left:50px;margin-top:15px" href="#">添加资源</a> 
	<a id="removeresource" style="margin-left:300px;margin-top:15px" href="#">删除资源</a> 
</div>


</body>
</html>