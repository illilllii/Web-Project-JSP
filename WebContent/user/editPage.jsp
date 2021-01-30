<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!-- 회원탈퇴 팝업 -->
<div class="popup_wrap" id="join_email_info" style="top: 800px; left: 0px; display: none;">
	<div class="popup_blind">
		<div class="login_popup" style="padding-bottom: 120px">
			<h1 class="pop_tt" >회원탈퇴</h1>
			<div class="pop_close">
				<a href="#c" onclick="close_login_pop()">
				<img src="/ediya/assets/img/user/mypage_pop_close.gif" width="17" height="16" alt="창닫기">
				</a>
			</div>
			
			<h2 class="pop_con_tt" style= "margin: 45px auto 70px;">회원탈퇴 안내</h2>
			<form name="drawalForm" id="drawalForm" action="/ediya/user?cmd=delete" method="post" style="margin-top: -50px">
					<div class="certify_form">
						<div class="leave_info">
							<h3><em style="font-weight: 600">정말로 탈퇴하시겠습니까?</em></h3>
							<p>
								탈퇴를 하시면 회원님의 스탬프 및 쿠폰사용이 불가하며, 
								<span class="block_txt">이미 결제하신 스마트오더 에 대한 결제취소 및 결제수단 변경이 불가능합니다.</span>
							</p>
						</div>
					</div>

					<div class="form_btn">
						<a href="#c" class="gray_btn" onclick="close_login_pop()" style="margin-top: 20px">취소</a> 
						<input type="hidden" name="email" value="${sessionScope.principal.email}" />
						<input type="submit"  value="탈퇴하기" class="submit_btn submit_half_btn" style="margin-top: 20px">
					</div>
			</form>
		</div>
	</div>
</div>

<!-- 회원정보수정 페이지 -->
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
		<form method="POST" action="/ediya/user?cmd=update" name="edit_form">
			<h2 class="edit_form_txt">회원정보수정</h2>
			<span class="info_btn"><a href="#c" class="delete_btn"
				onclick="open_join_pop('join_email_info');"
				style="margin-top: -50px">회원탈퇴</a></span>
			<dl>
				<dt>
					<label for="id">아이디(이메일)</label>
				</dt>
				<dd>
					<input type="text" name="email" id="email"
						value="${sessionScope.principal.email}"
						style="border-style: none; padding-left: 10px" readonly="readonly">
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="phone">휴대폰</label>
				</dt>
				<dd>
					<input type="text" name="phone" id="phone"
						value="${sessionScope.principal.phone}" placeholder="휴대폰 번호"
						required="required">
				</dd>
			</dl>

			<dl>
				<dt>
					<label for="pw">비밀번호</label>
				</dt>
				<dd>
					<input type="password" name="password" id="password"
						value="${sessionScope.principal.password}" placeholder="비밀번호"
						required="required">
				</dd>
			</dl>
			<p>안전한 비밀번호를 위해 숫자, 문자 조합하여 10~16자 이상으로 입력해주세요.</p>

			<dl>
				<dt>
					<label for="nickname">닉네임</label>
				</dt>
				<dd>
					<input type="text" name="nickname" id="nickname"
						value="${sessionScope.principal.nickname}" placeholder="닉네임"
						required="required">
				</dd>
			</dl>
			<p class="info_txt">욕설 등 부적절한 단어는 제한을 받습니다.</p>


			<div class="box_btn">
				<input type="submit" name="Submit" value="수정하기" class="submit_btn">
			</div>

		</form>
	</div>
</div>

<script>
function open_join_pop(pop_id){
	$(".members_pop_wrap").hide();
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