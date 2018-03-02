<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/login.css">

<script type="text/javascript" src="${ctx}/static/js/layer.js"></script>
<script type="	text/javascript" src="${ctx}/static/js/layer.m.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/layer.css" />
<title>欢迎</title>
 <style type="text/css">    
    body{
        margin:0 auto;
        font-family: 微软雅黑;
        background: url('${ctx}/img/login1.jpg') no-repeat;
        background-size: 100%;
    }
 </style>
</head>
<body >
<div class="login-box">
    <h5>登录</h5>
    <form  class="form-horizontal" action="${ctx}/login" method="post" id="form1">
        <div class="form-group">
            <div class="col-md-10">
                <select class="form-control" name="select" style="width:100%">
                    <option>电脑报修管理</option>
                    <option>签到管理</option>
                    <option>会议记录管理</option>
                    <option>用户统计</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="username" class="col-md-2 control-label"><img src="${ctx}/img/user.png" /></label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="username" name="username" placeholder="用户名" style="width:86%">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-md-2 control-label"><img src="${ctx}/img/pwd.png" /></label>
            <div class="col-md-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="密码" style="width:86%">
            </div>
        </div>
            <div class="form-group" >
                <input type="button" onclick="gosubmit();" class="btn btn-log" value="登录" />
            </div>
    </form>
    <%if(null!=request.getParameter("error")){%>  	
    	<script type="text/javascript">
    	function tishi(){
    		//alert("账号或者密码错误");
    		 show_popup_msg("账号或者密码错误",0, 3);
    	}
    	tishi()
    	</script>
    <%} %>
</div>
</body>
<script type="text/javascript">
    function gosubmit(){
        var info1=document.getElementById('username').value;
        var info2=document.getElementById('password').value;
        if(info1.length==0){
                show_popup_msg("请输入账号",0, 3);
                return false;
            }else if(info2.length==0){
                show_popup_msg("请输入密码",0, 3);
                return false;
            }
            else{

                  	document.getElementById("form1").submit();

                }
            }
    
</script>
</html>