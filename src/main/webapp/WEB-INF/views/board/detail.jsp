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
		                    <h1 class="h3 mb-4 text-gray-800">detail page</h1>
		                    <div >
		                    	<table class="table">
		                    		<thead class="thead-dark">
		                    			<tr>
		                    				<th scope="col">글 번호</th>
		                    				<th scope="col">제목</th>
		                    				<th scope="col">내용</th>
		                    				<th scope="col">작성날짜</th>
		                    				<th scope="col">조회 수</th>
		                    				<th scope="col">작성자</th>
		                    			</tr>
		                    		</thead>
		                    		<tbody>
		                    			<tr>
		                    				<td>${detail.commentNo} </td>
		                    				<td>${detail.title} </td>
											<td>${detail.contents}</td>
		                    				<td>${detail.toDate} </td>
		                    				<td>${detail.views} </td>
		                    				<td>${detail.professorNo} </td>
		                    					
		                    			</tr>
		                    			<tr>
		                    				<div >
		                    				<c:forEach items="${detail.list}" var="f">
		                    				<td><img src="/files/${name}/${f.fileName}"> ${f.oriName}</td>
		                    				</c:forEach>
		                    				</div>
		                    			</tr>
		                    		
		                    			
		                    		</tbody>
		                    	
		                    	
		                    	
		                    	</table>
		                    	
		                    
		                    </div>
						<div>
								<a  class="btn btn-primary" href="./update?commentNo=${detail.commentNo}">정보 수정</a>
								
								<form action="./delete" method="post">
									<input type="hidden" name="professorNo" value="${detail.commentNo}">
								<button type="submit" class="btn btn-primary"> 삭제</button>
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