<!--☆今後のタスク： -->
<!-- ユーザー入力部分のレシピ名、 URLの折り返し実装-->

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

 <body onload="init();onload();">
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

			<!-- 例外エラー時のresultモデル エラーメッセージ表示「登録に失敗しました」の表示 -->
			<p>${result.message1}</p>

			<span>※</span>は必須入力項目です。<br>

			<!-- レシピ名のエラーメッセージ -->
			<span id="recipeerror_message"></span><br>
			<!-- 費用のエラーメッセージ -->
			<span id="costerror_message"></span><span id="costnum_error_message"></span><br>
			<!-- 所要時間のエラーメッセージ -->
			<span id="timeerror_message"></span><span id="timenum_error_message"></span><br>



 			<!-- レシピ追加フォーム -->

  <!-- フォーム中央揃え用のdivタグ -->
  <div class="addform">
	<form method="POST" action="/EngelS/recipeAddServlet" id="form">
		<table>
			<tr>
				<td>
					<b>レシピ名</b><br>
					<div class="notes"><span>※</span>30文字以内</div>
				</td>
				<td>
					<!-- ☆onchangeの()内、this確認 -->
					<input type="text" name="recipe" id="recipe" maxlength="30" >
				</td>
			</tr>
			<tr>
				<td>
					<b>費用(円)</b><br>
					<div class="notes"><span>※</span>半角数字</div>
				</td>
				<td>
					<input type="text" name="cost" id="cost" >円
				</td>
			</tr>
			<tr>
				<td>
					<b>調理時間(分)</b><br>
					<div class="notes"><span>※</span>半角数字</div>
				</td>
				<td>
					<input type="text" name="time" id="time">分
				</td>
			</tr>
			<tr>
				<td>
					<b>参考URL</b>
				</td>
				<td>
					<input type="text" name="url" id="url" maxlength="100">
				</td>
			</tr>
			<tr>
				<td>
					<b>備考</b><br>
				</td>
				<td>
					<textarea name="remarks" id="remarks" rows="5" maxlength="200"></textarea>
				</td>
			</tr>
		</table>
		<input type="reset" name="reset" value="リセット" class="subbutton">

		<a href="#" class="button" id="modal_regist" >登録</a>
	</form>
  </div>

	<!-- resultモデルのエラー表記(err)と統一中、もし不都合あればerror_messageに変更、jsへの反映も -->
	<span id="error_message"></span><br>
	<span id="numerror_message"></span>

	<!-- resultモデルのエラーと差別化　<span id="err"></span>  -->


	<!-- オーバーレイ -->
	<div class="overlay"></div>


	<!-- モーダルウィンドウ -->
	<div class="modal">

	<!-- ×ボタンのプログラム。現状不要のためコメントアウト -->
	<!-- <div class="close">&times;</div>  -->

	<!-- モーダル内に表示される文章 -->
    <h3 id="modal_check">この内容で登録しますか？</h3>

	<!-- 入力内容を、以下①②へそれぞれ受け渡す -->
	<!-- ①モーダル内レイアウト編集しやすくテーブルへテキストのみ反映させる  -->
	<!-- ②データ受け渡し用のプログラムはhiddenで別でセット -->

	<!-- ①モーダル内準備  -->

	<!-- モーダルのフォーム中央揃え用divタグ -->
	<div class="modalform">
	  <table>
		<tr>
			<td>
			   <!-- レシピ名項目崩れ防止用divタグ -->
			   <!-- モーダル内、一番最初の項目を、<div style="width:任意の数字px;">で囲む -->
			   <!-- 今回最初の欄レシピなのでレシピ欄を囲んでいる  -->
			  <div style="width:100px;">
				<b>レシピ名</b>
			  </div>
			</td>
			<td><div id="modal_recipe"></div></td>
		</tr>
		<tr>
			<td class="td_space"><b>費用</b>(円)</td>
			<td><div id="modal_cost"></div></td>
		</tr>
		<tr>
			<td class="td_space"><b>所要時間</b>(分)</td>
			<td><div id="modal_time"></div></td>
		</tr>
		<tr>
			<td><b>URL</b></td>
			<td><div id="modal_url"></div></td>
		</tr>
		<tr>
			<td><b>備考</b></td>
			<td><div id="modal_remarks"></div></td>
		</tr>
	  </table>
	 </div>


	<!-- ②データ受け渡し用プログラム -->
	<!-- 記入してもらった項目をセット -->

	<form method="POST" action="/EngelS/recipeAddServlet">
		<input type="hidden" name="recipe" id="hidden_recipe">
		<input type="hidden"  name="cost" id="hidden_cost">
		<input type="hidden" name="time" id="hidden_time">
		<input type="hidden" name="url" id="hidden_url">
		<input type="hidden" name="remarks" id="hidden_remarks">



		<!-- 以下、はい(登録)、いいえ(モーダルウィンドウ消去)の追加 -->
		<input type="submit" name="close" value="いいえ" class="subbutton close">
		<input type="submit" name="REGIST" value="はい" class="button">
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