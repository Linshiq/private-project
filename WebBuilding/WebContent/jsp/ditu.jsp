<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
	<title>东拼西凑的地图</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
        <style type="text/css">
        #weather {
            height: 180px;
            background-color: #fff;
            padding-left: 10px;
            padding-right: 10px;
            position: absolute;
            bottom: 20px;
            font-size: 12px;
            right: 10px;
            border-radius: 3px;
            line-height: 20px;
            border: 1px solid #ccc;
        }
        .weather{
            width: 60px;
            padding-left: 8px;
            display: inline-block;
        }
    </style>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=3ed548729b46b63e5907084daf961aef"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<!-- <input input type="hidden" value="北京市" id="cityname"/>-->
<div id='container'></div>
<div id="tip" style="line-height: 24px"></div>
<!--  <input type="button" class="button" value="显示当前城市" onClick="javascript:showCityInfo()"/>-->
<script type="text/javascript">
    var map, geolocation;
    //默认定位为北京市
  //  var cityinfo=document.getElementById('cityname');;
    //加载地图，调用浏览器定位服务
    map = new AMap.Map('container', {
        resizeEnable: true,
    });
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition:'RB'
        });
       map.addControl(geolocation);
       geolocation.getCurrentPosition();
       AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
       AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
  /*     AMap.service('AMap.Weather', function() {
        	//实例化天气查询类
            var weather = new AMap.Weather();
            //查询实时天气信息, 查询的城市到行政级别的城市，如朝阳区、杭州市
            weather.getLive('深圳市', function(err, data) {
                if (!err) {
                	var str = [];
                    str.push('<div style="color: #3366FF;">没错,你在这.顺便给你预报一下天气!' + '</div>');
                    str.push('<div>城市/区：' + data.city + '</div>');
                    str.push('<div>天气：' + data.weather + '</div>');
                    str.push('<div>温度：' + data.temperature + '℃</div>');
                    str.push('<div>风向：' + data.windDirection + '</div>');
                    str.push('<div>风力：' + data.windPower + ' 级</div>');
                    str.push('<div>空气湿度：' + data.humidity + '</div>');
                    str.push('<div>发布时间：' + data.reportTime + '</div>');
                    var marker = new AMap.Marker({map: map, position: map.getCenter()});
                    var infoWin = new AMap.InfoWindow({
                        content: str.join(''),
                        offset: new AMap.Pixel(0, -20)
                    });
                    infoWin.open(map, marker.getPosition());
                    marker.on('mouseover', function() {
                        infoWin.open(map, marker.getPosition());
                    });
                }
            });
            //未来4天天气预报
            weather.getForecast(cityinfo, function(err, data) {
                if (err) {return;}
                var str = [];
                for (var i = 0,dayWeather; i < data.forecasts.length; i++) {
                    dayWeather = data.forecasts[i];
                    str.push(dayWeather.date+' <div class="weather">'+dayWeather.dayWeather+'</div> '+ dayWeather.nightTemp + '~' + dayWeather.dayTemp + '℃');
                }
                document.getElementById('tip').innerHTML = str.join('<br>');
            });
        });*/
    });
    //解析定位结果
    function onComplete(data) {
    	//实例化城市查询类
      /*  var citysearch = new AMap.CitySearch();
        //自动获取用户IP，返回当前城市
        citysearch.getLocalCity(function(status, result) {
            if (status === 'complete' && result.info === 'OK') {
                if (result && result.city && result.bounds) {
                	cityinfo = result.city;
                    var citybounds = result.bounds;
                    document.getElementById('tip').innerHTML = '您当前所在城市：'+cityinfo;
                    //地图显示当前城市
                    map.setBounds(citybounds);
                }
            } else {
                document.getElementById('tip').innerHTML = result.info;
            }
        });*/
        var str=['定位成功'];
        str.push('经度：' + data.position.getLng());
        str.push('纬度：' + data.position.getLat());
        str.push('精度：' + data.accuracy + ' 米');
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
        document.getElementById('tip').innerHTML = str.join('<br>'); 
    }
    //解析定位错误信息
    function onError(data) {
        document.getElementById('tip').innerHTML = '定位失败';
    }
</script>
</body>
</html>