<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="js/core/modal.js"></script>

<!-- 있을시 띄움 -->
<c:if test="${null ne msg}">
	<script type="text/javascript">
		alert("${msg }")
	</script>
</c:if>

<script type="text/javascript">
	//로그인 요청
	
	$(function() {
		$("#loginsb").click(function() {
			ajaxFormFunction("#userLogin","UserLogin.ac", ajaxOk, ajaxNo)
			//ajax("#userLogin", "testUserLogin.ac", "#body")
			return false
		})
		//modal = UIkit.modal("#userLoginDiv");
	})
	function ajaxOk(data) {
		//alert("loginOk"+modal+modal.isActive())
		//alert("ajaxOk:"+data)
		$("#run").html(data)
		//modal.hide();
	}
	function ajaxNo(data) {
		alert("ajaxNo:"+data)
	}
</script>

<!-- 로그인 팝업 -->
<div id="userLoginDiv" class="uk-grid uk-panel uk-modal uk-container-center">
	<!-- form.uk-form>fieldset[data-uk-margin]>legend{회원가입}+input[type="text" placeholder="id"]+input[type="password" placeholder=""] -->
	<form id="userLogin" method="post" action="testUserLogin.ac" class="uk-form uk-modal-dialog" modelAttribute="testUserVO">
		<fieldset data-uk-margin="">
			<legend>로그인</legend>
			<div class="uk-form-row">
				<input name="u_id" type="text" placeholder="id" />
			</div>
			<div class="uk-form-row">
				<input name="u_pw" type="password" placeholder="password" />
			</div>
			<div class="uk-form-row">
				<input id="loginsb" type="submit" value="로그인" /><input type="reset" value="다시작성" />
				<input class="uk-modal-close" type="button" value="닫기" />
			</div>
		</fieldset>
	</form>
</div>

<%-- <%@ include file="../scop.jsp" %> --%>