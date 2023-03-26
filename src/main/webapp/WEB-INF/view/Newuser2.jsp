<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		user account = (user)session.getAttribute("input_data");
	%>
	名前：<%=account.getName() %><br>
	メール：<%=account.getMail() %><br>
	電話番号：<%=account.getTel() %><br>
	パスワード：********************<br>

	
	<a href="Newuser3">OK</a><br>
	<a href="Newuser">戻る</a>
</body>
</html>