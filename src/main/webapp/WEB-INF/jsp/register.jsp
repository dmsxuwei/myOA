<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> -->

<title>login3</title>

<!-- Bootstrap -->
<link href="<%=basePath%>dist/css/bootstrap.min.css" rel="stylesheet">

<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>dist/js/bootstrap.min.js"></script>

    <style>
     body {background-image: url("<%=basePath%>img/index.jpg");}
    </style>
    <script type="text/javascript">

    </script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>

			<div class="col-md-4" >
				<form class="form-horizontal" role="form" action="register.do" style="margin:180px 0px">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">Username</label>
						<div class="col-sm-9">
							<input  class="form-control" id="inputEmail3" name="username"
								placeholder="Username"><!-- type="email" -->
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="inputPassword3" name="password"
								placeholder="Password">
						</div>
					</div>
					
<!-- 					<div class="form-group">
						<label  class="col-sm-3 control-label">realName</label>
						<div class="col-sm-9">
							<input  class="form-control"  name="realname" placeholder="Realname">
						</div>
					</div> -->
					
				
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<!-- <button type="submit" class="btn btn-default">Register</button> -->
						</div>
					</div> 
				</form>
			</div>
			<div class="col-md-4"></div>

		</div>
	</div>
</body>
</html>