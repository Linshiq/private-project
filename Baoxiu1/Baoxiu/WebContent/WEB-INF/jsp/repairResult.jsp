<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="viewport" content="width=640, user-scalable=yes, target-densitydpi=device-dpi" />
<link href="${ctxStatic}/styles/style1.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">var ctx = '${ctx}', ctxStatic='${ctxStatic}';</script>
<script src="${ctxStatic}/Scripts/jquery.js" type="text/javascript"></script>
<script src="${ctxStatic}/Scripts/paging.js" type="text/javascript"></script>
<script src="${ctxStatic}/Scripts/repair.js" type="text/javascript"></script>
<script src="${ctxStatic}/zeroclipboard-master/dist/ZeroClipboard.min.js" type="text/javascript"></script>
<script type="text/javascript">
window.onload = function(){
	//设置每页显示多少行,和table,tbody
	page = new Page(6,'customers','group_one'); 
};
</script>
<title>报修结果</title>

</head>

<body onload="today()">
	<!-- <div id="current-time"></div> -->
	<div name="nowDiv" id="nowDiv" class="left"></div>
<!-- 	<div name="head" class="left"> -->
	<!-- 	<h4>您好，欢迎查看报修历史!</h4> -->
	<div class="menu_navcc">
<div class="menu_nav clearfix">
<ul class="nav_content">
<li class="current"><a href="#" title="首页"><span>首页</span></a></li>
<li><a href="#" title=""><span>XXXX</span></a></li>
<li><a href="#" title=""><span>XXXX</span></a></li>
<li style="position:relative;"><a href="#" title="物业通知"><span>物业通知</span></a></li>
<li><a href="#" title=""><span>XXXX</span></a></li>
<li><a href="#" title=""><span>帮助咨询</span></a></li>
</ul>
<div class="menu_nav_right">
</div>
</div>
</div>
<!-- 	</div> -->
	<input type="button" id="btn_copy" title="点击复制可以将框内链接复制,按下快捷键Ctrl+V可进行粘贴." 
		class="right btn" data-clipboard-target="link" onclick="jsCopy()" value="复制" style="float:right;"/>
	<input type="text" id="link" class="right" value=""/>
	<label id="promt" class="right">请复制此链接:</label>
	<br /><br />
	<center>
		<div>
			<div>
				<div class="border">
					<table id="customers" class="table">
						<thead>
							<tr onmouseover="changTo(this)" onmouseout="changBack(this)">
								<th id="id" name="id">工单号</th>
								<th id="style" name="style">类型</th>
								<th id="personName" name="personName">报修人</th>
								<th id="address" name="address">地点</th>
								<th id="phoneNumber" name="phoneNumber">联系方式</th>
								<th id="repairTimes" name="repairTimes">报修时间</th>
								<th id="hopeTimes" name="hopeTimes">期望时间</th>
								<th id="repairStatus" name="repairStatus">报修状态</th>
								<th id="btn_copy" name="btn_copy"></th>
								<th id="btn_cancel" name="btn_cancel"></th>
							</tr>
						</thead>
						<tbody id="group_one">
						<!-- tr标签id自增1,以便后面隐藏id序号为1-6的内容 -->
						<c:set value="1" var="loop"></c:set>
							<c:forEach items="${list}" var="list">
								<tr id="${loop}" onmouseover="changeTo(this)" onmouseout="changeBack(this)">
									<c:set value="${loop+1}" var="loop"></c:set>
									<td>${list.id}</td>
									<td>${list.type}</td>
									<td>${list.name}</td>
									<td>${list.location}</td>
									<td>${list.phone}</td>
									<td><fmt:formatDate value="${list.time}"
											pattern="yyyy-MM-dd  HH:mm:ss" /></td>
									<td><fmt:formatDate value="${list.exceptedTime}"
											pattern="yyyy-MM-dd  HH:mm:ss" /></td>
									<c:choose>
										<c:when test="${list.delFlag eq '1'}">
											<td class="cancel">已取消</td>
										</c:when>
										<c:when test="${list.state eq '0'}">
											<td class="no">未维修</td>
										</c:when>
										<c:when test="${list.state eq '1'}">
											<td class="wait">维修中</td>
										</c:when>
										<c:when test="${list.state eq '2'}">
											<td class="yes">已维修</td>
										</c:when>
										<c:otherwise>
											<td class="cancel">出问题了</td>
										</c:otherwise>
									</c:choose>
									<td><button id="btn_link" name="btn_copy" type="button"
											class="btn_td" onclick="jsLink('${ctx}${list.url}')"
											title="点击链接可以生成报修人资料链接">链接</button></td>
									<td><button id="btn_cancel" name="btn_cancel" type="button" 
											class="btn_td" onclick="cancel('${list.id}')"
											title="点击取消可以取消该报修记录">取消</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="javascript:;" onclick="pageFirst();">首页</a> 
					<a href="#" onclick="page.prePage();">上一页</a>
					 第  <label id="pagenum" value=""></label> 页
					<a href="#" onclick="page.nextPage();">下一页</a>
					<a href="#" onclick="page.lastPage();">尾页</a>
				</div>
				<br />
				<button class="btn" type="button" onclick="wClose()">关闭</button>
			</div>
		</div>
	</center>
</body>
</html>