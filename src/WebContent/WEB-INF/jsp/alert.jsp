<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アラート設定</title>
<link rel="stylesheet" type="text/css" href="/EngelS/css/common.css">
</head>
<header></header>
<body>
	<p>アラート設定</p>
	<form method="POST" action="/EngelS/alertServlet">
		<input type="checkbox" name="days" value="月">月
		<input type="checkbox" name="days" value="火">火
		<input type="checkbox" name="days" value="水">水
		<input type="checkbox" name="days" value="木">木
		<input type="checkbox" name="days" value="金">金
		<input type="checkbox" name="days" value="土">土
		<input type="checkbox" name="days" value="日">日
		<p>調理時間</p>
		<table>
			<tr>
				<th>朝</th>
				<td><input type="text" name="morning_min" ></td>
				<td>～</td>
				<td><input type="text" name="morning_max"></td>
				<td>分</td>
			</tr>
			<tr>
				<th>昼</th>
				<td><input type="text" name="lunch_min" ></td>
				<td>～</td>
				<td><input type="text" name="lunch_max"></td>
				<td>分</td>
			</tr>
			<tr>
				<th>夕</th>
				<td><input type="text" name="dinner_min" ></td>
				<td>～</td>
				<td><input type="text" name="dinner_max"></td>
				<td>分</td>
			</tr>
		</table>
		<!-- 画面が更新されて入力されたものも消えてしまうので、JSで対応する -->
		<input type="submit" value="確定">
	</form>
	<a href="/EngelS/homeServlet"><input type="button" value="ホームに戻る"></a>
</body>
<footer></footer>
</html>