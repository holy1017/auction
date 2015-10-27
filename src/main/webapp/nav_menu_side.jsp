<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <script src="js/core/modal.js"></script>
<script src="js/core/offcanvas.js"></script> -->

<li><a href="BoardForm.ac">게시판</a></li>
<li class="uk-nav-header">경매</li>
<li><a href="itemList.ac">경매목록</a></li>
<li class="stateLogin"><a href="writeForm.ac">경매등록</a></li>
<li class="canvasHide" value="#chat"><a href="" data-uk-offcanvas="{target:'#chat'}">채팅</a></li>
<li class="uk-nav-header">회원</li>
<li class="login stateLogout"><a href="" data-uk-modal="{target:'#userLoginDiv',bgclose:false}">로그인</a></li>

<li class="userCreate stateLogout"><a href="userCreateForm.ac">회원가입</a></li>
<li class="userInfo stateLogin" class="uk-parent"><a href="#">회원정보</a>
	
	<ul class="uk-nav-sub">
		
		<li>NO:<span class="u_no">${sessionScope.userInfo.u_no} </span></li>
		<li>ID:<span class="u_id">${sessionScope.userInfo.u_id} </span></li>
		<li>Nick:<span class="u_nick">${sessionScope.userInfo.u_nick}</span></li>
		<li>Name:<span class="u_name">${sessionScope.userInfo.u_name}</span></li>
		<li class="uk-nav-divider"></li>
		<li><a href="UserLogout.ac">로그아웃</a></li>
	</ul></li>


<!-- 테스트용 및 예제 -->
<!-- 
<li class="uk-nav-header">기타</li>
<li class="uk-parent"><a href="#">Parent</a>
	<ul class="uk-nav-sub">
		<li class="uk-nav-divider"></li>
		<li><a href="">Item</a></li>
		<li><a href="">Another item</a></li>
		<li class="uk-nav-header">Header</li>
		<li><a href="">Item</a></li>
		<li><a href="">Another item</a></li>
		<li class="uk-nav-divider"></li>
		<li><a href="">Separated item</a></li>
		<li class="uk-nav-divider"></li>
	</ul></li>
	
	
<li class="uk-parent"><a href="#">test</a>
	<ul class="uk-nav-sub">
		<li><a href="test.ac?test=test">Test.ac</a></li>
		<li><a href="errerjsp">주소 에러 "/errerjsp" 발생시</a></li>
		<li><a href="errer.ac?test=dagfs">errer.ac 에러 요청</a></li>
		<li><a href="testUserCreateForm.ac">회원가입</a></li>
		<li><a href="testUserLoginForm.ac">로그인</a></li>
		<li><a href="testUserLogout.ac">로그아웃</a></li>
		<li><a href="testFileUploadForm.ac">파일업로드</a></li>
		<li><a href="testMapArgumentResolver.ac?aaa=value1&bbb=value2">testMapArgumentResolver.ac?aaa=value1&bbb=value2</a></li>
	</ul></li>
 -->