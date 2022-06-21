<!-- ☆今後のタスク -->
<!--レシピ追加からデータ持ってくるEL式通す、試しにレシピ名で該当要素名通す -->
<!-- 参考URLが全部見えるようなテキストボックスにする(ボックス文字数増やす) -->
<!-- モジュール画面、備考欄orURLが2行にわたって表示される時に項目名が崩れている可能性(開発ツールで確認) -->
<!-- メインをセンターへ持ってくる(result.cssでテーブルの高さ、幅設定してセンター？) -->
<!-- ☆☆109行目辺り警告：備考remarksのvalue未定義 -->
<!-- ☆☆セッションスコープのidを取得してくる(Slackで確認) -->


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
			<h2>レシピ登録結果</h2>

			<!-- ☆セッションスコープからのデータ反映処理記入 (login.jsp h2下、Slack) -->
			<p id="err">${result.message2}</p>
			<!--  <span>${result.message2}</span> -->


			レシピが追加できました(画面遷移のみ確認済 データ移動要確認)！

	<form method="POST" action="/EngelS/recipeAddServlet">
		<table>
			<tr>
				<td>
					レシピ名
				</td>
				<td>
					<!-- recipeAddにてリクエストスコープに格納したデータをフォワード時にEL式で持ってくる？ -->
					<!-- imputtype=textを$valueに変更するとよさそう？  -->

					<!-- input type="text" name="POST", value="$～←☆モジュールかテキスト要素確認" readonly -->

					<!-- <input type="text" name="recipe" value="${cardList.recipe}" readonly>  -->
					<input type="text" name="recipe" value="${cardList.recipe}" readonly>
					<!-- <input type="text" name="recipe" id="recipe" disabled> -->
				</td>
			</tr>
			<tr>
				<td>
					費用(円)
				</td>
				<td>
					<input type="text" name="cost" value="${cardList.cost}" readonly>
					<!-- <input type="text" name="cost" id="cost" disabled>円 -->
				</td>
			</tr>
			<tr>
				<td>
					調理時間(分)
				</td>
				<td>
					<input type="text" name="time" value="${cardList.time}" readonly>
					<!--  <input type="text" name="time" id="time" disabled>分 -->
				</td>
			</tr>
			<tr>
				<td>
					参考URL
				</td>
				<td>
					<input type="text" name="url" value="${cardList.url}" readonly>
					<!-- <input type="text" name="url" id="url" disabled> -->
				</td>
			</tr>
			<tr>
				<td>
					備考<br>
				</td>
				<td>
					<textarea name="remarks"  readonly>${cardList.remarks}</textarea>
					<!-- <textarea name="remarks" id="remarks" rows="5" disabled></textarea>  -->
				</td>
			</tr>
		</table>
	</form>


		<a href="/EngelS/recipeSearchServlet"><input type="button" value="一覧に戻る"></a>
		<a href="/EngelS/recipeAddServlet"><input type="button" value="続けて登録する"></a>


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