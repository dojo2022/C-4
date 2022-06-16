<!--☆今後のタスク： -->

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

 <!-- レシピ追加Jsファイルとの連携(onloadにて制御状態付き)-->
 <script type="text/javascript" src="/EngelS/js/recipeAdd.js"></script>
</head>

 <!-- ボディ -->
 <!-- onload…onloadが付いているタグの内容が読み込み終わったら -->
	<!-- "init"(=初期化ファンクション)が実行される -->

<body onload="init();">
	<h2>レシピ追加</h2>
	<p>※は必須入力項目です。</p>


 <!-- レシピ追加フォーム -->
 <!-- ☆☆input type=の先の名称確認して反映 ☆☆ -->

	<form method="POST" action="/EngelS/recipeAddServlet">
		<table>
			<tr>
				<td>
					レシピ名 ※30文字以内
				</td>
				<td>
					<input type="text" name="recipe" id="recipe" maxlength="30" >
				</td>
			</tr>
			<tr>
				<td>
					費用(円) ※半角数字
				</td>
				<td>
					<input type="text" name="cost" id="cost">円
				</td>
			</tr>
			<tr>
				<td>
					調理時間(分) ※半角数字
				</td>
				<td>
					<input type="text" name="time" id="time">分
				</td>
			</tr>
			<tr>
				<td>
					参考URL
				</td>
				<td>
					<input type="text" name="url" id="url" maxlength="100">
				</td>
			</tr>
			<tr>
				<td>
					備考<br>
				</td>
				<td>
					<textarea name="remarks" id="remarks" rows="5" maxlength="200"></textarea>
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

	<!-- ×ボタンのプログラム。現状不要のためコメントアウト -->
	<!-- <div class="close">&times;</div>  -->

	<!-- モーダル内に表示される文章 -->
    <h2>この内容で登録しますか？</h2>

	<!-- 入力内容を、以下①②へそれぞれ受け渡す -->
	<!-- ①モーダル内レイアウト編集しやすくテーブルへテキストのみ反映させる  -->
	<!-- ②データ受け渡し用のプログラムはhiddenで別でセット -->

	<!-- ①モーダル内準備  -->
	<table>
		<tr>
			<td>レシピ名</td>
			<td><div id="modal_recipe"></div></td>
		</tr>
		<tr>
			<td>費用(円)</td>
			<td><div id="modal_cost"></div>円</td>
		</tr>
		<tr>
			<td>所要時間(分)</td>
			<td><div id="modal_time"></div>分</td>
		</tr>
		<tr>
			<td>URL</td>
			<td><div id="modal_url"></div></td>
		</tr>
		<tr>
			<td>備考</td>
			<td><div id="modal_remarks"></div></td>
		</tr>
	</table>


	<!-- ②データ受け渡し用プログラム -->
	<!-- 記入してもらった項目をセット -->

	<form method="POST" action="/EngelS/recipeAddServlet">
		<input type="hidden" id="hidden_recipe">
		<input type="hidden" id="hidden_cost">
		<input type="hidden" id="hidden_time">
		<input type="hidden" id="hidden_url">
		<input type="hidden" id="hidden_remarks">



		<!-- 以下、はい(登録)、いいえ(モーダルウィンドウ消去)の追加 -->
		<input type="submit" name="REGIST" value="はい" class="button">
		<input type="submit" name="close" value="いいえ" class="button, close">
	</form>

</div>

<!-- スクロールで高さを出すためのsectionタグ -->
<section></section>

</body>
</html>