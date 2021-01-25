<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<section id="contentWrap">
	<div class="myPage_bg">
		<div class="myPage_content">
			<h1 class="myPage_title">나의 멤버십 이용현황</h1>
			<p class="myPage_txt1">My Member's Status</p>
			<p class="myPage_txt2">고객님의 이디야 멤버스 서비스 이용현황입니다.</p>
		</div>
	</div>


	<!-- 회원정보 현황 -->
	<div class="inform_container">
		<div class="inform_bg">
			<div class="inform_content">

				<div class="user_inform">
					<div class="user_inform_title">
						<div class="level_logo">
							<img src="/ediya/assets/img/user/level_family.png" alt="레벨로고"
								style="width: 100%; max-width: 130px;">
						</div>
						<p class="level_txt">
							<span style="font-weight: 700; font-size: 28px;">유혜지</span> 회원님은<br>
							<span style="font-size: 38px; font-weight: 900; color: #59606b;">
								Family Level</span> 입니다.
						</p>
					</div>
					<div class="user_inform_content">
						<ul class="inform_txt" style="list-style-type: none;">
							<li>아이디 : hjin7270@naver.com</li>
							<li>닉네임 : 회원</li>
							<li>휴대폰 : 01083727270</li>
						</ul>
						<a href="./editPage.jsp" class="userEdit_btn">회원정보 수정</a>
					</div>
				</div>

				<div class="user_mileage">
					<ul>
						<li class="mileage_status">
							<div class="status_icon">
								<img src="/ediya/assets/img/user/status_stamp_icon.png"
									alt="스탬프현황">
							</div>
							<dl class="status_content">
								<dt class="now_tt">스탬프 현황</dt>
								<dd class="now_txt">
									<span class="status_blue_txt status_bold_txt">0</span>/12
								</dd>
							</dl>
						</li>
						<li class="mileage_status" style="margin-top: 30px;">
							<div class="status_icon">
								<img src="/ediya/assets/img/user/status_coupon_icon.png"
									alt="쿠폰현황">
							</div>
							<dl class="status_content">
								<dt class="now_tt">보유 쿠폰</dt>
								<dd class="now_txt">
									<span class="status_blue_txt status_bold_txt">0</span>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<!-- 스탬프 현황 -->
	<div class="inform_container" style="margin-top: 50px;">
		<div class="con_align">
			<div class="status_condition_title">
				<h3>
					스탬프 적립 현황<span>스탬프 12개를 적립하면 아메리카노(R) Free 쿠폰을 발급해 드립니다.</span>
				</h3>

			</div>
			<!--스탬프 현황판-->
			<div class="stamp_status">
				<ul class="stamp_list">
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
					<li class="stamp_icon"><img
						src="/ediya/assets/img/user/stamp_icon_no.jpg" alt="이디야 스탬프 없음"></li>
				</ul>
			</div>

			<dl class="stamp_notice">
				<dt>유의사항</dt>
				<dd>- 음료1잔당 1개의 스탬프를 적립해드립니다.</dd>
				<dd>- 발행된 스탬프의 유효기간은 발행일로부터 1년입니다.</dd>
				<dd>- 스탬프 12개를 적립하시면 3,200원의 아메리카노(R) Free 쿠폰을 발급해 드립니다.</dd>
				<dd>- 발행된 쿠폰의 유효기간은 발행일로부터 1개월입니다.</dd>
			</dl>
		</div>
	</div>


	<!-- 쿠폰 현황 -->
	<div class="inform_container" style="margin-top: 50px;">
		<div class="con_align">

			<div class="status_condition_title">
				<h3 id="coupon_status_text">보유쿠폰 현황</h3>
				<a href="#c" class="status_btn" onclick="">쿠폰 사용내역</a>
			</div>

			<div class="coupon_status" >
				<ul class="coupon_visual" id="coupon_status">
					<dl class="coupon_no">
						<dt>사용 가능한 쿠폰이 없습니다.</dt>
						<dd>스탬프를 적립하시면 쿠폰을 받으 실 수 있습니다.</dd>
					</dl>
				</ul>
			</div>
		</div>
	</div>

</section>



<%@ include file="../layout/footer.jsp"%>

<!-- Template Main JS File -->
<script src="../assets/js/main.js"></script>

</body>
</html>