<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ一覧・検索</title>
<!-- 共通css,jsへのリンク ★各画面のもここに入れてください-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/recipeSearch.css">
<script src="./javascript/common.js"></script>
<script src="./javascript/recipeSearch.js"></script>
<script
	src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
	<script src="//listjs.com/assets/javascripts/list.min.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<!--設定ドロップダウンメニュー開始 -->
			<nav class="drop">
				<ul id="dropmenu" class="dropmenu">
					<li><a href="#">設定</a>
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
		<main>
			<!--★皆さんが作ってるものをここに入れてください-->
			<form method="POST" action="/EngelS/recipeSearchServlet">
				<input type="text" name="query" size="30" maxlength="40">
				<input type="submit" name="btn" value="検索">
			</form>

			<!-- 費用と所要時間（追加されたやつ）
		<select>
			<optgroup label="費用">
			<option value="up">昇順</option>
  			<option value="down">降順</option>
			</optgroup>
			<optgroup label="時間">
  			<option value="up">昇順</option>
  			<option value="down">降順</option>
			</optgroup>
		</select>
		-->
			【検索結果】<span id="hits"></span>${Listcount}件見つかりました。<!--検索数が表示されるところ-->


			<!-- 一覧表 -->

				<table border="1" class="sortable" style = "width:700px; height:100px">

				<!-- <pre>${recipe}</pre>  -->

					<tr>
						<th style="width:100px">レシピ名</th>
						<th style="width:50px">費用</th>
						<th style="width:50px">所要時間</th>
						<th style="width:30px">詳細ページ</th>
					</tr>
					<c:forEach var="e" items="${recipe}">
					<tr>
						<td>${e.recipe}</td>
						<td>${e.cost}円</td>
						<td>${e.time}分</td>
						<td><a href onclick="location.hre6f='/detailServlet.java'">詳細
					</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>


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