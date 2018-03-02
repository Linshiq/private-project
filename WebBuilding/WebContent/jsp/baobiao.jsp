<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/dashboard.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script type="text/javascript"
	src="${ctx}/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<!-- 时间控件 -->
<link rel="stylesheet" media="screen"
	href="${ctx}/plug/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" />
	<link href="${ctx}/plug/bootstrap-datetimepicker-master/sample in bootstrap v2/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<!--  <script src="jquery.datetimepicker.js"></script>-->

<!-- 时间控件end -->


</head>
<body>
	linshiq
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
				<form class="navbar-form navbar-right" role="search">
					<input type="text" class="form-control" placeholder="Search..." />
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<form class="navbar-form navbar-right" role="search">
					<div class="controls input-append date form_date" data-date=""
						data-date-format="yyyy-MM-dd" data-link-field="dtp_input2"
						data-link-format="yyyy-mm-dd" >
						<input size="16" type="text" class="form-control" value="" readonly> 
						<span class="add-on "><i class="icon-remove"></i></span> 
						<span class="add-on "><i class="icon-th"></i></span>
						<button type="submit" class="btn btn-default">Submit</button>					
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
					<li class="active"><a href="#">年度</a></li>
					<li><a href="#">2016年度</a></li>
					<li><a href="#">Analytics</a></li>
					<li><a href="#">Export</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">一月份报表</a></li>
					<li><a href="">二月份报表</a></li>
					<li><a href="">三月份报表</a></li>
					<li><a href="">四月份报表</a></li>
					<li><a href="">五月份报表</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- 右边部分 -->


				<h2 class="sub-header">Section title</h2>
				<div class="">
					<div id="linshiq" style="min-width: 400px; min-height: 800px;"></div>
				</div>

				<h1 class="page-header">Dashboard</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/vine" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/vine" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 日期插件 -->
	<script type="text/javascript"
		src="${ctx}/plug/bootstrap-datetimepicker-master/sample in bootstrap v2/jquery/jquery-1.8.3.min.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/plug/bootstrap-datetimepicker-master/sample in bootstrap v2/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/plug/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript" src="${ctx}/plug/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	;(function($){ //设置返回格式
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
	<!-- 报表数据 -->
	<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/Highcharts-4.2.6/js/highcharts.js"></script>
	<script type="text/javascript">
var chart = null;
$(function () {
    $('#linshiq').highcharts({
    	chart:{
    		type:'line' ,          //bar为柱型
    		events: {
                selection: function (event) {//拖动放大
                    var text,
                        label;
                    if (event.xAxis) {
                        text = 'min: ' + Highcharts.numberFormat(event.xAxis[0].min, 2) + ', max: ' + Highcharts.numberFormat(event.xAxis[0].max, 2);
                    } else {
                        text = 'Selection reset';
                    }
                    label = this.renderer.label(text, 100, 120)
                        .attr({
                        fill: Highcharts.getOptions().colors[0],
                        padding: 10,
                        r: 5,
                        zIndex: 8
                    })
                        .css({
                        color: '#FFFFFF'
                    })
                        .add();
                    setTimeout(function () {
                        label.fadeOut();
                    }, 1000);
                }
            },
            zoomType: 'x'
    	},   	
        legend: {
            layout: 'vertical',
            backgroundColor: '#FFFFFF',
            floating: true,
            align: 'left',
            verticalAlign: 'top',
            x: 90,
            y: 90,
            //labelFormat: '<span style="{color}">{name} (click to hide or show)</span>'
        },
        plotOptions: {
            series: {
                events: {
                    legendItemClick: function(e) {
                        var series = chart.series;
                        var count = 0;
                        for(var i=0;i<series.length;i++) {
                            if(series[i].visible) {
                                count ++;
                            }
                        }
                        // 计算图例点击事件执行后的数量
                        if(this.visible) {
                            count --;
                        } else {
                            count ++;   
                        }
                        alert(count);
                    }
                }
            }
        },
        title: {
            text: '2016年消费报表'                 //指定图表标题
        },
        tooltip: {                 
            valuePrefix: '￥', 			 //格式化提示前后
            valueSuffix: '元',
            shared: true				//开启不同报表比较 Ps:共享的提示框
        },
        yAxis:{
        	   title:{
        	       text:'金额'
        	   },
        	   ${sessionScope.y}
        	   ,
        	   plotLines:[{
        	        color:'red',           //线的颜色，定义为红色
        	        dashStyle:'solid',     //默认值，这里定义为实线
        	        value:0,               //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        	        width:2                //标示线的宽度，2px
        	    }]
        	},
        xAxis: {
        	 title:{
        	       text:'日期'
        	   },
            ${sessionScope.x} //categories:[1, 2, 3,4]
        },
        ${sessionScope.data2}			//series: [	
                                      	//  {  name: '无用线', data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4] }
										//, { name: '8月份金额曲线', data: [76,35,36.37,42.3,51.8,41.1,39.5,45.5,41.15,36.5,8,734.18,50,-758.5,143.5,98,41,49,97]}
										//]
    }, function(c) {
        chart = c;
    });
});
   </script>
</body>
</html>