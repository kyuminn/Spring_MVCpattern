<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form:form action="step3" commandName="formData">
		<table>
			<tr>
				<td>이메일</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><form:password path="confirmPassword"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입완료"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>