<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<!-- html5 -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login</title>

<!-- Bootstrap -->
<link href="<%=basePath%>dist/css/bootstrap.min.css" rel="stylesheet">

<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>dist/js/bootstrap.min.js"></script>

<style>
<%-- .login_form {
	width: auto;
	height: auto;
	background-image: url("<%=basePath%>img/index.jpg");
}
 --%>

      <style type="text/css">
          *{margin:0;padding:0;}/*去掉页面样式*/
          body{color:white;}
          .content{
              background-color:pink;
             position:absolute;/*绝对定位*/
             top:50%;
             left:0;
             width:100%;
             height:400px;
             margin-top:-200px;
             overflow:hidden;/*隐藏滚动条*/
         }
         .main{
             text-align:center;/*文本居中*/
             max-width:600px;
             height:400px;
             padding:100px 0px;/*上下80px,左右为0*/
             /*background:yellow;*//*验证div的位置*/
             margin:0 auto;/*设置上右下左,居中显示*/
         }
         .main h1{
             font-family:"楷体";/*设置字体*/
             font-size:70px;/*设置字体大小*/
             font-weight:2px;/*调整字体粗细*/
         }
         form{
             padding:20px 0;
         }
         form input{
             border:1px solid white;
             display:block;
             margin:0px auto 10px auto;/*上 右  下 左*/
             padding:10px;
             width:220px;
             border-radius:30px;/*H5设置圆角边框*/
             font-size:18px;
             font-weight:300;
             text-align:center;
         }
         form input:hover{
             background-color:pink;
         }
         form button{
             background-color:yellow;
             border-radius:10px;
             border:0;
             height:30px;
             width:80px;
             padding:5px 10px;
             color:black;
         }
         form button:hover{
             background-color:red;
         }

</style>

<script type="text/javascript">
    $(document).ready(function(){
        $("#register").unbind("click").click(function(){
    		//alert(1);
    		 $(location).attr('href', 'index.do');
    });
        
    });

   
    	
    
    </script>

</head>
<body>
	<!-- <div class="container ">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8 login_form">
				<form class="form-horizontal" role="form" method="post" action="login.do" style="margin: 180px 0px">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">Username</label>
						<div class="col-sm-9">
							<input class="form-control" id="inputEmail3" name="username" placeholder="Username">
							type="email"
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="inputPassword3" name="password" placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<div class="checkbox">
								<label> <input type="checkbox"> Remember me
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-default">Sign in</button>
							<button type="button" id="register" class="btn btn-default">register</button>
						</div>
					</div>
				</form>
			</div>
			
			<div class="col-md-2"></div>

		</div>
	</div> -->
	
	<div class="content">    
     <div class="main">
         <h1>Welcome</h1>
         <form  method="post" action="login.do">
             <input type="text" name="username" placeholder="username"/>
             <input type="password" name="password" placeholder="password">
             <button type="submit">Sign In</button>
         </form>
     </div>
 </div>     
	
</body>
</html>