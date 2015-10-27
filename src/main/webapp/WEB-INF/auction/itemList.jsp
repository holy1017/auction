<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld" %>	

<!-- <!DOCTYPE html>
<html lang="ko">
<head>
<meta charset=UTF-8 />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />


<title>BoardList2</title> -->

<!-- <script type="text/javascript" src="/js/board.js"></script> -->
<!-- <link rel="stylesheet" type="text/css/"
	href="/include/css/board.css"> -->
<!-- <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script> -->
<script type="text/javascript">
$(function() {
	//상세 페이지 이동 이벤트
	$(".goDetail").click(function() {
		var a_no = $(this).parent().parent().children().eq(0).html();
		$("#a_no").val(a_no);
		
		ajax("#detailForm","detail.ac","#body")

/* 		$("#detailForm").attr({
			"method" : "POST",
			"action" : "/auction/detail.ac"
		})
		$("#detailForm").submit(); */
	});
	
	$("#writeForm").click(function() {
		ajaxNoForm("writeForm.ac","#body")
	})
	
// 	//검색 후 검색 대상과 검색 단어 출력
// 	if("<c:out value='${data.keyword}' />" != ""){
// 		$('#keyword').val("<c:out value='${data.keyword}' />")
// 		$('#serch').val("<c:out value='${data.search}' />")
// 	}
// 	//한 페이지에 보여줄 레코드 수 조회 후 선택해 놓기 위해서 설정
// 	if("<c:out value='${data.pageSize}' />" !=""){
// 		$("#pageSize").val("<c:out value='${data.pageSize}' />");
// 	}
	
// 	//한 페이지에 보여줄 레코드 수 변결될 때마다 처리 이벤트
// 	$("#pageSize").change(function(){
// 		goPage(1);
// 	})
	
// 	//글쓰기 버튼 클릭시 처리 이벤트
// 	$("#writeForm").click(function() {
// 		location.href = "/10_MVCBoard/board/writeForm.do"
// 	})
	
	
// 	// 검색 대상이 변경될 때마다 처리 이벤트
// 	$("#search").change(function(){
// 		if($("#search").val()=="all"){
// 			$("#keyword").val("전체 데이터 조회합니다.");
// 		}else if($("#search").val()!="all"){
// 			$("#keyword").val("");
// 			$("#keyword").focus();				
// 		}
// 	})
// 	//검색 버튼 클릭 시 처리 이벤트
// 	$("#searchData").click(function(){
// 		if($('#search').val()!="all"){
// 			if(!chkSubmit($('#keyword'),"검색어를")) return;
// 		}
// 		goPage(1);
// 	})
})
//정렬 및 검색 시 실질적인 처리 함수
function goPage(page){
	if($("#search").val()=="all"){
		$("#keyword").val("");
	}	
	$("#page").val(page);
	$("#f_search").attr("method","get");
	$("#f_search").attr("action","/10_MVCBoard/board/list.do");
	$("#f_search").submit();
}
</script>
<!-- </head>


<body> -->
	<div id="boardContainer">
		<div id="boardTit">
			<h3>등록목록</h3>
		</div>
		<form name="detailForm" id="detailForm">
			<input type="hidden" name="a_no" id="a_no"> <input
				type="hidden" name="page" value="${param.page}"> <input
				type="hidden" name="pageSize" value="${param.pageSize}">
		</form>
		<%--================검색 기능 시작=========== --%>
		<div id="boardSearch">
			<form id="f_search" name="f_search">
				<input type="hidden" id="page" name="page" value="${data.page}">
				<table summary="검색">
					<tr>
						<td id="btd1"><label>검색 조건</label> <select id="search"
							name="search">
								<option value="all">전체</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="author">작성자</option>
						</select> <input type="text" name="keyword" id="keyword" value="검색어를 입력하세요">
							<input type="button" value="검색" id="searchData"></td>
						<td id="btd2">한 페이지에 <select id="pageSize" name="pageSize">
								<option value="2">2줄</option>
								<option value="3">3줄</option>
								<option value="5">5줄</option>
								<option value="7">7줄</option>
								<option value="10">10줄</option>
						</select>
						</td>
					</tr>
				</table>
			</form>
		</div>


		<%--==================리스트시작================ --%>
		<div id="boardList">
			<table summary="게시판 리스트">
				<colgroup>
					<col width="10%" />
					<col width="10%" />
					<col width="35%" />
					<col width="15%" />
					<col width="15%" />
					<col width="15%" />
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>판매자</th>
						<th>물품명</th>
						<th>현재가</th>
						<th>즉구가</th>
						<th>마감날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty iList}">
							<c:forEach var="bvo" items="${iList}">
								<tr align="center">
									<td>${bvo.a_no}</td>
									<td>${bvo.u_name}</td>
									<td align="left"><span class="goDetail">${bvo.a_name}</span></td>
									<td>${bvo.a_bot_price}</td>
									<td>${bvo.a_top_price}</td>
									<td>${bvo.a_ddate}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6" align="center">등록된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<%--=====글쓰기 버튼 출력 시작========== --%>
		<div id="boardBut">
			<input class="stateLogin" type="button" value="경매등록" id="writeForm">
		</div>
		<%-- ============== 페이지 네비게이션 시작 --%>
		<div id="boardPage">
			<tag:paging page="${param.page}" total="${total}"
				list_size="${data.pageSize}" />
		</div>
	</div>

<!-- 
</body>
</html> -->