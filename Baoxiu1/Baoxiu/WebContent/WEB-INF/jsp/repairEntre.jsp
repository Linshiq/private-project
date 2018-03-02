<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
   <meta http-equiv="Content-Type" content="text/html"/>
   <meta name="viewport" content="width=640, user-scalable=yes, target-densitydpi=device-dpi" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
   <meta content="yes" name="apple-mobile-web-app-capable" />
   <link href="${ctxStatic}/styles/bootstrap.min.css" rel="stylesheet" />
   <link href="${ctxStatic}/styles/NewGlobal.css" rel="stylesheet" />
   <script src="${ctxStatic}/Scripts/zepto.js" type="text/javascript"></script> 
  <!-- <link href="${ctxStatic}/styles/style.css" type="text/css" rel="stylesheet" /> --> 
   
   <title>在线报修</title>
   
</head>

<body>
	 <div class="header">
	 <a href="${ctx}/index" class="home">
	            <span class="header-icon header-icon-home"></span>
	            <span class="header-name">主页</span>
	</a>
	<div class="title" id="titleString">在线报修</div>
	<a href="javascript:history.go(-1);" class="back">
	            <span class="header-icon header-icon-return"></span>
	            <span class="header-name">返回</span>
	        </a>
	 </div>

   <script src="${ctxStatic}/calendar/touch.js" type="text/javascript"></script><!--新版zepto合并版中不包括touch.js-->
   <script src="${ctxStatic}/calendar/highlight.js" type="text/javascript"></script>
   <script src="${ctxStatic}/calendar/gmu.js" type="text/javascript"></script>
   <script src="${ctxStatic}/calendar/event.js" type="text/javascript"></script>
   <script src="${ctxStatic}/calendar/widget.js" type="text/javascript"></script>
   <script src="${ctxStatic}/calendar/calendar.js" type="text/javascript"></script>
   
    <link rel="stylesheet" type="text/css" href="calendar/calendar.css" />
    <link rel="stylesheet" type="text/css" href="calendar/calendar.default.css" />
   
   <div class="container width90 pt20">
    <!-- 如果onsubmit事件,不加return,无论是false还是true都将被执行action-insert方法 -->
	<form id="form1" action="${ctx}/insert" method="post" onsubmit="return success()" class="form-horizontal"> 
	<ul name="information" class="search-group unstyled">
    	<!--本报修页面样式-->
	  <style>
        .section {
            background: #f3f3f3;
            font-size: 14px;
        }
        #datepicker_wrap {
            overflow: hidden;
            height: 0;
            -webkit-transition: height 200ms ease-in-out;
            background: #e1e1e1;
            -webkit-box-sizing:border-box;
            box-sizing:border-box;
        }
        #datepicker_wrap>div {
            display: none;
            padding: 5px 5px 25px 5px;
        }

        .filter {
            padding: 10px;
        
        }
        .filter:after {
            content: '\0020';
            clear: both;
            display: block;
            height: 0;
            font-size: 0;
            line-height: 0;
        }

        a.datebox {
            border: 1px solid #e1e1e1;
            text-decoration: none;
            color: #000;
            padding: 5px 26px 5px 5px;
            margin: 0px 5px 0 0;
            position: relative;
            background: #fff;
            top: 5px;
        }

       .ui-icon-down {
            position: absolute;
            top: 50%;
            right: 5px;
            background-image: url("http://gmu.baidu.com/demo/assets/icons-36-black.png");
            -webkit-background-size: 776px 18px;
            background-size: 776px 18px;
            width:18px;
            height: 18px;
            margin-top: -9px;
            background-position: 	-216px 50%;
        }
        .filter a.ui-state-active, .filter a.ui-state-hover {
            background: #fff;
        }
        .filter a.ui-state-active .ui-icon-down, .filter a.ui-state-hover .ui-icon-down {
            background-position: 	-180px 50%;
        }

        .filter a.search {
            float: right;
            padding: 5px;
            margin: 0;
        }
        .result {
            padding: 15px;
            text-align: left;
        }
    </style>

    			<li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon uesr-icon"></span>
						<span class="coupon-label" for="personName">姓　　名：</span>
						<input id="personName" name="personName" type="text" onfocus="showDesc(this)" onblur="checkUsername()" class="coupon-input input" style="width:140px;" placeholder="请输入报修人姓名"/>
					</div>
					<label id="namePrompt" name="namePrompt" type="text" style="float:right; color:red;font-size:1.5em;"></label>
				</li>	

				<li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon phone-icon"></span>
						<span class="coupon-label" for="phoneNumber">联系电话：</span>
						<input id="phoneNumber" name="phoneNumber" onfocus="showDesc(this)" onblur="checkPhoneNumber()" class="coupon-input input" style="width:140px;" placeholder="请输入联系电话" type="text" />
					</div>
					<label id="phonePrompt" name="phonePrompt" type="text" style="float:right; color:red;font-size:1.5em;"></label>
				</li>
				
				<li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon location-icon"></span>
						<span class="coupon-label" for="address">报修地址：</span>
						<input id="address" name="address" onblur="checkLocation()" class="coupon-input input" style="width:140px;" placeholder="请输入上门维修地址" type="text" />
					</div>
					<label id="addressPrompt" name="addressPrompt" type="text" style="float:right; color:red;font-size:1.5em;"></label>
				</li>

				<li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon style-icon"></span>
						<span class="coupon-label" for="style">报修类型：</span>
						<select id="style" name="type" onblur="checkStyle()" class="coupon-input select">
                           <option value="null" selected="selected">请选择报修类型</option>
                           <option value="水">水</option>             
                           <option value="电">电</option>             
                           <option value="煤气">煤气</option>
                           <option value="家具">家具</option>             
                           <option value="房屋">房屋</option>             
                           <option value="电器">电器</option>
                           <option value="其他">其他</option>
                        </select>
					</div>
					<label id="stylePrompt" name="stylePrompt" type="text" style="float:right; color:red;font-size:1.5em;"></label>
				</li>

				<li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon time-icon"></span>
						<span class="coupon-label">报修时间：</span>
					    <span class="coupon-input"><a id="datestart" class="datebox" href="javascript:void(0)"><span class="ui-icon-down"></span></a></span>
					</div>
                    <div id="dp_start" class="none">
                     <div id="datepicker_start"></div>
                     </div>
				</li>

                <li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon time-icon"></span>
						<span class="coupon-label" for="hopeTimes">期望时间：</span>
					    <span class="coupon-input"><a id="hopeTimes" name="hopeTimes"  class="datebox"  href="javascript:void(0)" onblur="checkExceptedTime()"></a></span>
					</div>
                    <div id="dp_end" class="none">
                     <div id="datepicker_end"></div>
                     </div>
                     <label id="exceptedTimePrompt" name="exceptedTimePrompt" type="text" style="float:right; color:red;font-size:1.5em;"></label>
				</li>

				<li>
					<div class="coupon-nav coupon-nav-style">
						<span class="search-icon ps-icon"></span>
						<span class="coupon-label">备　　注：</span>
                        <textarea id="address" name="address" class="coupon-input input" placeholder="可以填写故障情况,在家时间等" style="resize:none;" type="text"></textarea>
				</li>

        </ul>      
    <!--zepto插件引用-->
	<script type="text/javascript">
    (function ($, undefined) {
        $(function () {//dom ready
            var open = null, today = new Date();
            var month = today.getMonth()+1;
            var beginday = today.getFullYear()+'-'+(month< 10 ? ("0" + month) : month)+'-'+today.getDate();
            var endday = today.getFullYear()+'-'+(month< 10 ? ("0" + month) : month)+'-'+today.getDate();
            //设置报修时间为今天
            $('#datestart').html(beginday);
            //设置期望时间事件
            $('#hopeTimes').html(endday +
                '<span class="ui-icon-down"></span>');
            $('#datepicker_end').calendar({//初始化期望时间的datepicker
                date: $('#hopeTimes').text(), //设置初始日期为文本内容
                //设置期望维修时间限制为报修当天到30天内
                minDate: new Date(today.getFullYear(), today.getMonth(), today.getDate()),
                maxDate: new Date(today.getFullYear(), today.getMonth(), today.getDate() + 30),
                select: function (e, date, dateStr) {//当选中某个日期时。
                    //收起datepicker
                    open = null;
                    $('#dp_end').toggle();
                    //把所选日期赋值给文本
                    $('#hopeTimes').html(dateStr + '<span class="ui-icon-down"></span>').removeClass('ui-state-active');
                    $('#checkOutDate').val(dateStr);
                }
            });
            $('#hopeTimes').click(function (e) {//展开或收起日期
                $('#hopeTimes').removeClass('ui-state-active');
                var type = $(this).addClass('ui-state-active').is('#hopeTimes') ? 'start' : 'end';
                $('#dp_end').toggle();

            }).highlight('ui-state-hover');
        });
    })(Zepto);
