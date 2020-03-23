
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
import pojo.Province;
import dao.*;
//import myUtil.*;
//import sun.security.provider.ConfigFile;

//import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void catchCountryData(String tableName,String website){
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        provinceDAO.createTable(tableName);
        provinceDAO.insert(Spider.getGovCountryData(website),tableName);
    }

    public static void catchProvinceData1(List<String> website) {
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        provinceDAO.insert(Spider.getHebeiData(website.get(0)), "河北");
        provinceDAO.insert(Spider.getShanxiData(website.get(1)), "山西");
        provinceDAO.insert(Spider.getLiaoNingData(website.get(2)), "辽宁");
        provinceDAO.insert(Spider.getJiLinData(website.get(3)), "吉林");
        provinceDAO.insert(Spider.getHeilongjiangData(website.get(4)), "黑龙江");
        provinceDAO.insert(Spider.getJiangsuData(website.get(5)), "江苏");
        provinceDAO.insert(Spider.getZhejiangData(website.get(6)), "浙江");
        provinceDAO.insert(Spider.getAnhuiData(website.get(7)), "安徽");
        provinceDAO.insert(Spider.getFujianData(website.get(8)), "福建");
        provinceDAO.insert(Spider.getJiangxiData(website.get(9)), "江西");
        provinceDAO.insert(Spider.getShandongData(website.get(10)), "山东");
        provinceDAO.insert(Spider.getHenanData(website.get(11)), "河南");
        provinceDAO.insert(Spider.getHubeiData(website.get(12)), "湖北");
        provinceDAO.insert(Spider.getHunanData(website.get(13)), "湖南");
        provinceDAO.insert(Spider.getGuangdongData(website.get(14)), "广东");
        provinceDAO.insert(Spider.getHainanData(website.get(15)), "海南");
        provinceDAO.insert(Spider.getSichuanData(website.get(16)), "四川");
        provinceDAO.insert(Spider.getGuizhouData(website.get(17)), "贵州");
        provinceDAO.insert(Spider.getYunnanData(website.get(18)), "云南");
        provinceDAO.insert(Spider.getShaanxiData(website.get(19)), "山西");
        provinceDAO.insert(Spider.getGansuData(website.get(20)), "甘肃");
        provinceDAO.insert(Spider.getQinghaiData(website.get(21)), "青海");
        provinceDAO.insert(Spider.getTaiwanData(website.get(22)), "台湾");
        provinceDAO.insert(Spider.getNeimenguData(website.get(23)), "内蒙古");
        provinceDAO.insert(Spider.getGuangxiData(website.get(24)), "广西");
        provinceDAO.insert(Spider.getXizangData(website.get(25)), "西藏");
        provinceDAO.insert(Spider.getNingxiaData(website.get(26)), "宁夏");
        provinceDAO.insert(Spider.getXinjiangData(website.get(27)), "新疆");
        provinceDAO.insert(Spider.getBeijingData(website.get(28)), "北京");
        provinceDAO.insert(Spider.getTianjinData(website.get(29)), "天津");
        provinceDAO.insert(Spider.getShanghaiData(website.get(30)), "上海");
        provinceDAO.insert(Spider.getChongqingData(website.get(31)), "重庆");
        provinceDAO.insert(Spider.getXianggangData(website.get(32)), "香港");
        provinceDAO.insert(Spider.getAomenData(website.get(33)), "澳门");
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
                ,"http://wsjkw.sh.gov.cn/xwfb/20200311/391bf753288a4486a06ffa3401f114e9e.html","http://wsjkw.cq.gov.cn/syyqzx/20200311/259361.html","","");
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
                ,"http://wsjkw.sh.gov.cn/xwfb/20200312/f8ab81f4929d49a0803749fcfe032d5b.html","http://wsjkw.cq.gov.cn/syyqzx/20200312/259509.html","","");
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        String[] names ={"河北", "山西", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建","江西","山东"
                , "河南", "湖北", "湖南","广东","海南","四川","贵州","云南" ,"陕西", "甘肃","青海","台湾","内蒙古"
                , "广西","西藏", "宁夏","新疆","北京","天津","上海", "重庆","香港","澳门"};
        for (int i=0;i<names.length;i++){
            provinceDAO.createTable(names[i]);
        }
        catchProvinceData1(data10);
        catchProvinceData1(data11);
        provinceDAO.createTable("latest");
        for (Province province:Spider.getProvincesData()
        ) {
            //公鸡地图数据
            provinceDAO.insert(province,"latest");
        }
        provinceDAO.createTable("country");
        //全国各种趋势图数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/08/c_1125679196.htm"),"country");//3.07的数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/09/c_1125682837.htm"),"country");//3.08的数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/10/c_1125688175.htm"),"country");//3.09的数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/11/c_1125694000.htm"),"country");//3.10的数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/12/c_1125699532.htm"),"country");//3.11的数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/13/c_1125706520.htm"),"country");//3.12的数据
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/14/c_1125711265.htm"),"country");//3.13的数据
        //详细省份数据
        provinceDAO.createTable("黑龙江");
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8142/navid/42/stypeid/"),"黑龙江");//3-7
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8144/navid/42/stypeid/"),"黑龙江");//3-8
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8145/navid/42/stypeid/"),"黑龙江");//3-9
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8146/navid/42/stypeid/"),"黑龙江");//3-10
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8147/navid/42/stypeid/"),"黑龙江");//3-11
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8148/navid/42/stypeid/"),"黑龙江");//3-12
        provinceDAO.insert(Spider.getHeilongjiangData("http://wsjkw.hlj.gov.cn/index.php/Home/Zwgk/show/newsid/8149/navid/42/stypeid/"),"黑龙江");//3-13

    }
    public static void main(String[] args) throws SQLException {
        try{
            System.out.println("抓取数据中...");
            initData();
            System.out.println("数据初始化成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}