<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="contentWrap">
	<div class="join_bg">
		<div class="join_content">
			<h1 class="con_tt">
				<img src="../img/user/join.png" width="302" height="78" alt="회원가입">
			</h1>
			<p class="visual_mt">Join Us, Ediya Coffee</p>
			<p class="visual_txt">이디야멤버스 가입을 위한 회원정보를 입력하는 공간입니다.</p>
		</div>
	</div>
</section>

<div class="join_box">
	<div class="join_con">
		<h2 class="join_tt ns">회원정보 입력</h2>

		<fieldset>
			<div class="join_form top_form">
				<dl>
					<dt>
						<label for="id">아이디(이메일)</label>
					</dt>
					<dd>
						<input type="email" name="email" id="nickname" value="">
						<button class="check_btn" onclick="">중복확인</button>
					</dd>
				</dl>
				<dl>
					<dt>
						<label for="name">이름</label>
					</dt>
					<dd>
						<input type="text" name="username" id="username" value="">
					</dd>
				</dl>

				<dl>
					<dt>
						<label for="phone">휴대폰</label>
					</dt>
					<dd id="ph_auth_v">
						<input type="text" name="phone" id="phone" value="">
					</dd>
				</dl>

				<dl>
					<dt>
						<label for="pw">비밀번호</label>
					</dt>
					<dd>
						<input type="password" name="password" id="password" value=""
							placeholder="비밀번호">
					</dd>
				</dl>
				<p>안전한 비밀번호를 위해 숫자, 문자 조합하여 10~16자 이상으로 입력해주세요.</p>

				<dl>
					<dt>
						<label for="pw_ck">비밀번호 확인</label>
					</dt>
					<dd>
						<input type="password" id="pw_ck">
					</dd>
				</dl>
				<p class="info_txt" id="pw_error"
					style="display: none; color: rgb(255, 0, 0);">비밀번호가 일치하지 않습니다.</p>

				<dl>
					<dt>
						<label for="nickname">닉네임</label>
					</dt>
					<dd>
						<input type="text" name="nickname" id="nickname" value=""
							placeholder="한글, 숫자 5자 이내로 입력하세요">
					</dd>
				</dl>
				<p class="info_txt">욕설 등 부적절한 단어는 제한을 받습니다.</p>

				<!--dl>
            <dt><label for="">수신동의</label></dt>
            <dd>
            	<div class="receive_agree">
              	<input type="checkbox" name="smsYn" id="receive_sms" value="Y"/> <label for="receive_sms">SMS 문자수신</label>
                <input type="checkbox" name="pushYn" id="receive_app" value="Y"/> <label for="receive_app">APP 알림 서비스</label>
                <input type="checkbox" name="emailYn" id="receive_email" value="Y"/> <label for="receive_email">메일수신</label>
              </div>            	
            </dd>
          </dl>         
          <p class="no_bottom">이벤트, 신상품 등의 프로모션 알림 서비스를 이용하시려면 동의해주세요. 마케팅 정보 제공에 대한 동의이며, 멤버십 서비스 이용에 따른 정보는 이용동의와 관계없이 제공됩니다.</p-->
			</div>
		</fieldset>
	</div>

	<div class="box_btn">
		<input type="submit" name="Submit" value="가입하기" class="submit_btn">
	</div>
</div>



<%@ include file="../layout/footer.jsp"%>

<!-- Template Main JS File -->
<script src="../assets/js/main.js"></script>

</body>
</html>