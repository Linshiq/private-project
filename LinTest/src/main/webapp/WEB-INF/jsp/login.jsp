<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/signin.css" />
<script type="text/javascript" src="${ctx}/static/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">非常简洁的登陆界面</h2>
        <input type="email" class="form-control" placeholder="账号" required autofocus>
        <input type="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>

    </div> <!-- /container -->
</body>
</html>