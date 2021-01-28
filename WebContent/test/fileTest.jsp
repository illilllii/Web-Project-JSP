<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div style="padding-top: 300px;">
	<input type='file' id='fileInput' />
	<div id="kind-input" class="d-flex" data-menu="bakery">
		<label class="menu-search-form-label"><input type="radio"
			name="kind" value="BREAD" data-a="bread" />BREAD</label> <label
			class="menu-search-form-label"><input type="radio"
			name="kind" value="DESSERT" data-a="dessert" />DESSERT</label> <label
			class="menu-search-form-label"><input type="radio"
			name="kind" value="COFFEE&ETC" data-a="etc" />COFFEE&ETC</label>
	</div>
	<div id="a"></div>
	<input type='button' value='확인' onclick='fileCheck()'>



	<h3>로컬에 있는 이미지를 바로 브라우저에 표시</h3>
	<img id="preview" src="" width="700" alt="로컬에 있는 이미지가 보여지는 영역"> <input
		type="file" id="getfile" accept="image/*">



</div>


<script type='text/javascript'>



var file = document.querySelector('#getfile');

file.onchange = function () { 
    var fileList = file.files ;
    
    // 읽기
    var reader = new FileReader();
    reader.readAsDataURL(fileList [0]);

    //로드 한 후
    reader.onload = function  () {
        document.querySelector('#preview').src = reader.result ;
    }; 
}; 
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
		var adddd = document.getElementById("fileInput").files[0].path;
		alert(adddd); 
		//});
		//input file 태그.
		var kind = document
		var file = document.getElementById('fileInput').path;
		//파일 경로.
		var filePath = document.getElementById('fileInput').value;
		//전체경로를 \ 나눔.
		var filePathSplit = filePath.split('\\');

		//전체경로를 \로 나눈 길이.
		var filePathLength = filePathSplit.length;
		//마지막 경로를 .으로 나눔.
		var fileNameSplit = filePathSplit[filePathLength - 1].split('.');
		//파일명 : .으로 나눈 앞부분
		var fileName = fileNameSplit[0];
		//파일 확장자 : .으로 나눈 뒷부분
		var fileExt = fileNameSplit[1];
		//파일 크기
		//var fileSize = file.files[0].size;

		//console.log("filePathLength : " + filePathSplit[1]);
		console.log("filePathSplite : " + filePathSplit[2]);
		console.log('파일 경로 : ' + filePath);
		console.log('파일 경로 : ' + (a + filePathSplit[2]));
		//console.log('파일명 : ' + fileName);
		//console.log('파일 확장자 : ' + fileExt);
		//console.log('파일 크기 : ' + fileSize);
		$("#a").html("<img src='" + (a + filePathSplit[2]) + "'/>");
		// C:\Users\82104\git\Web-Project-JSP\WebContent\assets\img\menu\bakery\bread
	}
</script>
</body>
</html>

