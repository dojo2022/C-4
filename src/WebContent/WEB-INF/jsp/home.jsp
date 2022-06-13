<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<nav>
		<ul class="list">
			<li><a href="/EngelS/homeServlet">ホーム</a></li>
			<li><a href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a></li>
			<li><a href="/EngelS/recipeAddServlet">レシピ追加</a></li>
		</ul>
	</nav>
    <!--設定ドロップダウンメニュー開始 -->
	<nav>
	    <ul id="dropmenu" class="dropmenu">
		    <li><a href="#">設定</a>
				<ul>
					<li>ニックネーム取得</li>
					<li>ログインID取得</li>
					<li><a href="/EngelS/newPwServlet">パスワード変更</a></li>
					<li><a href="/EngelS/goalServlet">目標金額設定</a></li>
					<li><a href="/EngelS/alertServlet">アラート設定</a></li>
					<li><a href="/EngelS/loginServlet">ログアウト</a></li>
				 </ul>
		    </li>
	    </ul>
    </nav>
    <!-- 設定ドロップダウンメニュー終わり -->
    <h1>節約金額目標グラフ</h1>
    <h2>目標削減金額<span>(金額取得)</span>円</h2>
    <h2>目標達成まであと<span>(金額取得)</span>円</h2>
    <p>期間：<span>(日付取得)</span>～<span>(日付取得)</span></p>
    <div>
    	～グラフをここに表示～
    </div>
    <a href="/EngelS/detailServlet">記録詳細へ</a>
    <a href="/EngelS/recordServlet">+今日の記録</a>
    ※画像にしたい
    <br>
    <p>以下フッター</p>
</body>

<footer>
	<a href="/EngelS/homeServlet">ホーム</a>
	<a href="/EngelS/recipeSearchServlet">レシピ一覧・検索</a>
	<a href="/EngelS/recipeAddServlet">レシピ追加</a>
	<br>
	<a href="/EngelS/recordServlet">日々の食事記録</a>
	<a href="/EngelS/detailServlet">詳細表示</a>
	<br>
	<a href="/EngelS/goalServlet">目標金額設定</a>
	|
	<a href="/EngelS/alertServlet">アラート設定</a>
	|
	<a href="/EngelS/newPwServlet">パスワード変更</a>
	<br>
	<a href="/EngelS/loginServlet">ログアウト</a>
</footer>
</html>

<link rel="stylesheet" type="text/css" href="/EngelS/css/common.css">
<script src="/EngelS/javascript/common.js"></script>