</script>

     <div class="control-group tc"> 
         <button id="in" style="padding-left:0px;padding-right: 0px;" class="btn-large green button width80" type="submit">立即报修</button>
  </div>
  <div class="control-group tc">
         <button name="consle" style="padding-left:0px;padding-right: 0px;" class="btn-large green button width80">取消</button>
  </div> 
	</form>
</div>

   <!-- 在顶部<head>中引入CSS,在<body>底部引入JS,有利于网页加载 -->
   <script src="${ctxStatic}/Scripts/jquery.js"  type="text/javascript"></script>
   <script src="${ctxStatic}/Scripts/repair.js" type="text/javascript"></script>
   <!--<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>-->
   <!--引入Jquery时间选择器的JS库-->
   <!--<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>-->
   
   <!--页面底部-->
  <div class="footer">
  <div> 
      <a href="index.html" class="ui-link">首页</a> <font color="#878787">|</font> <a href="#" class="ui-link">在线报修</a> <font color="#878787">|</font> <a href="login.html" class="ui-link">管理页面</a> <font color="#878787">|</font> <a href="tongzhi.html" class="ui-link">物业通知</a></div>

      <p style="color:#bbb;">作者:蒋新宇&nbsp;&nbsp; &copy; &nbsp;&nbsp;毕业设计&nbsp;&nbsp;2016</p>
  </div>
</body>
</html>