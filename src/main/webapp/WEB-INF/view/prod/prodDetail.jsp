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
						<div class="form-group">
						
							<label for="userNm" class="col-sm-2 control-label">제품아이디</label>
							<div class="col-sm-10">
								<label class="control-label" >${prodDetail.prod_id }</label>
							</div>
						</div>

						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품명</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.prod_name }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">제품그룹명</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.lprod_nm }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">바이어이름</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.buyer_name }</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">바이어 이메일</label>
							<div class="col-sm-10">
								<label class="control-label">${prodDetail.buyer_mail }</label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a class="btn btn-default" href="/prod/prodUpdate?prod_id=${prodDetail.prod_id }" >정보 수정</a>
							</div>
						</div>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>