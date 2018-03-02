<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/lsq_layout.css">
<title>签到管理界面</title>

</head>
<body>	
	<%
if ("Login".equals(request.getParameter("Login"))) {
	%>
	<header>
	<form action="${ctx}/qiandao" method="post">
		<input type="text" name="startTimes" placeholder="开始时间段" /> 
		<input type="text" name="endTimes" placeholder="结束时间段" /> 
		<input type="submit" name="submit" />
	</form>
	<form action="${ctx}/qiandao" method="post">
		<input type="text" name="search" placeholder="搜索" /> 
		<select id="select" name="select">
			<option>名字</option>
			<option>学号</option>
			<option>联系方式</option>
			<option>活动名称</option>
			<option>备注</option>
			<option>签到日期</option>
		</select> <input type="submit" name="submit" />
	</form>
	<%
		String startTimes = request.getParameter("startTimes");
		String endTimes = request.getParameter("endTimes");
		String search = request.getParameter("search");
		String select = request.getParameter("select");
	%> 
	</header>
	<div id="list">
		<table class="table">
			<thead>
				<tr>
					<th>姓名</th>
					<th>学号</th>
					<th>联系方式</th>
					<th>备注</th>
					<th>活动名称</th>
					<th>签到时间</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<%@ page import="menu_right.qiandao.base.*"%>
				<%@ page import="menu_right.qiandao.*"%>
				<%@ page import="com.tool.*"%>
				<%@ page import="java.util.*"%>
				<% int i=0; %>
				<% while(StringUtil.strIsNotEmpty((String)request.getAttribute("No."+i))){
					String s = request.getAttribute("No."+i).toString();
					String[] info = s.split("斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝");
					%>
				<tr>
				<% for(String str:info){ %>
					<td><input type="text" readonly value="<%=str%>"></td>
					<%} %>
					<td>
						<form action="${ctx}/qiandao" method="post">
							<input type="hidden" id="custno" name="custno" value="<%=(String)request.getAttribute("Custno."+i) %>" />
							<button class="btn btn-primary btn-sm" type="submit" value="删除" />
						</form>
					</td>
				</tr>
				<%i++;
				} %>
			</tbody>
		</table>
	</div>
	<%
		}
	%>
</body>
</html>