<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
  <script src="/ediya/assets/vendor/jquery/jquery.als-2.1.min.js"></script>
<style type="text/css">
	.a{display:none;}
</style>
</head>
<body>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	<div class="a">Content</div>
	
	<a href="#" id="load">더보기</a>
	<script>
		$(function() {
			$(".a").slice(0,3).show();
			$("#load").click(function(e) {
				e.preventDefault();
				$(".a:hidden").slice(0,3).show();
				if($(".a:hidden").length == 0) {
					$("a").css("display", "none");
				}
			});
		});
	</script>
</body>

</html>