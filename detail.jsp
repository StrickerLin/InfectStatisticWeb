<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,javax.servlet.*" %>   	
<%@ page import="java.text.*" %>
    
<%
	String province;
	String nowDate;
	Date dNow = new Date( );
	SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	nowDate=ft.format(dNow);
	province=request.getParameter("province");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=province %>省疫情详情</title>
<script src="dist/echarts.js"></script>
<script src="map/js/china.js"></script>
<script>
			function returnBack(){
				window.location.replace("index.jsp");
			}
		</script>
<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<body>
	<div id="content">
		<h1><%=province %>省的疫情详情</h1>
		<div id="chart">
			<div id="chart-box"></div>
			<script type="text/javascript">
				var chart1=echarts.init(document.getElementById("chart-box"));
				var option1 = {
					    title: {
					        text: '<%=province%>'+'省各类患者人数'
					    },
					    tooltip: {
					        trigger: 'axis'
					    },
					    legend: {
					        data: ['确诊患者', '疑似患者', '治愈', '死亡']
					    },
					    grid: {
					        left: '3%',
					        right: '4%',
					        bottom: '3%',
					        containLabel: true
					    },
					    toolbox: {
					        feature: {
					            saveAsImage: {}
					        }
					    },
					    xAxis: {
					        type: 'category',
					        boundaryGap: false,
					        data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
					    },
					    yAxis: {
					        type: 'value'
					    },
					    series: [
					        {
					            name: '确诊患者',
					            type: 'line',
					            stack: '总量',
					            data: [120, 132, 101, 134, 90, 230, 210]
					        },
					        {
					            name: '疑似患者',
					            type: 'line',
					            stack: '总量',
					            data: [220, 182, 191, 234, 290, 330, 310]
					        },
					        {
					            name: '治愈',
					            type: 'line',
					            stack: '总量',
					            data: [150, 232, 201, 154, 190, 330, 410]
					        },
					        {
					            name: '死亡',
					            type: 'line',
					            stack: '总量',
					            data: [320, 332, 301, 334, 390, 330, 320]
					        }
					    ]
					};
				chart1.setOption(option1);
			</script>
		</div>
		<br>
		<br>
		<div id="addchart">
			<div id="addchart-box"></div>
		</div>
		<script>
			var chart2=echarts.init(document.getElementById("addchart-box"));
			var option2 = {
				    title: {
				        text: '<%=province%>'+'省各类型患者新增趋势'
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    legend: {
				        data: ['新增确诊患者', '新增疑似患者', '新增治愈', '新增死亡']
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    toolbox: {
				        feature: {
				            saveAsImage: {}
				        }
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [
				        {
				            name: '新增确诊患者',
				            type: 'line',
				            stack: '总量',
				            data: [120, 132, 101, 134, 90, 230, 210]
				        },
				        {
				            name: '新增疑似患者',
				            type: 'line',
				            stack: '总量',
				            data: [220, 182, 191, 234, 290, 330, 310]
				        },
				        {
				            name: '新增治愈',
				            type: 'line',
				            stack: '总量',
				            data: [150, 232, 201, 154, 190, 330, 410]
				        },
				        {
				            name: '新增死亡',
				            type: 'line',
				            stack: '总量',
				            data: [320, 332, 301, 334, 390, 330, 320]
				        }
				    ]
				};
			chart2.setOption(option2);
		</script>
		<div id="returnButton">
			<button onclick="returnBack()">返回</button>
		</div>
	</div>
	<br>
	<br>
</body>
</html>