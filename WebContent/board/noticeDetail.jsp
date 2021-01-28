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
					<li onclick="location.href ='?cmd=event">이벤트</li>
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
					href="/ediya/notice?cmd=noticeList&page=0">이디야 소식</a></li>
				<li class="icofont-simple-right"><a
					href="/ediya/notice?cmd=noticeList&page=0">공지사항</a></li>
			</ol>
		</div>

	</div>
</section>
<!-- End Breadcrumbs -->

<!-- 관리자: 게시글 수정, 삭제 -->
<div class="detail_container" style="width: 1110px; margin: auto;">
	<c:if test="${sessionScope.principal.userRole eq 'ADMIN'}">
		<a href="/ediya/notice?cmd=updateNotice&id=${dto.id}"
			class="btn btn-primary"
			style="background-color: #002f6c; border: #002f6c;"> 수정</a>
		<button onClick="deleteById(${dto.id})" class="btn btn-danger" style="height: 36px;">삭제</button>
	</c:if>
</div>

<div class="detail_container"
	style="margin-bottom: 100px; width: 1110px; margin: auto;">
	<div class="board_view_title">
		<p class="datail_txt">${dto.title}</p>
		<p class="datail_s_txt">${dto.createDate}</p>
	</div>
	<div class="board_view_content">
		<p>${dto.content}</p>
	</div>
	<div class="board_view_util">
		<a href="/ediya/notice?cmd=noticeList&page=0">목록보기</a>
	</div>
	
	<div class="board_view_page">
			<dl>
				<dt>이전글</dt>
				<dd style="width: 800px;"><a href="이전글 id" class="pn_ac" >제목</a></dd>
				<dd class="list_date">날짜</dd>
			</dl>
			<dl>
				<dt>다음글</dt>
				<dd style="width: 800px;"><a href="다음글 id" class="pn_ac">제목 </a></dd>
				<dd class="list_date">날짜</dd>
			</dl>
	</div>

</div>

<%@ include file="../layout/footer.jsp"%>
</body>
</html>