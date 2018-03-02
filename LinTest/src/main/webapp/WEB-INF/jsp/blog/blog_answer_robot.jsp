<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>你问我答</title>

<!-- Bootstrap core CSS -->
<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${ctx}/static/css/blog.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="${ctx}/static/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!--  <style type="text/css">
    	.answer{display:none;}
    	.question{cursor:pointer;}
    </style> -->
</head>

<body>

	<jsp:include page="body/blog_top.jsp" flush="true">
		<jsp:param value="answerrobot" name="answerrobot" />
	</jsp:include>

	<div class="container">

		<div class="blog-header">
			<h1 class="blog-title">你问吧</h1>
			<p class="lead blog-description">做的不好,那你就来打我啊,啦啦啦~</p>
		</div>

		<div class="row">

			<div class="col-sm-8 blog-main">


				<div class="blog-post">
					<div class="col-lg-6">
						<div class="input-group">
							<form class="input-group" action="${ctx}/blog/answer_robot">
								<input type="text" class="form-control"
									name="info"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="submit">Go!</button>
								</span>
							</form>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
					<h2 class="blog-post-title ">@_@</h2>
					<p>您的上一个问题:${answerRobot.question}</p>
					<blockquote>
						<p class="question">
							回答: <strong class="answer">${answerRobot.text}</strong>
						</p>
						<!--  </ul> -->
					</blockquote>
				</div>
				<!-- /.blog-post -->


				<%-- <nav>
				<ul class="pager">
					<li><a href="${ctx}/blog/answer_robot">Next</a></li>
				</ul>
				</nav> --%>

			</div>
			<!-- /.blog-main -->

			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>
						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras
						mattis consectetur purus sit amet fermentum. Aenean lacinia
						bibendum nulla sed consectetur.
					</p>
				</div>
			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<div class="blog-footer">
		<p>
			Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
			by <a href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${ctx}/static/js/jquery.min.js"></script>
	<script src="${ctx}/static/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/assets/js/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="${ctx}/static/assets/js/ie10-viewport-bug-workaround.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.question').click(function() {
				if ($('.answer').hide()) {
					$('.answer').show();
				} else {
					$('.answer').hide();
				}
			});
		});
	</script>
</body>
</html>