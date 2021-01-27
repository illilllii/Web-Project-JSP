<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div style="padding-top: 300px;">
	<input type='file' id='fileInput' />
	<div id="kind-input" class="d-flex" data-menu="drinks">
		<label class="menu-search-form-label"><input type="radio"
			name="kind" value="BREAD" data-a="bread" />BREAD</label> <label
			class="menu-search-form-label"><input type="radio"
			name="kind" value="DESSERT" data-a="dessert" />DESSERT</label> <label
			class="menu-search-form-label"><input type="radio"
			name="kind" value="COFFEE&ETC" data-a="etc" />COFFEE&ETC</label>
	</div>
	<input type='button' value='확인' onclick='fileCheck()'>
</div>


<script type='text/javascript'>
	//1MB(메가바이트)는 1024KB(킬로바이트)
	var maxSize = 2048;
	var a;
	$("#kind-input").data().menu;
	// /ediya/assets/img/menu/drinks/beverage/ICED딸기 라떼.png
	function fileCheck() {
		//$('input:radio[name="kind"]').click(function() {
		$('input:radio[name="kind"]').each(function(i) {
			if ($(this).is(":checked") == true) {
				a = "/ediya/assets/img/menu/";
				a += $("#kind-input").data().menu + "/";
				a += $(this).data().a + "/";
			}

		});

		//});
		//input file 태그.
		var kind = document
		var file = document.getElementById('fileInput').path;
		//파일 경로.
		var filePath = document.getElementById('fileInput').file.name;
		//전체경로를 \ 나눔.
		//var filePathSplit = filePath.split('\\');
		
		//전체경로를 \로 나눈 길이.
		//var filePathLength = filePathSplit.length;
		//마지막 경로를 .으로 나눔.
		//var fileNameSplit = filePathSplit[filePathLength - 1].split('.');
		//파일명 : .으로 나눈 앞부분
		//var fileName = fileNameSplit[0];
		//파일 확장자 : .으로 나눈 뒷부분
		//var fileExt = fileNameSplit[1];
		//파일 크기
		//var fileSize = file.files[0].size;

		//console.log("filePathLength : " + filePathSplit[1]);
		console.log('파일 경로 : ' + file);
		//console.log('파일 경로 : ' + (a+fileName));
		//console.log('파일명 : ' + fileName);
		//console.log('파일 확장자 : ' + fileExt);
		//console.log('파일 크기 : ' + fileSize);
		
		// C:\Users\82104\git\Web-Project-JSP\WebContent\assets\img\menu\bakery\bread
	}
</script>
</body>
</html>

