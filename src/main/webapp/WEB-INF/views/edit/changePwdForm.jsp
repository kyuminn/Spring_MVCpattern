<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="password.change"/></title>
</head>
<body>
	<form:form>
		<p>
			<label>
				<spring:message code="currentPassword"/>
				<form:password path="currentPassword"/>
				<form:errors  path="currentPassword"/> <!-- error가 있다면 에러메세지 출력되는 부분 -->
			</label>
		</p>
		
		<p>
			<label>
				<spring:message code="newPassword"/>
				<form:password path="newPassword"/>
				<form:errors path="newPassword"/>
			</label>
		</p>
		<input type="submit" value="<spring:message code='change.btn'/>">
	</form:form>
</body>
</html>