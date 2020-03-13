package dao;

import org.sqlite.SQLiteException;
import pojo.Province;
import myUtil.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: dao
 * @ClassName: ProvinceDAOImpl
 * @Author: Date: 2020/3/11
 * project name: InfectStatisticWeb
 * @Version:
 * @Description:
 */
public class ProvinceDAOImpl {
    public void createTable(String tableName) {
        try{
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("drop table if exists "+ tableName);
            stmt.executeUpdate( "create table  if not exists " + tableName +"(name varchar(20) PRIMARY KEY,day date ,ipIncrease int " +
                    ",spIncrease int,cureIncrease int ,deadIncrease int,ip  int,sp int ,cure int ,dead int);" );
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void insert(Province province,String tableName){
        String sql = "insert into " + tableName +" values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            /*stmt.executeUpdate("drop table if exists province;");
            stmt.executeUpdate( "create table  if not exists province(name varchar(20),day date ,ip  int,sp int ,cure int ,dead int);" );//创建一个表，两列*/
            stmt.setString(1,province.getName());
            stmt.setString(2,province.getDay());
            stmt.setInt(3,province.getIpIncrease());
            stmt.setInt(4,province.getSpIncrease());
            stmt.setInt(5,province.getCureIncrease());
            stmt.setInt(6,province.getDeadIncrease());
            stmt.setInt(7,province.getIp());
            stmt.setInt(8,province.getSp());
            stmt.setInt(9,province.getCure());
            stmt.setInt(10,province.getDead());
            stmt.execute(); //插入数据
            conn.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void useJson(String json){
        Json.countryParse(json);
    }
    public void delete(Province province){

    }
    public void update(Province province){

    }

    public int getPeopleNum(String province){
        String sql = "select * from today where name="+province;
        int ip = 0;
        try (Connection conn = DBUtil.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
                ip = rs.getInt("ip");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ip;
    }

    public List<Province> list(String tableName){
        List<Province> provinces=new ArrayList<Province>();
        String sql = "select * from "+tableName;
        try (Connection c = DBUtil.getConnection(); Statement stmt = c.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Province province = new Province();
                province.setName(rs.getString("name"));
                province.setDay(rs.getString("day"));
                province.setIpIncrease(rs.getInt("ipIncrease"));
                province.setSpIncrease(rs.getInt("spIncrease"));
                province.setCureIncrease(rs.getInt("cureIncrease"));
                province.setDeadIncrease(rs.getInt("deadIncrease"));
                province.setIp(rs.getInt("ip"));
                province.setSp(rs.getInt("sp"));
                province.setCure(rs.getInt("cure"));
                province.setDead(rs.getInt("dead"));
                provinces.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinces;
    }
}