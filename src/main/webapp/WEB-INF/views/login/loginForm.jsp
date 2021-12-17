<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form commandName="loginCommand">
		<p>
			<label>
				<spring:message code="email"/>:
				<form:input path="email"/> <!-- <input type="text" name="email"> 쿠키값이 있으면 value에 넣어줌-->
				<form:errors path="email"/> <!-- errors 객체에 email 항목에 대한 에러가 있으면 에러 메세지가 표시되는 부분 -->
			</label>
		</p>
		
		<p>
			<label>
				<spring:message code="password"/>:
				<form:password path="password"/>
				<form:errors path="password"/>
			</label>
		</p>
		<p>
			<label>
				<spring:message code="rememberEmail"/>
				<form:checkbox path="rememberEmail"/>
			</label>
		</p>
		<form:errors/> <!-- 글로벌 에러 코드가 표시되는 부분 -->
		<br>
		<input type="submit" value="<spring:message code="login.btn"/>">
	</form:form>
</body>
</html>