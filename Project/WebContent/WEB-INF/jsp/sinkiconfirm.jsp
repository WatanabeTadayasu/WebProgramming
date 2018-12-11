<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="model.User"%>

    <%
    User User = (User) session.getAttribute("registerUser");
%>

<!DOCTYPE html>
<html>
<head>
<title>新規登録確認</title>
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

 <p>下記のユーザを作成します</p>
    <p>
        	ログインID:${registerUser.loginId}<br>
            ユーザ名:${registerUser.name}<br>
            生年月日:${registerUser.birthdate}<br>
    </p>

    <a href="sinki">戻る</a>

    <a href="sinki?action=done">登録</a>

</body>
</html>