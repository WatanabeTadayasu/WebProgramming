<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>登録完了</title>
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

    <p>登録完了しました</p>

    <a href="UserListServlet">戻る</a>

</body>
</html>