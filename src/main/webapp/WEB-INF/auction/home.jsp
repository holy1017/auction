<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false"%> --%>
<html>
<head>
<title>Home</title>
</head>
<body>
<%@ include file="/test/getContextPath.jsp" %>
	<h1>Hello world! 경매 테스트</h1>

	<P>The time on the server is ${serverTime}.</P>
	<h1>내용 확인 바람</h1>
	<h2>${msg}</h2>
	<h1>입력된 주소</h1>
	<h2>${url}</h2>
	<h1>클래스</h1>
	<h2>${classnm}</h2>
	<h1>메소드</h1>
	<h2>${method}</h2>
</body>
</html>
