<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/loginaChack.jsp"%>

<script src="js/components/pagination.js"></script>
<script src="js/components/accordion.js"></script>
<script src="js/core/modal.js"></script>
<!-- <script src="js/loginaChack.js" charset="utf-8"></script> -->
<c:if test="${result==1 }">
	<script type="text/javascript">
		alert("입력 성공")
	</script>
</c:if>
<c:if test="${result==0 }">
	<script type="text/javascript">
		alert("입력 실패")
	</script>
</c:if>
<script type="text/javascript">
	$('[data-uk-pagination]').on('select.uk.pagination',
			function(e, pageIndex) {
				//alert('You have selected page: ' + (pageIndex + 1));
				ajaxparams("BoardForm.ac", {
					PageNo : pageIndex + 1
				}, "#body")
			});
	$(function() {
		$("#pagemove").click(function() {
			var value = parseInt($("#pagenum").val(), 10);
			//alert('You have selected page: ' + (value));
			ajaxparams("BoardForm.ac", {
				PageNo : value
			}, "#body")
		})
	})
</script>

<div class="uk-grid uk-grid-collapse">
	<div class="uk-accordion uk-width-1-1" data-uk-accordion="{collapse: false,duration:100,showfirst:false}">
		<!-- ="{collapse: false}" -->
		<c:forEach items="${ list}" var="row">
			<article class="uk-comment">
				<header class="uk-comment-header uk-accordion-title">
					<h4 class="uk-comment-title">${row.b_title  }</h4>
					<span class="uk-comment-meta"><span class="uk-badge uk-badge-success">게시물 번호 : ${row.b_no  }</span> / <span class="uk-badge uk-badge-warning">회원번호
							: ${row.u_no  }</span> / <span class="uk-badge">작성날자 : ${row.b_date   }</span></span>
				</header>
				<div class="uk-accordion-content uk-comment-body uk-panel">${row.b_context}</div>
			</article>
		</c:forEach>
	</div>
	<div class="uk-grid uk-width-1-1 uk-grid-collapse">
		<span class="uk-width-2-10">
			<button class="uk-button stateLogin uk-grid-collapse uk-form-width-mini uk-button-mini" data-uk-modal="{target:'#modal6',bgclose:false}">글쓰기</button> <input id="pagenum"
			class="uk-form-width-mini" type="number" placeholder="" value="${paging.pageNo}">
			<button id="pagemove" class="uk-button uk-button-mini" type="button">이동</button>
		</span>
		<ul class="uk-pagination  uk-width-8-10"
			data-uk-pagination="{items:${paging.totalCount }, itemsOnPage:${paging.pageSize},currentPage:${paging.pageNo-1}, displayedPages:11,edges:5}"></ul>

	</div>
</div>
<%@ include file="/test/getContextPath.jsp"%>
<%@ include file="/test/scop.jsp"%>