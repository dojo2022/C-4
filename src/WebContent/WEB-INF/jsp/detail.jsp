<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録詳細</title>
<!-- 共通css,jsへのリンク ★各画面のもここに入れてください-->
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/detail.css">
<script src="./javascript/common.js"></script>
<script src="./javascript/detail.js"></script>
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
	</div>
		<main>
			<!--★皆さんが作ってるものをここに入れてください-->




<h1>詳細</h1>

	<!-- フォーム -->
	<form id="detail" method="GET" action="/EngelS/detailServlet"></form>
	<table border ="1">
	<div class= "scroll">

	 <tr>
            <th rowspan=4>日付</th>
            <th>３食</th>
            <th>食事内容</th>
            <th rowspan=4>節約金額</th>
            <th rowspan=4>備考</th>
     </tr>
<!-- エラーの部分を質問する。 -->
	<c:set var = "total" value = "0"></c:set>
	<c:forEach var="record" items="${recipe}">

 			<!-- 朝昼晩-->
  			<td>${record.mealtime}</td>

 			<!--  食事内容 -->
      		<td>${record.recipeid}</td>

			 <!--  節約金額 -->
      		<td>${record.savings}</td>

 			<!--  備考 -->
      		<td rowspan=4>${record.remarks}</td>
      		<!-- ${ リクエストスコープに入っているオブジェクトを指定 } -->
		<c:set var = "total" value = "${ total }${ record.savings }"></c:set>
			</c:forEach>

   </div>

   <!-- 合計行部分 -->
            <tfoot id="result2"></tfoot>
    </table>

<table>

</table>
		<button onclick="location.href='/homeServlet.java'">戻る
	</button>

		</main>

</body>
</html>