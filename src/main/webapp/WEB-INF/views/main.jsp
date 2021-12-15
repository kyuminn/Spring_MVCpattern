<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<c:if test="${empty authInfo}">
		<h2>환영합니다</h2>
		<!-- c tag는 자동으로 앞에 pageContext.request.contextPath()를 붙여준다!! -->
		<p>
			<a href="<c:url value='/register/step1'/>"><spring:message code="member.register"/></a>
			<a href="<c:url value='/login'/>"><spring:message code="login.title"/></a>
		</p>
	</c:if>
	
	<c:if test="${!empty authInfo }">
		<p>
			${authInfo.name }님 환영합니다
		</p>
		<p>
			<a href='<c:url value="/edit/changePassword"/>'><spring:message code="password.change"/></a>
			<a href="<c:url value='/logout'/>"><spring:message code="logout"/></a>
		</p>
	</c:if>

</body>
</html>