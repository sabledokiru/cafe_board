<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/shop/list.jsp</title>
</head>
<body>
<h3>상품목록 페이지 입니다.</h3>
<h4>개미</h4>
<img src="${pageContext.request.contextPath }/resources/images/kim1.png"  />
<p>5백원</p>
<form action="buy.do">
	<input type="hidden" name="id" value="sabio" />
	<input type="hidden" name="price"  value="500" />
	<button type="submit">구입하기</button>
</form>

<h4>개미토끼</h4>
<img src="${pageContext.request.contextPath }/resources/images/rabbit2.png"  />
<p>3백원</p>
<form action="buy.do">
	<input type="hidden" name="id" value="sabio" />
	<input type="hidden" name="price"  value="300" />
	<button type="submit">구입하기</button>
</form>
</body>
</html>