<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ一覧・検索</title>
<!-- 共通css,jsへのリンク ★各画面のもここに入れてください-->
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
			<!--★皆さんが作ってるものをここに入れてください-->


<form method="get" action=recipeSearch target="_blank">
<input type="text" name="query" size="30" maxlength="40" value="">
<input type="submit" name="btn" value="検索">
</form>
<!-- 費用と所要時間（あの追加されたやつ） -->
<!-- 一覧表 -->
<table border ="1">

</table>
<!-- クリックしたらモーダルを表示するボタン -->
<a href="/recipeSearchServlet" + "?recipeId=100" class="btn">詳細</a>
<!--  how to use the parameter with <a> tag?-->
<!--  how to make ajax request? -->

<!-- オーバーレイ -->
<div class="overlay"></div>

<!-- モーダルウィンドウ -->
<div class="modal">
  <div class="close">×</div>
<table>
				<tr>
					<th>レシピ名</th>
					<td>${e.Name}</td>
				</tr>
				<tr>
					<th>費用</th>
					<td>${e.Cost}円</td>
				</tr>
				<tr>
					<th>所要時間</th>
					<td>${e.Minutes}分</td>
				</tr>
				<tr>
					<th>URL</th>
					<td>${e.Url}</td>
				</tr>
				<tr>
					<th>備考</th>
					<td>${e.Notes}</td>
				</tr>

</table>

</div>

<!-- スクロールで高さを出すためのsectionタグ -->
<section></section>




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