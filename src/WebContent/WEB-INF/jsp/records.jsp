<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日々の食事記録|EngelS</title>
<!-- 共通css,jsへのリンク-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/records.css">
<script src="./js/common.js"></script>
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
		<main>
			<form method="POST" action="/EngelS/recordsServlet" id="record_form" onclick="records_confirm()">
			<p>
				日付<input type="date" name="date" id ="date" value="<%=request.getAttribute("datek")%>">
			</p>
			<p id="date_output"></p>
			<p id="subtitle">削除金額</p>

				<table class="records_table">
				<!-- 朝食コーナー -->
					<tr>

						<!-- 朝食を選ぶ -->
						<td id="morning_recipe">
						<div id="morningRecipe" name="morning_option">
						<input type="checkbox" id="morning_mealtime" name="mealtime" value="朝" checked>朝
						<select id="morning" name="recipe" onChange="selectFunction(this)">
								<option value="*選択してください">＊選択してください</option>
								<!-- データから取得できたのを確認済み -->
								<c:forEach var="recipe" items="${cardList}">
									<option value="${recipe.recipe}"><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
						</select>

						<!-- 節約金額を判定 -->
						<select id="morning_savings" name="savings" onChange="plus()">
								<!-- お金が自動で表示されるように作る -->
								<option>＊自動選択</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option id="number1" value="${recipe.cost}"><c:out value="${recipe.cost}" />円
									</option>
								</c:forEach>
						</select>
						</div>
						</td>
					</tr>

					<!-- プルダウンを追加 -->
					<tr class="plus">
						<td><button class="plus_bt" onclick="addMorningMenu();return false;">＋</button>
						<button class="minus" onclick="removeMorningMenu();return false;">－</button></td>
					</tr>

					<!-- 昼食コーナー -->
					<tr>
					<!-- 昼食を選択 -->
						<td id="lunch_recipe">
						<div id="lunchRecipe" name="lunch_option">
						<input type="checkbox" id="lunch_mealtime" name="mealtime" value="昼"checked>昼
						<select id="lunch" name="recipe" onChange="selectFunction(this)">
							<option value="*選択してください">＊選択してください</option>
							<!-- データから取得できたのを確認済み　jsp側に問題か -->
							<c:forEach var="recipe" items="${cardList}">
								<option value="${recipe.recipe}"><c:out value="${recipe.recipe}" /></option>
							</c:forEach>
						</select>
						<!-- 昼食の節約金額 -->
						<select id="lunch_savings" name="savings" onChange="plus()">
							<!-- お金が自動で表示されるように作る -->
							<option>＊自動選択</option>
							<!-- データから取得できたのを確認済み　jsp側に問題か -->
							<c:forEach var="recipe" items="${cardList}">
								<option id="number2" value="${recipe.cost}"><c:out value="${recipe.cost}" />円
								</option>
							</c:forEach>
						</select>
						</div>
						</td>
					</tr>

					<!-- プルダウン追加 -->
					<tr class="plus">
						<td><button class="plus_bt" onclick="addlunchMenu();return false;">＋</button>
						<button class="minus" onclick="removelunchMenu();return false;">－</button></td>
					</tr>

					<!-- 夕食コーナー -->
					<tr>
					<!-- 夕食選択 -->
						<td id="dinner_recipe">
						<div id="dinnerRecipe" name="dinner_option">
						<input type="checkbox" id="dinner_mealtime" name="mealtime" value="夕" checked>夕
						<select id="dinner" name="recipe" onChange="selectFunction(this)">
								<option value="*選択してください">＊選択してください</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option value="${recipe.recipe}"><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
						</select>
						<!-- 夕食節約 -->
						<select id="dinner_savings" name="savings" onChange="plus()">
								<!-- お金が自動で表示されるように作る -->
								<option>＊自動選択</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option id="number3" value="${recipe.cost}"><c:out value="${recipe.cost}" />円
									</option>
								</c:forEach>
						</select>
						</div>
						</td>
					</tr>
					<!-- プルダウン追加 -->
					<tr class="plus">
						<td><button class="plus_bt" onclick="adddinnerMenu();return false;">＋</button>
						<button class="minus" onclick="removeDinnerMenu();return false;">－</button></td>
					</tr>
				</table>
				<p>
					備考<input type="text" name="remarks">
				</p>
				<p>今日の削減金額は</p>
				<!-- jsを使って自動で表示させたい -->
				<p id="total">0円です!</p>
				<p>
					今日の目標:
					<%=request.getAttribute("money")%>
					円
				</p>
				<input type="submit" name="SUBMIT" value="登録する" class="button">
			</form>
			<p id="output"></p>
		</main>
	</div>
	<script type="text/javascript" src="/EngelS/js/records.js"></script>
</body>
</html>