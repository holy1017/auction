<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/test/getContextPath.jsp" %>
<c:if test="${sessionScope.userInfo  != null}">
	<li class="uk-parent" data-uk-dropdown><a href="#">회원정보 <i class="uk-icon-caret-down"></i></a>
		<div class="uk-dropdown uk-dropdown-navbar">
			<ul class="uk-nav uk-nav-navbar">
				<li class="uk-nav-divider"></li>
				<li><a href="#">${sessionScope.userInfo.u_id}</a></li>
				<li><a href="#">${sessionScope.userInfo.u_name}</a></li>
				<li class="uk-nav-header">Header</li>
				<li><a href="#">${sessionScope.userInfo.u_nick}</a></li>
				<li><a href="#">${sessionScope.userInfo.u_no}</a></li>
				<li class="uk-nav-divider"></li>
				<li><a href="#">Separated item</a></li>
				<li class="uk-nav-divider"></li>
			</ul>
		</div></li>
</c:if>