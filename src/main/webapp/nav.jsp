<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="js/core/modal.js"></script>
<script src="js/core/offcanvas.js"></script>
<script src="js/canvasHide.js"></script>

<%@ include file="/loginaChack.jsp"%>

<script type="text/javascript">
	$(function() {
		$('li a').click(function() {
			var url = $(this).attr("href")
			/* alert(url) */

			/* 			if (url == "#") {
			 return false
			 }
			 if (url == null||url =="") {
			 return true
			 } */

			UIkit.offcanvas.hide([ force = false ])
			if (url == null || url == "" || url == "#") {
				return true
			}

			$(".uk-navbar-nav").children("li").removeClass("uk-active")
			$(".uk-nav").children("li").removeClass("uk-active")
			$("li a[href='" + url + "']").parent().addClass("uk-active")
			/* alert(this) */

			if (url == "UserLogout.ac") {
				ajaxNoForm(url, "#run")
			} else {
				ajaxNoForm(url, "#body")
			}

			return false
		})

	})
</script>


<div id="offcanvas" class="uk-offcanvas">
	<div class="uk-offcanvas-bar">
		<ul class="uk-nav uk-nav-offcanvas uk-nav-parent-icon" data-uk-nav="{multiple:true}">
			<!-- <ul class="uk-nav uk-nav-offcanvas"> -->
			<%@ include file="nav_menu_side.jsp"%>
		</ul>
	</div>
</div>
<nav class="uk-navbar uk-margin-large-bottom">
	<a class="uk-navbar-brand uk-hidden-small" href="">Auction</a>
	<ul class="uk-navbar-nav uk-hidden-small">
		<%@ include file="nav_menu.jsp"%>
	</ul>
	<a href="#offcanvas" class="uk-navbar-toggle uk-visible-small" data-uk-offcanvas></a> <a class="uk-navbar-brand uk-navbar-center uk-visible-small" href="">Auction</a>
</nav>



