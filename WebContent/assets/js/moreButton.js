$(function() {
	$(".menu-item").slice(0,4).show();
	$("#more-button").click(function(e) {
		e.preventDefault();
		$(".menu-item:hidden").slice(0,4).show();
		if($(".menu-item:hidden").length == 0) {
			$("#more-button").css("display", "none");
		}
	});
});