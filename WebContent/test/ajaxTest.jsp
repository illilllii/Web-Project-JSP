<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>

<section id="menu" class="menu">
	<div class="menu__container" id="bakery__container">
		<div class="container">
			<div class="menu__title">
				<p class="menu__maintitle">베이커리</p>
				<p class="menu__subtitle">ALWAYS BESIDE YOU, EDIYA BAYKERY</p>
			</div>
			<div class="menu__list d-flex justify-content-center">
				<ul class="d-flex menu__list-content">
					<li onclick="location.href ='?cmd=drinks'">음료</li>
					<li onclick="location.href ='?cmd=bakery'" class="active">베이커리</li>
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
					<li class="icofont-simple-right">베이커리</li>
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
						<c:forEach var="bakery" items="${dto}">

							<li class="als-item"><img src="${bakery.imageSrc}" />
								<div class="recomm-menu-content">
									<div class="menu-content__maintitle">${bakery.name}</div>
									<div class="menu-content__subtitle">${bakery.subname}</div>
									<hr class="content-hr" />
									<div class="menu-content__content">${bakery.content}</div>
								</div>
						</c:forEach>

					</ul>
				</div>
				<span class="als-next"><i class="icofont-thin-right"></i></span>
			</div>
			<div class="menu-search">
				<ul class="d-flex justify-content-between">
					<li class="menu-search-title d-flex">메뉴 검색</li>
					<li class="menu-search-form"><input type="text" name="keyword" />
						<button class="search-btn">
							<i class="icofont-search"></i>
						</button></li>
				</ul>
				<hr />
				<div id="kind-input" class="d-flex">
					<label class="menu-search-form-label"><input
						type="checkbox" name="kind" value="BREAD" />BREAD</label> <label
						class="menu-search-form-label"><input type="checkbox"
						name="kind" value="DESSERT" />DESSERT</label> <label
						class="menu-search-form-label"><input type="checkbox"
						name="kind" value="COFFEE&ETC" />COFFEE&ETC</label>
				</div>
			</div>

		</div>
		<div id="menu-items" class="menu-items container">
			<c:forEach var="bakery" items="${bakeries}">
				<div class="menu-item">
					<div id="menu-item${bakery.id}">
						<img src="${bakery.imageSrc}" />
						<div class="menu-item-title">${bakery.name}</div>
					</div>
					<div class="menu-content">
						<div class="menu-content__title d-flex justify-content-between">
							<div class="menu-content__title-left">
								<div class="menu-content__maintitle">${bakery.name}</div>
								<div class="menu-content__subtitle">${bakery.subname}</div>
							</div>
						</div>
						<hr />
						<div class="menu-content__content">${bakery.content}</div>
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
<script>
	function addContent(data) {

		var contentItem = [];
		for (var i = 0; i < data.length; i++) {
			contentItem[i] = [ '' ];
			contentItem[i] += '<div class="menu-item">';
			contentItem[i] += '<img src= "'+data[i].imageSrc+'" />';
			contentItem[i] += '<div class="menu-item-title">' + data[i].name
					+ '</div>';
			contentItem[i] += '<div class="menu-content">';
			contentItem[i] += '<div class="menu-content__title d-flex justify-content-between">';
			contentItem[i] += '<div class="menu-content__title-left">';
			contentItem[i] += '<div class="menu-content__maintitle">'
					+ data[i].name + '</div>';
			contentItem[i] += '<div class="menu-content__subtitle">'
					+ data[i].subname + '</div>';
			contentItem[i] += '</div>';
			contentItem[i] += '</div>';
			contentItem[i] += '<hr />';
			contentItem[i] += '<div class="menu-content__content">'
					+ data[i].content + '</div>';
			contentItem[i] += '</div>';
			contentItem[i] += '</div>';

		}
		$("#menu-items").html(contentItem);

		$("#more-button").css("display", "block");
		$("#more-button").css("margin", "0 auto");
		$(".menu-item").slice(0, 4).show();
		$("#more-button").click(function(e) {
			e.preventDefault();
			$(".menu-item:hidden").slice(0, 4).show();
			if ($(".menu-item:hidden").length == 0) {
				$("#more-button").css("display", "none");
			}
		});

	}

	var keyword;
	var kindArray = [];
	$('input:text[name="keyword"]').on(
			"propertychange change keyup paste input", function() {
				keyword = $('input:text[name="keyword"]').val();
				$('input:checkbox[name="kind"]').each(function(i) {
					if ($(this).is(":checked") == true) {
						kindArray.push($(this).val());
					}

				});
				console.log(keyword);

				var data = {
					"kind" : kindArray,
					"keyword" : keyword
				};

				$.ajax({
					type : "post",
					url : "/ediya/menu?cmd=bakerySearch",
					data : JSON.stringify(data),
					contentType : "application/json; charset=utf-8",
					dataType : "json"
				}).done(function(result) {
					if (result.statusCode == 1) {
						console.log(result.data);
						addContent(result.data)
					}

				}).fail(function() {
					alert("실패");
				});
			});

	$('input:checkbox[name="kind"]').click(function() {
		kindArray = [];
		$('input:checkbox[name="kind"]:checked').each(function(i) {

			if ($.inArray(this.value, kindArray) == -1) {
				kindArray.push(this.value);
			}

		});

		var data = {
			"kind" : kindArray,
			"keyword" : keyword
		};

		$.ajax({
			type : "post",
			url : "/ediya/menu?cmd=bakerySearch",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(result) {
			if (result.statusCode == 1) {
				console.log(result.data);
				addContent(result.data)
			}

		}).fail(function() {
			alert("실패");
		});
		console.log(JSON.stringify(data));

	});
</script>
<script src="/ediya/assets/js/menuCarousel.js"></script>
<script src="/ediya/assets/js/moreButton.js"></script>
<%@ include file="../layout/footer.jsp"%>


</body>
</html>