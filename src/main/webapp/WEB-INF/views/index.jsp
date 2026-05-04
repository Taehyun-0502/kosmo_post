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
		                    <h1 class="h3 mb-4 text-gray-800">HOME</h1>
								<c:if test="${not empty member}">
								<h3 >로그인 상태</h3>
								</c:if>
								
								<c:if test="${empty member}">
								<h3>비 로그인 상태</h3>
								</c:if>
								<div id="map"  style="width:500px;height:400px">
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
	<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?></script>
	<script>
	const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		let options = { 
		center: new kakao.maps.LatLng(33.450701, 126.570667), 
		level: 3 
	};

	let map = new kakao.maps.Map(container, options); 
	</script> -->
	
</body>
</html>