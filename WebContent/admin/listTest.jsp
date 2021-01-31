<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<main id="main">
	<section id="menuAdmin" class="menuAdmin">
		<div class="container">
			<h2>메뉴정보</h2>
			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">음료</li>
				<li class="tab-link" data-tab="tab-2" data-cmd="bakery">베이커리</li>
				<li class="tab-link" data-tab="tab-3">스낵</li>
				<li class="tab-link" data-tab="tab-4">MD</li>
			</ul>

			<div id="tab-1" class="tab-content current">
				<button type="button" class="btn btn-primary btn-add"
					onclick="location.href ='/ediya/admin?cmd=drinksInsertForm'">추가하기</button>
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
							<tr id="drink-${drink.id}"
								onclick="location.href ='/ediya/admin?cmd=drinksDetail&id=${drink.id}'"
								class="menu-item">
								<td>${drink.id}</td>
								<td>${drink.name}</td>
								<td>${drink.subname}</td>
								<td class="menuList-content">${drink.content}</td>
								<td><img src="${drink.imageSrc}" /></td>
								<td>${drink.kind}</td>
								<td>${drink.recommend}</td>
								<td><button type="button" class="btn btn-danger"
										onclick="deleteDrinks(${drink.id})">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>


			<div id="tab-2" class="tab-content">
				<button type="button" class="btn btn-primary btn-add"
					onclick="location.href ='/ediya/admin?cmd=bakeryInsertForm'">추가하기</button>
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
							<tr class="menu-item"
								onclick="location.href ='/ediya/admin?cmd=bakeryDetail&id=${bakery.id}'">
								<td>${bakery.id}</td>
								<td>${bakery.name}</td>
								<td>${bakery.subname}</td>
								<td class="menuList-content">${bakery.content}</td>
								<td><img src="${bakery.imageSrc}" /></td>
								<td>${bakery.kind}</td>
								<td>${bakery.recommend}</td>
								<td><button type="button" class="btn btn-danger"
										onclick="deleteBakery(${bakery.id})">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item page-prev"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item page-next" id="page-next"><a
						class="page-link" href="#">Next</a></li>
				</ul>
			</div>


			<div id="tab-3" class="tab-content">
				<button type="button" class="btn btn-primary btn-add"
					onclick="location.href ='/ediya/admin?cmd=snackInsertForm'">추가하기</button>
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
						<c:forEach var="snack" items="${snacks}">
							<tr id="snack-${snack.id}" class="menu-item"
								onclick="location.href ='/ediya/admin?cmd=snackDetail&id=${snack.id}'">
								<td>${snack.id}</td>
								<td>${snack.name}</td>
								<td>${snack.subname}</td>
								<td class="menuList-content">${snack.content}</td>
								<td><img src="${snack.imageSrc}" /></td>
								<td>${snack.kind}</td>
								<td>${snack.recommend}</td>
								<td><button type="button" class="btn btn-danger"
										onclick="deleteSnack(${snack.id})">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>



			<div id="tab-4" class="tab-content">
				<button type="button" class="btn btn-primary btn-add"
					onclick="location.href ='/ediya/admin?cmd=mdInsertForm'">추가하기</button>
				<table class="table table-striped">
					<colgroup>
						<col width="5%" />
						<col width="15%" />
						<col width="45%" />
						<col width="15%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">이름</th>
							<th scope="col">내용</th>
							<th scope="col">이미지</th>
							<th scope="col">추천여부</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="md" items="${mds}">
							<tr id="md-${md.id}" class="menu-item"
								onclick="location.href ='/ediya/admin?cmd=mdDetail&id=${md.id}'">
								<td>${md.id}</td>
								<td>${md.name}</td>
								<td class="menuList-content">${md.content}</td>
								<td><img src="${md.imageSrc}" /></td>
								<td>${md.recommend}</td>
								<td><button type="button" class="btn btn-danger"
										onclick="deleteMd(${md.id})">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>

		</div>
	</section>

</main>
<%@ include file="../layout/footer.jsp"%>
<script>
function addContent(data) {
	
	
	var contentItem = [];
	
	for (var i = 0; i <data.length; i++) {
		console.log("data:" + data[i].id);
		contentItem[i] = [''];
		contentItem[i] += '<tr class="menu-item" onclick="location.href =\'/ediya/admin?cmd='+cmd+'Detail&id='+data[i].id+'\'">';
		contentItem[i] += '<td>'+data[i].id+'</td>';
		contentItem[i] += '<td>'+data[i].name+'</td>';
		contentItem[i] += '<td>'+data[i].subname+'</td>';
		contentItem[i] += '<td class="menuList-content">'+data[i].content+'</td>';
		contentItem[i] += '<td><img src="'+data[i].imageSrc+'" /></td>';
		contentItem[i] += '<td>'+data[i].kind+'</td>';
		contentItem[i] += '<td>'+data[i].recommend+'</td>';
		contentItem[i] += '<td onclick="event.cancelBubble=true"><button type="button" class="btn btn-danger" onclick="'+cmd+'Delete('+data[i].id+')">삭제</button></td></tr>';
			
		$("tbody").html(contentItem);
		
	}
}
	//var totalCount = ($('.current table tr').length)-1;
	var page = 0;
	var cmd;
	var data;
	var tab_id;
	
	$('ul.tabs li').click(function() {
		tab_id = "#"+($(this).attr('data-tab'));

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$(tab_id).addClass('current');
		
		cmd = $(this).attr('data-cmd');
		
		//totalCount = ($('.current table tr').length)-1;
		/*if(totalCount % 4 == 0) {
			page = (totalCount / 4)-1;
		} else {
			page = totalCount / 4;
		}*/

		data = {
				"page" : page
			};
		
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd="+cmd+"List",
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

	$('.page-next').click(function() {
		page++;
		data = {
				"page" : page
			};
		
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd="+cmd+"List",
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
	$('.page-prev').click(function() {
		page--;
		data = {
				"page" : page
			};
		
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd="+cmd+"List",
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

	

	
	
	
	function deleteDrinks(id) {
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd=drinksDelete&id=" + id,
			dataType : "json"

		}).done(function(result) {
			if (result.statusCode == 1) {
				console.log(result);
				$("#drink-" + id).remove();
				location.reload();
			}
		});
	}
	
	function bakeryDelete(id) {
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd=bakeryDelete&id=" + id,
			dataType : "json"

		}).done(function(result) {
			if (result.statusCode == 1) {
				console.log(result);
				$("#bakery-" + id).remove();
				//$("#tab-2").load(location.href + "#tab-2");
				//location.reload();
				
			}
		});
	}
	
	function deleteSnack(id) {
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd=snackDelete&id=" + id,
			dataType : "json"

		}).done(function(result) {
			if (result.statusCode == 1) {
				console.log(result);
				$("#snack-" + id).remove();
				location.reload();
			}
		});
	}
	function deleteMd(id) {
		$.ajax({
			type : "post",
			url : "/ediya/admin?cmd=mdDelete&id=" + id,
			dataType : "json"

		}).done(function(result) {
			if (result.statusCode == 1) {
				console.log(result);
				$("#md-" + id).remove();
				location.reload();
			}
		});
	}
</script>
</body>
</html>