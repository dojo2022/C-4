<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録|EngelS</title>
<!-- 共通css,jsへのリンク 各画面のもここに-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" type="text/css" href="/EngelS/css/signup.css">
<script src="./javascript/common.js"></script>
<script type="text/javascript" src="/EngelS/js/signup.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<div class="h_logo">
				<img src="./img/logo.png">
			</div>
		</header>
		<main>
			<h2>新規ユーザー登録</h2>

			<!-- 新規ユーザー登録フォーム -->
			<form method="POST" action="/EngelS/signupServlet" id="signupform"
				onclick="signupfun()">
				<table>
					<tr>
						<td>ログインID<br> *20字以内
						</td>
					</tr>
					<tr>
						<td><input type="text" name="user" id="user" maxlength="20">
						</td>
					</tr>
					<tr>
						<td>ニックネーム<br> *20字以内
						</td>
					</tr>
					<tr>
						<td><input type="text" name="name" id="name" maxlength="20">
						</td>
					</tr>
					<tr>
						<td>パスワード<br> *10文字以内
						</td>
					</tr>
					<tr>
						<td><input type="password" name="pw" id="pw" maxlength="10">
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="新規登録"></td>
					</tr>
				</table>
			</form>
			<a href="/EngelS/loginServlet">戻る</a>

			<p id="err">${result.message1}</p>
		</main>
		<footer>
			<div class="f_logo">
				<img src="./img/logo.png">
			</div>
			<p>&copy;3SFY All rights reserved.</p>
		</footer>
	</div>
</body>
</html>