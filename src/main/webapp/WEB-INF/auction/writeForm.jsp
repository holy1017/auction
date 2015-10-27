<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html lang="ko">
<head>
<meta charset=UTF-8 />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Hello Javascript</title> -->
<!-- <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script> -->
<!-- <script src="js/jquery.form.js"></script> -->
<script type="text/javascript">
	$(function() {
		$("#confirmBtn").click(function() {

// 			ajaxFile1("#setForm", "write.ac", "#body")

			$("#setForm").attr({
				"method" : "POST",
				"action" : "/auction/write.ac"
			})
			$("#setForm").submit(

			)
		});
	});
</script>
<!-- <style type="text/css">
.table {
	width: 50%
}

.table1 {
	width: 100%
}
</style> -->
<!-- </head>

<body> -->
	<form name="setForm" id="setForm" enctype="multipart/form-data">
		<!-- <input type="hidden" id="u_no" name="u_no" value=${u_no}> -->
		<h2 align="center">물품 등록하기</h2>
		<div id="head" align="center">
			<table border="1" class="table">
				<colgroup>
					<col width="30%" />
					<col width="70%" />
				</colgroup>
				<tr>
					<td height=200><label>사진</label><input type="file" name="a_file" id="a_file"></td>


					<td>
						<table border="1" class="table1">
							<tr>
								<td colspan="2">물품명 : <input type="text" name="a_name" id="a_name" size="50" required></td>
							</tr>
							<tr>
								<td>최소가 : <input type="text" id="a_bot_price" name="a_bot_price"></td>
								<td>즉구가 : <input type="text" name="a_top_price" id="a_top_price" required></td>
							</tr>
							<tr>
								<th colspan="2">예상경매 마감 날짜는 72시간 후 입니다.</th>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<table align="center">
			<tr>
				<td colspan="2"><textarea rows="30" cols="90" name="a_content" id="a_content"></textarea></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="물품등록" name="confirmBtn" id="confirmBtn"> <!--  --> <a href="list.jsp"><input type="button" value="등록취소"
						name="cancelBtn" id="cancelBtn"></a></td>
				<!-- 등록취소를 하게되면 list페이지로 -->
			</tr>
		</table>
	</form>
<!-- </body>
</html> -->