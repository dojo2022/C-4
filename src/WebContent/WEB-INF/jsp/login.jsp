<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン｜Engels</title>
<link rel="stylesheet" type="text/css" href="/EngelS/css/login.css">
</head>
<body>

	<h2>ログイン画面</h2>

	<p>${result.message1}</p>

	<!-- ログインフォーム -->
	<form id="logform" method="POST" action="/EngelS/loginServlet" onclick="logfun()">
		<table>
			<tr>
				<td>
					ログインID<br>
					*20文字以内
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="user" id="user" maxlength="20">
				</td>
			</tr>
			<tr>
				<td>
					パスワード<br>
					*10文字以内
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="pw" id="pw" maxlength="10">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="ログイン">
				</td>
			</tr>
		</table>
	</form>

	<p id="err">${result.message2}</p>
	<a href="/EngelS/signupServlet">新規登録はこちら</a>

	<footer>
		<p>&copy;3SFY All rights reserved.</p>
	</footer>
</body>

<script type="text/javascript" src="/EngelS/js/login.js"></script>

</html>