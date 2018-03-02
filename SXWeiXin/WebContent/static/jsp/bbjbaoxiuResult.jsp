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
<% String baoxiuType = request.getParameter("type"); 
   String baoxiuName = request.getParameter("student_name");
   String baoxiuId = request.getParameter("student_id");
   String baoxiuTimes = request.getParameter("times");
   String mobile = request.getParameter("mobile");
   String beizhu = request.getParameter("beizhu");
%>

<%@ page import="menu_center.bjb_baoxiu.base.*" %>
<%@ page import="menu_center.bjb_baoxiu.*" %>

<% 
   BJB bjb = new BJB();
   bjb.setBeizhu(beizhu);
   bjb.setDate(baoxiuTimes);
   bjb.setId(baoxiuId);
   bjb.setMobile(mobile);
   bjb.setName(baoxiuName);
   bjb.setType(baoxiuType);
   String flag = BJBBaoXiuWrite.baoxiuInput(bjb);
%>

<p><h1> <%=flag %> </h1></p>

</body>
</html>