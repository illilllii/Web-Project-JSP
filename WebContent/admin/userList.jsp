<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<main id="main">
	<section id="userAdmin" class="userAdmin">
		<div class="container">
			<h2>회원정보</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>이메일</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>닉네임</th>
						<th>권한</th>
						<th>가입일</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr id="user-${user.id}">
							<td>${user.id}</td>
							<td>${user.email}</td>
							<td>${user.username}</td>
							<td>${user.phone}</td>
							<td>${user.nickname}</td>
							<td><select name="userRole">
									<option value="USER"
										<c:if test="${user.userRole == 'USER'}">selected</c:if>>USER</option>
										<option value="ADMIN"
										<c:if test="${user.userRole == 'ADMIN'}">selected</c:if>>ADMIN</option>
									<option value="USERADMIN"
										<c:if test="${user.userRole == 'USERADMIN'}">selected</c:if>>USERADMIN</option>
									<option value="BOARDADMIN"
										<c:if test="${user.userRole == 'BOARDADMIN'}">selected</c:if>>BOARDADMIN</option>
									<option value="MENUADMIN"
										<c:if test="${user.userRole == 'MENUADMIN'}">selected</c:if>>MENUADMIN</option>

							</select></td>
							<td>${user.createDate}</td>
							<td><button type="button" class="btn btn-warning"
									onclick="updateUser(${user.id})">수정</button>
								<button type="button" class="btn btn-danger"
									onclick="deleteUser(${user.id})">삭제</button></td>
							<td></td>
						</tr>
					</c:forEach>




				</tbody>
			</table>

		</div>
	</section>

</main>
<%@ include file="../layout/footer.jsp"%>
<script>
function deleteUser(id) {
	$.ajax({
		type: "post",
		url: "/ediya/admin?cmd=userDelete&id="+id,
		dataType: "json"
		
	}).done(function(result) {
		if(result.statusCode == 1) {
			console.log(result);
			$("#user-"+id).remove();
			location.reload();
		}
	});
}


/*var data = {
		"userRole" :
};*/

function updateUser(id) {
	var selected = $("select[name='userRole']").val();
	console.log(selected);
	var data = {
			"id" : id,
			"userRole" : selected
		};
	$.ajax({
		type: "post",
		url: "/ediya/admin?cmd=userUpdate",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
		
	}).done(function(result) {
		if(result.statusCode == 1) {
			console.log(result);
			location.reload();
		}
	});
}
</script>
</body>
</html>