<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="step3" commandName="formData">
		<table>
			<tr>
				<td><spring:message code="email"/></td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td><spring:message code="name"/></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><spring:message code="password"/></td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td><spring:message code="password.confirm"/></td>
				<td><form:password path="confirmPassword"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="<spring:message code="register.btn"/>"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>