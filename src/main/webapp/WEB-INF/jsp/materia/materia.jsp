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
	
    function doSearch(){
    	//alert(1);
    	$('#materiatb').datagrid('load',{
    		//alert(1);
    		mat_id_search: $('#mat_id_search').val(),
    		name_search: $('#name_search').val(),
    		addr_search: $('#addr_search').val(),
    		manage_search: $('#manage_search').val(),
    		isout_search: $('#isout_search').val(),
    		//productid: $('#productid').val()
    	});
    }
    
$(document).ready(function(){
	/*Dialog上的控件*/	
    $('#mat_id').combobox({    
	    url:'getMat.do',    
	    valueField:'id',    
	    textField:'text'   
	});
	
    $('#modifymat_id').combobox({    
	    url:'getMat.do',    
	    valueField:'id',    
	    textField:'text'   
	});
    
	$('#name').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#modifyname').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#number').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#modifynumber').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#count').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#modifycount').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#addr').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#modifyaddr').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#manage').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#modifymanage').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
/*     $('#isout').combobox({    
	    url:'result.do',    
	    valueField:'id',    
	    textField:'text'   
	}); */
    
    $('#modifyisout').combobox({    
	    url:'base/yesorno.do',    
	    valueField:'id',    
	    textField:'text'   
	});
	
	
	$('#price').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#modifyprice').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#warehousingtime').datetimebox({    
	   // value: '3/4/2016 2:3',    
	    required: true,    
	    showSeconds: false   
	});
	
	$('#modifywarehousingtime').datetimebox({    
		   // value: '3/4/2016 2:3',    
		    required: true,    
		    showSeconds: false   
		});
	
	$('#modifyouttime').datetimebox({    
		   // value: '3/4/2016 2:3',    
		    required: true,    
		    showSeconds: false   
		})
	
	$('#modifyouttime').datetimebox('setValue', formatterDate(new Date()));
	
	$('#warehousingtime').datetimebox('setValue', formatterDate(new Date()));
	
	$('#modifysave').linkbutton({    
	    iconCls: 'icon-save',   
	});
	
	
	$('#save').linkbutton({    
	    iconCls: 'icon-save',   
	}).unbind("click").click(function(){
		//alert($('#testproject').val());
		//$("#materiaform").submit();
		var data=$('#materiaform').serialize();
	    $.ajax({
            url: 'addmateria.do',
            type: 'post',//提交的方式
            dataType:'json',
            async:false,
            data: data,
            success: function(msg) {
               // alert(msg[1].id);
                dialog.dialog({ 
					// closed: true,  
				});
  			 $("#center").load('toMateria.do');
            }
        }); 
	    return false;//防止提交两次
	});
	
/*Dialog*/
	var dialog=$('#materiadialog');
			$('#materiadialog').dialog({    
			    title: 'My Dialog',    
			    width: 380,    
			    height: 520,    
			    closed: true,    
			    cache: false,    
			});
			

/*添加打开Dialog*/			
$('#add').linkbutton({    
			    iconCls: 'icon-add'   
			}).unbind("click").click(function(){
				$('#materiadialog').dialog('open');
			});
	

var materiamodifydialog=$('#materiamodifydialog');
	$('#materiamodifydialog').dialog({    
	    title: 'My Dialog',    
	    width: 380,    
	    height: 580,    
	    closed: true,    
	    cache: false,    
	});
	
	$('#modify').linkbutton({    
	    iconCls: 'icon-edit'   
	}).unbind("click").click(function(){
		 var selRows = $('#materiatb').datagrid('getChecked');  
		 //alert(selRows[0].id);
		 $("#modifymat_id").combobox('setValue',selRows[0].mat_id);
		 $('#modifyname').textbox('setValue',selRows[0].name);
		 $('#modifynumber').textbox('setValue',selRows[0].number);
		 $('#modifycount').textbox('setValue',selRows[0].count);
		 $('#modifyaddr').textbox('setValue',selRows[0].addr);
		 $('#modifymanage').textbox('setValue',selRows[0].manage);
		 $('#modifyprice').textbox('setValue',selRows[0].price);
		 $('#modifywarehousingtime').datetimebox('setValue', selRows[0].warehousingtime);
		$('#materiamodifydialog').dialog('open');
	});		
				
/*删除记录*/			
  $('#del').linkbutton({    
			    iconCls: 'icon-remove'   
			}).unbind("click").click(function(){
				   var selRows = $('#materiatb').datagrid('getChecked');  
				   // alert(selRows[0].unittestid);
				    $.ajax({
			            url: 'delMateria.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: {id:selRows[0].id},
			            success: function(msg) {
			               // alert(msg[0].result);
			               // location.reload("getUnittest.do");
			              $("#center").load('toMateria.do');
			            }
			        }); 
			}); 
	
/*查询*/
$('#sertch').linkbutton({    
			    iconCls: 'icon-search'   
}); 
		

