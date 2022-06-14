<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- コピペのままなので、変える。 -->
<form method="get" action=http://www.google.co.jp/search target=”_blank”>
<input type="text" name="query" size="30" maxlength="255" value="">
<input type="submit" name="btn" value="検索">
<input type="hidden" name="hl" value="ja">
<input type="hidden" name="sitesearch" value="xxxxx.co.jp">
</form>

<!-- クリックしたらモーダルを表示するボタン -->
<a href="#" class="btn">詳細</a>

<!-- オーバーレイ -->
<div class="overlay"></div>

<!-- モーダルウィンドウ -->
<div class="modal">
  <div class="close">×</div>
    <table>
				<tr>
					<th>レシピ名</th>
					<td>${e.Name}</td>
				</tr>
				<tr>
					<th>費用</th>
					<td>${e.Cost}円</td>
				</tr>
				<tr>
					<th>所要時間</th>
					<td>${e.Minutes}分</td>
				</tr>
				<tr>
					<th>URL</th>
					<td>${e.Url}</td>
				</tr>
				<tr>
					<th>備考</th>
					<td>${e.Notes}</td>
				</tr>

</table>

</div>

<!-- スクロールで高さを出すためのsectionタグ -->
<section></section>

</body>
</html>