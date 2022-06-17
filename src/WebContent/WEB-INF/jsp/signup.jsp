<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録｜EngelS</title>
<link rel="stylesheet" type="text/css" href="/EngelS/css/signup.css">
</head>
<body>
	<h2>新規ユーザー登録</h2>

	<!-- 新規ユーザー登録フォーム -->
	<form method="POST" action="/EngelS/signupServlet" id="signupform" onclick="signupfun()">
		<table>
			<tr>
				<td>
					ログインID<br>
					*20字以内
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="user" id="user" maxlength="20">
				</td>
			</tr>
			<tr>
				<td>
					ニックネーム<br>
					*20字以内
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="name" id="name" maxlength="20">
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
				<td><input type="submit" value="新規登録"></td>
			</tr>
		</table>
	</form>
	<a href="/EngelS/loginServlet">戻る</a>

	<p id="err">${result.message1}</p>

	<footer>
		<p>&copy;3SFY All rights reserved.</p>
	</footer>

</body>

<script type="text/javascript" src="/EngelS/js/signup.js"></script>

</html>