<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>新規ユーザー登録</h2>

	<!-- 新規ユーザー登録フォーム -->
	<form method="POST" action="/EngelS/signupServlet">
		<table>
			<tr>
				<td>
					ログインID<br>
					*20字以内
				</td>
			</tr>
			<tr>
				<td>
					<input type="text">
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
					<input type="text">
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
					<input type="password">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="新規登録"></td>
			</tr>
		</table>
	</form>

	<p id="err"></p>

	<footer>
		<p>&copy;3SFY All rights reserved.</p>
	</footer>

</body>
</html>