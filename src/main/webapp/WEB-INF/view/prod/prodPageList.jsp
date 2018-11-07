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

	$(document).ready(function(){
		console.log("document.ready");
		
		//tr에 select (class="userClick")
		$(".prodClick").on("click", function(){
			console.log("prodClick");
			var prod_id = $(this).children()[1].innerHTML;
			
			$("#prod_id").val(prod_id);
			$("#frm").submit();
		});
		
	});
</script>

<!-- hidden으로 form을 넣는 것은 실무에서도 사용합니다! -->
<form action="/prod/prodDetail" method="get" id="frm">
	<input type="hidden" id="prod_id" name="prod_id"/>
</form>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>no.</th>
									<th>제품 아이디</th>
									<th>제품명</th>
									<th>제품그룹명</th>
									<th>제품등록일</th>
								</tr>

								<c:forEach items="${prodPageList }" var="prod" >
									<tr class="prodClick">
										<td>${prod.rnum }</td>
										<td>${prod.prod_id }</td>
										<td>${prod.prod_name }</td>
										<td>${prod.lprod_nm }</td>
										<td><fmt:formatDate value="${prod.prod_insdate }" pattern="yyyy/MM/dd" /></td>
									</tr>
								</c:forEach>
							</table>

						</div>
						<a class="btn btn-default pull-right" href="#">제품 등록</a>
						<!-- get으로 넘어갑니다. -->
						<div class="text-center">
							<ul class="pagination">
								<li><a href="/prod/prodPageList?page=1&pageSize=10"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
									
								<c:forEach begin="1" end="${prodPageCnt}" var="pageNum">
									<li><a href="/prod/prodPageList?page=${pageNum }&pageSize=10">${pageNum }</a></li>
								</c:forEach>

								<li>
								<a href="/prod/prodPageList?page=${prodPageCnt }&pageSize=10" aria-label="Next"> 
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