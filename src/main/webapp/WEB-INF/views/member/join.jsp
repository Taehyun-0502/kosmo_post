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
						<form action="./join" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="username">username(ID)</label> 
								<input type="text"class="form-control" id="username" name="username" >
								<span id="username_result"></span>
							</div>
							<div class="form-group">
								<label for="name">name</label> 
								<input type="text" class="form-control" id="name" name="name" >
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> 
								<input type="password" class="form-control" id="password" name="password">
							<span id="password_result"></span>
							</div>
							 <div class="form-group">
								<label for="passwordCheck">Password 확인</label> 
								<input type="password" class="form-control" name="password" id="passwordCheck">
							<span id="passwordCheck_result"></span>
							</div> 
							<div class="form-group">
								<label for="email">email</label> 
								<input type="email" class="form-control" id="email" name="email">
							</div>
							<div class="form-group">
								<label for="date">생일</label> 
								<input type="date"	 class="form-control" id="date" name="birth">
							</div>
							<div class="form-group">
								<label for="phone">전화번호</label> 
								<input type="tel" class="form-control" id="phone" name="phone">
							</div>
							<div class="form-group">
								<label for="file">profile img</label>
								<input type="file" class="form-control-file" id="attach"name="attach">
							</div>

							<button type="button" class="btn btn-primary"id="btn">회원가입</button>
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
<script src="/js/member/join.js"></script>


</body>
</html>