<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果</title>
</head>
<body>



<%
request.setCharacterEncoding("UTF-8");

String department = request.getParameter("department");
String place = request.getParameter("place");
String realPeople = request.getParameter("realPeople");
String people = request.getParameter("people");
String list = request.getParameter("list");
String title = request.getParameter("title");
String content = request.getParameter("content");
String advice = request.getParameter("advice");
String headPeople = request.getParameter("headPeople");

%>

<%@ page import="menu_center.huiyi_dengji.base.*" %>
<%@ page import="menu_center.huiyi_dengji.*" %>

<%

HuiYi huiYi = new HuiYi();
huiYi.setAdvice(advice);
huiYi.setContent(content);
huiYi.setDepartment(department);
huiYi.setHeadPeople(headPeople);
huiYi.setList(list);
huiYi.setPeople(people);
huiYi.setPlace(place);
huiYi.setRealPeople(realPeople);
huiYi.setTitle(title);

%>

<%

String result = HuiYiDJWrite.huiYiInput(huiYi);

%>

<h1><%=result %></h1>

</body>
</html>