/*表格*/
var url='getMateria.do';
			var dg=$('#materiatb');
			dg.datagrid({    
			    //url:'getGrid.do',    
			    title: '演示表格使用',
			    width: 1202,
			    height: 500,
			    pageSize:6,        //设置默认分页大小
	            pageList:[3,6,9,12,15],   //设置分页大小
			    rownumbers: true,
			  					 	
		    columns:[[   
					{field:'ck',width:100,checkbox:true}, 
					{field:'id',title:'',width:0},
					{field:'mat_id',title:'物料分类',width:100,sortable: true,},
			        {field:'name',title:'物料名称',width:180}, 
			        {field:'number',title:'物料编号',width:100}, 
			        {field:'count',title:'数量',width:50},    
			        {
                        field: 'warehousingtime', title: '入库时间', sortable: true,width:150,
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
			        {field:'addr',title:'存放地点',width:170}, 
			        {field:'manage',title:'保管员',width:80,editor:'text'}, 
			        {field:'isout',title:'是否已出货',width:80}, 
			        {
                        field: 'outtime', title: '出货时间', sortable: true,width:150,
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
                            if(year=='NaN'){
                            	//alert(year);
                            	return "";
                            }
                            return year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;
                        }
                    },			 	 
			       // {field:'iscompose',title:'是否全成品',width:80}, 
			       // {field:'composeid',title:'合成物料ID',width:100}, 
			        {field:'price',title:'价格',width:80,align:'center',editor:'numberbox'}    
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
			
		$("form").submit(function(e){
				    e.preventDefault();
				    $.ajax({
			            url: 'addmateria.do',
			            type: 'post',//提交的方式
			            dataType:'json',
			            async:false,
			            data: $('#materiaform').serialize(),
			            success: function(msg) {
			               // alert(msg[1].id);
						$('#materiadialog').dialog('close');
			  			 $("#center").load('toMateria.do');
			            }
			        });     
		});
		
/*搜索*/		
		 $('#mat_id_search').combobox({    
			    url:'getMat.do',    
			    valueField:'id',    
			    textField:'text'   
			});
			
		    $('#isout_search').combobox({    
			    url:'base/yesorno.do',    
			    valueField:'id',    
			    textField:'text'   
			});
		    

	
});
</script>

</head>
<body>	
		<div>
			<a id="add" href="#">添加</a>  
			<a id="del" href="#">删除</a> 
			<a id="modify" href="#">修改</a> 
			<div style="float:right;margin-right:50px;magrin-top:3px;">
			<span style="color:#666;magrin-left:20px">物料分类:</span><input id="mat_id_search" name="mat_id_search"  value="" style="width:100px">
			<span style="color:#666;magrin-left:20px">物料名称:</span><input id="name_search" name="name_search"  value="" style="width:100px">
			<span style="color:#666;magrin-left:20px">存放地点:</span><input id="addr_search" name="addr_search"  value="" style="width:100px">  
			<span style="color:#666;magrin-left:20px">保管员:</span><input id="manage_search" name="manage_search"  value="" style="width:100px"> 
			<span style="color:#666;magrin-left:20px">是否出货:</span><input id="isout_search" name="isout_search"  value="" style="width:50px">   
			<a id="sertch" href="#" onclick="doSearch()">查询</a> 
			</div>
		</div>
		<table id="materiatb"></table>  
		
<div id="materiadialog">
  <form id="materiaform">
    <input  name ="userid" type="text" style="display:none">
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">物料分类:</div>
			<input id="mat_id" name ="mat_id" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">物料名称:</div>
			<input id="name" type="text" name="name" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">物料编号:</div>
			<input id="number" name="number"  style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">数量:</div>
			<input id="count" name="count"  value="1" style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">存放地点:</div>
			<input id=addr name="addr"  style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">保管员:</div>
			<input id="manage" name="manage"  style="width:300px">  
		</div>
		
<!-- 		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">是否已出货:</div>
			<input id="isout" name="isout"  style="width:300px">  
		</div> -->
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">价格:</div>
			<input id="price" name="price"  style="width:300px">  
		</div>
		
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">入库日期:</div>
			<!-- <input id="testtime" type="text" style="width:300px"> -->
			<input id="warehousingtime" type="text" name="warehousingtime" style="width:300px"></input>  
		</div>
		
		<div style="margin-left: 20px; margin-top: 20px;padding-left:200px">
			 <a id="save" href="#">提交</a>
		</div>
			
	</form>

</div>



<div id="materiamodifydialog">
  <form id="materiamodifyform">
    <input  name ="modifyuserid" type="text" style="display:none">
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">物料分类:</div>
			<input id="modifymat_id" name ="modifymat_id" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">物料名称:</div>
			<input id="modifyname" type="text" name="modifyname" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">物料编号:</div>
			<input id="modifynumber" name="modifyumber"  style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">数量:</div>
			<input id="modifycount" name="modifycount"  value="1" style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">存放地点:</div>
			<input id="modifyaddr" name="modifyaddr"  style="width:300px">  
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">保管员:</div>
			<input id="modifymanage" name="modifymanage"  style="width:300px">  
		</div>
		
 		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">是否出货:</div>
			<input id="modifyisout" name="modifyisout"  style="width:300px">  
		</div>

	    <div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">入库日期:</div>
			<input id="modifywarehousingtime" type="text" name="modifywarehousingtime" style="width:300px"></input>  
		</div> 
		
	     <div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">出货日期:</div>
			<input id="modifyouttime" type="text" name="modifyouttime" style="width:300px"></input>  
		</div> 
		
				<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">价格:</div>
			<input id="modifyprice" name="modifyprice"  style="width:300px">  
		</div>
		
		<div style="margin-left: 20px; margin-top: 20px;padding-left:200px">
			 <a id="modifysave" href="#">提交</a>
		</div>
			
	</form>

</div>



</body>
</html>