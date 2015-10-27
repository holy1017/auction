<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:set var="u_name" value="${userInfo.u_name}" /> --%>


<c:if test="${result==1}">
	<script type="text/javascript">
		UIkit.notify("<i class='uk-icon-check'></i> 입찰이 완료되었습니다.");
	</script>
</c:if>
<c:if test="${result==0}">
	<script type="text/javascript">
		UIkit.notify("입찰액이 최대가격과 최소가격의 사이가 아니거나 경매가 종료되었습니다.<br> 다시 확인후 입찰 해주세요.", {status:'danger'})
	</script>
</c:if>
<script type="text/javascript" src="js/core/modal.js"></script>
<script type="text/javascript" src="js/components/notify.js"></script>
<link rel="stylesheet" href="css/components/notify.css" />
<script type="text/javascript">
	$(function() {
		var u_name = "<c:out value="${userInfo.u_name}" />";
		if(u_name==""){
			$('.btn').hide();
			UIkit.notify("로그인 후 입찰가능합니다.", {status:'danger'})
		}
		
		$('.itemList').click(function() {
			var url = $(this).attr("href")

			ajaxNoForm(url, "#body")

			return false
		})  
		
		//상세 페이지 이동 이벤트
		$("#biddingSubmit").click(function() {
						
			ajax("#bidder", "bidderUpdate.ac", "#body");
			
		});


	})
</script>





<article id="detail_body" class="uk-article">

	<h1 class="uk-article-title">경매 도서 상세정보</h1>

	<p style="height: 200px;">
		<img class="uk-responsive-height" src="upload/${list.a_imgContext}">
	</p>

	<p>${list.a_content}</p>

	<table class="uk-table">
		<thead>
			<tr>
				<th>도서명</th>
				<th>입찰자</th>
				<th>현재 입찰가</th>
				<th>입찰 최고가</th>
				<th>종료 일자</th>
				<th>시작 일자</th>
				<th>판매자 아이디</th>
				<th>경매 번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td id="a_name">${list.a_name}</td>
				<td id="bd_name">${list.bd_name}</td>				
				<td id="a_bot_price">${list.a_bot_price}</td>
				<td id="a_top_price">${list.a_top_price}</td>
				<td id="a_ddate">${list.a_ddate}</td>
				<td id="a_date">${list.a_date}</td>
				<td id="u_id">${list.u_id}</td>
				<td id="a_no">${list.a_no}</td>
			</tr>
		</tbody>
	</table>

	<div class="uk-width-medium-1-1">
		<a class="uk-button btn stateLogin" data-uk-modal="{target:'#bidding'}">입찰</a> 
		<!-- <a class="uk-button btn stateLogin" href="itemList.ac">즉시입찰</a>  -->
		<a class="uk-button itemList" href="itemList.ac" >경매목록</a> 
		<!-- <a class="uk-button" href="detail.ac">새로고침</a> -->
	</div>

	<hr class="uk-article-divider">

	<div class="uk-width-medium-1-1">
		<div class="uk-panel uk-panel-box ">
			<h3 class="uk-panel-title uk-text-danger">※책임한계 및 법적고지</h3>
			<p class="uk-text-danger">본 사이트는 판매자가 등록한 매물정보가 노출될 수 있도록 등록
				시스템만을 제공하며, 판매자가 등록한 매물 정보 및 이와 관련한 실제 거래에 대하여 어떤 책임도 부담하지 않습니다.</p>
		</div>
	</div>

</article>

<!-- =========================================입찰페이지 시작 -->


<div id="bidding" class="uk-modal">
	<div class="uk-modal-dialog">
		<button type="button" class="uk-modal-close uk-close"></button>
		<div class="uk-modal-header">
			<h2>입찰하기</h2>
		</div>
		<p>
			
			<form id="bidder" name="bidder">
			<table class="uk-table uk-table-hover">
					<tr>
						<th><input type="hidden" name="u_name" id="u_name" value="${userInfo.u_name}">						
						도서명</th>
						
						<td><input type="text" id="a_name" name="a_name"
						value="${list.a_name}" readonly onfocus="this.blur();"></td>
						<th>경매번호</th>
						<td><input type="text" id="a_no" name="a_no"
						value="${list.a_no}" readonly onfocus="this.blur();"></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><input type="text" id="a_date" name="a_date"
						value="${list.a_date}" readonly onfocus="this.blur();"></td>
						<th>종료일</th>
						<td><input type="text" id="a_ddate" name="a_ddate"
						value="${list.a_ddate}" readonly onfocus="this.blur();"></td>
					</tr>
					<tr>
						<th>현 입찰가</th>
						<td><input type="text" id="a_bot_price" name="a_bot_price"
						value="${list.a_bot_price}" readonly onfocus="this.blur();"></td>
						<th>즉구가</th>
						<td><input type="text" id="a_top_price" name="a_top_price"
						value="${list.a_top_price}" readonly onfocus="this.blur();">
						
					<td>
					
				</tr>
					<tr>

					</tr>
					<tr>
						<th>입찰 가격</th>
						<td colspan="3"><input type="text" id="a_bid_price"
						name="a_bid_price"></td>
					</tr>
				</table>
			</form>
			</p>
			<div class="uk-modal-footer uk-text-right">

				<input type="button" class="uk-button uk-button-primary"
				id="biddingSubmit" value="입찰">
				<button type="button" class="uk-button uk-modal-close">취소</button>
			</div>
		</div>
	</div>
<!-- 입찰페이지 끝-->



<!-- <div id="body1"> -->


<%-- 	<table border="1" height=50 width=800>
		<tr>
			<td height=200><img alt="책 사진" id="a_imgcontext" src="${list.a_imgcontext}"></td>
		</tr>

	</table> --%>
<!-- <table border="1" width=800 height=40> -->
			<%-- 
<br>
<table border=1 width=800>
	<tr>
		<td height=30>내용</td>
	</tr>
	<tr height=300>
		<td height=30 id="a_content">${list.a_content}</td>
	</tr>
</table>
<br>
<br> --%>




			<!-- </div>
 -->


			<!-- 		<div id="body3" align="center"> -->
			<!-- 		<input type="button" value="입찰" id="bidding" style=color:blue > &nbsp;&nbsp; -->
			<!-- 		<input type="button" value="즉시 입착" id="now_bidding" style=color:blue> &nbsp;&nbsp; -->
			<!-- 		<input type="button" value="목록보기" id="see_board" style=color:blue> -->
			<!-- 		</div> -->




			<!-- </body>
</html> -->