<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result.jsp</title>
</head>
<body>

result.jsp<br/>
검증 통과예요~~ <br/>

userId :	${userVo.userId } <br/>
name :		${userVo.name } <br/>
pass :		${userVo.pass } <br/>

<h2>view.jsp -jsr303</h2>
userId :	${userVoJsr303.userId } <br/>
name :		${userVoJsr303.name } <br/>
pass :		${userVoJsr303.pass } <br/>

</body>
</html>