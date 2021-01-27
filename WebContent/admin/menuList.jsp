<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<main id="main">
	<section id="menuAdmin" class="menuAdmin">
		<div class="container">
			<h2>메뉴정보</h2>
			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">음료</li>
				<li class="tab-link" data-tab="tab-2">베이커리</li>
				<li class="tab-link" data-tab="tab-3">스낵</li>
				<li class="tab-link" data-tab="tab-4">MD</li>
			</ul>
			<div id="tab-1" class="tab-content current">
				<table class="table table-striped">
					<colgroup>
						<col width="5%" />
						<col width="10%" />
						<col width="10%" />
						<col width="25%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">이름</th>
							<th scope="col">영어이름</th>
							<th scope="col">내용</th>
							<th scope="col">이미지</th>
							<th scope="col">종류</th>
							<th scope="col">추천여부</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="drink" items="${drinks}">
							<tr id="drink-${drink.id}">
								<td>${drink.id}</td>
								<td>${drink.name}</td>
								<td>${drink.subname}</td>
								<td>${drink.content}</td>
								<td><img src="${drink.imageSrc}" /></td>
								<td>${drink.kind}</td>
								<td>${drink.recommend}</td>
								<td><button type="button" class="btn btn-danger">삭제</button></td>
							</tr>
						</c:forEach>




					</tbody>
				</table>
			</div>





			<div id="tab-2" class="tab-content">
				<table class="table table-striped">
					<colgroup>
						<col width="5%" />
						<col width="10%" />
						<col width="10%" />
						<col width="25%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">이름</th>
							<th scope="col">영어이름</th>
							<th scope="col">내용</th>
							<th scope="col">이미지</th>
							<th scope="col">종류</th>
							<th scope="col">추천여부</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="bakery" items="${bakerys}">
							<tr id="bakery-${bakery.id}">
								<td>${bakery.id}</td>
								<td>${bakery.name}</td>
								<td>${bakery.subname}</td>
								<td>${bakery.content}</td>
								<td><img src="${bakery.imageSrc}" /></td>
								<td>${bakery.kind}</td>
								<td>${bakery.recommend}</td>
								<td><button type="button" class="btn btn-danger">삭제</button></td>
							</tr>
						</c:forEach>




					</tbody>
				</table>

			</div>



		</div>
	</section>

</main>
<%@ include file="../layout/footer.jsp"%>
<script>
$('ul.tabs li').click(function(){
	var tab_id = $(this).attr('data-tab');

	$('ul.tabs li').removeClass('current');
	$('.tab-content').removeClass('current');

	$(this).addClass('current');
	$("#"+tab_id).addClass('current');
})
</script>
</body>
</html>