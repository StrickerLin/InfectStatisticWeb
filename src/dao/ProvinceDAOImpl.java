package dao;

import pojo.Province;
import util.*;

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
    public ProvinceDAOImpl() throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("drop table if exists province;");
        stmt.executeUpdate( "create table  if not exists province(name varchar(20),day date ,ip  int,sp int ,cure int ,dead int);" );//创建一个表，两列
    }
    public void insert(Province province){
        String sql = "insert into province values(?,?,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            /*stmt.executeUpdate("drop table if exists province;");
            stmt.executeUpdate( "create table  if not exists province(name varchar(20),day date ,ip  int,sp int ,cure int ,dead int);" );//创建一个表，两列*/
            stmt.setString(1,province.getName());
            stmt.setString(2,province.getDay());
            stmt.setInt(3,province.getIp());
            stmt.setInt(4,province.getSp());
            stmt.setInt(5,province.getCure());
            stmt.setInt(6,province.getDead());
            stmt.execute(); //插入数据
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

    public List<Province> list(){
        List<Province> provinces=new ArrayList<Province>();
        String sql = "select * from province";
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Province province = new Province();
                province.setName(rs.getString("name"));
                province.setDay(rs.getString("day"));
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