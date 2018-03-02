<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="viewport"
	content="width=640,initial-scale=1.0, maximum-scale=1.0, user-scalable=yes, target-densitydpi=device-dpi" />
<link href="${ctxStatic}/css/style2.css" type="text/css"
	rel="stylesheet" />
<script src="${ctxStatic}/js/jquery.js" type="text/javascript"></script>
<script src="${ctxStatic}/js/repair.js" type="text/javascript"></script>

<title>报修用户资料</title>
</head>

<body onload="acceptRequest(${baoxiu.state},${baoxiu.delFlag})">
   <div id="current-time"></div>
	<br />
	<br />
	<table class="imagetable" >
		<tr>
			<th>报修时间:</th>
			<td><fmt:formatDate value="${baoxiu.time}"
					pattern="yyyy-MM-dd  HH:mm:ss" /></td>
		</tr>
		<tr>
			<th>报修类型:</th>
			<td>${baoxiu.type}</td>
		</tr>
		<tr>
			<th>报修人:</th>
			<td>${baoxiu.name}</td>
		</tr>
		<tr>
			<th>联系方式:</th>
			<td>${baoxiu.phone}</td>
		</tr>
		<tr>
			<th>期望时间:</th>
			<td><fmt:formatDate value="${baoxiu.exceptedTime}"
					pattern="yyyy-MM-dd  HH:mm:ss" /></td>
		</tr>
		<tr>
			<th>地点:</th>
			<td>${baoxiu.location}</td>
		</tr>
	</table>
	<br /><br />
	<form action="${ctx}/updateAccept?id=${baoxiu.id}" method="post" onsubmit="return acceptRequest(${baoxiu.state})">
	<input id="btn_accept" name="accept" type="submit" class="btn" value="接受"
		></input>
	</form>
	<br /><br />
	<form action="${ctx}/updateFinish?id=${baoxiu.id}" method="post" onsubmit="return (${baoxiu.state})" >
	<input id="btn_finish" name="finish" type="submit" class="btn"
		value="完成" ></input>
     </form>
</body>
</html>