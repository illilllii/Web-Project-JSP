<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="menu" class="menu">
	<div class="menu__container" id="drinks__container">
		<div class="container">
			<div class="menu__title">
				<p class="menu__maintitle">음료</p>
				<p class="menu__subtitle">ALWAYS BESIDE YOU, EDIYA COFFEE</p>
			</div>
			<div class="menu__list d-flex justify-content-center">
				<!--<table class="menu__list-table">
					<tr>
						<td><div class="menu__list-title" onclick="location.href ='#'">음료</div></td>
						<td><div class="menu__list-title" onclick="location.href ='#'">음료</div></td>
						<td><div class="menu__list-title" onclick="location.href ='#'">음료</div></td>
						<td><div class="menu__list-title" onclick="location.href ='#'">음료</div></td>
					</tr>
				</table>-->
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
					<li class="icofont-simple-right">음료</li>
				</ol>

			</div>


		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="main__container">
		<div class="container">
			<div class="menu-search">
				<ul class="d-flex justify-content-between">
					<li class="menu-search-title d-flex">메뉴 검색</li>
					<li class="menu-search-form"><input type="text" /><i
						class="icofont-search"></i></li>
				</ul>
				<hr />
				<label><input type="checkbox" name="coffee" value="coffee" />COFFEE</label>
				<label><input type="checkbox" name="beverage"
					value="beverage" />BEVERAGE</label> <label><input type="checkbox"
					name="blending tea" value="blending tea" />BLENDING TEA</label> <label><input
					type="checkbox" name="flatccino" value="flatccino" />FLATCCINO</label> <label><input
					type="checkbox" name="shake" value="shake" />SHAKE & ADE</label> <label><input
					type="checkbox" name="iceFlakes" value="iceFlakes" />ICE FLAKES</label> <label><input
					type="checkbox" name="rtd" value="rtd" />RTD</label>
			</div>

		</div>
	</section>

</main>
<!-- End #main -->
<!-- ======= Footer ======= -->
<%@ include file="../layout/footer.jsp"%>
</body>
</html>