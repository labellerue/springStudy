<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax view</title>
<%@ include file="/WEB-INF/view/common/basicLib.jsp" %>
<script>
	$(document).ready(function(){
		
		var userVo = {userId:"brown", alias:"곰", name:"브라운", pass:"brownpass"};
		// 값 확인용
		// 자바스크립트 객체를 문자열로 변환 메소드: stringify
		$("#sendData").html(JSON.stringify(userVo)); // 문자열로 변환하여 html 형태로 넣어라
		
		$("#send").on("click", function(){
			$.ajax({
				contentType: "application/json;charset=utf-8",
				url: "/ajax/getRangers",
				type: "post",   		// @RequestBody 는 body를 보내기 때문에 post로 보냅니다.
				data: JSON.stringify(userVo),	//값을 json으로 보내기
				dataType: "json",
				success: function(dt){
					$("#result").html(JSON.stringify(dt));
				}
			});
		
		});
		
	});
</script>
</head>
<body>

<h2>ajax view</h2>
<button id="send" >전송</button> <br/>
전송 데이터: <span id="sendData"></span> <br/>
응답 결과 : <span id="result"></span> 



</body>
</html>




























