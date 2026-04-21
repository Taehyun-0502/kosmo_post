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
					<h1 class="h3 mb-4 text-gray-800">회원가입</h1>

					<div>
						<form action="./create" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="productTitle">name</label> 
								<input type="text"class="form-control" id="productTitle" name="productTitle" >
							</div>
							<div class="form-group">
								<label for="productContents">상세설명</label> 
								<input type="text" class="form-control" id="productContents" name="productContents" >
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">type</label> 
								<input type="text" class="form-control" id="productType" name="productType">
							</div>
							<!-- <div class="form-group">
								<label for="exampleInputPassword1">Password 확인</label> 
								<input type="password" class="form-control" name="password" id="password">
							</div> -->
							<div class="form-group">
								<label for="productRate">이자율</label> 
								<input type="text" class="form-control" id="productRate" name="productRate">
							</div>
							
							<div class="form-group">
								<label for="file">img</label>
								<input type="file" class="form-control-file" id="attach"name="attach">
							</div>

							<button type="submit" class="btn btn-primary">상품등록</button>
						</form>


					</div>


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

</body>
</html>