<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>
		<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<p style="color:red">ログイン失敗</p>
	<form action="Login" method="post">
		Mail：<input type="text" name="mail" value="<%=request.getParameter("mail") %>"><br>
		Password：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="Newuser">新規ユーザー登録</a>
	<%
		} else {
	%>
	<form action="Login" method="post">
		Mail：<input type="text" name="mail"><br>
		Password：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="Newuser">新規ユーザー登録</a>

	<%
		}
	%>
</body>
</html>