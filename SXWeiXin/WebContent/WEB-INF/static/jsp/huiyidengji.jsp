<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会议记录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="height=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap3.1.1.min.css" />
<link rel="stylesheet" type="text/css" href="/static/css/layer.css" />
<script type="text/javascript" src="/static/js/layer.js"></script>
<script type="text/javascript" src="/static/js/layer.m.js"></script>
<link rel="stylesheet" type="text/css" href="/static/css/lsq_layout.css">
</head>
<body>
<div class="content">
    <h5>会议考核表</h5>
    <p class="line"></p>
	<form class="form-horizontal" action="huiyidengjiResult.jsp" method="post" id="form1">
        <div class="form-group">
            <label class="col-sm-2 control-label">会议部门</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" id="department" name="department">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">会议地点</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" name="place" id="place">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">实到人数</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" name="realPeople">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">应到人数</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" name="people">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">缺勤者名单及缘由</label>
            <div class="col-sm-10">
                <textarea name="list"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">会议主题</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" name="title">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">会议内容</label>
            <div class="col-sm-10">
               <textarea name="content"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">个人感受与建议</label>
            <div class="col-sm-10">
               <textarea name="advice"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">会议负责人</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" name="headPeople">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                 <input type="button" onclick="gosubmit();" class="btn btn-default" value="提交"/>
            </div>
        </div>
    </form>
</div>

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