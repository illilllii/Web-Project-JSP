<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="login_bg">

	<!-- title 영역 -->
	<div class="login_con">
		<h1 class="login_title">로그인</h1>
		<p class="login_txt">
			<em>Welcome, Ediya Coffee</em><br> 이디야커피에 오신 것을 환영합니다.</p>


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

			<a href="#c" onclick="">이디야 멤버스 가입정보 찾기</a>
		</div>

		<!-- 로그인 -->
		<div class="login_box" id="login_wrap">
			<div id="login_form">
				<form method="POST" action="./login_ok.php" name="login_form"
					onsubmit="return login_ck(this);" target="db_frame">
					<input type="hidden" value="0" name="dobaeCk" id="dobaeCk">
					<fieldset>
						<legend>ADMIN LOGIN</legend>
						<div>
							<input type="text" name="user_id" id="user_id" value=""
								placeholder="이메일을 입력하세요" style="ime-mode: disabled"> <input
								type="password" name="pwd" id="pwd" value=""
								placeholder="비밀번호를 입력하세요">
						</div>
						<div id="dobaeLayer" style="display: none">
							<div>
								<input type="text" name="dobae" id="dobae"
									placeholder="자동입력 방지문자를 입력하세요" autocomplete="off">
							</div>
							<div class="realperson_box">
								<span class="realperson_no" id="dobae_num">&nbsp;6<font
									color="#999999">5</font><img src="/dobae/images/icon_dot.gif"><span
									style="disply: none" bt_adminlogout_login=""></span>9<font
									color="#999999">9</font><img src="/dobae/images/icon_dot.gif">6<font
									color="#999999">2</font><img src="/dobae/images/icon_dot.gif">9<font
									color="#999999">2</font><img src="/dobae/images/icon_dot.gif">
								</span> <span class="realperson_btn"> <a href="#c"
									onclick="dobaeCk()" class="realperson_confirm"><span
										class="blind">확인</span></a> <a href="#c" onclick="dobaeRe()"
									class="realperson_refresh"><span class="blind">새로고침</span></a>
								</span>
							</div>
							<input type="hidden" value="42544" name="dobae_org"
								id="dobae_org">
						</div>
						<div class="email_save">
							<input type="checkbox" id="email_save"> <label
								for="email_save">이메일 저장</label>
						</div>
						<input type="submit" name="Submit" value="로그인" class="login_btn">

						<div class="join_btn">
							<a href="./join.html">회원가입</a> <a href="#c"
								onclick="open_login_pop('email_find')">이메일 찾기</a> <a href="#c"
								onclick="open_login_pop('passwd_find')">비밀번호 찾기</a>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
</div>


<%@ include file="../layout/footer.jsp"%>

<!-- Template Main JS File -->
<script src="../assets/js/main.js"></script>

</body>
</html>