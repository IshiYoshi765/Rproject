<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の登録</title>
</head>
<body>
 <h3>登録画面</h3>
 <from action="RegisterBook" method="post">
 <br>
	<input type="text" name="isbn" placeholder="ISBN"><br>
	<input type="text" name="bookname" placeholder="タイトル"><br>
	<input type="text" name="publiser" placeholder="出版社"><br>
	<input type="text" name="author" placeholder="作者"><br>
	<input type="text" name="illustrator" placeholder="絵"><br>
	<input type="text" name="booktype" placeholder=""><br>
	<input type="submit" value="追加">
	<a href="Adminmenu">戻る</a>
</from>
</body>
</html>