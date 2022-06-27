<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アラート設定|EngelS</title>
<!-- 共通css,jsへのリンク-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/alert.css">
<script type="text/javascript" src="/EngelS/js/common.js"></script>
<script type="text/javascript" src="/EngelS/js/alert.js"></script>

<!-- アラートCSSファイルとの連携 -->
 <link rel="stylesheet" type="text/css" href="/EngelS/css/alert.css">

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
						</ul>
					</li>
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
			<form method="POST" action="/EngelS/alertServlet" id="alert_form" onclick="alert_confirm()">
			  <div id="">
				<input type="checkbox" name="Mon" class="days" value="月">月
				<input type="checkbox" name="Tue" class="days" value="火">火
				<input type="checkbox" name="Wed" class="days" value="水">水
				<input type="checkbox" name="Thu" class="days" value="木">木
				<input type="checkbox" name="Fri" class="days" value="金">金
				<input type="checkbox" name="Sat" class="days" value="土">土
				<input type="checkbox" name="Sun" class="days" value="日">日
			  </div>
			  <p id="date_alert"></p>

				<p>調理時間</p>

				<table class="alert_table">
					<tr>
						<th>朝</th>
						<td><input type="number" name="morning_min" id="morning_alertMin" min="0" step="1"></td>
						<td>～</td>
						<td><input type="number" name="morning_max" id="morning_alertMax" min="0" step="1"></td>
						<td>分</td>
					</tr>
					<tr>
						<th>昼</th>
						<td><input type="number" name="lunch_min" id="lunch_alertMin" min="0" step="1"></td>
						<td>～</td>
						<td><input type="number" name="lunch_max"  id="lunch_alertMax" min="0" step="1"></td>
						<td>分</td>
					</tr>
					<tr>
						<th>夕</th>
						<td><input type="number" name="dinner_min" id="dinner_alertMin" min="0" step="1"></td>
						<td>～</td>
						<td><input type="number" name="dinner_max"  id="dinner_alertMax" min="0" step="1"></td>
						<td>分</td>
					</tr>

					<tr>
						<td>
							<!-- 画面が更新されて入力されたものも消えてしまうので、JSで対応する -->
							<input type="submit" name="SUBMIT" value="確定">
						</td>
					</tr>
				</table>
			</form>

			<p>*デフォルト値は、０～５分で設定しています。</p>
			<p id="morning_alert"></p>
			<p>${result.message1}</p>

			<a href="/EngelS/homeServlet">
				<input type="button" name="SUBMIT"value="ホームに戻る" class="subbutton">
			</a>

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
