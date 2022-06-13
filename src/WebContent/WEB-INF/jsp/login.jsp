<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ログイン画面</h2>

	<!-- ログインフォーム -->
	<form method="POST" action="/EngelS/loginServlet">
		<table>
			<tr>
				<td>
					ログインID<br>
					*20文字以内
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
				<td><input type="submit" value="ログイン"></td>
			</tr>
		</table>
	</form>

	<p id="err"></p>
	<a href="/EngelS/signupServlet">新規登録はこちら</a>
</body>
</html>