<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<p>아이디:${vo.id }</p>
	<p>이메일:${vo.email }</p>
	<p>이름:${vo.name }</p>
	<p>가입일:<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd-HH:mm"/></p>
</body>
</html>