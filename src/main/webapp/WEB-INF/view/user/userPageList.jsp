<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header --%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%-- left --%>
<%@ include file="/WEB-INF/view/common/left.jsp"%>
<style type="text/css">
	.userClick {
		cursor : pointer;
	}
</style>
<script type="text/javascript">

	function al(user){
		document.location="/userDetail?userId="+user;
	}
	
	$(document).ready(function(){
		console.log("document.ready");
		
		//tr에 select (class="userClick")
		$(".userClick").on("click", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerHTML;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
		
	});
</script>

<!-- hidden으로 form을 넣는 것은 실무에서도 사용합니다! -->
<form action="/user/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name="userId"/>
</form>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>no.</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생일</th>
								</tr>

								<c:forEach items="${pageList }" var="vo" >
									<tr class="userClick">
										<td>${vo.rnum }</td>
										<td>${vo.userId }</td>
										<td>${vo.name }</td>
										<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</table>

						</div>
						<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>
						<!-- get으로 넘어갑니다. -->
						<div class="text-center">
							<ul class="pagination">
								<li><a href="/user/userPageList?page=1&pageSize=10"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
									
								<c:forEach begin="1" end="${pageCnt}" var="pageNum">
									<li><a href="/user/userPageList?page=${pageNum }&pageSize=10">${pageNum }</a></li>
								</c:forEach>

								<li>
								<a href="/user/userPageList?page=${pageCnt }&pageSize=10" aria-label="Next"> 
								<span aria-hidden="true">&raquo;</span></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>