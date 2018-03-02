<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物业通知</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<link href="${ctxStatic}/styles/bootstrap.min.css" rel="stylesheet" />
<link href="${ctxStatic}/styles/NewGlobal.css" rel="stylesheet" />
<script type="text/javascript" src="${ctxStatic}/Scripts/zepto.js"></script>

    <style type="text/css">
     /* CSS样式 */  
     #tab-list{width: 100%;height:auto;margin: 30px auto 55% auto;padding-bottom: 50%;} /*通知框顶部整体框属性设置*/

     #ul1{border-bottom: 2px solid #878787;height: 0px;}
     /*通知框顶部的线条样式*/
     #ul1 li{display: inline-block;line-height: 40px; border: 1px;border-bottom: none;margin-left: 0px;}/*通知样式,决定其能以行的样式显示*/
    
     #tab-list div{border: 1px solid #7396B8;border-top: none;}/*通知框的边框样式*/
     #tab-list div li{height: 25px;line-height: auto;text-indent: 0px;margin-bottom: 2px}/*通知的li标签样式,能让通知与通知之间看起来有间隔*/
    </style>

</head>

<body>
 <div class="header">
 <a href="${ctx}/index" class="home">
            <span class="header-icon header-icon-home"></span>
            <span class="header-name">主页</span>
</a>
<div class="title" id="titleString">物业通知</div>
<a href="javascript:history.go(-1);" class="back">
            <span class="header-icon header-icon-return"></span>
            <span class="header-name">返回</span>
        </a>
 </div>

        
    <div id="tab-list" >
    <ul id="ul1">
       <div>
          <ul>
            <li><a href="javascript:;">关于校园消灭"四害"的最新通知</a></li><br/>
            <li><a href="javascript:;">明日下午四点停电通知</a></li><br/>
            <li><a href="javascript:;">水费上涨通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
            <li><a href="javascript:;">招租通知</a></li><br/>
          </ul>
        </div>
    </ul>
    </div>     
                
  <div class="footer">
  <div> 
      <a href="${ctx}/index" class="ui-link">首页</a> <font color="#878787">|</font> <a href="${ctx}/baoxiu" class="ui-link">在线报修</a> <font color="#878787">|</font> <a href="${ctx}/login" class="ui-link">管理页面</a> <font color="#878787">|</font> <a href="#" class="ui-link">物业通知</a></div>

      <p style="color:#bbb;">作者:蒋新宇&nbsp;&nbsp; &copy; &nbsp;&nbsp;毕业设计&nbsp;&nbsp;2016</p>
  </div>

</body>
</html>