<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="contentWrap">
	<div class="editPage_bg">
		<div class="editPage_content">
			<h1 class="editPage_title">회원정보수정</h1>
			<p class="editPage_txt1">Membership Information</p>
			<p class="editPage_txt2">고객님이 가입한 정보를 수정하실 수 있습니다.</p>
		</div>
	</div>
</section>


<div class="edit_box_bg">
	<div class="edit_box">
		<form method="POST" action="" name="edit_form">
			<h2 class="edit_form_txt">회원정보수정</h2>
			<span class="info_btn"><a href="#c" class="delete_btn" onclick="">회원탈퇴</a></span>
			<dl>
				<dt>
					<label for="id">아이디(이메일)</label>
				</dt>
				<dd>
					hjin7270@naver.com 
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="phone">휴대폰</label>
				</dt>
				<dd>
					<input type="text" name="phone" id="phone" value="01083727270"
						placeholder="휴대폰 번호" required="required">
				</dd>
			</dl>
			
			<dl>
				<dt>
					<label for="pw">비밀번호</label>
				</dt>
				<dd>
					<input type="password" name="password" id="password" value="1234"
						placeholder="비밀번호" required="required">
				</dd>
			</dl>
			<p>안전한 비밀번호를 위해 숫자, 문자 조합하여 10~16자 이상으로 입력해주세요.</p>

			<dl>
				<dt>
					<label for="nickname">닉네임</label>
				</dt>
				<dd>
					<input type="text" name="nickname" id="nickname" value="회원"
						placeholder="한글, 숫자 5자 이내로 입력하세요" required="required">
				</dd>
			</dl>
			<p class="info_txt">욕설 등 부적절한 단어는 제한을 받습니다.</p>




			<div class="box_btn">
				<input type="submit" name="Submit" value="수정하기" class="submit_btn">
			</div>

		</form>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>

<!-- Template Main JS File -->
<script src="../assets/js/main.js"></script>

</body>
</html>