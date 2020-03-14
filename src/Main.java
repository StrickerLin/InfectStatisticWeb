import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Province;
import dao.*;
import myUtil.*;
import sun.security.provider.ConfigFile;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void catchCountryData(String tableName,String website){
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        provinceDAO.createTable(tableName);
        provinceDAO.insert(Spider.getGovCountryData(website),tableName);
    }

     /*
    1河北省 2山西省 3辽宁省 4吉林省 5黑龙江省 6江苏省 7浙江省 8安徽省 9福建省 10江西省 11山东省 12河南省 13湖北省 14湖南省 15广东省 16海南省 17四川省 18贵州省
    19云南省 20陕西省 21甘肃省 22青海省 23台湾省
自治区：内蒙古自治区 广西壮族自治区 西藏自治区 宁夏回族自治区 新疆维吾尔自治区
直辖市：北京市 天津市 上海市 重庆市
特别行政区：香港特别行政区 澳门特别行政区
     */
    public static void catchProvinceData(String tableName,List<String> website){
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        provinceDAO.insert(Spider.getHebeiData(website.get(0)),tableName);
        provinceDAO.insert(Spider.getShanxiData(website.get(1)),tableName);
        provinceDAO.insert(Spider.getLiaoNingData(website.get(2)),tableName);
        provinceDAO.insert(Spider.getJiLinData(website.get(3)),tableName);
        provinceDAO.insert(Spider.getHeilongjiangData(website.get(4)),tableName);
        provinceDAO.insert(Spider.getJiangsuData(website.get(5)),tableName);
        provinceDAO.insert(Spider.getZhejiangData(website.get(6)),tableName);
        provinceDAO.insert(Spider.getAnhuiData(website.get(7)),tableName);
        provinceDAO.insert(Spider.getFujianData(website.get(8)),tableName);
        provinceDAO.insert(Spider.getJiangxiData(website.get(9)),tableName);
        provinceDAO.insert(Spider.getShandongData(website.get(10)),tableName);
        provinceDAO.insert(Spider.getHenanData(website.get(11)),tableName);
        provinceDAO.insert(Spider.getHubeiData(website.get(12)),tableName);
        provinceDAO.insert(Spider.getHunanData(website.get(13)),tableName);
        provinceDAO.insert(Spider.getGuangdongData(website.get(14)),tableName);
        provinceDAO.insert(Spider.getHainanData(website.get(15)),tableName);
        provinceDAO.insert(Spider.getSichuanData(website.get(16)),tableName);
        provinceDAO.insert(Spider.getGuizhouData(website.get(17)),tableName);
        provinceDAO.insert(Spider.getYunnanData(website.get(18)),tableName);
        provinceDAO.insert(Spider.getShaanxiData(website.get(19)),tableName);
        provinceDAO.insert(Spider.getGansuData(website.get(20)),tableName);
        provinceDAO.insert(Spider.getQinghaiData(website.get(21)),tableName);
        //provinceDAO.insert(Spider.getTaiwanData(website.get(22)),tableName);
        provinceDAO.insert(Spider.getNeimenguData(website.get(23)),tableName);
        provinceDAO.insert(Spider.getGuangxiData(website.get(24)),tableName);
        provinceDAO.insert(Spider.getXizangData(website.get(25)),tableName);
        provinceDAO.insert(Spider.getNingxiaData(website.get(26)),tableName);
        provinceDAO.insert(Spider.getXinjiangData(website.get(27)),tableName);
        provinceDAO.insert(Spider.getBeijingData(website.get(28)),tableName);
        provinceDAO.insert(Spider.getTianjinData(website.get(29)),tableName);
        provinceDAO.insert(Spider.getShanghaiData(website.get(30)),tableName);
        provinceDAO.insert(Spider.getChongqingData(website.get(31)),tableName);
        //provinceDAO.insert(Spider.getXianggangData(website.get(32)),tableName);
        //provinceDAO.insert(Spider.getAomenData(website.get(33)),tableName);
    }

    public static  void initData(){
        List<String> data10 = Arrays.asList("http://wsjkw.hebei.gov.cn/content/content_3714/401428.jhtml"
                ,"http://wjw.shanxi.gov.cn/wjywl02/25230.hrh","http://wsjk.ln.gov.cn/wst_zdzt/xxgzbd/yqtb/202003/t20200311_3768277.html"
                ,"http://www.jl.gov.cn/szfzt/jlzxd/yqtb/202003/t20200311_6882680.html","http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8146/navid/42/stypeid/"
                ,"http://wjw.jiangsu.gov.cn/art/2020/3/11/art_7290_9003482.html","http://www.zjwjw.gov.cn/art/2020/3/11/art_1202101_42222674.html"
                ,"http://wjw.ah.gov.cn/news_details_55778.html","http://wjw.fujian.gov.cn/ztzl/gzbufk/yqtb/202003/t20200311_5213782.htm"
                ,"http://hc.jiangxi.gov.cn/doc/2020/03/11/140792.shtml","http://wsjkw.shandong.gov.cn/ztzl/rdzt/qlzhfkgz/tzgg/202003/t20200311_3046054.html"
                ,"http://wsjkw.henan.gov.cn/contents/858/48930.shtml","http://wjw.hubei.gov.cn/bmdt/ztzl/fkxxgzbdgrfyyq/xxfb/202003/t20200311_2178379.shtml"
                ,"http://wjw.hunan.gov.cn/wjw/xxgk/gzdt/zyxw_1/202003/t20200311_11807784.html","http://wsjkw.gd.gov.cn/zwyw_yqxx/content/post_2927832.html"
                ,"http://wst.hainan.gov.cn/swjw/rdzt/yqfk/202003/t20200311_2759327.html","http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/3/11/997366dc4701463e8de1562c74f05d59.shtml"
                ,"http://www.gzhfpc.gov.cn/xwzx_500663/zwyw/202003/t20200311_54745904.html","http://ynswsjkw.yn.gov.cn/wjwWebsite/web/doc/UU158386205254284227"
                ,"http://sxwjw.shaanxi.gov.cn/art/2020/3/10/art_9_68660.html","http://wsjk.gansu.gov.cn/single/11218/84755.html"
                ,"https://wsjkw.qinghai.gov.cn/zhxw/xwzx/2020/03/11/1583887771440.html",""
                ,"http://wjw.nmg.gov.cn/doc/2020/03/11/295928.shtml","http://wsjkw.gxzf.gov.cn/zhuantiqu/ncov/ncovyqtb/2020/0311/70012.html"
                ,"http://wjw.xizang.gov.cn/xwzx/wsjkdt/202003/t20200305_133506.html"
                ,"http://wsjkw.nx.gov.cn/info/1140/15800.htm","http://www.xjhfpc.gov.cn/info/1495/19542.htm"
                ,"http://wjw.beijing.gov.cn/xwzx_20031/wnxw/202003/t20200311_1689388.html","http://wsjk.tj.gov.cn/art/2020/3/11/art_87_72162.html"
                ,"http://wsjkw.sh.gov.cn/xwfb/20200311/391bf753288a4486a06ffa3401f114e9e.html","http://wsjkw.cq.gov.cn/syyqzx/20200311/259361.html");
        List<String> data11 = Arrays.asList("http://wsjkw.hebei.gov.cn/content/content_3714/401471.jhtml"
                ,"http://wjw.shanxi.gov.cn/wjywl02/25235.hrh","http://wsjk.ln.gov.cn/wst_zdzt/xxgzbd/yqtb/202003/t20200312_3769089.html"
                ,"http://www.jl.gov.cn/szfzt/jlzxd/yqtb/202003/t20200312_6883874.html","http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8147/navid/42/stypeid/"
                ,"http://wjw.jiangsu.gov.cn/art/2020/3/12/art_7290_9008480.html","http://www.zjwjw.gov.cn/art/2020/3/12/art_1202101_42230728.html"
                ,"http://wjw.ah.gov.cn/news_details_55803.html","http://wjw.fujian.gov.cn/ztzl/gzbufk/yqtb/202003/t20200312_5214485.htm"
                ,"http://hc.jiangxi.gov.cn/doc/2020/03/12/140883.shtml","http://wsjkw.shandong.gov.cn/ztzl/rdzt/qlzhfkgz/tzgg/202003/t20200312_3046712.html"
                ,"http://wsjkw.henan.gov.cn/contents/858/48941.shtml","http://wjw.hubei.gov.cn/bmdt/ztzl/fkxxgzbdgrfyyq/xxfb/202003/t20200312_2179627.shtml"
                ,"http://wjw.hunan.gov.cn/wjw/xxgk/gzdt/zyxw_1/202003/t20200312_11809991.html","http://wsjkw.gd.gov.cn/zwyw_yqxx/content/post_2928761.html"
                ,"http://wst.hainan.gov.cn/swjw/rdzt/yqfk/202003/t20200312_2759717.html","http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/3/12/12124dfd43414b61a24a034f35730a9e.shtml"
                ,"http://www.gzhfpc.gov.cn/xwzx_500663/zwyw/202003/t20200312_54961513.html","http://ynswsjkw.yn.gov.cn/wjwWebsite/web/doc/UU158394842553077971"
                ,"http://sxwjw.shaanxi.gov.cn/art/2020/3/11/art_9_68887.html","http://wsjk.gansu.gov.cn/single/11218/84786.html"
                ,"https://wsjkw.qinghai.gov.cn/zhxw/xwzx/2020/03/12/1583974459006.html","",""
                ,"http://wjw.nmg.gov.cn/doc/2020/03/12/296035.shtml","http://wsjkw.gxzf.gov.cn/zhuantiqu/ncov/ncovyqtb/2020/0312/70084.html"
                ,"http://wjw.xizang.gov.cn/xwzx/wsjkdt/202003/t20200306_133608.html","http://wsjkw.nx.gov.cn/info/1140/15838.htm","http://www.xjhfpc.gov.cn/info/1495/19552.htm"
                ,"http://wjw.beijing.gov.cn/xwzx_20031/wnxw/202003/t20200312_1697813.html","http://wsjk.tj.gov.cn/art/2020/3/12/art_87_72209.html"
                ,"http://wsjkw.sh.gov.cn/xwfb/20200312/f8ab81f4929d49a0803749fcfe032d5b.html","http://wsjkw.cq.gov.cn/syyqzx/20200312/259509.html");
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        provinceDAO.createTable("today");
        for (Province province:Spider.getProvincesData()
        ) {
            provinceDAO.insert(province,"today");
        }
        /*catchCountryData("March6","http://www.xinhuanet.com/politics/2020-03/06/c_1125670759.htm");
        catchCountryData("March7","http://www.xinhuanet.com/politics/2020-03/07/c_1125675222.htm");
        catchCountryData("March8","http://www.xinhuanet.com/politics/2020-03/08/c_1125679196.htm");
        catchCountryData("March9","http://www.xinhuanet.com/politics/2020-03/09/c_1125682837.htm");
        catchCountryData("March10","http://www.xinhuanet.com/politics/2020-03/10/c_1125688175.htm");
        catchCountryData("March11","http://www.xinhuanet.com/politics/2020-03/11/c_1125694000.htm");*/
        provinceDAO.createTable("March10");
        catchCountryData("March10","http://www.xinhuanet.com/politics/2020-03/11/c_1125694000.htm");//全国数据
        catchProvinceData("March10",data10);
        provinceDAO.createTable("March11");
        catchCountryData("March11","http://www.xinhuanet.com/politics/2020-03/12/c_1125699532.htm");//全国数据
        catchProvinceData("March11",data11);
    }
    public static void main(String[] args) throws SQLException {
        try{
            System.out.println("抓取数据中...");
            initData();
        }catch (Exception e){
            e.printStackTrace();
        }
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        /*provinceDAO.createTable("March12");
        Spider spider = new Spider();
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/12/c_1125699532.htm"),"March12");
        provinceDAO.createTable("March12");*/
        for (Province province:Spider.getProvincesData()
             ) {
            provinceDAO.insert(province,"today");
        }
        /*JSONArray array = JSONArray.fromObject(Spider.getAreaStat());
        JSONObject jsonObject = JSONObject.fromObject(array.getString(0));
        String provinceName = jsonObject.getString("provinceName");
        System.out.println("provinceName："+provinceName);//Province country = Json.countryParse(Spider.getCountryStatisticsService());*?
        //provinceDAO.insert(country);
        //List<Province> provinces = Json.provinceParse(Spider.getProvinceStatisticService());
        /*for (Province province: provinces
             ) {
            provinceDAO.insert(province);
        }
        for (Province province:provinceDAO.list()
             ) {
            System.out.println(province.getName()+' '+province.getDay()+' '+province.getIp()+' '+ province.getSp()+' '+province.getCure()+' '+province.getDead());
        }
        //Spider spider = new Spider();
        spider.initWebsites();
        for (String website:spider.getWebsites()
             ) {
            provinceDAO.insert(Spider.getGovCountryData(website));
        }*/


        for (Province province:provinceDAO.list("March10")
        ) {
            province.printString();
        }
        for (Province province:provinceDAO.list("March11")
        ) {
            province.printString();
        }
        /*
        for (Province province:provinceDAO.list("today")) {
            province.printString();
        }*/
        //System.out.println(Spider.getAreaStat());
       // Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/12/c_1125699532.htm").printString();
    }


}