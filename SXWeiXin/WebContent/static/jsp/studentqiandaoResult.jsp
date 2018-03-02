<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
   String name = request.getParameter("student_name");
   String id = request.getParameter("student_id");
   String mobile = request.getParameter("mobile");
   String huodong = request.getParameter("huodong_name");
   String beizhu = request.getParameter("beizhu"); 
 %>
 
<%@ page import="menu_right.qiandao.base.*" %>
<%@ page import="menu_right.qiandao.*" %>

<%
   QianDao qianDao = new QianDao();
   qianDao.setBeizhu(beizhu);
   qianDao.setHuodong(huodong);
   qianDao.setId(id);
   qianDao.setMobile(mobile);
   qianDao.setName(name);
   boolean flag = QianDaoWrite.qiandaoInput(qianDao);
%>

<% if(!flag){%><p><h1> 提交失败</h1></p> <%}
   else{%><p><h1> 提交成功</h1></p> <%} %>

</body>
</html>