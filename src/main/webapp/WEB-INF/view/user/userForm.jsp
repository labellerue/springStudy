<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%-- left --%>
<%@ include file="/WEB-INF/view/common/left.jsp"%>
<!-- jquery UI css -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- 다음 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- jquery UI API -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function(){
		
	//개발 과정에서 사용할 기본 값 설정
	$("#userId").val();
	$("#pass").val("pass1234");
	$("#name").val("testUser");
	$("#addr1").val("대전 중구 중앙로 76 ");
	$("#addr2").val("영민빌딩 2층");
	$("#zip").val("34940");
	$("#birth").val("2018-10-12");
	$("#email").val("newUser@gmail.com");
	$("#tel").val("0422228202");
	
	
	//주소검색 버튼의 click event가 발생했을 시 실행
		$("#addrSearchBtn").click(function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					console.log(data);
					//주소 : roadAddress
					//상세주소 : ""
					//우편번호 : zonecode

					//주소 input value 설정: data.roadAddress
					//우편번호 input value 설정: data.zonecode
					$("#addr1").val(data.roadAddress);
					$("#zip").val(data.zonecode);
				}
			}).open();
		});

	//datePicker
		$(function() {
			$("#birth").datepicker({
				yearRange: "1930:2018",
				dateFormat: "yyyy-mm-dd",
				changeMonth : true,
				changeYear : true
			});
		});
		
		
	});
</script>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1><b>사용자 등록</b></h1>
				<br/>
				<div class="row">
					<!-- form -->
					<form class="form-horizontal" role="form" action="/user/userForm" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
							<div class="col-sm-10">
								<input type="file" name="profilePic" />
							</div>
						</div>
						<div class="form-group">
							<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디" >
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">비밀번호</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호" >
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">이름</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name" placeholder="이름">
							</div>
						</div>
						
						<div class="form-group">
							<label for="addr1" class="col-sm-2 control-label">주소</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addr1" name="addr1" readonly placeholder="주소">
								<!-- 주소 검색 버튼 -->
								<button type="button" id="addrSearchBtn" class="btn btn-default">주소검색</button>
							</div>
						</div>
						
						<div class="form-group">
							<label for="addr2" class="col-sm-2 control-label">상세주소</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소">
							</div>
						</div>
						
						<div class="form-group">
							<label for="zip" class="col-sm-2 control-label">우편번호</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="zip" name="zip" placeholder="우편번호">
							</div>
						</div>

						<div class="form-group">
							<label for="birth" class="col-sm-2 control-label">생년월일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일">
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">이메일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email" name="email" placeholder="이메일">
							</div>
						</div>
						
						<div class="form-group">
							<label for="tel" class="col-sm-2 control-label">연락처</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="tel" name="tel" placeholder="연락처">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">사용자 등록</button>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>