<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电脑报修处理界面</title>
<link rel="stylesheet"  type="text/css" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="${ctx}/static/css/lsq_layout.css">
</head>
<body>
<%if("Login".equals(request.getParameter("Login"))){ %>
	<header>
		<form action="${ctx}/Baoxiu" method="post">
			<input type="text" name="search" placeholder="搜索" />
			<select id="select" name="select">
				<option>唯一ID</option>
				<option>名字</option>
				<option>学号</option>
				<option>维修类型</option>
				<option>联系方式</option>
				<option>备注</option>
				<option>期望维修时间</option>
				<option>维修状态</option>
			</select>
			<input type="submit" name="submit"/>
		</form>
	</header>
	<%@ page import="menu_center.bjb_baoxiu.base.*" %>
    <%@ page import="menu_center.bjb_baoxiu.*" %>
    <%@ page import="com.tool.*" %>
    <%@ page import="java.util.*" %>
    <div id="list">
		<table class="table">
		<thead>
				<tr>
					<th>唯一ID</th>
					<th>名字</th>
					<th>学号</th>
					<th>维修类型</th>
					<th>联系方式</th>
					<th>备注</th>
					<th>期望维修时间</th>
					<th>维修状态</th>
					<th>处理</th>
					<th>删除</th>
				</tr>	
			</thead>
			<tbody>

	<%
	   String select = request.getParameter("select");
	   String search = request.getParameter("search");	
	%>
	<% 
	    List<BJB> bjbList = null;
	    if(!StringUtil.strIsNotEmpty(search)){
	    	bjbList = BJBBaoXiuRead.BJBOuput("","");
	    }else{
	    	bjbList = BJBBaoXiuRead.BJBOuput(select,search);
	    }
	    for(BJB b:bjbList){
	   %>
	    
	    	   <tr>
					<td><input type="text" readonly value="<%=b.getCustnon() %>"></td>
					<td><input type="text" readonly value="<%=b.getName() %>"></td>
					<td><input type="text" readonly value="<%=b.getId() %>"></td>
					<td><input type="text" readonly value="<%=b.getType() %>"></td>
					<td><input type="text" readonly value="<%=b.getMobile() %>"></td>
					<td><input type="text" readonly value="<%=b.getBeizhu() %>"></td>
					<td><input type="text" readonly value="<%=b.getDate() %>"></td>
					<td><input type="text" readonly value="<%=b.getStatus() %>"></td>
					<td>
				         <form action="${ctx}/Baoxiu" method="post">
					     <input type="hidden" id="caozuo" name="caozuo" />
                         <input type="hidden" id="custno" name="custno" value="<%=b.getCustnon()+"!-!-!-!-!-!-!updateTBL" %>"/>
					     <button class="btn btn-primary btn-sm" type="submit" value="处理" />
				         </form>
				   </td>
				   <td>
				         <form action="${ctx}/Baoxiu" method="post" >
				         <input type="hidden" id="caozuo" name="caozuo" />
                         <input type="hidden" id="custno" name="custno" value="<%=b.getCustnon()+"!-!-!-!-!-!-!deleteTBL" %>"/>
					     <button class="btn btn-primary btn-sm" type="submit" value="删除"/>
				      </form>
	      		  </td>
				</tr>	
		     		    	
	<%    }%>													
			</tbody>
		</table>
	</div>
<%} %>
</body>
<script type="text/javascript">
    function updateJDBC(){
    	document.getElementById("caozuo").value="updateTBL";
    }
    function deleteJDBC(){
    	document.getElementById("caozuo").value="deleteTBL	";
    }
</script>
</html>