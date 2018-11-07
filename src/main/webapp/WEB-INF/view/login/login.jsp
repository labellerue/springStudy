<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>로그인 화면</title>
<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/signin.css" rel="stylesheet">
<%@include file="/WEB-INF/view/common/basicLib.jsp"%>

</head>

<body class="text-center">
	<div class="container">
		<form class="form-signin" action="/user/loginProcess" method="post">
			<h1 class="h3 mb-3 font-weight-bold font-italic">Belle Board</h1>
			<br />
			<br />
			<!-- ID -->
			<label for="inputID" class="sr-only">ID</label>
			<input type="text" name="userId" id="userId" class="form-control" placeholder="your ID" value="brown" required autofocus> 
			<!-- PASSWORD -->
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" value="brownpass" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" id="remember-me" name="remember-me" value="remember-me"> Remember me </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2018. SoHyoung Lee all
				rights reserved.</p>
		</form>
	</div>
</body>
</html>

