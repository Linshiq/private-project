<%@page import="com.google.gson.JsonObject"%>
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
	href="${ctx}/static/css/huiyidengji_layout.css">
<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/bootstrap.min.js"></script>
<title>会议记录管理</title>
</head>
<body>
	<%
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
		if ("Login".equals(request.getParameter("Login"))) {
	%>
	<header>
	<form action="${ctx}/huiyi" method="post">
		<input type="text" name="startTimes" placeholder="开始时间段" /> <input
			type="text" name="endTimes" placeholder="结束时间段" /> <input
			type="submit" name="submit" />
	</form>
	<form action="${ctx}/huiyi" method="post">
		<input type="text" name="search" placeholder="搜索" /> <select
			id="select" name="select">
			<option>登记时间</option>
			<option>会议部门</option>
			<option>会议地点</option>
			<option>实到人数</option>
			<option>缺勤者名单及缘由</option>
			<option>会议主题</option>
			<option>会议内容</option>
			<option>个人感受与建议</option>
			<option>会议负责人</option>
		</select> <input type="submit" name="submit" />
	</form>
	</header>
	<div id="list">
		<table class="table">
			<thead>
				<tr>
					<th>登记时间</th>
					<th>会议部门</th>
					<th>会议地点</th>
					<th>实到人数</th>
					<th>应到人数</th>
					<th>缺勤者名单及缘由</th>
					<th>会议主题</th>
					<th>会议内容</th>
					<th>个人感受与建议</th>
					<th>会议负责人</th>
					<th>查看</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<%@ page import="menu_center.huiyi_dengji.base.*"%>
				<%@ page import="menu_center.huiyi_dengji.*"%>
				<%@ page import="com.tool.*"%>
				<%@ page import="java.util.*"%>
				<%@ page import="net.sf.json.JSONObject"%>
				<%@ page import="net.sf.json.JSONArray"%>
				<%@ page import="java.util.regex.Pattern"%>
				<%@ page import="java.util.regex.Matcher" %>
				
				<%
					int i = 0;
						while (StringUtil.strIsNotEmpty((String) request.getAttribute("huiyidengji" + i))) {
							String s = request.getAttribute("huiyidengji" + i).toString();
							Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				            Matcher m = p.matcher(s);
				            String advice = s.substring(s.indexOf("'advice'")+10,s.indexOf("'content'")-2);
				            String content = s.substring(s.indexOf("'content'")+11,s.indexOf("'custno'")-2);
				            String list = s.substring(s.indexOf("'list'")+8,s.indexOf("'people'")-2);
				            s = m.replaceAll("");
							JSONObject info = new JSONObject(s);
							JSONArray columnInfo = info.getJSONArray("columnInfo"); 
							JSONObject json = columnInfo.getJSONObject(0);
				%>
				<tr>
					<td><input type="text" readonly
						value="<%=json.getString("date")%>"></td>
					<td><input type="text" readonly
						value="<%=json.getString("department")%>"></td>
					<td><input type="text" readonly
						value="<%=json.getString("place")%>"></td>
					<td><input type="text" readonly
						value="<%=json.getString("realpeople")%>"></td>
					<td><input type="text" readonly
						value="<%=json.getString("people")%>"></td>
					<td><input type="text" readonly
						value="<%=list%>"></td>
					<td><input type="text" readonly
						value="<%=json.getString("title")%>"></td>
					<td><input type="text" readonly
						value="<%=content%>"></td>
					<td><input type="text" readonly
						value="<%=advice%>"></td>
					<td><input type="text" readonly
						value="<%=json.getString("headpeople")%>"></td>
					<td>
						<button class="btn btn-primary btn-lg" data-toggle="modal"
							data-target="#myModal<%=i%>"></button>
					</td>
					<td>
						<form action="${ctx}/huiyi" method="post">
							<input type="hidden" id="caozuo" name="caozuo" /> <input
								type="hidden" id="delete" name="delete"
								value="<%=json.getString("custno")%>" />
							<button class="btn btn-primary btn-sm" type="submit" value="删除"></button>
						</form>
					</td>
				</tr>
				<!-- 模态框（Modal） -->
				<form action="${ctx}/huiyi" method="post" >
				<div class="modal fade" id="myModal<%=i%>" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
								 <input
								type="hidden" id="updateA" name="updateA"
								value="<%=json.getString("custno")%>" />
									ID：<%=json.getString("custno")%>详细资料
								</h4>
							</div>
							<div class="modal-body">
								<!--模态框内容  -->
								<div class="form-group">
									<label class="col-sm-2 control-label">登记时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="date"
												name="date" readonly value="<%=json.getString("date")%>">
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">会议部门</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="department"
												name="department" value="<%=json.getString("department")%>">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">会议地点</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="place"
												id="place" value="<%=json.getString("place")%>">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">实到人数</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="realPeople" 
											  value="<%=json.getString("realpeople")%>">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">应到人数</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="people" value="<%=json.getString("people")%>">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">缺勤者名单及缘由</label>
										<div class="col-sm-10">
											<textarea name="list" style="width: 426px" ><%=list%></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">会议主题</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="title" value="<%=json.getString("title")%>">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">会议内容</label>
										<div class="col-sm-10">
											<textarea name="content" style="width: 426px; height: 100px;" ><%=content%></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">个人感受与建议</label>
										<div class="col-sm-10">
											<textarea name="advice" style="width: 426px" ><%=advice%></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">会议负责人</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="headPeople" value="<%=json.getString("headpeople")%>">
										</div>
									</div>
								</div>
								<!--end模态框内容  -->
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								    <button type="submit" class="btn btn-primary">提交更改</button>
									
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>
					<!-- end modal -->
					</form>
					<%
						i++;
							}
					%>				
			</tbody>
		</table>
	</div>
	<%
		}
	%>
	<script type="text/javascript">
    function submit_form(){
        document.getElementById("form1").submit();
    }
    function gosubmit(){
        var info1=document.getElementById('department').value;
        var info2=document.getElementById('place').value;
        
        var pattern=/^1[3578][0123456789]\d{8}$/;
        if(info1.length==0){
                show_popup_msg("请输入部门",0, 3);
                return false;
            }else if(info2.length==0){
                show_popup_msg("请输入地点",0, 3);
                return false;
            }else{
                layer.open({
                    content: '确定提交？',
                    btn: ['确认', '取消'],
                    shade: true,
                    yes: function(){
                    	document.getElementById("form1").submit();
                        //window.location.reload();
                    },
                    no: function(){
                    }
                })
            }
    }
</script>
</body>
</html>
