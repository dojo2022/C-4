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
						<td>朝食</td>
						<td id="morning"><select id="morningSelect" name="recipeid">
								<option>＊選択してください</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
						</select>
						</td>
						<td>
						<select name="savings">
						<!-- お金が自動で表示されるように作る -->
								<option>＊自動選択</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardlist}">
								 <option><c:out value="${recipe.savings}"/></option>
								</c:forEach>
						</select>
						<p>円</p>
						</td>
					</tr>
					<tr>
						<td>プラスorマイナス</td>
					</tr>
					<tr>
						<td>昼食</td>
						<td><select name="recipeid">
								<option>＊選択してください</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
								</select>
								</td>
						<td>円*要変更</td>
					</tr>
					<tr>
						<td>プラスorマイナス</td>
					</tr>
					<tr>
						<td>夕食</td>
						<td><select name="recipeid">
								<option>＊選択してください</option>
								<!-- データから取得できたのを確認済み　jsp側に問題か -->
								<c:forEach var="recipe" items="${cardList}">
									<option><c:out value="${recipe.recipe}" /></option>
								</c:forEach>
								</select>
								</td>
						<td>円*要変更</td>
					</tr>
					<tr>
						<td>プラスorマイナス</td>
					</tr>
				</table>
				<p>
					備考<input type="text" name="remarks">
				</p>
				<p>今日の削減金額は_円です！*要変更</p>
				<p>
					今日の目標:<%=request.getAttribute("money")%>円*要変更
				</p>
				<input type="submit" value="登録する">
			</form>
			<p id="output"></p>
		</main>
		<!--  footer入れるか問題
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
		-->
	</div>
	<script src="js/records.js"></script>
</body>
</html>