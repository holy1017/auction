<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/test/getContextPath.jsp"%>

<script src="http://malsup.github.com/jquery.form.js"></script>

<script type="text/javascript">
	//using jquery.form.js
	function uploadJqueryForm(url) {
		$('#fileresult').html('uploadJqueryForm ' + url + '<br>');

		$("#form2").ajaxForm({
			url : url,
			success : function(data) {
				$('#fileresult').append(data + "<br>");
			},
			dataType : "text"
		}).submit();
	}
	//using FormData() object
	function uploadFormData(url) {
		$('#fileresult').html('uploadFormData ' + url + '<br>');

		var oMyForm = new FormData();
		$.each($('#attachFile')[0].files, function(i, file) {
			oMyForm.append('file-' + i, file);
		});
		//oMyForm.append("file", file2.files[0]);

		$.ajax({
			url : url,
			data : oMyForm,
			dataType : 'text',
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {
				$('#fileresult').append(data + "<br>");
			}
		});
	}
</script>
<script>
	$(function() {
		//add more file components if Add is clicked
		$('#addFile')
				.click(
						function() {
							var fileIndex = $('#fileTable tr').children().length - 1;
							$('#fileTable')
									.append(
											'<tr><td>'
													+ '   <input type="file" name="files['+ fileIndex +']" />'
													+ '</td></tr>');
						});

	});
</script>
<h1>SpringMVC - File Upload with/without Ajax</h1>

<!--  Form 1 -->
<!-- <i>Uploading File Without Ajax</i>
<br />
<form id="form1" method="post" action="cont/upload.ac" enctype="multipart/form-data">

	File input
	<input name="file" id="file" type="file" /><br /> <input type="submit" value="Upload" />
</form>
<hr /> -->
<!--  Form 2 -->
<i>Uploading File With Ajax</i>
<br />
<form id="form2" method="post" action="testFileUpload.ac" enctype="multipart/form-data">
	<!-- File input -->
	<input id="addFile" type="button" value="Add File" />
	<table id="fileTable">
		<tr>
			<td><input name="files[0]" type="file" /></td>
		</tr>
		<tr>
			<td><input name="files[1]" type="file" /></td>
		</tr>
	</table>
</form>

<c:forEach begin="0" end="4" var="x">
	<p>testFileUpload${x }</p>
	<button value="Submit" onclick="uploadJqueryForm('testFileUpload${x }.ac')">Upload</button>
	<i>Using JQuery Form Plugin</i>
	<br />
	<button value="Submit" onclick="uploadFormData('testFileUpload${x }.ac')">Upload</button>
	<i>Using FormData Object</i>
</c:forEach>
<!-- 
<p>testFileUpload0</p>
<button value="Submit" onclick="uploadJqueryForm('testFileUpload0.ac')">Upload</button>
<i>Using JQuery Form Plugin</i>
<br />
<button value="Submit" onclick="uploadFormData('testFileUpload0.ac')">Upload</button>
<i>Using FormData Object</i>
<p>testFileUpload1</p>
<br />
<button value="Submit" onclick="uploadJqueryForm('testFileUpload1.ac')">Upload</button>
<i>Using JQuery Form Plugin</i>
<br />
<button value="Submit" onclick="uploadFormData('testFileUpload1.ac')">Upload</button>
<i>Using FormData Object</i>
<br />
<p>testFileUpload2</p>
<button value="Submit" onclick="uploadJqueryForm('testFileUpload2.ac')">Upload</button>
<i>Using JQuery Form Plugin</i>
<br />
<button value="Submit" onclick="uploadFormData('testFileUpload2.ac')">Upload</button>
<i>Using FormData Object</i>
<br />
<p>testFileUpload3</p>
<button value="Submit" onclick="uploadJqueryForm('testFileUpload3.ac')">Upload</button>
<i>Using JQuery Form Plugin</i>
<br />
<button value="Submit" onclick="uploadFormData('testFileUpload3.ac')">Upload</button>
<i>Using FormData Object</i>
<br /> -->
<p>fileresult</p>
<div id="fileresult"></div>