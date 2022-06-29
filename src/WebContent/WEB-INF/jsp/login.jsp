<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン|EngelS</title>
<!-- 共通css,jsへのリンク 各画面のもここに-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" type="text/css" href="/EngelS/css/login.css">
<!-- <script type="text/javascript" src="/javascript/common.js"></script> -->
<script type="text/javascript" src="/EngelS/js/login.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<div class="h_logo">
				<img src="./img/logo.png">
			</div>
		</header>
		<main>

			<h2>ログイン画面</h2>

			<p>${result.message3}</p>

			<div class="form">
				<!-- ログインフォーム -->
				<form id="logform" method="POST" action="/EngelS/loginServlet"
					onclick="logfun()">
					<table>
						<tr>
							<td>ログインID<br> *20文字以内
							</td>
						</tr>
						<tr>
							<td><input type="text" name="user" id="user" maxlength="20">
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
					</table>
					<table>
						<tr>
							<td class="sub"><input type="submit" value="ログイン"></td>
							<td><a href="/EngelS/signupServlet">新規登録はこちら</a></td>
						</tr>
					</table>
				</form>

				<p id="err">${result.message2}</p>
			</div>
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