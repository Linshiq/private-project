<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户使用情况</title>
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

<%@ page import="hidden_funtion.tongji_user.*"%>
<%@ page import="hidden_funtion.tongji_user.base.*"%>
<%@ page import="java.util.*"%>
<% List<UseFZ> strList= ReadTxt.readJDBC(); %>

<center>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							使用者微信名称
						</th>
						<th>
							使用功能类型
						</th>
						<th>
							使用次数
						</th>
						<th>
							使用时间
						</th>
					</tr>
				</thead>
				<tbody>
				<%for(UseFZ u: strList){ %>
					<tr class="error">
						<td>
						 <%=u.getUseName() %>
						</td>	
						<td>
						 <%=u.getUseType() %>
						</td>
						<td>
						 <%=u.getUseNum() %>
						</td>
						<td>
						 <%=u.getDate() %>
						</td>				
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
</div>
</center>
</body>
</html>