<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签到</title>
<meta name="viewport" content="height=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap3.1.1.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/layer.css" />
<script type="text/javascript" src="${ctx}/static/js/layer.js"></script>
<script type="text/javascript" src="${ctx}/static/js/layer.m.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/lsq_layout.css">

</head>
<body>
<div class="content">
    <h5>签到</h5>
    <p class="line"></p>
	<form action="studentqiandaoResult.jsp" method="post" class="form-horizontal" id="form1">
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
               <input type="text" id="student_name" name="student_name" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学号</label>
            <div class="col-sm-10">
               <input type="text" id="student_id" name="student_id"  class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">联系方式</label>
            <div class="col-sm-10">
               <input type="text" id="mobile" name="mobile"  class="form-control">
            </div>
        </div>
         <div class="form-group">
            <label class="col-sm-2 control-label">活动名称</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" id="huodong_name" name="huodong_name" >
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
               <textarea name="beizhu" ></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                 <input type="button" onclick="gosubmit();" class="btn btn-default" value="提交" />
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
    function submit_form(){
        document.getElementById("form1").submit();
    }
    function gosubmit(){
        var info1=document.getElementById('student_name').value;
        var info2=document.getElementById('student_id').value;
        var info3=document.getElementById('mobile').value;
        var info4=document.getElementById('huodong_name').value;
        var pattern=/^1[3578][0123456789]\d{8}$/;
        if(info1.length==0){
                show_popup_msg("请输入您的姓名",0, 3);
                return false;
            }else if(info2.length==0){
                show_popup_msg("请输入您的学号",0, 3);
                return false;
            }else if(!pattern.test(info3)){
                show_popup_msg("手机号码格式错误！",0, 3);
                return false;
            }else if(info4.length==0){
            	show_popup_msg("请输入活动名称",0, 3);
                return false;
            }else{
               layer.open({
                    content: '确认提交？',
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