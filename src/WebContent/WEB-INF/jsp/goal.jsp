<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目標金額設定|EngelS</title>
<!-- 共通css,jsへのリンク 各画面のもここに-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/goal.css">
</head>

<body>

	<div class="container">
		<header>
			<!--設定ドロップダウンメニュー開始 -->
			<nav class="drop">
				<ul id="dropmenu" class="dropmenu">
					<li><a href="#">設定</a>
						<ul>
							<li class="username">ID：</li>
							<li>ニックネーム：</li>
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

		<main>
			<h1>目標金額設定</h1>
			<p class="money">今月の目標金額は￥</p>
			<div id="money">${goal.money}</div>
			<br>
			<p class="sum">今月の削減金額は￥</p>
			<div id="sum">${goal.sum}</div>
			<br>
			<p class="sagaku">目標まであと￥</p>
			<div id="sagaku"></div>
			<form id="goal_form" method="POST" action="/EngelS/goalServlet">
				<div class="ca">

					<label>
						設定月<input type="month" name="date">
					</label>
				</div>

				<div class="tx">
					<label>
					目標削減金額 ￥<input type="text" name="new_money">
					</label>

				</div>
				<div class="btn">
					<input type="submit" value="変更" name="change_goal">
					<div id="error"></div>
				</div>
			</form>
			<div class="back">
				<a href="/EngelS/homeServlet">ホームに戻る</a>
			</div>
			<!-- 登録できました！のメッセージ -->
			<p class="msg">${result.message3}</p>
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
	</div>
<script src="./js/common.js"></script>
<script src="./js/goal.js"></script>
</body>
</html>

