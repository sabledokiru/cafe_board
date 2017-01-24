<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>개미 쇼핑몰 입니다.</h3>
<h4>공지 사항</h4>
<ul>
	<c:forEach var="tmp" items="${info }">
		<li>${tmp}</li>
	</c:forEach>
</ul>
<h5>메뉴</h5>
<ul>
	<li><a href="depositform.do">입금하러 가기</a></li>
	<li><a href="list.do">상품 목록 보러 가기</a></li>
</ul>
</body>
</html>