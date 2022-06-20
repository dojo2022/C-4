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
			<p>
				日付<input type="date" name="date">
			</p>
			<p>削除金額</p>
			<form method="POST" action="/EngelS/recordsServlet" id="record_form">
				<button onclick="addMorningMenu();return false;">クリック</button>

				<table>
					<tr>
						<td>
							<input type="radio" id="morning" name="朝" checked>朝
							<input type="radio" id="morning" name="昼">昼
							<input type="radio" id="morning" name="夕">夕
						</td>
						<td id="morning"><select id="morningSelect" name="recipeid">
								<option>＊選択してください</option>
								<!-- データから取得できたのを確認済み -->
								<c:forEach var="recipe" items="${cardList}">
									<option><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
						</select></td>
						<td><select name="savings">
								<!-- お金が自動で表示されるように作る -->
								<option>＊自動選択</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option id="number1"><c:out value="${recipe.cost}" />円
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>レシピを増やすもの</td>
					</tr>
					<tr>
						<td>
							<input type="radio" id="lunch" name="朝">朝
							<input type="radio" id="lunch" name="昼" checked>昼
							<input type="radio" id="lunch" name="夕">夕
						</td>
						<td><select name="recipeid">
								<option>＊選択してください</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
						</select></td>
						<td><select name="savings">
								<!-- お金が自動で表示されるように作る -->
								<option>＊自動選択</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option id="number2"><c:out value="${recipe.cost}" />円
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>レシピを増やすもの</td>
					</tr>
					<tr>
						<td>
							<input type="radio" id="dinner" name="朝">朝
							<input type="radio" id="dinner" name="昼">昼
							<input type="radio" id="dinner" name="夕" checked>夕
						</td>
						<td><select name="recipeid">
								<option>＊選択してください</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
						</select></td>
						<td><select name="savings">
								<!-- お金が自動で表示されるように作る -->
								<option>＊自動選択</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option id="number3"><c:out value="${recipe.cost}" />円
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>レシピを増やすもの</td>
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
				<input type="submit" value="登録する">
			</form>
			<p id="output"></p>
		</main>
	</div>
	<script type="text/javascript" src="/EngelS/js/records.js"></script>
</body>
</html>