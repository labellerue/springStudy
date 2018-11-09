<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- jquery UI css -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- 다음 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- jquery UI API -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function(){
		
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
			//$("#birth").val("");
			$("#birth").datepicker({
				yearRange: "1930:2018",
				dateFormat: "yy-mm-dd",
				changeMonth : true,
				changeYear : true
			});
		});
		
	});
</script>

<div class="row">
	<!-- form -->
	<form class="form-horizontal" role="form" action="/user/userUpdate"
		method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
			<div class="col-sm-10">
				<c:choose>
					<c:when test="${userDetail.profile == null }">
						<img src="/profile/noimage.png" width="216" />
					</c:when>
					<c:otherwise>
						<img src="${userDetail.profile }" width="216" />
					</c:otherwise>
				</c:choose>
				<input type="file" name="profilePic" />
			</div>
		</div>
		<div class="form-group">
			<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userId" name="userId"
					readonly placeholder="사용자 아이디" value="${userDetail.userId }">
			</div>
		</div>

		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pass" name="pass"
					placeholder="사용자 아이디" value="${userDetail.pass }">
			</div>
		</div>

		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" name="name"
					placeholder="이름" value="${userDetail.name }">
			</div>
		</div>

		<div class="form-group">
			<label for="addr1" class="col-sm-2 control-label">주소</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="addr1" name="addr1"
					readonly placeholder="주소" value="${userDetail.addr1 }">
				<!-- 주소 검색 버튼 -->
				<button type="button" id="addrSearchBtn" class="btn btn-default">주소검색</button>
			</div>
		</div>

		<div class="form-group">
			<label for="addr2" class="col-sm-2 control-label">상세주소</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="addr2" name="addr2"
					placeholder="상세주소" value="${userDetail.addr2 }">
			</div>
		</div>

		<div class="form-group">
			<label for="zip" class="col-sm-2 control-label">우편번호</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="zip" name="zip"
					placeholder="우편번호" value="${userDetail.zip }">
			</div>
		</div>

		<div class="form-group">
			<label for="birth" class="col-sm-2 control-label">생년월일</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="birth" name="birth"
					placeholder="생년월일"
					value="<fmt:formatDate value="${userDetail.birth }" pattern="yyyy-MM-dd" />">
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">이메일</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="email" name="email"
					placeholder="이메일" value="${userDetail.email }">
			</div>
		</div>

		<div class="form-group">
			<label for="tel" class="col-sm-2 control-label">연락처</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="tel" name="tel"
					placeholder="연락처" value="${userDetail.tel }">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="수정완료">
			</div>
		</div>
	</form>

</div>











