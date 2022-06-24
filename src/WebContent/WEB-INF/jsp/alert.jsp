<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アラート設定|EngelS</title>
<!-- 共通css,jsへのリンク-->
<link rel="stylesheet" href="./css/common.css">
<script src="./javascript/common.js"></script>

<!-- アラートCSSファイルとの連携 -->
 <link rel="stylesheet" type="text/css" href="/EngelS/css/alert.css">

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
			<p>アラート設定</p>
			<form method="POST" action="/EngelS/alertServlet">
				<input type="checkbox" name="Mon" value="月">月 <input
					type="checkbox" name="Tue" value="火">火 <input
					type="checkbox" name="Wed" value="水">水 <input
					type="checkbox" name="Thu" value="木">木 <input
					type="checkbox" name="Fri" value="金">金 <input
					type="checkbox" name="Sat" value="土">土 <input
					type="checkbox" name="Sun" value="日">日
				<p>調理時間</p>
				<table>
					<tr>
						<th>朝</th>
						<td><input type="text" name="morning_min"></td>
						<td>～</td>
						<td><input type="text" name="morning_max"></td>
						<td>分</td>
					</tr>
					<tr>
						<th>昼</th>
						<td><input type="text" name="lunch_min"></td>
						<td>～</td>
						<td><input type="text" name="lunch_max"></td>
						<td>分</td>
					</tr>
					<tr>
						<th>夕</th>
						<td><input type="text" name="dinner_min"></td>
						<td>～</td>
						<td><input type="text" name="dinner_max"></td>
						<td>分</td>
					</tr>
					<tr>
						<td>
							<!-- 画面が更新されて入力されたものも消えてしまうので、JSで対応する -->
							<input type="submit" name="SUBMIT" value="確定" class="button">
						</td>
					</tr>
				</table>
			</form>
			<p>${result.message1}</p>
			<a href="/EngelS/homeServlet"><input type="button" name="SUBMIT"
				value="ホームに戻る" class="subbutton"></a>
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