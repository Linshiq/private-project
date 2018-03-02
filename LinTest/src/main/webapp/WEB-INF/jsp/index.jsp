<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
	font-size: 14px;
}

#l-map {
	height: 300px;
	width: 100%;
}

#r-result {
	width: 100%;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=EnajO2tY4oBl0axGkhUGdnes"></script>
<title></title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/cover.css" />
<script type="text/javascript" src="${ctx}/static/js/ie-emulation-modes-warning.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
</head>
<body>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">LinShiqin</h3>
						<nav>
						<ul class="nav masthead-nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#">Features</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">Cover your page.</h1>
					<p class="lead">Cover is a one-page template for building
						simple and beautiful home pages. Download, edit the text, and add
						your own fullscreen background photo to make it your own.</p>
					<p class="lead">
						<a href="#" class="btn btn-lg btn-default">Learn more</a>
					</p>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Cover template for <a href="http://getbootstrap.com">Bootstrap</a>,
							by <a href="https://twitter.com/mdo">@mdo</a>.
						</p>
					</div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>