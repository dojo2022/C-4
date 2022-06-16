<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目標金額設定|EngelS</title>
<!-- 共通css,jsへのリンク 各画面のもここに-->
<link rel="stylesheet" href="./css/common.css">
<script src="./javascript/common.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<!--設定ドロップダウンメニュー開始 -->
			<nav class="drop">
				<ul id="dropmenu" class="dropmenu">
					<li><a href="#">設定</a>
						<ul>
							<li class="username">ニックネーム取得</li>
							<li>ログインID取得</li>
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
			<p>目標金額設定</p>

			<form method="POST" action="/EngelS/goalServlet">
				設定月<input type="date" name="date">

				<p>選択した月の目標削減金額は円で、</p>
				<p>現在${goal.sum}円削減達成中です。</p>
				<label>目標削減金額 <input type="text" name="new_money"> 円
				</label>
				<!-- 未設定の場合どうするかまだ考えてない -->
				<input type="submit" value="変更" name="change_goal">
			</form>

			<a href="/EngelS/homeServlet">ホームに戻る</a>
			<!-- 登録できました！のメッセージ -->
			<p>${result.message1}</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>
			<p>テスト</p>

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