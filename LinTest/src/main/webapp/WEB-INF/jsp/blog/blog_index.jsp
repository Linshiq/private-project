<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>微信热门文章</title>

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
  </head>

  <body>

    <jsp:include page="body/blog_top.jsp" flush="true">
	<jsp:param value="hotwechat" name="hotwechat"/>
	</jsp:include>

    <div class="container">

      <div class="blog-header">
        <h1 class="blog-title">收集微信精选文章</h1>
        <p class="lead blog-description">做的不好,那你就来打我啊,啦啦啦~</p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">
		 
		 
		   <c:forEach items="${contentWeChatList}" var="contentWeChat" varStatus="vs">  <!-- 取出消费细节 -->
	          <div class="blog-post">
	            <h2 class="blog-post-title">${contentWeChat.title}</h2>
	            <p class="blog-post-meta">${contentWeChat.ctime} <a href="${contentWeChat.url}" target="view_window">${contentWeChat.description} ->点我可以进入原网页</a></p>
	            <!-- <div class="nav nav-sidebar">
			            	<a href="#${contentWeChat.title}" data-toggle="collapse">点我收起来<i class="icon icon_down_triangle"></i></a>
			     </div> -->
	            <blockquote>
	             <%--  <ul id="${contentWeChat.title}" class="nav nav-list collapse in"> --%>
	               <p>这里没有什么内容. <strong>所以只是强行占据空间!</strong> 嫌弃也没有用~</p>
	               	<%-- <p><c:import url="${contentWeChat.url}"/></p> --%>
	              <!--  </ul> -->
	            </blockquote>
	             </div><!-- /.blog-post -->
		   </c:forEach>
			
          <nav>
            <ul class="pager">
              <li><a href="#">Previous</a></li>
              <li><a href="#">Next</a></li>
            </ul>
          </nav>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>你想返回多少条?</h4>
            <ol class="list-unstyled">
              <li><a href="${ctx}/blog?num=1">1</a></li>
              <li><a href="${ctx}/blog?num=5">5</a></li>
              <li><a href="${ctx}/blog?num=10">10</a></li>
              <li><a href="${ctx}/blog?num=20">20</a></li>
              <li><a href="${ctx}/blog?num=40">40</a></li>
              <li><a href="${ctx}/blog/jxwechat">微信精选</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->

    <div class="blog-footer">
      <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
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
</body>
</html>