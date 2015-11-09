<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/test/getContextPath.jsp" %>

<c:if test="${null ne msg}">
	<script type="text/javascript">
		alert("${msg }")
	</script>
</c:if>

<script type="text/javascript">
	//회원가입 예제
	$(function() {
		$("#submit").click(function() {
			ajax("#userLogin", "UserLogin.ac", "#run")
			return false
		})
	})
</script>

<div class="uk-grid">
	<!-- form.uk-form>fieldset[data-uk-margin]>legend{회원가입}+input[type="text" placeholder="id"]+input[type="password" placeholder=""] -->
	<form id="userLogin" method="post" action="UserLogin.ac" class="uk-form" modelAttribute="testUserVO">
		<fieldset data-uk-margin="">
			<legend>로그인</legend>
			<div class="uk-form-row">
				<input name="u_id" type="text" placeholder="id" />
			</div>
			<div class="uk-form-row">
				<input name="u_pw" type="password" placeholder="password" />
			</div>
			<!-- 			<div class="uk-form-row">
				<input name="u_nick" type="text" placeholder="nick" />
			</div>
			<div class="uk-form-row">
				<input name="u_name" type="text" placeholder="name" />
			</div> -->
			<div class="uk-form-row">
				<input id="submit" type="submit" value="로그인" /><input type="reset" value="다시작성" />
			</div>
		</fieldset>
	</form>
</div>

<%-- <%@ include file="../scop.jsp" %> --%>