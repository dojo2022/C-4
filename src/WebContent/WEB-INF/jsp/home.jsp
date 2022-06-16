<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム|EngelS</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/home.css">
<script src="./javascript/common.js"></script>
<script src="./javascript/home.js"></script>
<script src="./javascript/graph.js"></script>
</head>

<body>
	<div class="container">
		<header>
			<!--設定ドロップダウンメニュー開始 -->
			<nav class="drop">
				<ul id="dropmenu" class="dropmenu">
					<li><a href="#">設定</a>
						<ul>
							<li class="user">名前を取得${user.name}</li>
							<li>ユーザーIDを取得${user.userid}</li>
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
			<!-- ★ここから消す★ -->
			<h1>節約金額目標グラフ</h1>
			<h2>
				目標削減金額<span>(金額取得)</span>円
			</h2>
			<h2>
				目標達成まであと<span>(金額取得)</span>円
			</h2>
			<p>
				期間：<span>(日付取得)</span>～<span>(日付取得)</span>
			</p>
			<section>～グラフをここに表示～</section>
			<a href="/EngelS/detailServlet">記録詳細へ</a> <a
				href="/EngelS/recordsServlet">+今日の記録</a> ※画像にしたい <br>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テストaaaa</p>
			<!-- ★ここまで消す★ -->
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
</body>
</html>



