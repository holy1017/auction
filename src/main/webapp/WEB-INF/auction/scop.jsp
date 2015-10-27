<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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