<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>消费比重</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>

<!-- 组装网页左右两边 -->
<jsp:include page="body/report_top_right.jsp" flush="true">
<jsp:param value="annualConsumptionReport" name="annualConsumptionReport"/>
</jsp:include>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- 右边部分 -->


				<h2 class="sub-header">报表</h2>
				<div class="">
					<div id="container" style="min-width:400px;min-height:800px;"></div>
				</div> 

				<h2 class="sub-header">总共: ${sum}</h2>

</div>
<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/css/Highcharts-4.2.6/js/highcharts.js"></script>
<script type="text/javascript" src="${ctx}/static/css/Highcharts-4.2.6/js/highcharts-3d.js"></script>
<script>
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
       
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        ${title},
        ${data2}
    });
});
</script>
</body>
</html>