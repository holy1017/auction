<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/test/getContextPath.jsp"%>

<script src="js/core/modal.js"></script>
<c:choose>
	<c:when test="${null== userInfo}">
		<script type="text/javascript">
			logout()
			alert("로그아웃 성공")
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			login("${userInfo.u_no}", "${userInfo.u_id}", "${userInfo.u_nick}",
					"${userInfo.u_name}")
			alert("로그아웃 실패")
		</script>
	</c:otherwise>
</c:choose>