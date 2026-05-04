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
					<h1 class="h3 mb-4 text-gray-800">cart List Page</h1>

						<div class="row">
							<div>
								<input type="checkbox" id="all">
								<button class="btn btn-primary" id="checkdel">선택 삭제</button>
								<button class="btn btn-primary">선택 가입</button>
							</div>
						</div>
					<div class="row">
						<div class="row" id="list">
						
						
						
						</div>
						
					</div>
					<div>
						<nav aria-label="Page navigation example">
							<%-- <ul class="pagination">
								<li class="page-item ${pager.pre?'':'disabled'}"><a
									class="page-link"
									href="./list?page=${pager.pre?pager.start-1:pager.start}&search=${pager.search}&kind=${pager.kind} "
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach begin="${pager.start}" end="${pager.end}" var="i">

									<li class="page-item"><a class="page-link"
										href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
								</c:forEach>
								<li class="page-item ${pager.next?'':'disabled'}"><a
									class="page-link"
									href="./list?page=${pager.next?pager.end+1:pager.end}&search=${pager.search}&kind=${pager.kind}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul> --%>
						</nav>





					</div>
					<!-- <a href="./create">상품 등록</a>-->



				</div>
				<!-- end page content fluid -->
			</div>
			<!-- end content page  -->

			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- end content wrapper  -->
	</div>
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<!-- end wrapper  -->
	<script src="/js/cart/list.js"></script>
</body>
</html>