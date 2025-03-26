<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body {
		margin: auto;
		width: 800px;
	}
	a { 
		text-decoration: none;
		color: black;
		cursor: pointer;
	}
	
	h1 {
		text-align: center;
	}

</style>
</head>
<body>
	<h1>게 시 판</h1>
	<p>총 레코드 수 : ${totalRecord}</p>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="b" items="${list}">
				<tr>
				<td>${b.boardno}</td>
				<td><a href="detail?boardno=${b.boardno}">${b.title}</a></td>
				<td>${b.writer}</td>
				<td> <a href="delete?boardno=${b.boardno}" class="btn btn-outline-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a></td>
				</tr>
			</c:forEach>
		
	</table>
	<br><br>
	<a href="writeForm"><button type="button" class="btn btn-outline-primary">글작성</button></a>
</body>
</html>