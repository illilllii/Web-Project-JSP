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
		<form method="POST" action="" name="join_form">
			<h2 class="join_form_txt">회원정보입력</h2>
			<dl>
				<dt>
					<label for="id">아이디(이메일)</label>
				</dt>
				<dd>
					<input type="email" name="id" id="id" value=""
						placeholder="아이디(이메일)" required="required" style="width: 75%;">
					<button type="button" class="userId_check" onClick="userIdCheck()">아이디
						중복확인</button>
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="username">이름</label>
				</dt>
				<dd>
					<input type="text" name="username" id="username" value=""
						placeholder="이름" required="required">
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="phone">휴대폰</label>
				</dt>
				<dd>
					<input type="text" name="phone" id="phone" value=""
						placeholder="휴대폰 번호" required="required">
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="pw">비밀번호</label>
				</dt>
				<dd>
					<input type="password" name="password" id="password" value=""
						placeholder="비밀번호" required="required">
				</dd>
			</dl>
			<p>안전한 비밀번호를 위해 숫자, 문자 조합하여 10~16자 이상으로 입력해주세요.</p>

			<dl>
				<dt>
					<label for="nickname">닉네임</label>
				</dt>
				<dd>
					<input type="text" name="nickname" id="nickname" value=""
						placeholder="한글, 숫자 5자 이내로 입력하세요" required="required">
				</dd>
			</dl>
			<p class="info_txt">욕설 등 부적절한 단어는 제한을 받습니다.</p>

			<div class="box_btn">
				<input type="submit" name="Submit" value="가입하기" class="submit_btn">
			</div>
			
		</form>

	</div>
</div>




<%@ include file="../layout/footer.jsp"%>

<!-- Template Main JS File -->
<script src="../assets/js/main.js"></script>

</body>
</html>