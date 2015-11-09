/**
 * canvasHide 클래스를 등록한 버튼이나 태그를 클릭하면 
 * 나머진 들어가고 클릭한것만 나옴
 */

$(function() {
	// var modal = UIkit.modal(".modalSelector");
	$(".canvasHide").click(function() {
		// alert("#login click:")
		//UIkit.offcanvas.hide([ force = false ])
		//alert($(this).attr("value"))
		UIkit.offcanvas.show($(this).attr("value"));
		return false
		// modal.show();

		/*
		 * if (modal.isActive()) { modal.hide(); } else { }
		 */

	})
	
	
})
