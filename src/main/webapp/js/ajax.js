/**
 * 사용법: ajax("#user", "testUserCreate.ac", "#body")
 * 
 * @param form_name
 *            전송할 폼 이름
 * @param url
 *            전송할 주소
 * @param tag_name
 *            바뀔 태그
 */
function ajax(form_name, url, tag_name) {

	var string = $(form_name).serialize();

	$.ajax({
		url : url,
		type : "post",
		data : string, // 인수전달용
		dataType : 'text',
		success : function(result) {
			$(tag_name).html(result)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$(tag_name).load("errer.jsp", {
				/* jqXHR:jqXHR, */
				textStatus : textStatus,
				errorThrown : errorThrown
			});
			/* alert(textStatus+":"+errorThrown) */
		}
	})
}
function ajaxFile1(form_name, url, tag_name) {
//	$(form_name).attr({
//		"method" : "POST",
//		"action" : url
//	})
	alert("전송 전!!");
	$(form_name).ajaxForm({
		target:tag_name,
		type : "POST",
		url : url,
		// 보내기전 validation check가 필요할경우
		beforeSubmit : function(data, frm, opt) {
			alert("전송전!!");
			return true;
		},
		// submit이후의 처리
		success : function(result) {
			$(tag_name).html(result)
			alert("전송성공!!");
		}
		// ajax error
//		,error : function(jqXHR, textStatus, errorThrown) {
//			$(tag_name).load("errer.jsp", {
//				/* jqXHR:jqXHR, */
//				textStatus : textStatus,
//				errorThrown : errorThrown
//			});
//			/* alert(textStatus+":"+errorThrown) */
//		}
	});

	// var string = $(form_name).serialize();
	//
	// $.ajax({
	// url : url,
	// type : "post",
	// data : string, // 인수전달용
	// dataType : 'text',
	// success : function(result) {
	// $(tag_name).html(result)
	// },
	// error : function(jqXHR, textStatus, errorThrown) {
	// $(tag_name).load("errer.jsp", {
	// /* jqXHR:jqXHR, */
	// textStatus : textStatus,
	// errorThrown : errorThrown
	// });
	// /* alert(textStatus+":"+errorThrown) */
	// }
	// })
}
/**
 * { mode : "login", code : code, uid : uid, pass : pass }
 * 
 * @param url
 */
function ajaxparams(url, data, changTag) {
	$.ajax({
		url : url,
		type : 'post', // post,get,등..전송방식
		dataType : 'text',// 데이타 타입
		data : data,
		success : function(result) {
			$(changTag).html(result)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$(changTag).load("errer.jsp", {
				/* jqXHR:jqXHR, */
				textStatus : textStatus,
				errorThrown : errorThrown
			});
			/* alert(textStatus+":"+errorThrown) */
		}
	})
}

function ajaxUploadFormData(form_name, url, tag_name) {

	var oMyForm = new FormData();
	oMyForm.append("file", file2.files[0]);

	$.ajax({
		url : url,
		data : oMyForm,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(data) {
			$('#result').append(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$(tag_name).load("errer.jsp", {
				/* jqXHR:jqXHR, */
				textStatus : textStatus,
				errorThrown : errorThrown
			});
			/* alert(textStatus+":"+errorThrown) */
		}
	});
}
/**
 * @param url
 *            전송할 주소
 * @param tag_name
 *            바뀔 태그 사용법: ajax( "testUserCreate.ac", "#body")
 */
function ajaxNoForm(url, tag_name) {
	// var string = $(form_name).serialize();

	$.ajax({
		url : url,
		type : "post",
		// data : string, // 인수전달용
		dataType : 'text',
		success : function(result) {
			$(tag_name).html(result)
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$(tag_name).load("errer.jsp", {
				/* jqXHR:jqXHR, */
				textStatus : textStatus,
				errorThrown : errorThrown
			});
			/* alert(textStatus+":"+errorThrown) */
		}
	})
}
/**
 * @param url
 *            전송할 주소
 * @param success
 *            성공했을때 작동될 함수명
 * @param error
 *            실패했을때 작동될 함수명
 */
function ajaxFunction(url, success, error) {
	// var string = $(form_name).serialize();

	$.ajax({
		url : url,
		type : "post",
		// data : string, // 인수전달용
		dataType : 'text',
		success : success,
		error : error
	})
}
/**
 * form_name폼의 내용을 url로 전송후 성공 실패 반응 처리
 * 
 * @param form_name
 *            전송할 폼
 * @param url
 *            전송할 주소
 * @param success
 *            성공했을때 작동될 함수명
 * @param error
 *            실패했을때 작동될 함수명
 */
function ajaxFormFunction(form_name, url, success, error) {
	var string = $(form_name).serialize();

	$.ajax({
		url : url,
		type : "post",
		data : string, // 인수전달용
		dataType : 'text',
		success : success,
		error : error
	})
}