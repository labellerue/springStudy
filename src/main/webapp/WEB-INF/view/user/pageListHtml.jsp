<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${pageList }" var="userVo">
	<tr class="userClick">
		<td>${userVo.rnum }</td>
		<td>${userVo.userId }</td>
		<td>${userVo.name }</td>
		<td><fmt:formatDate value="${userVo.birth }" pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>