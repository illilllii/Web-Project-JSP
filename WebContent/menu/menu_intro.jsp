<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="menu" class="menu">
	<div class="menu__container" id="menu-intro__container">
		<div class="container">
			<div class="menu__title">
				<p class="menu__maintitle">메뉴</p>
				<p class="menu__subtitle">ALWAYS BESIDE YOU, EDIYA COFFEE</p>
				<p class="menu__subtitle-kr">한 잔의 커피 그 이상의 감동을 경험하세요.</p>
			</div>
			<div class="menu__list d-flex justify-content-center">
				<ul class="d-flex menu__list-content">
					<li onclick="location.href ='/ediya/menu?cmd=drinks'">음료</li>
					<li onclick="location.href ='/ediya/menu?cmd=bakery'">베이커리</li>
					<li onclick="location.href ='/ediya/menu?cmd=snack'">스낵</li>
					<li onclick="location.href ='/ediya/menu?cmd=md'">MD</li>
				</ul>

			</div>
		</div>
	</div>
	<div class="menu__container" id="menu-intro-drinks__container">
		<div class="container pt-100">
			<div class="menu__title ta-left">
				<p class="menu__maintitle">음료</p>
				<p class="menu__subtitle">특별한 경험을 선사합니다.</p>
				<p class="menu__subtitle-kr">오직 품질에 대한 열정,<br />이디야의 노력을 음료 한 잔에 가득 담았습니다.</p>
			</div>
			<div class="menu__href-button ta-left">
				<span onclick="location.href ='/ediya/menu?cmd=drinks'">자세히 보기</span>
			</div>
		</div>
	</div>
	<div class="menu__container" id="menu-intro-bakery__container">
		<div class="container pt-100">
			<div class="menu__title ta-right">
				<p class="menu__maintitle">베이커리</p>
				<p class="menu__subtitle">갓 구워낸 신선함, 그 맛과 영양을 그대로</p>
				<p class="menu__subtitle-kr">좋은 재료를 엄선해 만든 빵으로 든든한 하루를 시작하세요.</p>
			</div>
			<div class="menu__href-button ta-right">
				<span onclick="location.href ='/ediya/menu?cmd=bakery'">자세히 보기</span>
			</div>
			
		</div>
	</div>
	<div class="menu__container" id="menu-intro-md__container">
		<div class="container pt-100">
			<div class="menu__title ta-left">
				<p class="menu__maintitle">MD</p>
				<p class="menu__subtitle">특별함을 더해줄 상품들</p>
				<p class="menu__subtitle-kr">이디야 커피의 다양한 컬렉션으로 당신의 일상을 더 특별하게!</p>
			</div>
			<div class="menu__href-button ta-left">
				<span onclick="location.href ='/ediya/menu?cmd=md'">자세히 보기</span>
			</div>
		</div>
	</div>
</section>

<!-- End #main -->
<!-- ======= Footer ======= -->

<%@ include file="../layout/footer.jsp"%>


</body>
</html>