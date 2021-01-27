<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="contentWrap">
	<div class="join_bg">
		<div class="join_content">
			<h1 class="join_title">회원가입</h1>
			<p class="join_txt1">Join Us, Ediya Coffee</p>
			<p class="join_txt2">이디야멤버스 가입을 위한 회원정보를 입력하는 공간입니다.</p>
		</div>
	</div>
</section>


<!-- 회원가입 영역 -->
<div class="join_box_bg">
	<div class="join_box">
		<form method="POST" action="/ediya/user?cmd=join" onsubmit="return valid()">
			<h2 class="join_form_txt">회원정보입력</h2>
			<dl>
				<dt>
					<label for="id">아이디(이메일)</label>
				</dt>
				<dd>
					<input type="email" name="email" id="email" placeholder="아이디(이메일)"
						required="required" style="width: 75%;">
					<button type="button" class="userId_check" onClick="userIdCheck()">아이디
						중복확인</button>
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="username">이름</label>
				</dt>
				<dd>
					<input type="text" name="username" id="username" placeholder="이름"
						required="required">
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="phone">휴대폰</label>
				</dt>
				<dd>
					<input type="text" name="phone" id="phone" placeholder="휴대폰 번호"
						required="required">
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="pw">비밀번호</label>
				</dt>
				<dd>
					<input type="password" name="password" id="password"
						placeholder="비밀번호" required="required">
				</dd>
			</dl>
			<p>안전한 비밀번호를 위해 숫자, 문자 조합하여 10~16자 이상으로 입력해주세요.</p>

			<dl>
				<dt>
					<label for="nickname">닉네임</label>
				</dt>
				<dd>
					<input type="text" name="nickname" id="nickname"
						placeholder="닉네임" required="required">
				</dd>
			</dl>
			<p class="info_txt">욕설 등 부적절한 단어는 제한을 받습니다.</p>

			<div class="box_btn">
				<input type="submit" value="가입하기" class="submit_btn">
			</div>

		</form>

	</div>
</div>

<script>
	var isChecking = false;
	
	function valid() {
		if (isChecking == false) {
			alert("아이디 중복체크를 해주세요");
		}
		return isChecking;
	}
	
	function userIdCheck() {
		// DB에서 확인해서 정상이면 isChecking = true
		var email = $("#email").val();
		$.ajax({
			type : "POST",
			url : "/ediya/user?cmd=userIdCheck",
			data : email,
			contentType : "text/plain; charset=utf-8",
			dataType : "text" // 응답 받을 데이터의 타입을 적으면 자바스크립트 오브젝트로 파싱해줌.
		}).done(function(data) {
			if (data === 'ok') { // 유저네임 있다는 것
				isChecking = false;
				alert('아이디(이메일)가 중복되었습니다.')
			} else {
				isChecking = true;
				alert("해당 아이디(이메일)를 사용할 수 있습니다.")
			}
		});
	}
</script>



<%@ include file="../layout/footer.jsp"%>


</body>
</html>