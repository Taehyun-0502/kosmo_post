<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

	<div class="col-12">
		<div class="card ListAll" id="listAll">
			
			<div id="replyAll">
				
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">내용</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">별점</th>
							<th></th>
						</tr>
					</thead>
				<tbody>
<c:forEach items="${reply}" var="p">
					<tr>
						<td >
						<h5>${p.replyContents}</h5>
						</td>
						<td>
						<h5>${p.username}</h5>
						</td>
						<td>
								<fmt:parseDate pattern="yyyy-MM-dd'T'HH:mm" value="${p.replyDate}" var="parseDateTime"></fmt:parseDate>
								<fmt:formatDate value="${parseDateTime}" pattern="yyyy-MM-dd HH:mm"/>
						</td>
						
						<td>
						<h5>${p.replyStar}</h5>
						</td>
						<td>
							<button class="btn btn-outline-success update" data-toggle="modal" data-target="#reviewModal" data-reply-num="${p.replyNum}">수정</button>
							<button class="btn btn-outline-success del" data-del="del" data-num="${p.replyNum}">삭제</button>
						</td>
					</tr>
</c:forEach>
				
				</tbody>
				</table>
					
						
				</div>
			</div>
		</div>
	