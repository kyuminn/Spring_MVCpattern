<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<form:form commandName="cmd">
		<p>
			<label>
				from:<form:input path="from"/>
			</label>
			<label>
				to:<form:input path="to"/>
			</label>
			<input type="submit" value="조회">
		</p>
	</form:form>
	
	<c:if test="${empty members }"></c:if>
</body>
</html>