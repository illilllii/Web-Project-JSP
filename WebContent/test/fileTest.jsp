<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>File Test</title>
		<script type='text/javascript'>
			//1MB(메가바이트)는 1024KB(킬로바이트)
			var maxSize = 2048;
			
			function fileCheck() {
				//input file 태그.
				var file = document.getElementById('fileInput');
				//파일 경로.
				var filePath = file.value;
				//전체경로를 \ 나눔.
				var filePathSplit = filePath.split('\\'); 
				//전체경로를 \로 나눈 길이.
				var filePathLength = filePathSplit.length;
				//마지막 경로를 .으로 나눔.
				var fileNameSplit = filePathSplit[filePathLength-1].split('.');
				//파일명 : .으로 나눈 앞부분
				var fileName = fileNameSplit[0];
				//파일 확장자 : .으로 나눈 뒷부분
				var fileExt = fileNameSplit[1];
				//파일 크기
				var fileSize = file.files[0].size;
				
				console.log('파일 경로 : ' + filePath);
				console.log('파일명 : ' + fileName);
				console.log('파일 확장자 : ' + fileExt);
				console.log('파일 크기 : ' + fileSize);
			}
		</script>
	</head>
	<body>
		<input type='file' id='fileInput'>
		<input type='button' value='확인' onclick='fileCheck()'>
	</body>
</html>

