<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="menu" class="menu">
	<div class="menu__container" id="notice__container">
		<div class="container">
			<div class="menu__title">
				<p class="menu__maintitle">공지사항</p>
				<p class="menu__subtitle">
					이디야는 국내브랜드의 자부심을 지키며<br> 대한민국 커피 문화를 이끌어 나갑니다.
				</p>
			</div>
			<div class="menu__list d-flex justify-content-center">
				<ul class="d-flex menu__list-content">
					<li onclick="location.href ='?cmd=noticeList'" class="active">공지사항</li>
					<li onclick="location.href ='?cmd=youtube'">이디야 유튜브</li>
				</ul>

			</div>
		</div>
	</div>
</section>

<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container">

		<div class="d-flex justify-content-end align-items-center">
			<ol>
				<li><a href="index.html">Home</a></li>
				<li class="icofont-simple-right"><a
					href="<%=request.getContextPath()%>/notice?cmd=noticeList">이디야
						소식</a></li>
				<li class="icofont-simple-right"><a
					href="<%=request.getContextPath()%>/notice?cmd=noticeList">공지사항</a></li>
			</ol>
		</div>

	</div>
</section>
<!-- End Breadcrumbs -->

<div class="container" style="margin-bottom: 100px;">
	<div class="noticeForm_board_top"></div>

	<form action="/ediya/notice?cmd=update" method="POST">
		<input type="hidden" name="id" value="${dto.id}" />
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" placeholder="제목을 입력하세요" id="title" name="title" value="${dto.title}">
		</div>

		<div class="form-group">
			<label for="content">내용:</label>
			<textarea id="summernote" class="form-control " rows="11"
				id="content" name="content" >${dto.content}</textarea>
		</div>

		<button type="submit" class="btn btn-primary"
			style="float: right; background-color: #002f6c; border: #002f6c;">등록하기</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>

<script>

$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 500,            // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR"				// 한글 설정
          
	});

});
</script>

</body>
</html>