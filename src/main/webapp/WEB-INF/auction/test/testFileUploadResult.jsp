<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Spring Multiple File Upload example</h1>
<c:if test="${resultmsg!=null}">
	<p>resultmsg</p>
	<ol>
		<c:forEach items="${resultmsg}" var="msg" varStatus="no">
			<li>${no.count}:${msg}</li>
		</c:forEach>
	</ol>
</c:if>
<c:if test="${filevos!=null}">
	<c:forEach items="${filevos}" var="filevo" varStatus="filevono">
		<p>filevos</p>
		<ol>
			<li>${filevono.count}:${filevo}</li>
			<li>${filevono.count}:${filevo.length}</li>
			<li>${filevono.count}:${filevo.bytes}</li>
			<li>${filevono.count}:${filevo.name}</li>
			<li>${filevono.count}:${filevo.type}</li>
		</ol>
	</c:forEach>
</c:if>
<c:if test="${fileone!=null}">
	<p>fileone</p>
	<ol>
		<li>${filevono.count}:${fileone}</li>
		<li>${filevono.count}:${fileone.length}</li>
		<li>${filevono.count}:${fileone.bytes}</li>
		<li>${filevono.count}:${fileone.name}</li>
		<li>${filevono.count}:${fileone.type}</li>
	</ol>
</c:if>
<c:if test="${filenames!=null}">
	<ol>
		<c:forEach items="${filenames}" var="filename" varStatus="fileno">
			<li>${fileno.count}:${filename}</li>
		</c:forEach>
	</ol>
</c:if>

<%-- 	<c:forEach var="vo" items="${list}" varStatus="vs">
		<c:if test="${not vs.last}">
			<c:set var="names" value="${names + vo.name}," />
		</c:if>
		<c:if test="${vs.last}">
			<c:set var="names" value="${names + vo.name}" />
		</c:if>
	</c:forEach> --%>


<%@ include file="/test/getContextPath.jsp"%>
<%@ include file="/test/scop.jsp"%>



<!--  파일 업로드 스크립트 ->
<script src="js/components/upload.js"></script>
파일 업로드 폼
<form action="" method="post" enctype="multipart/form-data">
<div id="upload-drop" class="uk-placeholder uk-text-center">
	<i class="uk-icon-cloud-upload uk-icon-medium uk-text-muted uk-margin-small-right"></i> Attach binaries by dropping them here or <a class="uk-form-file">selecting
		one<input id="upload-select" type="file">
	</a>.
</div>

<div id="progressbar" class="uk-progress uk-hidden">
	<div class="uk-progress-bar" style="width: 0%;">0%</div>
</div>
</form>
파일 업로드 스크립트
<script>
	$(function() {

		var progressbar = $("#progressbar"), bar = progressbar
				.find('.uk-progress-bar'), settings = {

			action : 'testFileUpload.ac', // upload url

			allow : '*.(jpg|gif|png)', // allow only images

			//filelimit: 100,
			
			loadstart : function() {
				bar.css("width", "0%").text("0%");
				progressbar.removeClass("uk-hidden");
			},

			progress : function(percent) {
				percent = Math.ceil(percent);
				bar.css("width", percent + "%").text(percent + "%");
			},

			allcomplete : function(response) {

				bar.css("width", "100%").text("100%");

				setTimeout(function() {
					progressbar.addClass("uk-hidden");
				}, 250);

				alert("Upload Completed")
			}
		};

		var select = UIkit.uploadSelect($("#upload-select"), settings), drop = UIkit
				.uploadDrop($("#upload-drop"), settings);
	});
</script> -->