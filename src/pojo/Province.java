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
    private int ipIncrease;
    private int spIncrease;
    private int cureIncrease;
    private int deadIncrease;

    public Province(){
        this.name = "";
        this.day = "";
        this.ip = 0;
        this.sp = 0;
        this.cure = 0;
        this.dead = 0;
        this.ipIncrease = 0;
        this.spIncrease = 0;
        this.cureIncrease = 0;
        this.deadIncrease = 0;
    }
    public Province(String name,String day,int ip,int sp,int cure,int dead,int ipIncrease
            ,int spIncrease,int cureIncrease,int deadIncrease){
        this.name = name;
        this.day = day;
        this.ip = ip;
        this.sp = sp;
        this.cure = cure;
        this.dead = dead;
        this.ipIncrease = ipIncrease;
        this.spIncrease = spIncrease;
        this.cureIncrease = cureIncrease;
        this.deadIncrease = deadIncrease;
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

    public int getIpIncrease() {
        return ipIncrease;
    }

    public int getSpIncrease() {
        return spIncrease;
    }

    public int getCureIncrease() {
        return cureIncrease;
    }

    public int getDeadIncrease() {
        return deadIncrease;
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

    public void setIpIncrease(int ipIncrease) {
        this.ipIncrease = ipIncrease;
    }

    public void setSpIncrease(int spIncrease) {
        this.spIncrease = spIncrease;
    }

    public void setCureIncrease(int cureIncrease) {
        this.cureIncrease = cureIncrease;
    }

    public void setDeadIncrease(int deadIncrease) {
        this.deadIncrease = deadIncrease;
    }

    public void printString(){
        System.out.println("日期:"+day+' '+name + " 新增确诊:" + ipIncrease + " 新增疑似:"
                + spIncrease + " 新增治愈：" + cureIncrease + " 新增死亡:"
                + deadIncrease + " 现有确诊:"+ip+" 现有疑似:"+sp+" 累计治愈:"+cure+" 累计死亡:"+dead+"\n");
    }
}