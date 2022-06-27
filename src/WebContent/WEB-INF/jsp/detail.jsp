<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録詳細</title>
<!-- 共通css,jsへのリンク ★各画面のもここに入れてください-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/detail.css">
<script src="./js/common.js"></script>
<script src="./js/detail.js"></script>

</head>
<body>
	<div class="container">
		<header>
			<!--設定ドロップダウンメニュー開始 -->
			<nav class="drop">
				<ul id="dropmenu" class="dropmenu">
					<li><img class="menu" src="./img/menu.png" onmouseover="ro(this, './img/menu2.png')"  onmouseout="ro(this, './img/menu.png')" >
						<ul>
							<li class="user">${user1.user}</li>
							<li class="name">${user1.name}</li>
							<li><a href="/EngelS/newPwServlet">パスワード変更</a></li>
							<li><a href="/EngelS/goalServlet">目標金額設定</a></li>
							<li><a href="/EngelS/alertServlet">アラート設定</a></li>
							<li><a href="/EngelS/loginServlet">ログアウト</a></li>
						</ul></li>
				</ul>
			</nav>
			<!-- 設定ドロップダウンメニュー終了 -->
			<!-- ナビゲーション開始 -->
			<div class="nav">
				<a href="/EngelS/homeServlet">ホーム</a> <a
					href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a> <a
					href="/EngelS/recipeAddServlet">レシピ追加</a>
			</div>
			<!-- ナビゲーション終了 -->
			<div class="h_logo">
				<img src="./img/logo.png">
			</div>
		</header>
	</div>

	<main>
		<h1 style="text-align:center;">詳細</h1>
		<form id="detail" method="POST" action="/EngelS/detailServlet">
			<table border="1" style="width: 700px; height: 400px; margin-right:auto; margin-left:auto;" >
				<tr>
					<th style="width: 100px">日付</th>
					<th style="width: 40px">３食</th>
					<th style="width: 200px">食事内容</th>
					<th style="width: 70px">節約金額</th>
					<th style="width: 300px">備考</th>
				</tr>

				<c:forEach var="e" items="${recipe}">
					<tr>
						<!-- 日付-->
						<td class="td-first">${e.date}</td>
						<!-- 朝昼晩-->
						<td class="td-second">${e.mealtime}</td>
						<!--  食事内容 -->
						<td class="td-third">${e.recipe}</td>
						<!--  節約金額 -->
						<td class="td-fourth">${e.savings}円</td>
						<!--  備考 -->
						<td class="td-fifth">${e.remarks}</td>
					</tr>
				</c:forEach>
			</table>

		</form>
		<a href="/EngelS/homeServlet">ホームへ戻る</a>


	</main>
	<footer>
		<div class="f_logo">
			<img src="./img/logo.png">
		</div>
		<div class="f1">
			<a class="a1" href="/EngelS/homeServlet">ホーム</a> <a
				href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a> <a
				href="/EngelS/recipeAddServlet">レシピ追加</a> <br>
		</div>
		<div class="f2">
			<a href="/EngelS/recordsServlet">1日の食事記録</a> <a
				href="/EngelS/detailServlet">詳細表示</a> <br>
		</div>
		<div class="f3">
			<a href="/EngelS/goalServlet">目標金額設定</a> | <a
				href="/EngelS/alertServlet">アラート設定</a> | <a
				href="/EngelS/newPwServlet">パスワード変更</a>
		</div>
		<div class="logout">
			<a href="/EngelS/loginServlet">ログアウト</a>
		</div>
		<p>&copy;3SFY All rights reserved.</p>
	</footer>
</body>
</html>