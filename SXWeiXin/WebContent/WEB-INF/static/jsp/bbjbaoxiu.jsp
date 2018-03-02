<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="height=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/bootstrap3.1.1.min.css" />
<link rel="stylesheet" type="text/css" href="../css/layer.css" />
<title>电脑故障申报</title>
<script type="text/javascript" src="../js/layer.js"></script>
<script type="text/javascript" src="../js/layer.m.js"></script>
<style>
.content{
    margin-top: 15px;
}
.content h5{
    text-align: center;
    font-size: 20px;
}
.content p.line{
    border-bottom:2px solid #ccc;
}
.content form{
    margin:25px auto;
}
.content .form-group{
    width: 90%;
    margin: 0 auto;
    padding: 0;
    margin-bottom: 15px;
}
.content .form-group .col-sm-2{
    width: 25%;
    padding: 0;
    margin: 0;
    float: left;
    text-align: left;
    padding-top:6px;
    font-weight: normal;
}
.content .form-group .col-sm-10{
    width: 70%;
    padding: 0;
    margin: 0;
    float: right;
}
.content .form-group .col-sm-10 textarea{
    width: 100%;
    max-width: 100%;
    min-height: 80px;
}
.content .form-group .col-sm-10 .btn-default{
    width: 100%;
    background: #06f;
    border:none;
    color:#fff;
}
.content .form-group .col-sm-10 .btn-default:focus{
    background: #08f;
}
</style> 
</head>
<body>

<div class="content">
    <h5>电脑义修预约</h5>
    <p class="line"></p>
	<form action="bbjbaoxiuResult.jsp" method="post" class="form-horizontal" id="form1">
        <div class="form-group">
            <label class="col-sm-2 control-label">类型</label>
            <div class="col-sm-10">
                <select class="form-control" id="type" name="type">
                    <option>网络无法连接</option>
                    <option>重装系统</option>
                    <option>安装软件</option>
                    <option>没有声音</option>
                    <option>电脑清灰(收费)</option>
                    <option>其他故障</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
               <input type="text" id="student_name" name="student_name"  class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学号</label>
            <div class="col-sm-10">
               <input type="text" id="student_id" name="student_id" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">期望时间</label>
            <div class="col-sm-10">
               <input type="date" name="times" id="times" value="2015-01-01" class="form-control" >
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">联系方式</label>
            <div class="col-sm-10">
               <input type="text" id="mobile" name="mobile" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
               <textarea name="beizhu"></textarea>
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