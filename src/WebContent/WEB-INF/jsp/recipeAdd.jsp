<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 共通CSSファイル(common.css)との連携 -->
<link rel="stylesheet" type="text/css" href="/EngelS/css/common.css">

<!-- レシピ追加CSSファイルとの連携 -->
<link rel="stylesheet" type="text/css" href="/EngelS/css/recipeAdd.css">
<script type="text/javascript" src="/EngelS/js/recipeAdd.js"></script>
</head>
<body onload="init();">
<h2>レシピ追加</h2>


<!-- レシピ追加フォーム -->
<!-- ☆☆input type=の先の名称確認して反映 ☆☆ -->

	<form method="POST" action="/EngelS/recipeAddServlet">
		<table>
			<tr>
				<td>
					レシピ名 *30文字以内
				</td>
				<td>
					<input type="text" name="recipe" id="recipe">
				</td>
			</tr>
			<tr>
				<td>
					費用(円) *半角数字
				</td>
				<td>
					<input type="text" name="cost">
				</td>
			</tr>
			<tr>
				<td>
					調理時間(分) *半角数字
				</td>
				<td>
					<input type="text" name="time">
				</td>
			</tr>
			<tr>
				<td>
					参考URL
				</td>
				<td>
					<input type="text" name="url">
				</td>
			</tr>
			<tr>
				<td>
					備考<br>
				</td>
				<td>
					<textarea name="remarks"  rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="reset" name="reset" value="リセット" class="subbutton"></td>

					<!-- 登録ボタン…作業後半、クリックしたらモーダルを表示する仕様に変更 -->
					<!--  actionページ遷移もモーダルへ移動 -->
					<!--  <a href="#" class="button">登録(モーダルウィンドウを表示)</a> -->
					<!-- 元文章：<td><input type="submit" name="REGIST" value="登録" class="button"></td> -->
				<td><a href="#" class="button" id="modal_regist" onclick="onclick_regist()">登録(モーダルウィンドウを表示)</a></td>
			</tr>
		</table>
	</form>


<!-- エラー表示(ログインjsp準拠) -->
<p id="err"></p>

<!-- オーバーレイ -->
<div class="overlay"></div>

<!-- モーダルウィンドウ -->
<div class="modal">
  <div class="close">&times;</div>
    <h2>この内容で登録しますか？</h2>
    <p>ここにモダルの内容(レシピ情報)が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。</p>

	<table>
		<tr>
			<td>レシピ名</td>
			<td><div id="modal_recipe"></div></td>
		</tr>
	</table>
	<!-- 以下、はい(登録)、いいえ(モーダルウィンドウ消去)の追加 -->

	<form method="POST" action="/EngelS/recipeAddServlet">
		<input type="hidden" id="hidden_recipe">

		<input type="submit" name="REGIST" value="はい" class="button">
		<input type="submit" name="close" value="いいえ" class="button, close">
	</form>

</div>

<!-- スクロールで高さを出すためのsectionタグ -->
<section></section>

</body>
</html>