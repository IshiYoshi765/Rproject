<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
</head>
<body>
	<h1>編集する図書の情報を入力してください！</h1>
	<form action="Bookedit2" method="post">
	<h2>ISBN：<input type="text" name="ISBN"required></h2>
	<h2>タイトル：<input type="text" name="bookname"required></h2>
	<h2>出版社：<input type="text" name="publisher"required></h2>
	<h2>作者：<input type="text" name="author"required></h2>
	<h2>絵：<input type="text" name="illustrator"></h2>
	<input type="submit" value="編集"></form>
	
	<form action="Adminmenu" method="post">
	<input type="submit" value="戻る">
	</form>
</body>
</html>