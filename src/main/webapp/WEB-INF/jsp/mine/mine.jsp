<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">

	
$(document).ready(function(){
	
	
	
	/*Dialog上的控件*/

	$('#username').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left',
	    readonly:true
	});
	
	$('#jobnum').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left',
	    readonly:true
	});
	
	$('#password').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left',
	});
	
	$('#age').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#realname').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});
	
	$('#sex').combobox({    
	    url:'base/getsex.do',    
	    valueField:'id',    
	    textField:'text'   
	});
	
	$('#tel').textbox({      
	    iconCls:'icon-man',
	    iconAlign:'left'      
	});

	
	$('#departmentid').combobox({    
	    url:'department/department.do',    
	    valueField:'id',    
	    textField:'text'   
	});

	$('#save').linkbutton({    
	    iconCls: 'icon-save',   
	}).click(function(){
		var data=$('#userform').serialize();
	    $.ajax({
            url: 'mine/modifymine.do',
            type: 'post',//提交的方式
            dataType:'json',
            async:false,
            data: data,
            success: function(msg) {
            //alert(msg[0].result);
            $.messager.alert('Message','提交成功');
  			 $("#center").load('mine/tomine.do');
            }
        }); 

	});
	

	
	
	
	$.ajax({
			url : 'mine/getmine.do',
			type : 'post',//提交的方式
			dataType : 'json',
			async : false,
			success : function(msg) {
				//alert(msg.userid);
				$("#userid").val(msg.userid);
				$("#username").textbox('setValue',msg.username);
				$("#password").textbox('setValue',msg.password);
				$("#age").textbox('setValue',msg.age);
				$("#realname").textbox('setValue',msg.realname);
				$("#sex").combobox('setValue',msg.sex);
				$("#tel").textbox('setValue',msg.tel);
				$("#departmentid").combobox('setValue',msg.departmentid);
				return false;//防止提交两次
		}

	});
			
});
</script>

</head>
<body>		
<div id="userdialog">
  <form id="userform">
    <input  id ="userid" name ="userid" type="text" style="display:none">
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">用户名:</div>
			<input id="username" name ="username" type="text" style="width:300px">
		</div>
<!-- 		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">工号:</div>
			<input id="jobnum" name ="jobnum" type="text" style="width:300px">
		</div> -->
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">密码:</div>
			<input id="password" name ="password" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">年龄:</div>
			<input id="age" name ="age" type="text" style="width:300px">
		</div>
		
	    <div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">真实姓名:</div>
			<input id="realname" name ="realname" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">性别:</div>
			<input id="sex" name ="sex" type="text" style="width:300px">
		</div>
		
		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">电话:</div>
			<input id="tel" name ="tel" type="text" style="width:300px">
		</div>
		
<!-- 		<div style="margin-left:20px;margin-top:10px">
			<div class="testtitle">部门:</div>
			<input id="departmentid" name ="departmentid" type="text" style="width:300px">
		</div> -->

		<div style="margin-left: 20px; margin-top: 20px;padding-left:200px">
			 <a id="save" href="#">提交</a>
		</div>
			<!-- <a href="/oa/report/徐伟的周报.xls">压缩包</a>   -->
	</form>

</div>

</body>
</html>