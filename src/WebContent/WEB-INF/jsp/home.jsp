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
					<li><a href="#">設定</a>
						<ul>
							<li class="user">名前を取得${user.name}</li>
							<li>ユーザーIDを取得${user.userid}</li>
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
			<h1>節約金額目標グラフ</h1>
			<p class="money">今月の目標金額は￥</p><div id="money">${goal.money}</div>
			<br>
			<p class="sum">今月の削減金額は￥</p><div id="sum">${goal.sum}</div>
			<br>
			<p class="sagaku">目標まであと￥</p><div id="sagaku"></div>

			<p>
			期間：<span>${goal.date}</span>
			</p>
			<section style="width: 380px">
				<div hidden>
					<c:forEach var="List" items="${graph}">
						<p class="savings">${List.savings}</p>
						<p class="date">${List.date}</p>
					</c:forEach>
					<p class="goal">${goal.money}</p>
					<p class="daymax">${daymax}</p>
				</div>
				<!--  グラフをここに表示-->
				<canvas id="myChart"></canvas>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js"
					integrity="sha512-sW/w8s4RWTdFFSduOTGtk4isV1+190E/GghVffMA9XczdJ2MDzSzLEubKAs5h0wzgSJOQTRYyaz73L3d6RtJSg=="
					crossorigin="anonymous" referrerpolicy="no-referrer">
				</script>
				<script>
					var ctx = document.getElementById('myChart').getContext(
							'2d');
					var chart = new Chart(ctx, {
						type : 'line',

						// データを指定
						data : {
							labels : Arraylabel(),
							datasets : [ {
								label : 'dataset example',
								borderColor : 'rgb(75, 192, 192)',
								fill : false,
								data : Arraydata()

							}, {
								label : 'quota',
								borderColor : '#f88',
								fill : false,
								data : [ 100, 100, 100, 100, 100, 100, 100 ]
							} ]
						},

						// 設定はoptionsに記述
						options : {
							//タイトル
							title : {
								display : true,
								text : '線グラフの例'
							},
							y: {
								min: 0,
							},
						},
					});

					//グラフデータの設定
					function Arraydata(){
						var hoge = document.getElementsByClassName('savings');
						var data = [];

						for(let i = 0; i < hoge.length; i++){
							data.push(hoge[i].textContent);
						};
						return data;
					}

					//ラベルの設定
					function Arraylabel(){
						var hoge = document.getElementsByClassName('date');
						var label = [];

						for(let i = 0; i < hoge.length; i++){
							label.push(hoge[i].textContent);
						};
						return label;
					}

					//目標金額の日割り計算
					function Arraylabel(){
						var hoge = document.getElementsByClassName('date');
						const goal = document.getElementsByClassName('goal');
						const daymax = document.getElementsByClassName('daymax');

						var quota = [];

						for(let i = 0; i < hoge.length; i++){
							quota.push(hoge[i].textContent);
						};
						return quota;
					}
				</script>
			</section>
			<a href="/EngelS/detailServlet">記録詳細へ</a>
			<div class="rec"><a href="/EngelS/recordsServlet">+今日の記録</a></div>
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



