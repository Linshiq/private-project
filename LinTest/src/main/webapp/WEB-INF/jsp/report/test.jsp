<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>年度报表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script type="text/javascript"
	src="${ctx}/static/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- 时间控件 -->
<link rel="stylesheet" media="screen"
	href="${ctx}/static/plug/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" />

<!--  <script src="jquery.datetimepicker.js"></script>-->

<!-- 时间控件end -->
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="opacity:0.8;">
		  <div class="container-fluid"   >
			<div class="navbar-header" >
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">点我点我可以返回顶部</a>
			</div>
			<div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse" >
				<ul class="nav navbar-nav navbar-right" >
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search" action="${ctx}">
					<input type="text" class="form-control" placeholder="Search..." />
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				
				<form class="navbar-form navbar-right" role="search" action="${ctx}/table/dd" method="get">
					<div class="input-group date form_date " data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
						 <input name="oneday" class="form-control" size="16" type="text" value="please choose date" readonly>
                   		 <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						 <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>	
						 <button type="submit" class="nav navbar-nav navbar-right btn btn-default ">Submit</button>			
					</div>	
					<input type="hidden" id="dtp_input2" value="" /><br />					
				</form>
			</div>
		</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li ><h3 class="sub-header">报表总览</h3></li>
				</ul>
				<!-- 年度报表div -->
				<div class="tabbable">
			        <div class="nav nav-tabs"> 
			            <div class="nav nav-sidebar">
			            	<a href="#yearBaoBiao" data-toggle="collapse">年度消费报表<i class="icon icon_down_triangle"></i></a>
			            </div>
			            <ul id="yearBaoBiao" class="nav nav-list collapse in">
			                <li ><a href="${ctx}/table/yearbaobiao">2016年消费报表</a></li>	
			            </ul>
			        </div>
			    </div>
   				<!-- 年度报表div end -->
   				<!--余额折线报表  -->
   				<div class="tabbable">
			        <div class="nav nav-tabs"> 
			            <div class="nav nav-sidebar">
			            	<a href="#yuEBaoBiao" data-toggle="collapse">余额折线报表<i class="icon icon_down_triangle"></i></a>
			            </div>
			            <ul id="yuEBaoBiao" class="nav nav-list collapse in">
			                <li ><a href="${ctx}/table/yue"> <span class="glyphicon glyphicon-circle-arrow-right"></span> 余额折线总览</a></li>	
			            </ul>
			        </div>
			    </div>
			    <!--余额折线报表end  -->
				<ul class="nav nav-sidebar">
					<li><a href="#">Sorry,I'm gone</a></li>
				</ul>
				<!--月份报表  -->
   				<div class="tabbable">
			        <div class="nav nav-tabs"> 
			            <div class="nav nav-sidebar">
			            	<a href="#yueBaoBiao" data-toggle="collapse">月份折线报表<i class="icon icon_down_triangle"></i></a>
			            </div>
			            <ul id="yueBaoBiao" class="nav nav-list collapse in">
			                <li><a href="${ctx}/table/monthbaobiao?oneMonth=01">一月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=02">二月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=03">三月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=04">四月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=05">五月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=06">六月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=07">七月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=08">八月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=09">九月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=10">十月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=11">十一月份报表</a></li>
							<li><a href="${ctx}/table/monthbaobiao?oneMonth=12">十二月份报表</a></li>	
			            </ul>
			        </div>
			    </div>
			    <!--月份报表end  -->
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul>
			</div>
			
		</div>
	</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${ctx}/static/js/ie10-viewport-bug-workaround.js"></script>
<!-- 日期插件 -->
	<script type="text/javascript"
		src="${ctx}/static/plug/bootstrap-datetimepicker-master/sample in bootstrap v3/jquery/jquery-1.8.3.min.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/static/plug/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/static/plug/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.fr.js"
		charset="UTF-8"></script>
	<script type="text/javascript" src="${ctx}/static/plug/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	(function($){ //设置返回格式
		$.fn.datetimepicker.dates['zh-CN'] = {
		days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
		daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
		daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
		months: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
		monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
		today: "今天",
		suffix: [],
		meridiem: ["上午", "下午"]
		};
		}(jQuery));
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        autoclose: 1,
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
</script>
</body>
</html>