<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/uikit.js"></script>
<script src="js/core/modal.js"></script>
<script src="js/components/lightbox.js"></script>
<script src="js/components/pagination.js"></script>
<script src="js/ajax.js"></script>
<script src="js/board.js"></script>
<script type="text/javascript">
var chk1 = false;
var chk2 = false;

$(function() {
	
	$("#u_id").change(function(){
		chk1=false;
	})
	$("#u_nick").change(function(){
		chk2=false;
	})
	
	$("#submit").click(function() {
		
		if(!chkSubmit($('#u_id'),"아이디")){
			return;
		}else if(!chkSubmit($('#u_pw'),"비밀번호")){
			return;
		}else if(!chkSubmit($('#u_pwchk'),"비밀번호 확인")){
			return;
		}else if(!chkSubmit($('#u_nick'),"닉네임")){
			return;
		}else if(!chkSubmit($('#u_name'),"이름")){
			return;
		}else if($('#u_pw').val() != $('#u_pwchk').val()){
			alert("비밀번호가 틀립니다.");
			return;
		}else{
			if(chk1){
				if(chk2){
					ajax("#userCreate", "UserCreate.ac", "#body")
					return false
				}else{
					alert("닉네임 중복 검사를 해주시기 바랍니다.")
				}
				
			}else{
				alert("아이디 중복 검사를 해주시기 바랍니다.")
			}			
		}
	})
	$('#id_chk').click(function(){
		var v_id =$("#u_id").val();
		 var param = "mem_id=" +v_id;
			$.ajax({
				type:"POST",
				url:"UserSelect.ac",
				data:param,
				success:function(data){
				
					 if(data==1){
						 alert("아이디 사용이 가능합니다.");
						 chk1=true;
						
					}else{
						alert("아이디가 중복 됩니다.");
						chk1=false;
					} 					
				}
			});
		
	})
	$('#nick_chk').click(function(){
		var v_id =$("#u_nick").val();
		 var param = "mem_id=" +v_id;
			$.ajax({
				type:"POST",
				url:"NickSelect.ac",
				data:param,
				success:function(data){
					
					if(data==1){
						 alert("닉네임 사용이 가능합니다.");
						chk2 = true;
					}else{
						alert("닉네임이 중복 됩니다.");
						chk2 = false;
					} 					
				}
			});
		
	})
})



</script>
</head>
<body>
<div class="uk-grid">
<form id="userCreate" name="userCreate" method="post" action="UserCreate.ac" class="uk-form" modelAttribute="testUserVO">
		<fieldset data-uk-margin="">
			<legend>회원가입</legend>
			<div class="uk-form-row">
				<input id="u_id" name="u_id" type="text" placeholder="아이디" />
				<input id="id_chk" name="id_chk" type="button" value="중복 확인"/>
				
			</div>
			<div class="uk-form-row">
				<input id="u_pw" name="u_pw" type="password" placeholder="비밀번호" />
			</div>
			<div class="uk-form-row">
				<input id="u_pwchk" name="u_pwchk" type="password" placeholder="비밀번호 확인" />
			</div>
			<div class="uk-form-row">
				<input id ="u_nick" name="u_nick" type="text" placeholder="닉네임" />
				<input id="nick_chk" name="nick_chk" type="button" value="중복 확인"/>
			</div>
			<div class="uk-form-row">
				<input id="u_name" name="u_name" type="text" placeholder="이름" />
			</div>
			<div class="uk-form-row">
				<input name="u_lv" type="radio" value="1" checked="checked">일반회원
				<input name="u_lv" type="radio" value="2">기업회원
			</div>
			<!-- <div class="uk-form-row">
				<input name="u_post" type="text" placeholder="post" />
			</div>
			<div class="uk-form-row">
				<input name="u_email" type="text" placeholder="email" />
			</div> -->
			<div class="uk-form-row">
				<input id="submit" type="button" value="가입하기" /><input type="reset" value="다시작성" />
			</div>
			
		</fieldset>
	</form>
</div>
<div id = "idresult">
	
</div>

</body>
</html>