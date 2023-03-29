<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.bookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧</title>
</head>
<body>
	<h2>本の検索</h2>
	<input type="text" name="bookname">
	<input type="submit" value="Search">
	<br>
	<h3>検索結果</h3>
	<table border="1">
		<tr>
			<th>図書名</th>
			<th>出版社</th>
			<th>著者</th>
			<th>作者</th>
			<th>新書・旧書</th>
			<th>画像</th>
		</tr>
	<%
	List<bookDTO> list = (ArrayList<bookDTO>)request.getAttribute("list");
			for(bookDTO s : list) {
	%>
		<tr>
			<td><%=s.getBookname() %></td>
			<td><%=s.getPublisher() %></td>
			<td><%=s.getAuthor() %></td>
			<td><%=s.getIllustrator() %></td>
			<td><%=s.getBooktype() %></td>
			<td><%=s.getImagepass() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>