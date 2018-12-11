<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
</head>

 <body>

<header class="head">

<div align="right">ユーザー管理システム</div>

</header>

<div align="center">
<h1>ログイン画面</h1>
</div>

<c:if test="${errMsg != null}">
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

<form class="form-signin" action="LoginServlet" method="post">

	<div class="form-group">
      <label for="inputCity">ログインID</label>
      <input type="text" name="loginId" class="form-control" id="inputCity">
	</div>

	<div class="form-group">
      <label for="inputCity">パスワード</label>
      <input type="password" name="password" class="form-control" id="inputCity">
	</div>

  	<button type="submit" class="btn btn-primary">ログイン</button>
</form>

</body>
</html>
