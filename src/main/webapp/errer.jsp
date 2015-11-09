<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/test/getContextPath.jsp" %>
<div class="uk-grid">
	<div class="uk-width-1">
		<h1>에러 페이지-!</h1>
		<h1>param</h1>
		<c:forEach items="${param}" var="item">
			<p>${item.key}=${item.value}</p>
		</c:forEach>
		<h1>sessionScope</h1>
		<c:forEach items="${sessionScope}" var="item">
			<p>${item.key}=${item.value}</p>
		</c:forEach>

		<h1>requestScope</h1>
		<c:forEach items="${requestScope}" var="item">
			<p>${item.key}=${item.value}</p>
		</c:forEach>
		<h1>pageScope</h1>
		<c:forEach items="${pageScope}" var="item">
			<p>${item.key}=${item.value}</p>
		</c:forEach>
		<h1>applicationScope</h1>
		<c:forEach items="${applicationScope}" var="item">
			<p>${item.key}=${item.value}</p>
		</c:forEach>
	</div>
</div>