<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member JPA #01 - SelectAll</h1>

	 <c:forEach var="member" items="${members}">
        아이디 : ${member.id} <br>
        이름 : ${member.username} <br>
        날짜 : ${member.createDate} <br>
        <hr>
    </c:forEach>

</body>
</html>