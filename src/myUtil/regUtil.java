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
    private String ipIncrease = "����ȷ�ﲡ��(\\d+)��";
    private String spIncrease = "�������Ʋ���(\\d+)��";
    private String cureIncrease = "����������Ժ����(\\d+)��";
    private String deadIncrease = "������������(\\d+)��";
    private String ip = "����ȷ�ﲡ��(\\d+)��";
    private String sp = "�������Ʋ���(\\d+)��";
    private String cure = "�ۼ�������Ժ����(\\d+)��";
    private String dead = "�ۼ���������(\\d+)��";
    private String  day = "����(\\d+)��(\\d+)��";
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