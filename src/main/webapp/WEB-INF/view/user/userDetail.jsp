<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
	<!-- form -->
	<form class="form-horizontal" role="form" action="/user/userUpdate"
		method="get">
		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
			<div class="col-sm-10">
				<c:choose>
					<c:when test="${userDetail.profile == null }">
						<img src="/profile/noimage.png" width="216" />
					</c:when>
					<c:otherwise>
						<img src="${userDetail.profile }" width="216" />
						<!-- 다운로드
									<img src="/fileDownload?userId=${userDetail.userId }" width="216" />
								 	-->
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.userId }</label>
			</div>
		</div>

		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">이름</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.name }</label>
			</div>
		</div>

		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">주소</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.addr1 }</label>
			</div>
		</div>

		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">상세주소</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.addr2 }</label>
			</div>
		</div>

		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">우편번호</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.zip }</label>
			</div>
		</div>

		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">생년월일</label>
			<div class="col-sm-10">
				<label class="control-label"><fmt:formatDate
						value="${userDetail.birth }" pattern="yyyy-MM-dd" /></label>
			</div>
		</div>

		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">이메일</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.email }</label>
			</div>
		</div>

		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">연락처</label>
			<div class="col-sm-10">
				<label class="control-label">${userDetail.tel }</label>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a class="btn btn-default"
					href="/user/userUpdate?userId=${userDetail.userId }">정보 수정</a>
			</div>
		</div>
	</form>
	<form action="/fileDownloadName" method="get">
		<button type="submit">다운로드 받기</button>
	</form>

</div>
