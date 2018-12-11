<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User"%>

    <%
    User User = (User) session.getAttribute("updateUser");
%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー削除確認</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
</head>
<body>

<div align="right">
<header class="head">

${userInfo.name} さん

<a href="LogoutServlet">ログアウト</a>
</header>
</div>

<div align="center">
<h1>ユーザー削除確認</h1>
</div>

		<p>ログインID:${deleteUser.loginId}を</p>
		<p>本当に削除してもよろしいでしょうか。</p>

<div align="center">

<a href="UserListServlet">
<button type="button" class="btn btn-success">キャンセル</button></a>

<a href="UserDeleteServlet?action=done">
<button type="button" class="btn btn-danger">OK</button></a>

</div>

</body>
</html>