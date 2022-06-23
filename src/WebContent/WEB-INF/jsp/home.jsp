<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム|EngelS</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/home.css">
</head>

<body>
	<script src="./js/common.js"></script>
	<script src="./js/home.js"></script>
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
			<h1>削減金額目標グラフ</h1>
			<div class="wrapper1">
				<p class="money">今月の目標金額は￥</p>
				<div id="money">${goal.money}</div>
			</div>
			<div class="wrapper2">
				<p class="sum">今月の削減金額は￥</p>
				<div id="sum">${goal.sum}</div>
			</div>
			<div class="wrapper3">
				<p class="sagaku">目標まであと￥</p>
				<div id="sagaku"></div>
			</div>
			<div class="date">
				<p>期間：<span>${goal.date}～</span></p>
			</div>

			<div id="graph">
				<section>
					<!-- home.cssで指定したのでwidthは消しました -->
					<div hidden>
						<c:forEach var="List" items="${graph}">
							<p class="savings">${List.savings}</p>
							<p class="day">${List.date}</p>
						</c:forEach>
						<p class="goal">${goal.money}</p>
						<p class="daymax">${daymax}</p>
						<c:forEach var="List" items="${RecipeList}">
							<p class="Random">${List.recipe}</p>
						</c:forEach>
					</div>
					<!--  グラフをここに表示-->
					<canvas id="myChart"></canvas>
				</section>
			</div>

			<div class="det">
					<a href="/EngelS/detailServlet">記録詳細へ</a>
			</div>
			<div class="rec">
				<a href="/EngelS/recordsServlet">+今日の記録</a>
			</div>
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.js">

	</script>
	<script type="text/javascript" src="/EngelS/js/graph.js"></script>
</body>
</html>



