<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>no.</th>
					<th>아이디</th>
					<th>이름</th>
					<th>생일</th>
				</tr>

				<c:forEach items="${userList }" var="vo" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${vo.userId }</td>
						<td>${vo.name }</td>
						<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<a class="btn btn-default pull-right">사용자 등록</a>
	</div>
</div>
