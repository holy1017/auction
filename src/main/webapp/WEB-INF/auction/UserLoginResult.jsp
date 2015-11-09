<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/test/getContextPath.jsp" %>
<script src="js/core/modal.js"></script>
<c:choose>
	<c:when test="${'1'== result}">
		<script type="text/javascript">
		
			login(    "${userInfo.u_no}"
					, "${userInfo.u_id}"
					, "${userInfo.u_nick}"
					, "${userInfo.u_name}")
			alert("로그인 성공")
			var modal = UIkit.modal("#userLoginDiv");
			modal.hide();
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("로그인 실패")
		</script>
	</c:otherwise>
</c:choose>