<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="model.User"%>

    <%
    User User = (User) session.getAttribute("updateUser");
%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー情報更新確認</title>
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

 <p>下記のユーザーを更新します</p>
    <p>
    	ログインID:${updateUser.loginId}<br>
        ユーザ名:${updateUser.name}<br>
        生年月日:${updateUser.birthdate}<br>
        パスワード:${updateUser.password}<br>
    </p>

    <a href="UserListServlet">戻る</a>

    <a href="UserUpdateServlet?action=done">更新</a>

</body>
</html>