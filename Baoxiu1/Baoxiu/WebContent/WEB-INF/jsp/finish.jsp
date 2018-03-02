<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctxStatic}/js/repair.js" type="text/javascript"></script>
<title>申请成功!</title>
</head>
<body>
<%String str = "/url?id="+request.getParameter("id").replace(".jsp","");%>
<center><span>申请成功!请点击<span>
<button type="button" onclick="back('${ctx}<%=str%>')">返回</button>
</center>
</body>
</html>