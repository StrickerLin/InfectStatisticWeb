package myUtil;

/**
 * @PackgeName: util
 * @ClassName: regUtil
 * @Author: ll
 * Date: 2020/3/12
 * project name: InfectStatisticWeb
 * @Version:
 * @Description:
 */
public class regUtil {
    private String ipIncrease = "新增确诊病例(\\d+)例";
    private String spIncrease = "新增疑似病例(\\d+)例";
    private String cureIncrease = "新增治愈出院病例(\\d+)例";
    private String deadIncrease = "新增死亡病例(\\d+)例";
    private String ip = "现有确诊病例(\\d+)例";
    private String sp = "现有疑似病例(\\d+)例";
    private String cure = "累计治愈出院病例(\\d+)例";
    private String dead = "累计死亡病例(\\d+)例";
    private String  day = "截至(\\d+)月(\\d+)日";
    private String countryName = "(.)*新型冠状病毒肺炎疫情最新情况";
    private String provinceName = "(.)*省";
    /*public void setIp(String ip) {
        this.ip = ip;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public void setIpIncrease(String ipIncrease) {
        this.ipIncrease = ipIncrease;
    }

    public void setSpIncrease(String spIncrease) {
        this.spIncrease = spIncrease;
    }

    public void setCureIncrease(String cureIncrease) {
        this.cureIncrease = cureIncrease;
    }

    public void setDeadIncrease(String deadIncrease) {
        this.deadIncrease = deadIncrease;
    }*/

    public String getIp() {
        return ip;
    }

    public String getSp() {
        return sp;
    }

    public String getCure() {
        return cure;
    }

    public String getDead() {
        return dead;
    }

    public String getIpIncrease() {
        return ipIncrease;
    }

    public String getSpIncrease() {
        return spIncrease;
    }


    public String getDeadIncrease() {
        return deadIncrease;
    }

    public String getCureIncrease() {
        return cureIncrease;
    }

    public String getDay() {
        return day;
    }
}