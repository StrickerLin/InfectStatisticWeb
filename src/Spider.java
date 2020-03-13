import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import myUtil.regUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.HttpPojo;
import pojo.Province;
import sun.dc.pr.PRError;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Spider
 * @Author: ll
 * Date: 2020/3/11
 * project name: InfectStatisticWeb
 * @Version:
 * @Description:
 */
class Spider {
    /*private List<String> websites;
    public List<String> initWebsites(){
        websites = new ArrayList<String>();
        File file = new File("src/txt/CountryWebsites.txt");
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String currentLine = null;
            while((currentLine = reader.readLine()) != null){
                websites.add(currentLine);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return websites;
    }

    public List<String> getWebsites(){
        return websites;
    }*/
    public static  Province getYunnanData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("ynswsjkw.yn.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        //httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile(reg.getDay());
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile(reg.getSp());
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile("治愈出院(\\d+)例");
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile("死亡(\\d+)例");
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("云南省");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

    public static  Province getHebeiData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("wsjkw.hebei.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        //httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile(reg.getDay());
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile(reg.getSp());
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile(reg.getCure());
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("河北省");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

    public static  Province getShanxiData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("wjw.shanxi.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpPojo.setHttpCookie("_site_id_cookie=%24%7Bsite.id!%7D; clientlanguage=en_US; Hm_lvt_f9f9d4221f4772d28cc9efcd7ca16803=1584036413; JSESSIONID=AA052A96BC5F25CD498B72D4D669E3C9; Hm_lpvt_f9f9d4221f4772d28cc9efcd7ca16803=1584040468");
        //httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile("2020年(\\d+)月(\\d+)日");
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile("现有(.)*确诊病例(\\d+)例");
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile(reg.getSp());
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile("累计治愈出院(\\d+)例");
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("山西");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

  /*  public static  Province getLiaoNingData(String url){

    }

    public static  Province getJiLinData(String url){

    }

    public static  Province getJiangsuData(String url){

    }

    public static  Province getZhejiangData(){

    }

    public static  Province getShandongData(String url){

    }
     public static  Province getHeilongjiangData(String url){

    }
   */


    public  static  Province getAnhuiData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("wjw.ah.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
       // httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile("(\\d+)月(\\d+)日");
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile("累计医学观察密切接触者(.)*人");
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile(reg.getCure());
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("安徽");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

    public  static Province getFujianData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("wjw.fujian.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile(reg.getDay());
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile("新增新型冠状病毒肺炎确诊病例(\\d+)例");
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile("新增新型冠状病毒肺炎疑似病例(\\d+)例");
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile("现有报告新型冠状病毒肺炎疑似病例(\\d+)例");
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile(reg.getCure());
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("福建");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

    public static Province getJiangxiData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("hc.jiangxi.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile(reg.getDay());
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile("新增出院病例(\\d+)例");
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile(reg.getSp());
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile("累计出院病例(\\d+)例");
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("江西");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }


    public static  Province getHenanData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("wsjkw.henan.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile(reg.getDay());
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile(reg.getSp());
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile("累计出院病例(\\d+)例");
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("河南");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

    public static Province getHubeiData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("wjw.hubei.gov.cn");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile("截至2020年(.)*月(.)*日");
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile("全省新增新冠肺炎确诊病例(\\d+)例");
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile("全省新增出院(\\d+)例");
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile("全省新增病亡(\\d+)例");
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile("目前仍在院治疗(.)*例");
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile("现有疑似病例(.)*人");
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile("全省累计治愈出院(.)*例");
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile("全省累计病亡(.)*例");
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("湖北");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }
    private static Province getProvince(Province province, Matcher dayMatcher, Matcher ipIncreaseMatcher, Matcher spIncreaseMatcher, Matcher cureIncreaseMatcher, Matcher deadIncreaseMatcher, Matcher ipMatcher, Matcher spMatcher, Matcher cureMatcher, Matcher deadMatcher) {
        if (dayMatcher.find())
            province.setDay("2020-"+dayMatcher.group(1)+"-"+dayMatcher.group(2));
        if (ipIncreaseMatcher.find())
            province.setIpIncrease(Integer.parseInt(ipIncreaseMatcher.group(1)));
        if (spIncreaseMatcher.find())
            province.setSpIncrease(Integer.parseInt(spIncreaseMatcher.group(1)));
        if (cureIncreaseMatcher.find())
            province.setCureIncrease(Integer.parseInt(cureIncreaseMatcher.group(1)));
        if (deadIncreaseMatcher.find())
            province.setDeadIncrease(Integer.parseInt(deadIncreaseMatcher.group(1)));
        if (ipMatcher.find())
            province.setIp(Integer.parseInt(ipMatcher.group(1)));
        if (spMatcher.find())
            province.setSp(Integer.parseInt(spMatcher.group(1)));
        if (cureMatcher.find())
            province.setCure(Integer.parseInt(cureMatcher.group(1)));
        if (deadMatcher.find())
            province.setDead(Integer.parseInt(deadMatcher.group(1)));
        return province;
    }

    public static Province getGovCountryData(String url){
        Province province = new Province();
        regUtil reg = new regUtil();
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("www.xinhuanet.com");
        httpPojo.setHttpAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpPojo.setHttpReferer("http://www.nhc.gov.cn/xcs/yqtb/list_gzbd.shtml");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        Pattern dayPattern = Pattern.compile(reg.getDay());
        Matcher dayMatcher = dayPattern.matcher(htmlResult);
        Pattern ipIncreasePattern = Pattern.compile(reg.getIpIncrease());
        Matcher ipIncreaseMatcher = ipIncreasePattern.matcher(htmlResult);
        Pattern spIncreasePattern = Pattern.compile(reg.getSpIncrease());
        Matcher spIncreaseMatcher = spIncreasePattern.matcher(htmlResult);
        Pattern cureIncreasePattern = Pattern.compile(reg.getCureIncrease());
        Matcher cureIncreaseMatcher = cureIncreasePattern.matcher(htmlResult);
        Pattern deadIncreasePattern = Pattern.compile(reg.getDeadIncrease());
        Matcher deadIncreaseMatcher = deadIncreasePattern.matcher(htmlResult);
        Pattern ipPattern = Pattern.compile(reg.getIp());
        Matcher ipMatcher = ipPattern.matcher(htmlResult);
        Pattern spPattern = Pattern.compile(reg.getSp());
        Matcher spMatcher = spPattern.matcher(htmlResult);
        Pattern curePattern = Pattern.compile(reg.getCure());
        Matcher cureMatcher = curePattern.matcher(htmlResult);
        Pattern deadPattern = Pattern.compile(reg.getDead());
        Matcher deadMatcher = deadPattern.matcher(htmlResult);
        province.setName("全国");
        return getProvince(province, dayMatcher, ipIncreaseMatcher, spIncreaseMatcher, cureIncreaseMatcher, deadIncreaseMatcher, ipMatcher, spMatcher, cureMatcher, deadMatcher);
    }

    public static List<Province> getProvincesData() {
        List<Province> provinces = new ArrayList<Province>();
        Province province = null;
        String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("ncov.dxy.cn");
        httpPojo.setHttpAccept("*/*");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        httpPojo.setHttpReferer("https://ncov.dxy.cn");
        httpPojo.setHttpOrigin("https://ncov.dxy.cn");
        Map paramObj = new HashMap();
        String htmlResult = httpSendGet(url, paramObj, httpPojo);
        String getDateReg = "window.getStatisticsService = (.*?)\\}(?=catch)";
        Pattern DatePattern = Pattern.compile(getDateReg);
        Matcher DateMatcher = DatePattern.matcher(htmlResult);
        String result = "";
        String modifyTime = "";
        if (DateMatcher.find()){
            result = DateMatcher.group(1);
            JSONObject jsonObject = JSONObject.fromObject(result);
            modifyTime = jsonObject.getString("modifyTime");
        }
        String reg = "window.getAreaStat = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);
        if (totalMatcher.find()) {
            result = totalMatcher.group(1);
            //System.out.println(result);
            //各个省市的是一个列表List，如果想保存到数据库中，要遍历结果，下面是demo
            /*JSONArray array = JSONArray.parseArray(result);
            JSONObject jsonObject = JSONObject.parseObject(array.getString(0));
            String provinceName = jsonObject.getString("provinceName");
            System.out.println("provinceName："+provinceName);*/
            JSONArray array = JSONArray.fromObject(result);
            for (int i=0;i<array.size();i++){
                province = new Province();
                JSONObject jsonObject = JSONObject.fromObject(array.getString(i));
                Date date = new Date(Long.parseLong(modifyTime));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = format.format(date);
                province.setDay(dateString);
                province.setName(jsonObject.getString("provinceName"));
                province.setIp(jsonObject.getInt("currentConfirmedCount"));
                province.setCure(jsonObject.getInt("curedCount"));
                province.setDead(jsonObject.getInt("deadCount"));
                provinces.add(province);
            }
            /*JSONObject jsonObject = JSONObject.fromObject(array.getString(0));
            String provinceName = jsonObject.getString("provinceName");
            System.out.println("provinceName："+provinceName);//Province country = Json.countryParse(Spider.getCountryStatisticsService());*/
        }
        return provinces;
    }

    private static String httpSendGet(String url, Map paramObj, HttpPojo httpPojo) {
        String result = "";
        String urlName = url + "?" + parseParam(paramObj);

        BufferedReader in = null;
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            String ip = randIP();
            //System.out.println("目前伪造的ip：" + ip);
            conn.setRequestProperty("X-Forwarded-For", ip);
            conn.setRequestProperty("HTTP_X_FORWARDED_FOR", ip);
            conn.setRequestProperty("HTTP_CLIENT_IP", ip);
            conn.setRequestProperty("REMOTE_ADDR", ip);
            conn.setRequestProperty("Host", httpPojo.getHttpHost());
            conn.setRequestProperty("accept", httpPojo.getHttpAccept());
            conn.setRequestProperty("connection", httpPojo.getHttpConnection());
            conn.setRequestProperty("user-agent", httpPojo.getHttpUserAgent());
            conn.setRequestProperty("Referer", httpPojo.getHttpReferer()); //伪造访问来源
            conn.setRequestProperty("Origin", httpPojo.getHttpOrigin()); //伪造访问域名
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                //System.out.println(s + "-->" + map.get(s));
            }
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }

    public static String parseParam(Map paramObj) {
        String param = "";
        if (paramObj != null && !paramObj.isEmpty()) {
            for (Object key : paramObj.keySet()) {
                String value = paramObj.get(key).toString();
                param += (key + "=" + value + "&");

            }
        }
        return param;
    }

    public static String randIP() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1)
                + "." + (random.nextInt(255) + 1) + "."
                + (random.nextInt(255) + 1);
    }
}