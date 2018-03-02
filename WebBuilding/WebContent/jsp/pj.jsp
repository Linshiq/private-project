
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/signin.css" />
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body> 
<jsp:include page="404.jsp" flush="true"> 
<jsp:param name="a" value="1"/>
</jsp:include>
<jsp:include page="404.jsp"  /> 


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/view/includes.jsp"%> 
<!--wrap--> <div id="wrap"> <!--sidebar--> 
<jsp:include page="/WEB-INF/view/manage/newsfeed.jsp"> 
<jsp:param value="31" name="type"/> </jsp:include> 
<!--sidebar end--> <!--main--> <div id="main" class="with_sb"> --%>
</body> 
</html>