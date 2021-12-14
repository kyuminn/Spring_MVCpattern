<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form action="step3" method="post">
		<table>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="confirmPwd" id="confirmPwd"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입완료"></td>
			</tr>
		</table>
	</form>
</body>
</html>