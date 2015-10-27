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
		
		if(!chkSubmit($('#u_id'),"���̵�")){
			return;
		}else if(!chkSubmit($('#u_pw'),"��й�ȣ")){
			return;
		}else if(!chkSubmit($('#u_pwchk'),"��й�ȣ Ȯ��")){
			return;
		}else if(!chkSubmit($('#u_nick'),"�г���")){
			return;
		}else if(!chkSubmit($('#u_name'),"�̸�")){
			return;
		}else if($('#u_pw').val() != $('#u_pwchk').val()){
			alert("��й�ȣ�� Ʋ���ϴ�.");
			return;
		}else{
			if(chk1){
				if(chk2){
					ajax("#userCreate", "UserCreate.ac", "#body")
					return false
				}else{
					alert("�г��� �ߺ� �˻縦 ���ֽñ� �ٶ��ϴ�.")
				}
				
			}else{
				alert("���̵� �ߺ� �˻縦 ���ֽñ� �ٶ��ϴ�.")
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
						 alert("���̵� ����� �����մϴ�.");
						 chk1=true;
						
					}else{
						alert("���̵� �ߺ� �˴ϴ�.");
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
						 alert("�г��� ����� �����մϴ�.");
						chk2 = true;
					}else{
						alert("�г����� �ߺ� �˴ϴ�.");
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
			<legend>ȸ������</legend>
			<div class="uk-form-row">
				<input id="u_id" name="u_id" type="text" placeholder="���̵�" />
				<input id="id_chk" name="id_chk" type="button" value="�ߺ� Ȯ��"/>
				
			</div>
			<div class="uk-form-row">
				<input id="u_pw" name="u_pw" type="password" placeholder="��й�ȣ" />
			</div>
			<div class="uk-form-row">
				<input id="u_pwchk" name="u_pwchk" type="password" placeholder="��й�ȣ Ȯ��" />
			</div>
			<div class="uk-form-row">
				<input id ="u_nick" name="u_nick" type="text" placeholder="�г���" />
				<input id="nick_chk" name="nick_chk" type="button" value="�ߺ� Ȯ��"/>
			</div>
			<div class="uk-form-row">
				<input id="u_name" name="u_name" type="text" placeholder="�̸�" />
			</div>
			<div class="uk-form-row">
				<input name="u_lv" type="radio" value="1" checked="checked">�Ϲ�ȸ��
				<input name="u_lv" type="radio" value="2">���ȸ��
			</div>
			<!-- <div class="uk-form-row">
				<input name="u_post" type="text" placeholder="post" />
			</div>
			<div class="uk-form-row">
				<input name="u_email" type="text" placeholder="email" />
			</div> -->
			<div class="uk-form-row">
				<input id="submit" type="button" value="�����ϱ�" /><input type="reset" value="�ٽ��ۼ�" />
			</div>
			
		</fieldset>
	</form>
</div>
<div id = "idresult">
	
</div>

</body>
</html>