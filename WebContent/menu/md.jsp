<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="menu" class="menu">
	<div class="menu__container" id="md__container">
		<div class="container">
			<div class="menu__title">
				<p class="menu__maintitle">MD상품</p>
				<p class="menu__subtitle">ALWAYS BESIDE YOU, EDIYA MD</p>
			</div>
			<div class="menu__list d-flex justify-content-center">
				<ul class="d-flex menu__list-content">
					<li onclick="location.href ='drinks.jsp'">음료</li>
					<li onclick="location.href ='bakery.jsp'">베이커리</li>
					<li onclick="location.href ='snack.jsp'">스낵</li>
					<li onclick="location.href ='md.jsp'" class="active">MD</li>
				</ul>

			</div>
		</div>
	</div>
</section>
<main id="main" data-aos="fade-up">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<div class="d-flex justify-content-end align-items-center">
				<ol>
					<li><a href="index.html">Home</a></li>
					<li class="icofont-simple-right">메뉴</li>
					<li class="icofont-simple-right">MD</li>
				</ol>

			</div>


		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="main__container">
		<div class="container">
			<div class="menu-recomm">
				<h1>추천 상품</h1>
			</div>
			
			<div class="als-container" id="demo3">
			  <span class="als-prev"><i class="icofont-thin-left"></i></span>
			  <div class="als-viewport">
			    <ul class="als-wrapper">
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/자몽에이드.png" /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/청포도에이드.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/초코쿠키쉐이크.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/딸기쉐이크.png"  /></li>
			       <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/자몽에이드.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/청포도에이드.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/초코쿠키쉐이크.png"  /></li>
			      <li class="als-item"><img src="../assets/img/menu/drinks/shake&ade/딸기쉐이크.png"  /></li>
			
			    </ul>
			  </div>
			  <span class="als-next"><i class="icofont-thin-right"></i></span>
			</div>
			

		</div>
		<div class="menu-items container">
			<div class="menu-item">
				<div id="menu-item1">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
					<div class="menu-item-title">ICED딸기라떼</div>
				</div>
				<div class="menu-content">
					<div class="menu-content__title d-flex justify-content-between">
						<div class="menu-content__title-left">
							<div class="menu-content__maintitle">ICED딸기라떼</div>
							<div class="menu-content__subtitle">Strawberry Latte</div>
						</div>
					</div>
					<hr />
					<div class="menu-content__content">
						새콤달콤 딸기와 우유가 맛있게<br />어우러진 음료
					</div>
				</div>
			</div>

			<div class="menu-item">
				<div id="menu-item2">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
					<div class="menu-item-title">ICED딸기라떼</div>
				</div>
				<div class="menu-content">
					<div class="menu-content__title d-flex justify-content-between">
						<div class="menu-content__title-left">
							<div class="menu-content__maintitle">ICED딸기라떼</div>
							<div class="menu-content__subtitle">Strawberry Latte</div>
						</div>
					</div>
					<hr />
					<div class="menu-content__content">
						새콤달콤 딸기와 우유가 맛있게<br />어우러진 음료
					</div>
				</div>
			</div>
			<div class="menu-item">
				<div id="menu-item3">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
				</div>
			</div>
			<div class="menu-item">
				<div id="menu-item4">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
				</div>
			</div>
			<div class="menu-item">
				<div id="menu-item5">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
				</div>
			</div>
			<div class="menu-item">
				<div id="menu-item6">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
				</div>
			</div>
			<div class="menu-item">
				<div id="menu-item7">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
				</div>
			</div>
			<div class="menu-item">
				<div id="menu-item8">
					<img src="../assets/img/menu/drinks/shake&ade/딸기라떼.png" />
				</div>
			</div>
			
		</div>

		<div class="more-button container">
				<button>더보기 +</button>
		</div>
	</section>

</main>
<!-- End #main -->
<!-- ======= Footer ======= -->
<script>
$("#demo3").als({
	visible_items: 3,
	scrolling_items: 1,
	orientation: "horizontal",
	circular: "yes",
	autoscroll: "yes",
	interval: 3000
});
</script>
<%@ include file="../layout/footer.jsp"%>


</body>
</html>