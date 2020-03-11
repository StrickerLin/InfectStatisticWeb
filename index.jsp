<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.mysql.jdbc.Driver" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/style.css">
	<title>某次疫情统计应用</title>
	<script src="dist/echarts.js"></script>
    <script src="map/js/china.js"></script>
</head>
<body>
	<div id="content">
		<h1>某次疫情可视化统计</h1>
		<div id="static">
			<div class="infectData">
				<b>确诊患者：</b>
				<br>
				<p>较昨日</p>
			</div>
			<div class="infectData"><b>疑似患者：</b><br>
				<p>较昨日</p>
			</div>
			<div class="infectData"><b>治愈：</b><br>
				<p>较昨日</p>
			</div>
			<div class="infectData"><b>死亡：</b><br>
				<p>较昨日</p>
			</div>
		</div>
		<div id="map-box">
			<div id="map"></div>
			<script type="text/javascript">
      			var dataList=[
      		    	{name:"南海诸岛",value:0},
    	        	{name: '北京', value: 181},
   		        	{name: '天津', value: 0},
            		{name: '上海', value: 65},
            		{name: '重庆', value: 221},
           		 	{name: '河北', value: 57},
            		{name: '河南', value: 262},
            		{name: '云南', value: 43},
            		{name: '辽宁', value: 37},
            		{name: '黑龙江', value: 227},
            		{name: '湖南', value: 245},
            		{name: '安徽', value: 270},
            		{name: '山东', value: 395},
            		{name: '新疆', value: 44},
            		{name: '江苏', value: 173},
            		{name: '浙江', value: 396},
            		{name: '江西', value: 251},
            		{name: '湖北', value: 432977},
            		{name: '广西', value: 102},
            		{name: '甘肃', value: 9},
            		{name: '山西', value: 37},
           			{name: '内蒙古', value: 41},
            		{name: '陕西', value: 65},
            		{name: '吉林', value: 29},
            		{name: '福建', value: 87},
            		{name: '贵州', value: 41},
            		{name: '广东', value: 515},
            		{name: '青海', value: 0},
            		{name: '西藏', value: 0},
            		{name: '四川', value: 239},
            		{name: '宁夏', value: 10},
            		{name: '海南', value: 39},
            		{name: '台湾', value: 25},
            		{name: '香港', value: 63},
            		{name: '澳门', value: 3}
        		]
    		    var myChart = echarts.init(document.getElementById('map'));
   		        option = {
            	tooltip: {
            	        formatter:function(params,ticket, callback){
           	             return params.seriesName+'<br />'+params.name+'：'+params.value
          	            }//数据格式化
                },
           		 visualMap: {
                	min: 0,
                	max: 50000,
                	left: 'left',
                	top: 'bottom',
                	text: ['高','低'],//取值范围的文字
                	inRange: {
                    color: ['#e0ffff', '#006edd']//取值范围的颜色
                	},
                	show:true//图注
            		},
            	geo: {
                	map: 'china',
                	roam: false,//不开启缩放和平移
                	zoom:1.23,//视角缩放比例
                	label: {
                    	normal: {
                       		show: true,
                        	fontSize:'10',
                        	color: 'rgba(0,0,0,0.7)'
                    	}
                	},
                	itemStyle: {
                    	normal:{
                        	borderColor: 'rgba(0, 0, 0, 0.2)'
                    	},
                    	emphasis:{
                        	areaColor: '#F3B329',//鼠标选择区域颜色
                        	shadowOffsetX: 0,
                        	shadowOffsetY: 0,
                        	shadowBlur: 20,
                        	borderWidth: 0,
                        	shadowColor: 'rgba(0, 0, 0, 0.5)'
                    	}
                	}
            	},
            	series : [
                {
                    name: '确诊患者',
                    type: 'map',
                    geoIndex: 0,
                    data:dataList
                }
                ]	
       		};
        	myChart.setOption(option);
        	myChart.on('click', function (params) {
            	window.location.href="detail.jsp?province="+params.name;
        	});
    	</script>
		</div>
		<div id="chart-box">
		</div>
		<script>
			var chart1=echarts.init(document.getById("chart-box"));
			var option1=[];
			
			chart1.setOption(option1);
		</script>
		<div id="addchart">
		</div>
		<script>
			var chart2=echarts.init(document.getById("addchart"));
			var option2=[];
			
			chart2.setOption(option2);
		</script>
		<div id="inline-box">
			<iframe src="https://baijiahao.baidu.com/s?id=1658566544718579058&wfr=spider&for=pc" name="inframe" id="inlineframe"></iframe>
		</div>
	</div>
</body>
</html>