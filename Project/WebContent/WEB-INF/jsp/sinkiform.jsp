<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
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
<h1>新規登録</h1>
</div>

<c:if test="${errMsg1 != null}">
	    <div class="alert alert-danger" role="alert">
		  ${errMsg1}
		</div>
	</c:if>

	<c:if test="${errMsg2 != null}">
	    <div class="alert alert-danger" role="alert">
		  ${errMsg2}
		</div>
	</c:if>

	<c:if test="${errMsg3 != null}">
	    <div class="alert alert-danger" role="alert">
		  ${errMsg3}
		</div>
	</c:if>

	<c:if test="${errMsg4 != null}">
	    <div class="alert alert-danger" role="alert">
		  ${errMsg4}
		</div>
	</c:if>

<form action="sinki" method="post" class="form-horizontal">

    <div class="form-group col-md-6">
      <label for="inputCity">ログインID</label>
      <input type="text" name="loginId" class="form-control" id="inputCity">
    </div>

    <div class="form-group col-md-6">
      <label for="inputCity">パスワード</label>
      <input type="password" name="password" class="form-control" id="inputCity">
    </div>

    <div class="form-group col-md-6">
      <label for="inputCity">パスワード(確認)</label>
      <input type="password" name="password1" class="form-control" id="inputCity">
    </div>

    <div class="form-group col-md-6">
      <label for="inputCity">ユーザー名</label>
      <input type="text" name="name" class="form-control" id="inputCity">
    </div>

    <div class="form-group col-md-6">
      <label for="inputCity">生年月日</label>
      <input type="Date" name="birthdate" value="2018-09-09" class="form-control" id="inputCity">
    </div>

  <button type="submit" class="btn btn-primary">確認</button>

</form>

<a href="UserListServlet">戻る</a>

</body>
</html>