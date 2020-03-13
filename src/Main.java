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
    1河北省 2山西省 3辽宁省 4吉林省 5黑龙江省 6江苏省 浙江省 安徽省 福建省 江西省 山东省 河南省 湖北省 湖南省 广东省 海南省 四川省 贵州省 云南省 陕西省 甘肃省 青海省 台湾省
自治区：内蒙古自治区 广西壮族自治区 西藏自治区 宁夏回族自治区 新疆维吾尔自治区
直辖市：北京市 天津市 上海市 重庆市
特别行政区：香港特别行政区 澳门特别行政区
     */
    public static void catchProvinceData(String tableName,List<String> website){
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        provinceDAO.insert(Spider.getHebeiData(website.get(0)),tableName);
        provinceDAO.insert(Spider.getShanxiData(website.get(1)),tableName);
    }

    public static  void initData(){
        List<String> data10 = Arrays.asList("http://wsjkw.hebei.gov.cn/content/content_3714/401428.jhtml"
                ,"http://wjw.shanxi.gov.cn/wjywl02/25230.hrh");
        List<String> data11 = Arrays.asList("http://wsjkw.hebei.gov.cn/content/content_3714/401471.jhtml"
                ,"http://wjw.shanxi.gov.cn/wjywl02/25235.hrh");
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
        initData();
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
        /*provinceDAO.createTable("March12");
        Spider spider = new Spider();
        provinceDAO.insert(Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/12/c_1125699532.htm"),"March12");
        provinceDAO.createTable("March12");*/
        /*for (Province province:Spider.getProvincesData()
             ) {
            provinceDAO.insert(province,"March13");
        }*/
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
        for (Province province:provinceDAO.list("March11")
        ) {
            province.printString();
        }
        for (Province province:provinceDAO.list("today")) {
            province.printString();
        }
        //System.out.println(Spider.getAreaStat());
       // Spider.getGovCountryData("http://www.xinhuanet.com/politics/2020-03/12/c_1125699532.htm").printString();
    }


}