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
<%!
	public int getIpNum(String province,Connection conn){
		String sql = "select * from latest where name=?";
		int ip = 0;
		try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1,province);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				ip = rs.getInt("ip");
		}catch (Exception e){
			e.printStackTrace();
		}
		return ip;
	}
%>
<%!
	public String getUpdateTime(Connection conn){
		String day = null ;
		String sql = "select * from latest";
		try ( Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				day = rs.getString("day");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return day;
	}
%>
<%!
	public int[] getAllTyeNum(Connection conn,String tableName){
		String sql = "select * from "+tableName;
		int[] num = {0,0,0,0,0,0,0,0};
		try ( Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				num[0] = rs.getInt("ip");
				num[1] = rs.getInt("ipIncrease");
				num[2] = rs.getInt("sp");
				num[3] = rs.getInt("spIncrease");
				num[4] = rs.getInt("cure");
				num[5] = rs.getInt("cureIncrease");
				num[6] = rs.getInt("dead");
				num[7] = rs.getInt("deadIncrease");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return num;
	}
%>
<%!
	public int[] getSomdedayArray(Connection conn,String day){
		String sql = "select * from country where day=?";
		int[] num = {0,0,0,0,0,0,0,0};
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1,day);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				num[0] = rs.getInt("ip");
				num[1] = rs.getInt("ipIncrease");
				num[2] = rs.getInt("sp");
				num[3] = rs.getInt("spIncrease");
				num[4] = rs.getInt("cure");
				num[5] = rs.getInt("cureIncrease");
				num[6] = rs.getInt("dead");
				num[7] = rs.getInt("deadIncrease");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return num;
	}
%>
<%
	try{
		Class.forName("org.sqlite.JDBC");
	}catch (Exception e){
		e.printStackTrace();
	}
	Class.forName("com.mysql.jdbc.Driver");  ////驱动程序名
	//String url = "jdbc:sqlite://d:/软件工程作业/production/production/InfectStatisticWeb/InfectData.db"; //数据库名
    String url = "./src/InfectData.db"; //数据库名
	String username = "";  //数据库用户名
	String password = "";  //数据库用户密码
	Connection con = DriverManager.getConnection(url, username, password);  //连接状态
	int[] num = getAllTyeNum(con,"country");
	int[] march7 = getSomdedayArray(con,"2020-3-7");
	int[] march8 = getSomdedayArray(con,"2020-3-8");
	int[] march9 = getSomdedayArray(con,"2020-3-9");
	int[] march10 = getSomdedayArray(con,"2020-3-10");
	int[] march11 = getSomdedayArray(con,"2020-3-11");
	int[] march12 = getSomdedayArray(con,"2020-3-12");
	int[] march13 = getSomdedayArray(con,"2020-3-13");
%>
	<div id="content">
		<h1>某次疫情可视化统计(更新时间<%=getUpdateTime(con)%>)</h1>
		<div id="static">
			<div class="infectData"><b>确诊患者：<%=num[0]%></b>
				<br>
				<p>较昨日+<%=num[1]%></p>
			</div>
			<div class="infectData"><b>疑似患者: <%=num[2]%></b>
				<br>
				<p>较昨日+<%=num[3]%></p>
			</div>
			<div class="infectData"><b>治愈：<%=num[4]%></b>
				<br>
				<p>较昨日+<%=num[5]%></p>
			</div>
			<div class="infectData"><b>死亡：<%=num[6]%></b>
				<br>
				<p>较昨日+<%=num[7]%></p>
			</div>
		</div>
		<div id="map-box">
			<div id="map"></div>
			<script type="text/javascript">
      			var dataList=[
      		    	{name:"南海诸岛",value:0},
    	        	{name: '北京', value:<%=getIpNum("北京",con)%>},
   		        	{name: '天津', value: <%=getIpNum("天津",con)%>},
            		{name: '上海', value: <%=getIpNum("上海",con)%>},
            		{name: '重庆', value: <%=getIpNum("重庆",con)%>},
           		 	{name: '河北', value: <%=getIpNum("河北",con)%>},
            		{name: '河南', value: <%=getIpNum("河南",con)%>},
            		{name: '云南', value: <%=getIpNum("云南",con)%>},
            		{name: '辽宁', value: <%=getIpNum("辽宁",con)%>},
            		{name: '黑龙江', value: <%=getIpNum("黑龙江",con)%>},
            		{name: '湖南', value: <%=getIpNum("湖南",con)%>},
            		{name: '安徽', value: <%=getIpNum("安徽",con)%>},
            		{name: '山东', value: <%=getIpNum("山东",con)%>},
            		{name: '新疆', value: <%=getIpNum("新疆",con)%>},
            		{name: '江苏', value: <%=getIpNum("江苏",con)%>},
            		{name: '浙江', value: <%=getIpNum("浙江",con)%>},
            		{name: '江西', value: <%=getIpNum("江西",con)%>},
            		{name: '湖北', value: <%=getIpNum("湖北",con)%>},
            		{name: '广西', value: <%=getIpNum("广西",con)%>},
            		{name: '甘肃', value: <%=getIpNum("甘肃",con)%>},
            		{name: '山西', value: <%=getIpNum("山西",con)%>},
           			{name: '内蒙古', value: <%=getIpNum("内蒙古",con)%>},
            		{name: '陕西', value: <%=getIpNum("陕西",con)%>},
            		{name: '吉林', value: <%=getIpNum("吉林",con)%>},
            		{name: '福建', value: <%=getIpNum("福建",con)%>},
            		{name: '贵州', value: <%=getIpNum("贵州",con)%>},
            		{name: '广东', value: <%=getIpNum("广东",con)%>},
            		{name: '青海', value: <%=getIpNum("青海",con)%>},
            		{name: '西藏', value: <%=getIpNum("西藏",con)%>},
            		{name: '四川', value: <%=getIpNum("四川",con)%>},
            		{name: '宁夏', value: <%=getIpNum("宁夏",con)%>},
            		{name: '海南', value: <%=getIpNum("海南",con)%>},
            		{name: '台湾', value: <%=getIpNum("台湾",con)%>},
            		{name: '香港', value: <%=getIpNum("香港",con)%>},
            		{name: '澳门', value: <%=getIpNum("澳门",con)%>}
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
		<br>
		<br>
		<div id="chart-box">
		</div>
		<script>
			var chart1=echarts.init(document.getElementById("chart-box"));
			var option1 = {
				    title: {
				        text: '全国各类感染人数'
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
				        data: ['3-07', '3-08', '3-09', '3-10', '3-11', '3-12', '3-13']
				    },
				    yAxis: {
				        type: 'value',
				    },
				    series: [
				        {
				            name: '确诊患者',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[0]%>,<%=march8[0]%>,<%=march9[0]%>,<%=march10[0]%>,<%=march11[0]%>,<%=march12[0]%>,<%=march13[0]%>]
				        },
				        {
				            name: '疑似患者',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[2]%>,<%=march8[2]%>,<%=march9[2]%>,<%=march10[2]%>,<%=march11[2]%>,<%=march12[2]%>,<%=march13[2]%>]
				        },
				        {
				            name: '治愈',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[4]%>,<%=march8[4]%>,<%=march9[4]%>,<%=march10[4]%>,<%=march11[4]%>,<%=march12[4]%>,<%=march13[4]%>]
				        },
				        {
				            name: '死亡',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[6]%>,<%=march8[6]%>,<%=march9[6]%>,<%=march10[6]%>,<%=march11[6]%>,<%=march12[6]%>,<%=march13[6]%>]
				        }
				    ]
				};
			
			chart1.setOption(option1);
		</script>
		<br>
		<br>
		<div id="addchart">
		</div>
		<script>
			var chart2=echarts.init(document.getElementById("addchart"));
			var option2 = {
				    title: {
				        text: '全国各类感染新增人数'
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
				        data: ['3-07', '3-08', '3-09', '3-10', '3-11', '3-12', '3-13']
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [
				        {
				            name: '新增确诊患者',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[1]%>,<%=march8[1]%>,<%=march9[1]%>,<%=march10[1]%>,<%=march11[1]%>,<%=march12[1]%>,<%=march13[1]%>]
				        },
				        {
				            name: '新增疑似患者',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[3]%>,<%=march8[3]%>,<%=march9[3]%>,<%=march10[3]%>,<%=march11[3]%>,<%=march12[3]%>,<%=march13[3]%>]
				        },
				        {
				            name: '新增治愈',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[5]%>,<%=march8[5]%>,<%=march9[5]%>,<%=march10[5]%>,<%=march11[5]%>,<%=march12[5]%>,<%=march13[5]%>]
				        },
				        {
				            name: '新增死亡',
				            type: 'line',
				            stack: '总量',
				            data: [<%=march7[7]%>,<%=march8[7]%>,<%=march9[7]%>,<%=march10[7]%>,<%=march11[7]%>,<%=march12[7]%>,<%=march13[7]%>]
				        }
				    ]
				};
			
			chart2.setOption(option2);
		</script>
		<br>
		<br>
		<div id="inline-box">
			<iframe src="https://baijiahao.baidu.com/s?id=1658566544718579058&wfr=spider&for=pc" name="inframe" id="inlineframe"></iframe>
		</div>
		<br>
		<br>
		<div id="button-box" style="text-align:center">
				<button onclick="ask()">医生问询通道</button>
		</div>
		<script type="text/javascript">
			function ask(){
				window.location.href="https://www.120ask.com/";
			}
		</script>
	</div>
</body>
</html>