<!-- ☆今後のタスク -->
<!--レシピ追加からデータ持ってくるEL式通す、試しにレシピ名で該当要素名通す -->
<!-- 参考URLが全部見えるようなテキストボックスにする(ボックス文字数増やす) -->
<!-- モジュール画面、備考欄orURLが2行にわたって表示される時に項目名が崩れている可能性(開発ツールで確認) -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>レシピ登録結果</h2>

レシピが追加できました！

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
														  <!--☆ ↓{}前にドル入れる(コメント内でもエラー出てしまうので未記入)  -->
					<!-- <input type="text" name="recipe", value="{cardList.recipe}" readonly> -->
					<input type="text" name="recipe" id="recipe" disabled>
				</td>
			</tr>
			<tr>
				<td>
					費用(円)
				</td>
				<td>
				<!-- <input type="text" name="cost", value="{cardList.cost}" readonly> -->
					<input type="text" name="cost" id="cost" disabled>円
				</td>
			</tr>
			<tr>
				<td>
					調理時間(分)
				</td>
				<td>
				<!-- <input type="text" name="time", value="{cardList.time}" readonly> -->
					<input type="text" name="time" id="time" disabled>分
				</td>
			</tr>
			<tr>
				<td>
					参考URL
				</td>
				<td>
				<!-- <input type="text" name="url", value="{cardList.url}" readonly> -->
					<input type="text" name="url" id="url" disabled>
				</td>
			</tr>
			<tr>
				<td>
					備考<br>
				</td>
				<td>
				<!-- <input type="text" name="remarks", value="{cardList.remarks}" readonly> -->
					<textarea name="remarks" id="remarks" rows="5" disabled></textarea>
				</td>
			</tr>
		</table>
	</form>


<a href="/EngelS/recipeSearchServlet"><input type="button" value="一覧に戻る"></a>
<a href="/EngelS/recipeAddServlet"><input type="button" value="続けて登録する"></a>


</body>
</html>