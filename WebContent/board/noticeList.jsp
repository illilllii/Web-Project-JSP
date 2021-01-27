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
					<li onclick="location.href ='?cmd=notice'" class="active">공지사항</li>
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
					href="<%=request.getContextPath()%>/notice?cmd=noticeList">이디야
						소식</a></li>
				<li class="icofont-simple-right"><a
					href="<%=request.getContextPath()%>/notice?cmd=noticeList">공지사항</a></li>
			</ol>
		</div>

	</div>
</section>
<!-- End Breadcrumbs -->


<!-- 검색 -->
<div class="noticePage_box">
	<div class="notice_search_container">
		<div class="seach_box">
			<form name="search_form" action="/ediya/notice?cmd=noticelist">
				<div class="search_bar">
					<input type="hidden" name="cmd" value="searchNotice" /> <input
						type="text" name="keyword" class="search_txt" />
					<button class="search_btn"></button>
				</div>
			</form>
		</div>
	</div>
	
	<ul class="board_notice_List">
			<li>
					<div class="board_notice_logo"></div>
					<div class="board_notice_content">
					<h5>
					<a href="/ediya/notice?cmd=detail&id=${notice.id}">연습</a></h5>
					<p><a href="">2020년 5월 25일부터 이디야커피랩의 영업시간이 아래와같이 &nbsp;변경되오니 참고부탁드립니다.감사합니다.&nbsp;&nbsp;</a></p>	
                    <p class="btn_area">
					<span class="board_saveDate">2020.05.21</span>
					</p>
				</div>
			</li>
			
			<li>
				<div class="board_num">79</div>
				<div class="board_notice_content">
					<h5><a href="">EDIYA COFFEE X SUBSUB 2021다이어리세트 상세페이지 &amp; 판매...</a></h5>
					<p><a href="">※ 판매매장 리스트는 상세이미지 하단에서 확인 하실 수 있습니다. 판매매장 바로보기&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></p>	
					<p class="btn_area">
						<span class="board_saveDate">2020.09.14</span>
					</p>
				</div>
			</li>
			
			
			<li>
				<div class="board_num">79</div>
				<div class="board_notice_content">
					<h5><a href="">EDIYA COFFEE X SUBSUB 2021다이어리세트 상세페이지 &amp; 판매...</a></h5>
					<p><a href="">※ 판매매장 리스트는 상세이미지 하단에서 확인 하실 수 있습니다. 판매매장 바로보기&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></p>	
					<p class="btn_area">
						<span class="board_saveDate">2020.09.14</span>
					</p>
				</div>
			</li>
			
			
			<li>
				<div class="board_num">79</div>
				<div class="board_notice_content">
					<h5><a href="">EDIYA COFFEE X SUBSUB 2021다이어리세트 상세페이지 &amp; 판매...</a></h5>
					<p><a href="">※ 판매매장 리스트는 상세이미지 하단에서 확인 하실 수 있습니다. 판매매장 바로보기&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></p>	
					<p class="btn_area">
						<span class="board_saveDate">2020.09.14</span>
					</p>
				</div>
			</li>
			
			
			<li>
				<div class="board_num">79</div>
				<div class="board_notice_content">
					<h5><a href="">EDIYA COFFEE X SUBSUB 2021다이어리세트 상세페이지 &amp; 판매...</a></h5>
					<p><a href="">※ 판매매장 리스트는 상세이미지 하단에서 확인 하실 수 있습니다. 판매매장 바로보기&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></p>	
					<p class="btn_area">
						<span class="board_saveDate">2020.09.14</span>
					</p>
				</div>
			</li>
			
	</ul>
</div>




<%@ include file="../layout/footer.jsp"%>

</body>
</html>