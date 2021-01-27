<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!-- 이메일찾기 팝업 -->
<div class="popup_wrap" id="join_email_info" style="top: 900px; left: 0px; display: none;" >
	<div class="popup_blind">
		<div class="login_popup" style="padding-bottom: 120px">
			<h1 class="pop_tt">가입 정보 확인</h1>
			<div class="pop_close">
				<a href="#c" onclick="close_login_pop()">
				<img src="/ediya/assets/img/user/mypage_pop_close.gif" width="17" height="16" alt="창닫기" style="margin-top: -20px;"></a>
			</div>

			<h2 class="pop_con_tt">가입 시 입력한 정보를 입력하세요.</h2>
			<p class="pop_txt" style="text-align: center; font-size: 15px; margin: -15px auto 60px;">
				타인의 개인정보를 도용 할 경우<br> 서비스 이용 제한 및 법적 제재를 받으실 수 있습니다.
			</p>

			<form method="POST" action="/ediya/user?cmd=findEmail" name="info_form" style="margin-top:-35px;">
					<div class="certify_form">
						<dl style="display: table; ">
							<dt >
								<label for="findEmailMobileNo" style="width: 150px; margin-left: 40px; font-size: 15px;">▶ 휴대폰 번호</label>
							</dt>
							<dd>
								<input id="findEmailMobileNo" name="phone"  style="width: 400px; margin-left: 40px" placeholder="가입 시 입력한 휴대폰 번호를 '-'없이 입력하세요">
							</dd>
						</dl>
					</div>

					<div class="form_btn">
						<a href="#c" class="gray_btn" onclick="close_login_pop()')" style="margin-top: 20px">취소</a> 
						<input type="submit"  value="이메일 찾기" class="submit_btn submit_half_btn" style="margin-top: 20px">
					</div>
			</form>
		</div>
	</div>
</div>

<!-- 비밀번호찾기 팝업 -->
<div class="popup_wrap" id="passwd_find" style="top: 900px; left: 0px; display: none;" >
	<div class="popup_blind">
		<div class="login_popup" style="padding-bottom: 120px">
			<h1 class="pop_tt">가입 정보 확인</h1>
			<div class="pop_close">
				<a href="#c" onclick="close_login_pop()">
				<img src="/ediya/assets/img/user/mypage_pop_close.gif" width="17" height="16" alt="창닫기" style="margin-top: -20px;"></a>
			</div>

			<h2 class="pop_con_tt">가입 시 입력한 정보를 입력하세요.</h2>
			<p class="pop_txt" style="text-align: center; font-size: 15px; margin: -15px auto 60px;">
				타인의 개인정보를 도용 할 경우<br> 서비스 이용 제한 및 법적 제재를 받으실 수 있습니다.
			</p>

			<form method="POST" action="/ediya/user?cmd=findPwd" name="info_form" style="margin-top:-35px;">
					<div class="certify_form">
						<dl style="display: table; ">
							<dt >
								<label for="findPwdEmail" style="width: 150px; margin-left: 40px; font-size: 15px;">▶ 이메일</label>
							</dt>
							<dd>
								<input type="email"  id="findPwdEmail" name="email"  style="width: 400px; margin-left: 40px" placeholder="가입 시 입력한 이메일을 입력하세요" required="required">
							</dd>
						</dl>
						<dl style="display: table; ">
							<dt >
								<label for="findPwdPhone" style="width: 150px; margin-left: 40px; font-size: 15px;">▶ 휴대폰 번호</label>
							</dt>
							<dd>
								<input id="findPwdPhone" name="phone"  style="width: 400px; margin-left: 40px" placeholder="가입 시 입력한 휴대폰 번호를 '-'없이 입력하세요" required="required">
							</dd>
						</dl>
					</div>

					<div class="form_btn">
						<a href="#c" class="gray_btn" onclick="close_login_pop()')" style="margin-top: 20px">취소</a> 
						<input type="submit"  value="비밀번호 찾기" class="submit_btn submit_half_btn" style="margin-top: 20px">
					</div>
			</form>
		</div>
	</div>
</div>

<div class="login_bg">
	<!-- title 영역 -->
	<div class="login_con">
		<h1 class="login_title">로그인</h1>
		<p class="login_txt">
			<em>Welcome, Ediya Coffee</em><br> 이디야커피에 오신 것을 환영합니다.
		</p>


		<!-- 가입정보 찾기 -->
		<div class="mem_info" style="margin-bottom: 20px;">
			<h2>
				이디야 회원이셨나요?<br> <em>이디야 멤버스가 새로워졌습니다.</em>
			</h2>

			<p>
				회원님께 더 좋은 서비스를 제공해드리고자,<br> 선물하기, 이디야카드, 스마트오더 등의 서비스를 추가하여 더욱
				새로워졌습니다.<br> 회원님께서 새로운 서비스를 이용하시기 위해서는 본인 인증이 필요합니다.<br>
				본인 인증은 1회만 진행하며, 인증후, 더 편리하게 서비스를 이용하실 수 있습니다.
			</p>

			<a href="#c" onclick="open_login_pop('join_email_info')">이디야 멤버스 가입정보 찾기</a>
		</div>

		<!-- 로그인 -->
		<div class="login_box" id="login_wrap">
			<div id="login_form">

				<form method="POST" action="/ediya/user?cmd=login" name="login_form">
					<div>
						<input type="email" name="email" id="user_id"
							placeholder="이메일을 입력하세요" required="required"> <input
							type="password" name="password" id="pwd"
							placeholder="비밀번호를 입력하세요" required="required">
					</div>
					<br> <input type="submit" name="Submit" value="로그인"
						class="login_btn">

					<div class="join_btn">
						<a href="/ediya/user?cmd=joinForm">회원가입</a> <a href="#c"
							onclick="open_login_pop('join_email_info')">이메일 찾기</a> <a href="#c"
							onclick="open_login_pop('passwd_find')">비밀번호 찾기</a>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>

<script>
	function open_login_pop(pop_id){
		$(".popup_wrap").hide();
		$("#"+pop_id).css({"top":(($(window).height()-$("#"+pop_id).outerHeight())/2+ $(window).scrollTop())+"px", 	"left":(($(window).width()-$("#"+pop_id).outerWidth())/2+ $(window).scrollLeft())+"px"}); 
		$("#"+pop_id).show();	
	}
	
	function close_login_pop(){
		$(".popup_wrap").hide();
	}
</script>

<%@ include file="../layout/footer.jsp"%>


</body>
</html>