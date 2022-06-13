<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					<input type="text" name="recipe">
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
					<!--  <a href="#" class="btn">登録　モーダルウィンドウを表示</a> -->
				<td><input type="submit" name="REGIST" value="登録" class="button"></td>
			</tr>
		</table>
	</form>




<!-- オーバーレイ -->
<div class="overlay"></div>

<!-- モーダルウィンドウ -->
<div class="modal">
  <div class="close">&times</div>
    <h2>この内容で登録しますか？</h2>
    <p>ここにモダルの内容(レシピ情報)が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。ここにモダルの内容が入ります。</p>

	<!-- 以下、はい(登録)、いいえ(モーダルウィンドウ消去)の追加 -->



</div>

<!-- スクロールで高さを出すためのsectionタグ -->
<section></section>

</body>
</html>