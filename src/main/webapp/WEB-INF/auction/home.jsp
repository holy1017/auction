<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false"%> --%>
<html>
<head>
<title>Home</title>
</head>
<body>
<%@ include file="/test/getContextPath.jsp" %>
	<h1>Hello world! ��� �׽�Ʈ</h1>

	<P>The time on the server is ${serverTime}.</P>
	<h1>���� Ȯ�� �ٶ�</h1>
	<h2>${msg}</h2>
	<h1>�Էµ� �ּ�</h1>
	<h2>${url}</h2>
	<h1>Ŭ����</h1>
	<h2>${classnm}</h2>
	<h1>�޼ҵ�</h1>
	<h2>${method}</h2>
</body>
</html>
