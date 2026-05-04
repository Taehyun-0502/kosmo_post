<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">

	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">

			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>

				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">detail Page</h1>
					<h3 id="num">${detail.productNum}</h3>

					<h3>${detail.productTitle}</h3>
					<h3>${detail.productRate}</h3>

					<a href="../account/create?productNum=${detail.productNum}"
						class="btn-btn">상품 가입</a>
					<button id="cart" class="btn btn-danger">장바구니에 담기</button>

					<div id="review_List"></div>
					<div>
						<textarea rows="8" cols="" id="replydetail"></textarea>
						<input id="replyStar" name="replyStar" type="text">
						<button id="replyup">등록</button>
					</div>


				</div>
				<!-- end page content fluid -->
			</div>
			<!-- end content page  -->

			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- end content wrapper  -->
	</div>
	<div>
		<!-- Modal -->
		<div class="modal fade" id="reviewModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<textarea rows="4" cols="" id="content_update"></textarea>
						<input type="hidden" id="n1">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal"id="close">Close</button>
						<button type="button" class="btn btn-primary" id="update_btn">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>

	</div>



	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<!-- end wrapper  -->
	<script src="/js/cart/cart.js"></script>
	<script src="/js/reply/reply.js"></script>
</body>
</html>