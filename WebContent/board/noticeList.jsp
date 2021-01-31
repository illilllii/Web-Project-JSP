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
					<li onclick="location.href='/ediya/notice?cmd=noticeList&page=0'"
						class="active">공지사항</li>
					<li onclick="location.href ='?cmd=youtube'">이디야 유튜브</li>
				</ul>

			</div>
		</div>
	</div>
</section>

<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container" style="width: 1000px;">

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


<!-- 검색 -->
<div class="noticePage_box">
	<div class="notice_search_container">
		<div class="seach_box">
			<form name="search_form" action="/ediya/notice?cmd=noticeList">
				<div class="search_bar">
					<input type="hidden" name="cmd" value="searchNotice" /> <input
						type="hidden" name="page" value="0" /> <input type="text"
						name="keyword" class="search_txt" />
					<button class="search_btn"></button>
				</div>
			</form>
		</div>
	</div>

	<ul class="board_notice_List">
		<!-- 제일 중요한 공지사항 -->
		<c:forEach var="important" items="${importants}">
			<li>
				<div class="board_notice_logo"></div>
				<div class="board_notice_content">
					<h5>
						<a href="/ediya/notice?cmd=detail&id=${important.id}">${important.title}</a>
					</h5>
					<p>
						<a href="/ediya/notice?cmd=detail&id=${important.id}">${important.content}</a>
					</p>
					<p class="btn_area">
						<span class="board_saveDate">${important.createDate}</span>
					</p>
				</div>
			</li>
		</c:forEach>
	</ul>

	<ul class="board_notice_List_normal">
		<c:forEach var="notice" items="${notices}">
			<li>
				<div class="board_num">${notice.id}</div>
				<div class="board_notice_content">
					<h5>
						<a href="/ediya/notice?cmd=detail&id=${notice.id}">${notice.title}</a>
					</h5>
					<p>
						<a href="/ediya/notice?cmd=detail&id=${notice.id}">${notice.content}</a>
					</p>
					<p class="btn_area">
						<span class="board_saveDate">${notice.createDate}</span>
					</p>
				</div>
			</li>
		</c:forEach>
	</ul>

	<c:if test="${sessionScope.principal.userRole eq 'BOARDADMIN'}">
		<button class="btn btn-primary"
			style="float: right; background-color: #002f6c; border: #002f6c;"
			onClick="location.href ='?cmd=noticeForm'">글쓰기</button>
	</c:if>

	<br />
	<div class="container" style="padding: 0 45%;">
	<ul class="pagination">
		<c:choose>
			<c:when test="${param.page == 0}">
				<li class="page-item disabled"><a style="color:#002f6c;" class="page-link" href="#">◁</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a style="color:#002f6c;" class="page-link"
					href="/ediya/notice?cmd=noticeList&page=${param.page-1}">◀</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${lastPage == param.page}">
				<li class="page-item disabled"><a style="color:#002f6c;"class="page-link" href="#">▷</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a style="color:#002f6c;" class="page-link"
					href="/ediya/notice?cmd=noticeList&page=${param.page+1}">▶</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</div>







<%@ include file="../layout/footer.jsp"%>

</body>
</html>