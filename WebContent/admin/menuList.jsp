<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<main id="main">
	<section id="menuAdmin" class="menuAdmin">
		<div class="container">
			<h2>메뉴정보</h2>
			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1" data-cmd="drinks">음료</li>
				<li class="tab-link" data-tab="tab-2" data-cmd="bakery">베이커리</li>
				<li class="tab-link" data-tab="tab-3" data-cmd="snack">스낵</li>
				<li class="tab-link" data-tab="tab-4" data-cmd="md">MD</li>
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
						
					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item page-prev disabled"><a class="page-link"
						href="#">Previous</a></li>
					<c:forEach var="i" begin="0" end="${drinksLastPage}">
						<li class="page-number" id="drinks-page-${i}" data-page="${i}"><c:out value="${i+1}" /></li>
					</c:forEach>
					<li class="page-item page-next" id="page-next"><a
						class="page-link" href="#">Next</a></li>
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

					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item page-prev disabled"><a class="page-link"
						href="#">Previous</a></li>
					<c:forEach var="i" begin="0" end="${bakeryLastPage}">
						<li class="page-number" id="bakery-page-${i}" data-page="${i}"><c:out value="${i+1}" /></li>
					</c:forEach>
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
						
					</tbody>
				</table>
				<ul class="pagination justify-content-center">
					<li class="page-item page-prev disabled"><a class="page-link"
						href="#">Previous</a></li>
					<c:forEach var="i" begin="0" end="${snackLastPage}">
						<li class="page-number" id="md-page-${i}" data-page="${i}"><c:out value="${i+1}" /></li>
					</c:forEach>
					<li class="page-item page-next" id="page-next"><a
						class="page-link" href="#">Next</a></li>
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
						
					</tbody>
				</table>

				<ul class="pagination justify-content-center">
					<li class="page-item page-prev disabled"><a class="page-link"
						href="#">Previous</a></li>
					<c:forEach var="i" begin="0" end="${mdLastPage}">
						<li class="page-number" id="snack-page-${i}" data-page="${i}"><c:out value="${i+1}" /></li>
					</c:forEach>
					<li class="page-item page-next" id="page-next"><a
						class="page-link" href="#">Next</a></li>
				</ul>
			</div>

		</div>
	</section>

</main>
<%@ include file="../layout/footer.jsp"%>
<script>
var page = 0;
var cmd = 'drinks';
var data;
var tab_id;
var lastPage;

function addContent(data) {
	
	var contentItem = [];
	for (var i = 0; i <data.length; i++) {
		if(cmd=='md') {
			contentItem[i] = [''];
			contentItem[i] += '<tr class="menu-item" onclick="location.href =\'/ediya/admin?cmd='+cmd+'Detail&id='+data[i].id+'\'">';
			contentItem[i] += '<td>'+data[i].id+'</td>';
			contentItem[i] += '<td>'+data[i].name+'</td>';
			contentItem[i] += '<td class="menuList-content">'+data[i].content+'</td>';
			contentItem[i] += '<td><img src="'+data[i].imageSrc+'" /></td>';
			contentItem[i] += '<td>'+data[i].recommend+'</td>';
			contentItem[i] += '<td onclick="event.cancelBubble=true"><button type="button" class="btn btn-danger" onclick="'+cmd+'Delete('+data[i].id+')">삭제</button></td></tr>';
			} else {
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
		}
	
			
		$("tbody").html(contentItem);
		
	}
	if(page>0) {
		$(".page-prev").removeClass("disabled");
	} else {
		$(".page-prev").addClass("disabled");
	}
	if(page<lastPage) {
		$(".page-next").removeClass("disabled");
	} else {
		$(".page-next").addClass("disabled");
	}
}

function pagingAjax() {
	console.log(cmd);
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
	
	$('#'+cmd+'-page-'+page ).css( 'color', '#222' );

}

lastPage = "${drinksLastPage}";	
pagingAjax();

	$('ul.tabs li').click(function() {
		$('#'+cmd+'-page-'+page ).css( 'color', '#ccc' );
		page = 0;
		console.log('page:');
		$('#'+cmd+'-page-'+page ).css( 'color', '#222' );
		console.log(lastPage);
		tab_id = "#"+($(this).attr('data-tab'));
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$(tab_id).addClass('current');
		
		cmd = $(this).attr('data-cmd');

		if(cmd=='bakery') {
			lastPage = "${bakeryLastPage}";
		} else if(cmd=='drinks') {
			lastPage = "${drinksLastPage}";
		} else if(cmd=='snack') {
			lastPage = "${snackLastPage}";
		} else if(cmd=='md') {
			lastPage = "${mdLastPage}";
		}
				
		pagingAjax();
	
	});
	

	$('.page-number').click(function() {
		$('#'+cmd+'-page-'+page ).css( 'color', '#ccc' );
		page=$(this).attr('data-page');
		pagingAjax();
		//$(this).css('color', 'red');
			//console.log("data-page:"+$(this).attr('data-page'));
	});
	
	$('.page-next').click(function() {
		
		if(page<lastPage) {
			$('#'+cmd+'-page-'+page ).css( 'color', '#ccc' );
			page++;
			
			pagingAjax();

			
		} 		
	});
	
	$('.page-prev').click(function() {
		
		if (page > 0) {
			$('#'+cmd+'-page-'+page ).css( 'color', '#ccc' );
			page--;
			pagingAjax();
		} 
		
	});
	
	function drinksDelete(id) {
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
				location.reload();
				
			}
		});
	}
	
	function snackDelete(id) {
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
	function mdDelete(id) {
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