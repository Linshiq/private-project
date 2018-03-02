<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>插入</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ctx}/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${ctx}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- 时间控件 -->
	<link rel="stylesheet" media="screen"
		href="${ctx}/plug/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" />
    
  </head>

  <body>

   <!-- 组装网页左右两边 -->
	<jsp:include page="body/report_top_right.jsp" flush="true">
	<jsp:param value="insert_day" name="insert_day"/>
	</jsp:include>

    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
				<h1 class="sub-header">日期</h1>
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">消费日期</label>
						<div class="col-sm-10">

							<div class="input-group date form_date " data-date=""
								data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
								data-link-format="yyyy-mm-dd">
								<input name="oneday" class="form-control" size="16" type="text"
									value="${leftTitle}" readonly> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-calendar"></span></span>

							</div>
							<input type="hidden" id="dtp_input2" value="" /><br />	
						</div>
					</div>
					
				<h2 class="sub-header">细节</h2>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">时间</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="consumptionTime">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">消费类型</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="consumptionType">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">支出</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="consumption">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">收入</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="income">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label" >合计</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="sum" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">备注</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="remark"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
          <div class="table-responsive">
            
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${ctx}/js/ie10-viewport-bug-workaround.js"></script>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="${ctx}/static/js/ie10-viewport-bug-workaround.js"></script>
<!-- 日期插件 -->
	<script type="text/javascript"
		src="${ctx}/plug/bootstrap-datetimepicker-master/sample in bootstrap v3/jquery/jquery-1.8.3.min.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/plug/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/plug/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.fr.js"
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
