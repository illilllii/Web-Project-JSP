<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<main class="main" id="main">
	<section id="menuAdmin-detail" class="menuAdmin-detail" data-menu="md">
		<div class="container menuAdmin-detail__content">
			<div class="card" style="width: 400px">
				<div class="card-title-form">
					<input type="text" id="detail-name" class="form-control"
						value="${dto.name}" /> <br /> <input type="file"
						id="menu-file-input" accept="image/gif, image/jpeg, image/png" />

				</div>

				<img class="card-img-top" id="detail-image" src="${dto.imageSrc}"
					alt="Card image" style="width: 100%">


				<div class="card-body">

					<textarea class="form-control" rows="5" id="detail-content">${dto.content}</textarea>
					<br />


					<div class="recommend-radio-form">
						<div class="recommend-radio-form-title">추천여부</div>
						<div class="menuAdmin-detail__recommend">
							<input type="radio" id="recommend-Y" name="recommend" value="Y"
								<c:if test="${dto.recommend eq 'Y'}">checked</c:if> /> <label
								for="recommend-Y">Y</label><br /> <input type="radio"
								id="recommend-N" name="recommend" value="N"
								<c:if test="${dto.recommend eq 'N'}">checked</c:if> /> <label
								for="recommend-N">N</label><br />
						</div>
					</div>
					<div class="btn-wrap">
						<button class="btn btn-warning"
							onclick="updateMenu(${dto.id},'${dto.imageSrc}')">수정하기</button>
						<button class="btn btn-secondary"
							onclick="location.href ='javascript:history.back()'">뒤로가기</button>
					</div>

				</div>
			</div>

		</div>
	</section>
</main>
<%@ include file="../layout/footer.jsp"%>
<script src="/ediya/assets/js/menuUpdate.js"></script>
<script type="text/javascript">

</script>
</body>
</html>