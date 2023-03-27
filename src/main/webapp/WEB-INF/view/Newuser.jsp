<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			user ac = (user)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>新規会員登録</h3>
		<form action="Newuser2" method="post">
			名前：<input type="text" name="name" value="<%=ac.getName()%>"required><br>
			メール：<input type="email" name="email" value="<%=ac.getMail()%>"required><br>
			電話番号：<input type="tel" name="tel" value="<%=ac.getTel()%>"required><br>
			パスワード：<input type="password" name="pw"required><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
		<h3>新規会員登録</h3>
		<form action="Newuser2" method="post">
			名前：<input type="text" name="name"required><br>
			メール：<input type="email" name="email"required><br>
			電話番号：<input type="tel" name="tel"required><br>
			パスワード：<input type="password" name="pw"required><br>
			<input type="submit" value="登録">
		</form>
	<%
		}
	%>
</body>
</html>