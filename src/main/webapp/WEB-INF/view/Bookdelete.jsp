<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.bookDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="css/root.css">
<title>図書データ削除</title>
</head>
<body>
<div>
	<h1>図書データ削除画面</h1>
	
	<form action="Bookdelete2" method="post">
	<h2>本のIDを入力してください</h2><br>
	<input type="text" name="bookid"required>
	<input type="submit" value="削除">
	</form>
	<a href="Admintop">戻る</a>
</div>
</body>
</html>