<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${ctx}/static/css/login.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap3.1.1.min.css" />

</head>
<body>
<% 
   request.setCharacterEncoding("UTF-8");
   String resultName = request.getParameter("resultName"); 
   if(resultName == null || resultName.length()<=0){
	   
   }
   
%>
<%@ page import="hidden_funtion.tongji_user.*"%>
<%@ page import="hidden_funtion.tongji_user.base.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<% List<UseFZ> strMap= DealMsg.dealMsga(); %>
<% SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");%>
<% Date time = new Date(); %>
<center>
<form action="${ctx}/msgConut" method="post">
<div class="row" >
 <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" name="name" placeholder="输入使用者名称" >
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div>
</form>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">使用清单</div>	
  <!-- Table -->
  <table class="table">
    <thead>
					<tr class="error">
						<th>
							使用者名字
						</th>
						<th>
							使用类型
						</th>
						<th>
							使用次数
						</th>
						<th>
							截止日
						</th>
					</tr>
				</thead>
				<tbody>
				<tr><td>翻译的名称为：</td><td><%=resultName %></td></tr>
				<% for(UseFZ s: strMap){ 	if(s.getUseName().equals("-") && s.getUseType().equals("-")) continue;%>
					<tr>
					   <td>
						<%=s.getUseName() %>
						</td>
						<td>
						<%=s.getUseType() %>
						</td>
						<td>
						<%=s.getUseNum() %>
						</td>
						<td>
							<%=df.format(time.getTime()) %>
						</td>
						
					</tr>
				<% } %>
				</tbody>
  </table>
</div>
</center>
</body>
</html>