<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<link rel="stylesheet" href="css/uikit.min.css" />
<link rel="stylesheet" href="css/uikit.docs.min.css">
<link rel="stylesheet" href="css/highlight.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>
<script src="js/jquery.form.min.js"></script>

<script src="js/uikit.js"></script>
<!-- //아작스 처리 함수 -->
<script src="js/ajax.js"></script>
<!-- //로그인 반응 처리 함수 -->
<script src="js/login.js"></script>

<script src="js/highlight.js"></script>

<script src="js/common.js" charset="utf-8"></script>
<!-- <script src="js/loginaChack.js" charset="utf-8"></script> -->

<script type="text/javascript">
	$(function() {
		//메인페이지 로드용
		/* ajaxNoForm("test.ac", "#body") */
		ajaxNoForm("itemList.ac", "#body")
	})
</script>

</head>
<body>

	<%-- <%@ include file="/test/getContextPath.jsp" %> --%>

	<!-- 메뉴 -->
	<jsp:include page="nav.jsp"></jsp:include>

	<!-- 메뉴 선택시 바뀌는 부분 -->
	<div id="body" class="body"></div>

	<!-- 자바만 실행할경우 -->
	<div id="run" class="run"></div>

	<!-- 로그인폼. 숨겨져있음 -->
	<jsp:include page="UserLoginForm.jsp"></jsp:include>
	
	
	<jsp:include page="boardWriteForm.jsp"></jsp:include>

	<!-- 채팅 -->
	<%@ include file="chat.jsp"%>

</body>
</html>