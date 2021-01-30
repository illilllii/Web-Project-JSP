<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<main class="main" id="main">
	<section id="menuAdmin-insert" class="menuAdmin-insert"
		data-menu="bakery">
		<div class="container menuAdmin-insert__content">
			<div class="card" style="width: 400px">
				<div class="card-title-form">
					<input type="text" id="insert-name" class="form-control"
						placeholder="이름을 입력해주세요." /> <br /> <input type="text"
						id="insert-subname" class="form-control"
						placeholder="영어이름을 입력해주세요." /> <br /> <input type="file"
						id="menu-file-input" accept="image/gif, image/jpeg, image/png" />

				</div>


				<img class="card-img-top" id="insert-image" style="width: 100%"
					src="">


				<div class="card-body">

					<textarea class="form-control" rows="5" id="insert-content">${dto.content}</textarea>
					<br />

					<div class="kind-radio-form">
						<div class="kind-radio-form-title">종류</div>
						<div class="menuAdmin-insert__kind">
							<ul>
								<li><input type="radio" id="bread" name="kind"
									value="BREAD" data-kind="bread" checked /> <label
									for="bread">BREAD</label> <input type="radio" id="dessert"
									name="kind" value="DESSERT" data-kind="dessert" /> <label
									for="dessert">DESSERT</label></li>
								<li><input type="radio" id="cookie-etc" name="kind"
									value="COOKIE&ETC" data-kind="etc" /> <label
									for="cookie-etc">COOKIE & ETC</label></li>

							</ul>
						</div>
					</div>
					<div class="recommend-radio-form">
						<div class="recommend-radio-form-title">추천여부</div>
						<div class="menuAdmin-insert__recommend">
							<input type="radio" id="recommend-Y" name="recommend" value="Y"
								checked /> <label for="recommend-Y">Y</label><br /> <input
								type="radio" id="recommend-N" name="recommend" value="N" /> <label
								for="recommend-N">N</label><br />
						</div>
					</div>
					<div class="btn-wrap">
						<button class="btn btn-warning" onclick="insertMenu()">등록하기</button>
						<button class="btn btn-secondary"
							onclick="location.href ='javascript:history.back()'">뒤로가기</button>
					</div>

				</div>
			</div>

		</div>
	</section>
</main>
<%@ include file="../layout/footer.jsp"%>
<script src="/ediya/assets/js/menuInsert.js"></script>


</body>
</html>