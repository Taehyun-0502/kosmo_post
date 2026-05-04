<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:forEach items="${list}" var="p">
	<div class="col-4">
		<div class="card ListAll" id="listAll">
			<div class="card-headder">
				<input type="checkbox" class="ch" value="${p.productNum}">
				<button class="btn btn-info debtn" id="deleteBtn"
					value="${p.productNum }">삭제</button>

			</div>
			<div id="listAll">
				<img src="/files/bank/${p.bankFileDTO.fileName}"
					class="card-img-top">
				<div class="card-body">
					<h5 class="card-title">${p.productTitle}</h5>
					<h5>${p.productRate}</h5>
					<a href="/bank/detail?productNum=${p.productNum}"
						class="btn btn-primary">상세보기</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>