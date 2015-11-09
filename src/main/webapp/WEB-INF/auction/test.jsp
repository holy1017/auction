<%@page import="auction.test.testVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="js/core/scrollspy.js"></script>
<script src="js/core/modal.js"></script>
<script src="js/components/lightbox.js"></script>
<script src="js/components/pagination.js"></script>


<%-- <%@ include file="test/testUserCreateForm.jsp" %> --%>
<%-- <jsp:include page="test/testUserCreateForm.jsp"></jsp:include> --%>
<%@ include file="/test/getContextPath.jsp" %>
테스트용 문서 말그대로 코드 확인용
<!-- <h1>testVO</h1> -->
<%-- <c:forEach items="${testVO}" var="item">
	<p>${item.key}=${item.value}</p>
</c:forEach> --%>

<%-- <c:out value="${testVO}" /> --%>


<%@ include file="scop.jsp"%>

<c:if test="${exception != null}">
	<h1>exception</h1>
	<div class="uk-width-1">
		<mark> ${exception} </mark>
	</div>
</c:if>
<%-- <div class="uk-grid">
	<h1>test</h1>
	<div class="uk-width-1">
		<mark> ${test} </mark>
	</div>

	<h1>result</h1>
	<div class="uk-width-1">
		<mark> ${result} </mark>
	</div>

	<h1>exception</h1>
	<div class="uk-width-1">
		<mark> ${exception} </mark>
	</div>

	<h1>list</h1>
	<div class="uk-width-1">
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<div class="uk-width-1">
					<c:forEach items="${list }" var="row">
						<li>${row.num }</li>
						<li>${row.text }</li>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
				<li>조회된 결과가 없습니다.</li>
			</c:otherwise>
		</c:choose>
	</div>
</div> --%>

<h3 class="tm-article-subtitle">data-uk-pagination="{items:${pageItems}, itemsOnPage:${pageOnItems}, currentPage:${pageNum}}" 페이지 번호 Example</h3>

<ul class="uk-pagination" data-uk-pagination="{items:${pageItems}, itemsOnPage:${pageOnItems}, currentPage:${pageNum},displayedPages:5,edges:3}"></ul>


<script type="text/javascript">
	$('[data-uk-pagination]').on('select.uk.pagination',
			function(e, pageIndex) {
				alert('You have selected page: ' + (pageIndex + 1));
			});
</script>


<h1>data-uk-scrollspy</h1>
<div class="uk-grid">
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-fade', repeat: true}">
			<h3>Fade</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid">
	<div class="uk-width-medium-1-4 uk-push-1-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-scale-up', repeat: true}">
			<h3>Scale up</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid">
	<div class="uk-width-medium-1-4 uk-push-2-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-scale-down', repeat: true}">
			<h3>Scale down</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid">
	<div class="uk-width-medium-1-4 uk-push-3-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-slide-top', repeat: true}">
			<h3>Slide top</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid">
	<div class="uk-width-medium-1-4 uk-push-2-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-slide-bottom', repeat: true}">
			<h3>Slide bottom</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid">
	<div class="uk-width-medium-1-4 uk-push-1-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-slide-right', repeat: true}">
			<h3>Slide right</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid">
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box" data-uk-scrollspy="{cls:'uk-animation-slide-left', repeat: true}">
			<h3>Slide left</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<div class="uk-grid" data-uk-grid-margin data-uk-scrollspy="{cls:'uk-animation-fade uk-invisible', target:'> div > .uk-panel', delay:300, repeat: true}">
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
	<div class="uk-width-medium-1-4">
		<div class="uk-panel uk-panel-box uk-invisible">
			<h3 class="uk-panel-title">Item</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
		</div>
	</div>
</div>

<h3 class="tm-article-subtitle">uk-animation-* Example</h3>

<p>Hover over any of the boxes to see the animation.</p>

<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-fade">Fade</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale-up">Scale up</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale-down">Scale down</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-shake">Shake</div>
	</div>
</div>


<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-slide-top">Slide top</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-slide-bottom">Slide bottom</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-slide-left">Slide left</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-slide-right">Slide right</div>
	</div>
</div>
<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale">Scale</div>
	</div>
</div>

<h3 class="tm-article-subtitle">uk-animation-reverse Example</h3>

<p>Hover over any of the boxes to see the animation.</p>

<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-fade">Fade</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-scale-up">Scale up</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-scale-down">Scale down</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-shake">Shake</div>
	</div>
</div>

<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-slide-top">Slide top</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-slide-bottom">Slide bottom</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-slide-left">Slide left</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-slide-right">Slide right</div>
	</div>
</div>
<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-reverse uk-animation-scale">Scale</div>
	</div>
</div>

<h3 class="tm-article-subtitle">uk-animation-scale Example</h3>

<p>Hover over any of the boxes to see the animation.</p>

<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-top-left">Top Left</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-top-center">Top Center</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-top-right">Top Right</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-middle-left">Middle Left</div>
	</div>
</div>

<div class="uk-grid uk-text-center" data-uk-grid-match="{target:'> div > .uk-panel'}" data-uk-grid-margin>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-middle-right">Middle Right</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-bottom-left">Bottom Left</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-bottom-center">Bottom Center</div>
	</div>
	<div class="uk-width-medium-1-5 uk-animation-hover">
		<div class="uk-panel uk-panel-box uk-animation-scale uk-animation-bottom-right">Bottom Right</div>
	</div>
</div>


<h3 class="tm-article-subtitle">data-lightbox-type="image" data-uk-lightbox="{group:'group1'}" Example</h3>
<div class="uk-grid uk-grid-width-medium-1-4" data-uk-grid-margin>
	<div>
		<a href="images/placeholder_800x600_1.jpg" data-lightbox-type="image" data-uk-lightbox="{group:'group1'}" title="Title"> <img
			src="images/placeholder_800x600_1.jpg" width="800" height="600" alt="">
		</a>
	</div>
	<div>
		<a href="images/placeholder_800x600_2.jpg" data-lightbox-type="image" data-uk-lightbox="{group:'group1'}" title="Title"> <img
			src="images/placeholder_800x600_2.jpg" width="800" height="600" alt="">
		</a>
	</div>
	<div>
		<a href="images/placeholder_800x600_3.jpg" data-lightbox-type="image" data-uk-lightbox="{group:'group1'}" title="Title"> <img
			src="images/placeholder_800x600_3.jpg" width="800" height="600" alt="">
		</a>
	</div>
	<div>
		<a href="images/placeholder_800x600_4.jpg" data-lightbox-type="image" data-uk-lightbox="{group:'group1'}" title="Title"> <img
			src="images/placeholder_800x600_4.jpg" width="800" height="600" alt="">
		</a>
	</div>
</div>



