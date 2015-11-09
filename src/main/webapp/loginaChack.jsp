<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.userInfo  != null}">
		<script type="text/javascript">
			$(function() {
				login("${sessionScope.userInfo.u_no}",
						"${sessionScope.userInfo.u_id}",
						"${sessionScope.userInfo.u_nick}",
						"${sessionScope.userInfo.u_name}")
				//alert( $(".login"))
			})
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			$(function() {
				logout()
				//alert( $(".logout"))
			})
		</script>
	</c:otherwise>
</c:choose>