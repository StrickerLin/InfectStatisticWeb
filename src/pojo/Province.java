package pojo;

/**
 * @PackgeName: edu.fzu.pojo
 * @ClassName: pojo.Province
 * @Author: Date: 2020/3/11
 * project name: InfectStatisticWeb
 * @Version:
 * @Description:
 */
public class Province {
    private String name;
    private  String day;
    private int ip;
    private int sp;
    private int cure;
    private int dead;

    public Province(){

    }
    public Province(String name,String day,int ip,int sp,int cure,int dead){
        this.name = name;
        this.day = day;
        this.ip = ip;
        this.sp = sp;
        this.cure = cure;
        this.dead = dead;
    }

    public String getDay() {
        return day;
    }

    public String getName(){
        return name;
    }

    public int getIp(){
        return ip;
    }

    public int getSp(){
        return sp;
    }

    public int getCure(){
        return cure;
    }

    public int getDead(){
        return dead;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public void setCure(int cure) {
        this.cure = cure;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }
}