<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messageView</title>
</head>
<body>

messageView <br/>
<%-- <spring:argument value="brown"/> --%>
hello :  <spring:message code="hello"/><br/>
visitor : <spring:message code="visitor" arguments="brown, sally"/> <br/>

<form action="/messageView" method="post" id="frm">
<select name="lang" id="lang">
	<option value="ko" ${lang == "ko" ? "selected":"" }>한국어</option>
 	<option value="en" ${lang == "en" ? "selected":"" }>English</option>
 	<option value="ja" ${lang == "ja" ? "selected":"" }>日本語</option>
</select>
<input type="submit" value="전송"/> <br/>
</form>






</body>
</html>