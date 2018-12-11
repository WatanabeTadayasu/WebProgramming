<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>ユーザ情報詳細参照</title>
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
<h1>ユーザー情報詳細参照</h1>
</div>

<div align="center">
					<p>
        			ログインID:${Detail.loginId}<br>
                   	ユーザ名:${Detail.name}<br>
                    生年月日:${Detail.birthdate}<br>
                    登録日時:${Detail.createDate}<br>
                    更新日時:${Detail.updateDate}<br>
    				</p>
</div>

<a href="UserListServlet">戻る</a>

</body>
</html>