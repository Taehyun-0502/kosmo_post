<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
    
</head>
<body id="page-top">
	
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">

			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>

				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">update Page</h1>
					<!-- 입력 폼 시작 -->
					<div>
						<form action="./update" enctype="multipart/form-data" method="post">
							<input type="hidden" value="${dto.boardNum }" name="boardNum" >
							<div class="form-group">
								<label for="boardTitle">제목</label> <input
									type="text" value="${dto.boardTitle}" name="boardTitle" class="form-control" id="boardTitle">
							</div>
							<div class="form-group">
								<label for="boardWriter">작성자</label>
								
								 <input
									type="text" name="boardWriter" value="${dto.boardWriter}" class="form-control" id="boardWriter">
							</div>
							<div class="form-group">
								<label for="boardContents">내용</label>
								<textarea rows="8" cols=""name="boardContents"id="boardContents"class="form-control">${dto.boardContents}</textarea>
								
							</div>
							
							<div class="form-group">
								 <label>첨부파일</label>
								 <input type="file" name="attach" class="form-control">
								 <input type="file" name="attach" class="form-control">
							</div>
							<button type="submit" class="btn btn-primary">등록</button>
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
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	<!-- end wrapper  -->
	<script>
      	$('#contents').summernote({
        	placeholder: 'Hello Bootstrap 4',
        	tabsize: 2,
        	height: 100
      	});
    </script>
</body>
</html>