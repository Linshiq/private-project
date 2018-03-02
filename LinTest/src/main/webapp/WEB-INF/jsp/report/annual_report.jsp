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

<!-- 组装网页左右两边 -->
<jsp:include page="body/report_top_right.jsp" flush="true">
<jsp:param value="annual_report" name="annual_report"/>
</jsp:include>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- 右边部分 -->


				<h2 class="sub-header">报表</h2>
				<div class="">
					<div id="container" style="min-width:400px;min-height:800px;"></div>
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

<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/css/Highcharts-4.2.6/js/highcharts.js"></script>
<script>
var chart = null;
$(function () {
    $('#container').highcharts({
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
        tooltip: {                 
            valuePrefix: '￥', 			 //格式化提示前后
            valueSuffix: '元',
            shared: true				//开启不同报表比较 Ps:共享的提示框
        },
        ${title},
        yAxis:{
        	   ${y}
        	   ,
        	   plotLines:[{
        	        color:'red',           //线的颜色，定义为红色
        	        dashStyle:'solid',     //默认值，这里定义为实线
        	        value:0,               //定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        	        width:2                //标示线的宽度，2px
        	    }]
        	},
        xAxis: {
            ${x} //categories:[1, 2, 3,4]
        },
        ${data2}			//series: [	
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