import java.sql.*;
import java.util.*;
import java.text.*;

public class DbOperator{
	private String dbName;
	private String userName;
	private String password;
	private Connection conn;

	public DbOperator() {
		dbName="infect";
		userName="root";
		password="123456";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo?useSSL=false&serverTimezone=UTC",userName,password);
		}catch (ClassNotFoundException e1) {
			System.out.print(e1);
			System.exit(1);
		}catch(SQLException e2){
			System.out.print(e2);
			System.exit(2);
		}
	}

	public ResultSet getStaticByProvince(String pid,String infectType,java.util.Date d){
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		String dStr=ft.format(d);
		Statement stm;
		String sqlstr="select "+infectType+"from infect where pid="+pid+" and datadate='"+dStr+"'";
		try{
			stm=conn.createStatement();
			return stm.executeQuery(sqlstr);
		}catch(SQLException e2){
			System.out.print("sqlException:"+e2.toString());
			return null;
		}
	}

	public void writeSql(String pid,String pname,int infect,int dinfect,int cure,int dead,java.util.Date d){
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		String dStr=ft.format(d);
		Statement stm;
		String sqlstr="insert into "+daName+" value("+pid+",'"+pname+"',"+infect+","+dinfect+","+cure+','+dead+",'"+dStr+");";
		try {
			stm=conn.createStatement();
			stm.executeQuery(sqlstr);
		}catch(SQLException e) {
			System.out.print(e);
			System.exit(2);
		}
	}
}
