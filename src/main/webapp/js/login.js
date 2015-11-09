/**
 * 
 */
	/**
	 * 로그인 된후 반응 처리.
	 * 메뉴에서 로그인 회원가입 버튼이 사라지고 받은 정보를 메뉴 클릭시 보여줌
	 * @param u_no
	 * @param u_id
	 * @param u_nick
	 * @param u_name
	 */
	function login(u_no, u_id, u_nick, u_name) {
		$(".stateLogin").removeClass("uk-hidden")
		$(".stateLogout").addClass("uk-hidden")
/*		$(".userInfo").removeClass("uk-hidden")
		$(".logout").removeClass("uk-hidden")
		$(".login").addClass("uk-hidden")
		$(".userCreate").addClass("uk-hidden")*/
		//alert( $(".stateLogin"))
		$(".u_no").html(u_no)
		$(".u_id").html(u_id)
		$(".u_nick").html(u_nick)
		$(".u_name").html(u_name)
	}
	/**
	 * 로그아웃된후 된후 반응 처리
	 * 로그인과 반대 반응
	 */
	function logout() {
		$(".stateLogin").addClass("uk-hidden")
		$(".stateLogout").removeClass("uk-hidden")
		//alert( $(".stateLogout"))
/*		$(".userInfo").addClass("uk-hidden")
		$(".logout").addClass("uk-hidden")
		$(".login").removeClass("uk-hidden")
		$(".userCreate").removeClass("uk-hidden")*/
	}