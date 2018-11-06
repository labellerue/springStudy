<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileuploadView</title>
</head>
<body>
<h2>fileupload</h2>

<form action="/mvc/fileupload" method="post" enctype="multipart/form-data">
	user : <input type="text" name="userId" value="brown"/>  <br/>
	<input type="file" name="uploadfile" multiple="multiple"/> <br/>
	<input type="submit" value="전송"/>  <br/>
</form>

</body>
</html>