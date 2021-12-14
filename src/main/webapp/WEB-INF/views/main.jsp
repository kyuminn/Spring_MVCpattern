<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h2>환영합니다</h2>
	<!-- c tag는 자동으로 앞에 pageContext.request.contextPath()를 붙여준다!! -->
	<p><a href="<c:url value='/register/step1'/>">회원 가입</a></p>
</body>
</html>