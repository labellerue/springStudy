<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		$("#userList").on("click", ".userClick", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerHTML;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
		//getUserList(1);
		getUserListHtml(1); // userList html로 리턴해주는 함수
		getUserPagenationHtml(1); //해당 페이지의 페이지네이션 정보를 리턴해주는 함수
		
	});
	
	<%-- 유저 리스트 처리 --%>
	function getUserListHtml(page){
		var pageSize = 10;
		
		$.ajax({
			url: "/user/userPageListAjaxHtml",
			type: "get",
			data: "page="+page+"&pageSize="+pageSize,
			success: function(dt){
				$("#userList").html(dt);
				
			}
		});
	}
	<%-- 페이징 처리 --%>
	function getUserPagenationHtml(page){
		var pageSize = 10;
		
		$.ajax({
			url: "/user/userPagenationHtml",
			type: "get",
			data: "page="+page+"&pageSize="+pageSize,
			success: function(dt){
				$(".pagination").html(dt);
				
			}
		});
		
	}
	
	<%-- 유저 리스트 처리 --%>
	//page 인자를 받아서
	//해당 페이지에 속하는 사용자 리스트 정보를 가져온다.
	function getUserList(page){
		var pageSize = 10;
		console.log("page: "+ page);
		// ajax call
		// 사용자 리스트 데이터만 가져오기
		// html --> json 데이터를 받는 형태로 변경 (기존 방식)
		$.ajax({
			type: "GET",
			url : "/user/userPageListAjax",
			data : "page="+page+"&pageSize="+pageSize,			
			success : function(datadata){ //datadata는 아작스!!!!!!!!!! userservice에서 
				//data(사용자 json 데이터)를 바탕으로 사용자 리스트 갱신
				//1. 기존 리스트를 삭제
				//2. data를 이용하여 table 태그(tr)를 작성
				//3. 기존 리스트 위치에 붙여넣기
				var html = "";
				$.each(datadata.pageList, function(idx, user){
					console.log(user);
					html += "<tr class='userClick'>";
					html += "	<td>"+ user.rnum + "</td>";
					html += "	<td>"+ user.userId + "</td>";
					html += "	<td>"+ user.name + "</td>";
					html += "	<td>"+ user.formatBirth + "</td>";
					html += "</tr>";
				});
				
				<%-- 페이징 처리 --%>
				var pagination = "<li><a href='javascript:getUserList(1);'";
				pagination +=" aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>";
				
				for(var i=1 ; i<datadata.pageCnt+1 ; i++){
					pagination += "<li><a href='javascript:getUserList("+i+");'>"+i+"</a></li>";
				}
				
				pagination += "<li><a href='javascript:getUserList("+datadata.pageCnt+");'";
				pagination += " aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>";
				
				$("#pagination").html(pagination);
				<%-- 페이징 처리 --%>
				
				
				$("#userList").html(html);
				
			}
		});
		<%-- 유저 리스트 처리 --%>
		
		
	}
</script>

<!-- hidden으로 form을 넣는 것은 실무에서도 사용합니다! -->
<form action="/user/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name="userId"/>
</form>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>no.</th>
						<th>아이디</th>
						<th>이름</th>
						<th>생일</th>
					</tr>
				</thead>

				<tbody id="userList">
					<!-- ajax로 처리 -->
				</tbody>
			</table>

		</div>
		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>
		<!-- get으로 넘어갑니다. -->
		<div class="text-center">
			<ul class="pagination" id="pagination">
				<!-- ajax로 처리 -->
			</ul>
		</div>
	</div>
</div>







