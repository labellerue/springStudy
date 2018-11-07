<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%-- left --%>
<%@ include file="/WEB-INF/view/common/left.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
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
										<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
							</table>
							
						</div>
						<a class="btn btn-default pull-right">사용자 등록</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
