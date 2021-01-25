<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>


<section id="menu" class="menu">
	<div class="menu__container" id="drinks__container">
		<div class="container">
			<div class="menu__title">
				<p class="menu__maintitle">음료</p>
				<p class="menu__subtitle">ALWAYS BESIDE YOU, EDIYA COFFEE</p>
			</div>
			<div class="menu__list d-flex justify-content-center">
				<ul class="d-flex menu__list-content">
					<li onclick="location.href ='?cmd=drinks'" class="active">음료</li>
					<li onclick="location.href ='?cmd=bakery'">베이커리</li>
					<li onclick="location.href ='?cmd=snack'">스낵</li>
					<li onclick="location.href ='?cmd=md'">MD</li>
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
					<li class="icofont-simple-right">음료</li>
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
			    	<c:forEach var="drink" items="${dto}">
			    		
			    			<li class="als-item">
			      				<img src="${drink.imageSrc}"  />
			      				<div class="recomm-menu-content">
			      					<div class="menu-content__maintitle">${drink.name}</div>
									<div class="menu-content__subtitle">${drink.subname}</div>
									<hr class="content-hr"/>
									<div class="menu-content__content">
										${drink.content}
									</div>
			      				</div>
			     			 </li>
			    		
			    	</c:forEach>
			     
			
			    </ul>
			  </div>
			  <span class="als-next"><i class="icofont-thin-right"></i></span>
			</div>
			<div class="menu-search">
				<ul class="d-flex justify-content-between">
					<li class="menu-search-title d-flex">메뉴 검색</li>
					<li class="menu-search-form">
					<form class="form-inline d-flex justify-content-end" action="/ediya/menu?cmd=drink">
						<input type="hidden" name="cmd" value="drinkSearch" />
						<input type="text"name="keyword" />
						<button><i class="icofont-search"></i></button>
					</form>
					
					</li>
				</ul>
				<hr />
				<label class="menu-search-form-label"><input type="checkbox"
					name="coffee" value="coffee" />COFFEE</label> <label
					class="menu-search-form-label"><input type="checkbox"
					name="beverage" value="beverage" />BEVERAGE</label> <label
					class="menu-search-form-label"><input type="checkbox"
					name="blending tea" value="blending tea" />BLENDING TEA</label> <label
					class="menu-search-form-label"><input type="checkbox"
					name="flatccino" value="flatccino" />FLATCCINO</label> <label
					class="menu-search-form-label"><input type="checkbox"
					name="shake" value="shake" />SHAKE & ADE</label> <label
					class="menu-search-form-label"><input type="checkbox"
					name="iceFlakes" value="iceFlakes" />ICE FLAKES</label> <label
					class="menu-search-form-label"><input type="checkbox"
					name="rtd" value="rtd" />RTD</label>
			</div>

		</div>
		<div class="menu-items container">
			<c:forEach var="drink" items="${drinks}">
				<div class="menu-item">
				<div id="menu-item${drink.id}">
					<img src="${drink.imageSrc}" />
					<div class="menu-item-title">${drink.name}</div>
				</div>
				<div class="menu-content">
					<div class="menu-content__title d-flex justify-content-between">
						<div class="menu-content__title-left">
							<div class="menu-content__maintitle">${drink.name}</div>
							<div class="menu-content__subtitle">${drink.subname}</div>
						</div>
					</div>
					<hr class="content-hr"/>
					<div class="menu-content__content">
						${drink.content}
					</div>
				</div>
			</div>
			</c:forEach>
			
		</div>

		<div class="more-button container">
				<button id="more-button">더보기 +</button>
		</div>
	</section>

</main>
<!-- End #main -->
<!-- ======= Footer ======= -->
<script src="/ediya/assets/js/menuCarousel.js"></script>
<script src="/ediya/assets/js/moreButton.js"></script>
<%@ include file="../layout/footer.jsp"%>


</body>
</html>