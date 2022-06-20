<!--☆今後のタスク： -->
<!-- メインをセンターへ持ってくる(result.cssでテーブルの高さ、幅設定してセンター？) -->
<!--レシピ追加サーブレットのスコープと合ってるか確認  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ追加|EngelS</title>

<!-- 共通css,jsへのリンク 各画面のもここに-->
<link rel="stylesheet" href="./css/common.css">
<script src="./javascript/common.js"></script>

 <!-- レシピ追加CSSファイルとの連携 -->
 <link rel="stylesheet" type="text/css" href="/EngelS/css/recipeAdd.css">

 <!-- レシピ追加Jsファイルとの連携(onloadにて制御状態付き)-->
 <script type="text/javascript" src="/EngelS/js/recipeAdd.js"></script>
</head>

 <!-- ボディ -->
 <!-- onload…onloadが付いているタグの内容が読み込み終わったら -->
	<!-- "init"(=初期化ファンクション)が実行される -->

 <body onload="init();">
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
						</ul>
					</li>
				</ul>
			</nav>
			<!-- 設定ドロップダウンメニュー終了 -->
			<!-- ナビゲーション開始 -->
			<div class="nav">
				<a href="/EngelS/homeServlet">ホーム</a>
				<a href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a>
				<a href="/EngelS/recipeAddServlet">レシピ追加</a>
			</div>
			<!-- ナビゲーション終了 -->
			<div class="h_logo">
				<img src="./img/logo.png">
			</div>
		</header>

		<main>
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
				<td><a href="#" class="button" id="modal_regist" onclick="onclick_regist()">登録</a></td>
			</tr>
		</table>
	</form>


<!-- エラー表示欄(BCログインjsp準拠) -->
<span id="error_message"></span>">

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
		<input type="hidden" name="recipe" id="hidden_recipe">
		<input type="hidden"  name="cost" id="hidden_cost">
		<input type="hidden" name="time" id="hidden_time">
		<input type="hidden" name="url" id="hidden_url">
		<input type="hidden" name="remarks" id="hidden_remarks">



		<!-- 以下、はい(登録)、いいえ(モーダルウィンドウ消去)の追加 -->
		<input type="submit" name="REGIST" value="はい" class="button">
		<input type="submit" name="close" value="いいえ" class="button, close">
	</form>

</div>

<!-- スクロールで高さを出すためのsectionタグ -->
<section></section>

		</main>
		<footer>
			<div class="f_logo">
				<img src="./img/logo.png">
			</div>
			<div class="f1">
				<a class="a1" href="/EngelS/homeServlet">ホーム</a>
				<a href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a>
				<a href="/EngelS/recipeAddServlet">レシピ追加</a> <br>
			</div>
			<div class="f2">
				<a href="/EngelS/recordsServlet">1日の食事記録</a>
				<a href="/EngelS/detailServlet">詳細表示</a> <br>
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