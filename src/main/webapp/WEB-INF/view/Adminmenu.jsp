<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dto.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ホーム</title>
</head>
<body>
	<%
	user account = (user)session.getAttribute("input_data");
	%>
	<div class="message">
	<h3>管理者画面</h3>
	
	<div class="button01">
	<a href="">図書登録</a><br>
	<a href="Bookdelete">図書データ削除</a><br>
	<a href="Bookedit">図書データ編集</a><br>
	<a href="Booklist">図書一覧</a><br>
	<a href="">返却</a><br>
	<a href="">通知</a><br>
	<a href="">ユーザーアカウント管理</a><br>
	<a href="Logout">ログアウト</a>
	</div>
	</div>
</body>
</html>