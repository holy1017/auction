<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <script src="js/core/modal.js"></script> -->

<script type="text/javascript">
	$(function() {		
		$(".formReset").click(function() {
			//$(".uk-form")[0].reset()
		    $("form").each(function() {  
	            this.reset();  
	         });  
		})
		$("#boardInsertBt").click(function() {
			ajax("#boardInsert", "boardInsert.ac", "#body")
		})
		
	})
</script>

<div id="modal6" class="uk-modal" aria-hidden="true" style="display: none; overflow-y: scroll;">
	<div class="uk-modal-dialog">

		<button type="button" class="uk-modal-close uk-close"></button>
		<div class="uk-modal-header">
			<h2>글쓰기</h2>
		</div>
		<form id="boardInsert" class="uk-form" modelAttribute="BoardVO">
			<div class="uk-form-row">
				<input name="b_title" type="text" placeholder="타이틀" class="uk-form-width-large">
			</div>
			<div class="uk-form-row">
				<textarea name="b_context" cols="" rows="" placeholder="내용" class="uk-form-width-large"></textarea>
			</div>
		</form>
		<div class="uk-modal-footer uk-text-right">
			<button type="button" class="uk-button formReset">리셋</button>
			<button type="button" class="uk-button uk-modal-close">닫기</button>
			<button id="boardInsertBt" type="button" class="uk-button uk-button-primary">저장</button>
		</div>

	</div>
</div>

<%-- <%@ include file="../scop.jsp" %> --%>