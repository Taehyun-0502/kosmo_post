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
	
						<h3>${detail.productTitle}</h3>
						<h3>${detail.productRate}</h3>
					<a href="../account/create?productNum=${detail.productNum}" class="btn-btn" >상품 가입</a>
	
	
	
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