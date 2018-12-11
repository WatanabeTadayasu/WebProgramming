<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<head>
<title>ユーザー削除</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
</head>
<body>

	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

<div align="right">
<header class="head">

${userInfo.name} さん

<a href="LogoutServlet">ログアウト</a>
</header>
</div>

<div align="center">
<h1>ユーザー削除</h1>
</div>

<form method="post" action="UserDeleteServlet">

    <div class="form-group col-md-6">
      <label for="inputCity">ログインID</label>
      <input type="text" value="${Detail.loginId}" readonly="readonly" name="loginId" class="form-control" id="inputCity">
    </div>

  <button type="submit" class="btn btn-primary">確認</button>
</form>

<a href="UserListServlet">戻る</a>

</body>
</html>