<!-- ☆今後のタスク -->
<!-- 参考URLが全部見えるようなテキストボックスにするか検討(ボックス文字数増やす) -->
<!-- モジュール画面、備考欄orURLが2行にわたって表示される時に項目名が崩れている可能性(開発ツールで確認) -->
<!-- メインをセンターへ持ってくる(result.cssでテーブルの高さ、幅設定してセンター？) -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ登録結果|EngelS</title>
<!-- 共通css,jsへのリンク-->
<link rel="stylesheet" href="./css/common.css">
<script src="./javascript/common.js"></script>

<!-- レシピ登録結果CSSファイルとの連携 -->
 <link rel="stylesheet" type="text/css" href="/EngelS/css/result.css">

<!-- レシピ追加Jsファイルとの連携 -->
 <script type="text/javascript" src="/EngelS/js/result.js"></script>

</head>

<body>
	<div class="container">
		<header>
			<!--設定ドロップダウンメニュー開始 -->
			<nav class="drop">
				<ul id="dropmenu" class="dropmenu">
					<li><a href="#">設定</a>
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
			<h2>レシピ登録結果</h2>

			<!-- セッションスコープからのデータ反映処理(レシピが追加できました！) -->
			<p id="err">${result.message2}</p>
			<!--現在Pタグにて記述  <span>${result.message2}</span> -->

  <div class="resultform">
	<form method="POST" action="/EngelS/recipeAddServlet">
		<table>
			<tr>
				<td>
					<b>レシピ名</b>
				</td>
				<td>
					<input type="text" name="recipe" value="${addrecipe.recipe}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<b>費用(円)</b>
				</td>
				<td>
					<input type="text" name="cost" value="${addrecipe.cost}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<b>調理時間(分)</b>
				</td>
				<td>
					<input type="text" name="time" value="${addrecipe.time}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<b>参考URL</b>
				</td>
				<td>
					<input type="text" name="url" value="${addrecipe.url}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<b>備考<br></b>
				</td>
				<td>
					<textarea name="remarks"  readonly>${addrecipe.remarks}</textarea>
				</td>
			</tr>
		</table>
	</form>
  </div>

		<a href="/EngelS/recipeSearchServlet"><input type="button" value="一覧に戻る" class="subbutton"></a>
		<a href="/EngelS/recipeAddServlet"><input type="button" value="続けて登録する" class="subbutton"></a>


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