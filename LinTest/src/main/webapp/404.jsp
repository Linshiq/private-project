<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
%>
<% response.setStatus( 404 ); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>404</title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/amazeui.min.css" />
</head>
<body>
	<!-- content start -->
	<div class="admin-content">

		<div class="am-g">
			<div class="am-u-sm-12">
				<h2 class="am-text-center am-text-xxxl am-margin-top-lg">404.Not Found</h2>
				<p class="am-text-center">没有找到你要的页面</p>
				<pre class="am-text-center">
          .----.
       _.'__    `.
   .--($)($$)---/#\
 .' @          /###\
 :         ,   #####
  `-..__.-' _.-\###/
        `;_:    `"'
      .'"""""`.
     /,  ya ,\\
    //  404!  \\
    `-._______.-'
    ___`. | .'___
   (______|______)
      		  </pre>
			</div>
		</div>
	</div>
	<!-- content end -->
</body>
</html>