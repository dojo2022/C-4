<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日々の食事記録</title>
</head>
<header>
	<!--<a href="/EngelS/homeServlet">ホーム</a>
	<a href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a>
	<a href="/EngelS/recipeAddServlet">レシピ追加</a>
	設定(ここを押すとモーダルウィンドウ表示の予定)-->
</header>
<body>
	<p>
		日付<input type="date" name="date">
	</p>
	<p>削除金額</p>
	<form method="POST" action="/EngelS/recordsServlet" id="record_form">
		<table>
			<tr>
				<td>朝食</td>
				<td><select name="recipeid">
						<option>*選択してください</option>
						<c:forEach var="e" items="${cardList}">
							<select value="${e.recipe}"></select>
						</c:forEach>
				</select></td>
				<td>円*要変更</td>
			</tr>
			<tr>
				<td>プラスorマイナス</td>
			</tr>
			<tr>
				<td>昼食</td>
				<td><input type="text" name="recipeid" placeholder="*選択してください"></td>
				<td><input type="text" name="savings">円*要変更</td>
			</tr>
			<tr>
				<td>プラスorマイナス</td>
			</tr>
			<tr>
				<td>夕食</td>
				<td><input type="text" name="recipeid" placeholder="*選択してください"></td>
				<td><input type="text" name="savings">円*要変更</td>
			</tr>
			<tr>
				<td>プラスorマイナス</td>
			</tr>
		</table>
		<p>
			備考<input type="text" name="remarks">
		</p>
		<p>今日の削減金額は_円です！*要変更</p>
		<p>今日の目標:_円*要変更</p>
		<input type="submit" value="登録する">
	</form>
	<p id="output"></p>
	<footer> </footer>
	<script src="records.js"></script>
</body>
</html>