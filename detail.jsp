<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.Date,javax.servlet.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.sql.*" %>

<%
	String province;
	String nowDate;
	Date dNow = new Date( );
	SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	nowDate=ft.format(dNow);
	province=request.getParameter("province");
%>
<%
	try{
		Class.forName("org.sqlite.JDBC");
	}catch (Exception e){
		e.printStackTrace();
	}
	Class.forName("com.mysql.jdbc.Driver");  ////驱动程序名
	String url = "jdbc:sqlite://d:/软件工程作业/production/production/InfectStatisticWeb/InfectData.db"; //数据库名
	String username = "";  //数据库用户名
	String password = "";  //数据库用户密码
	Connection con = DriverManager.getConnection(url, username, password);  //连接状态
%>
<%!
	public int[][] getProvinceArray(Connection conn,String tableName){
		String sql = "select * from "+tableName;
		int[][] sevenDatas = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
			,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				if(rs.getString("day").equals("2020-3-7")){
					sevenDatas[0][0] = rs.getInt("ip");
					sevenDatas[0][1] = rs.getInt("sp");
					sevenDatas[0][2] = rs.getInt("cure");
					sevenDatas[0][3] = rs.getInt("dead");
					sevenDatas[0][4] = rs.getInt("ipIncrease");
					sevenDatas[0][5] = rs.getInt("spIncrease");
					sevenDatas[0][6] = rs.getInt("cureIncrease");
					sevenDatas[0][7] = rs.getInt("deadIncrease");
				}
				if(rs.getString("day").equals("2020-3-8")){
					sevenDatas[1][0] = rs.getInt("ip");
					sevenDatas[1][1] = rs.getInt("sp");
					sevenDatas[1][2] = rs.getInt("cure");
					sevenDatas[1][3] = rs.getInt("dead");
					sevenDatas[1][4] = rs.getInt("ipIncrease");
					sevenDatas[1][5] = rs.getInt("spIncrease");
					sevenDatas[1][6] = rs.getInt("cureIncrease");
					sevenDatas[1][7] = rs.getInt("deadIncrease");
				}
				if(rs.getString("day").equals("2020-3-9")){
					sevenDatas[2][0] = rs.getInt("ip");
					sevenDatas[2][1] = rs.getInt("sp");
					sevenDatas[2][2] = rs.getInt("cure");
					sevenDatas[2][3] = rs.getInt("dead");
					sevenDatas[2][4] = rs.getInt("ipIncrease");
					sevenDatas[2][5] = rs.getInt("spIncrease");
					sevenDatas[2][6] = rs.getInt("cureIncrease");
					sevenDatas[2][7] = rs.getInt("deadIncrease");
				}
				if(rs.getString("day").equals("2020-3-10")){
					sevenDatas[3][0] = rs.getInt("ip");
					sevenDatas[3][1] = rs.getInt("sp");
					sevenDatas[3][2] = rs.getInt("cure");
					sevenDatas[3][3] = rs.getInt("dead");
					sevenDatas[3][4] = rs.getInt("ipIncrease");
					sevenDatas[3][5] = rs.getInt("spIncrease");
					sevenDatas[3][6] = rs.getInt("cureIncrease");
					sevenDatas[3][7] = rs.getInt("deadIncrease");
				}
				if(rs.getString("day").equals("2020-3-11")){
					sevenDatas[4][0] = rs.getInt("ip");
					sevenDatas[4][1] = rs.getInt("sp");
					sevenDatas[4][2] = rs.getInt("cure");
					sevenDatas[4][3] = rs.getInt("dead");
					sevenDatas[4][4] = rs.getInt("ipIncrease");
					sevenDatas[4][5] = rs.getInt("spIncrease");
					sevenDatas[4][6] = rs.getInt("cureIncrease");
					sevenDatas[4][7] = rs.getInt("deadIncrease");
				}
				if(rs.getString("day").equals("2020-3-12")){
					sevenDatas[5][0] = rs.getInt("ip");
					sevenDatas[5][1] = rs.getInt("sp");
					sevenDatas[5][2] = rs.getInt("cure");
					sevenDatas[5][3] = rs.getInt("dead");
					sevenDatas[5][4] = rs.getInt("ipIncrease");
					sevenDatas[5][5] = rs.getInt("spIncrease");
					sevenDatas[5][6] = rs.getInt("cureIncrease");
					sevenDatas[5][7] = rs.getInt("deadIncrease");
				}
				if(rs.getString("day").equals("2020-3-13")){
					sevenDatas[6][0] = rs.getInt("ip");
					sevenDatas[6][1] = rs.getInt("sp");
					sevenDatas[6][2] = rs.getInt("cure");
					sevenDatas[6][3] = rs.getInt("dead");
					sevenDatas[6][4] = rs.getInt("ipIncrease");
					sevenDatas[6][5] = rs.getInt("spIncrease");
					sevenDatas[6][6] = rs.getInt("cureIncrease");
					sevenDatas[6][7] = rs.getInt("deadIncrease");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return sevenDatas;
	}
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
<%
int[][] sevenDatas = getProvinceArray(con,province);
%>
	<div id="content">
		<h1><%=province %>疫情详情</h1>
		<p>注：除黑龙江省以外，其他省份只有（3.10和3.11两天的数据）</p>
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
					        data: ['3-07', '3-08', '3-09', '3-10', '3-11', '3-12', '3-13']
					    },
					    yAxis: {
					        type: 'value'
					    },
					    series: [
					        {
					            name: '确诊患者',
					            type: 'line',
					            stack: '总量',
					            data: [<%=sevenDatas[0][0]%>, <%=sevenDatas[1][0]%>,<%=sevenDatas[2][0]%>,<%=sevenDatas[3][0]%>
									,<%=sevenDatas[4][0]%>,<%=sevenDatas[5][0]%>, <%=sevenDatas[6][0]%>]
					        },
					        {
					            name: '疑似患者',
					            type: 'line',
					            stack: '总量',
					            data: [<%=sevenDatas[0][1]%>, <%=sevenDatas[1][1]%>,<%=sevenDatas[2][1]%>,<%=sevenDatas[3][1]%>
									,<%=sevenDatas[4][1]%>,<%=sevenDatas[5][1]%>, <%=sevenDatas[6][1]%>]
					        },
					        {
					            name: '治愈',
					            type: 'line',
					            stack: '总量',
					            data: [<%=sevenDatas[0][2]%>, <%=sevenDatas[1][2]%>,<%=sevenDatas[2][2]%>,<%=sevenDatas[3][2]%>
									,<%=sevenDatas[4][2]%>,<%=sevenDatas[5][2]%>, <%=sevenDatas[6][2]%>]
					        },
					        {
					            name: '死亡',
					            type: 'line',
					            stack: '总量',
					            data: [<%=sevenDatas[0][3]%>, <%=sevenDatas[1][3]%>,<%=sevenDatas[2][3]%>,<%=sevenDatas[3][3]%>
									,<%=sevenDatas[4][3]%>,<%=sevenDatas[5][3]%>, <%=sevenDatas[6][3]%>]
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
				            data: [<%=sevenDatas[0][4]%>, <%=sevenDatas[1][4]%>,<%=sevenDatas[2][4]%>,<%=sevenDatas[3][4]%>
								,<%=sevenDatas[4][4]%>,<%=sevenDatas[5][4]%>, <%=sevenDatas[6][4]%>]
				        },
				        {
				            name: '新增疑似患者',
				            type: 'line',
				            stack: '总量',
				            data: [<%=sevenDatas[0][5]%>, <%=sevenDatas[1][5]%>,<%=sevenDatas[2][5]%>,<%=sevenDatas[3][5]%>
								,<%=sevenDatas[4][5]%>,<%=sevenDatas[5][5]%>, <%=sevenDatas[6][5]%>]
				        },
				        {
				            name: '新增治愈',
				            type: 'line',
				            stack: '总量',
				            data: [<%=sevenDatas[0][6]%>, <%=sevenDatas[1][6]%>,<%=sevenDatas[2][6]%>,<%=sevenDatas[3][6]%>
								,<%=sevenDatas[4][6]%>,<%=sevenDatas[5][6]%>, <%=sevenDatas[6][6]%>]
				        },
				        {
				            name: '新增死亡',
				            type: 'line',
				            stack: '总量',
				            data: [<%=sevenDatas[0][7]%>, <%=sevenDatas[1][7]%>,<%=sevenDatas[2][7]%>,<%=sevenDatas[3][7]%>
								,<%=sevenDatas[4][7]%>,<%=sevenDatas[5][7]%>, <%=sevenDatas[6][7]%>]
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