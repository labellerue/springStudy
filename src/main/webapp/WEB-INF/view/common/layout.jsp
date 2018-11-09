<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- tiles custom tag -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!-- header -->
<tiles:insertAttribute name="header"/>
<!-- left -->
<tiles:insertAttribute name="left"/>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<tiles:insertAttribute name="content"/>
			</div>
		</div>
	</div>
</body>
</html>