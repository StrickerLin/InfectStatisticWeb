package myUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Province;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @PackgeName: util
 * @ClassName: Json
 * @Author: ll
 * Date: 2020/3/11
 * project name: InfectStatisticWeb
 * @Version:
 * @Description:
 */
public class Json {
    public static Province countryParse(String json) {
        Province province = new Province();
        JSONObject jsonObject = JSONObject.fromObject(json);
        province.setName("全国");
        String day = jsonObject.getString("modifyTime");
        Date date = new Date(Long.parseLong(day));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        province.setDay(str);
        province.setIp(jsonObject.getInt("confirmedCount"));
        province.setSp(jsonObject.getInt("suspectedCount"));
        province.setCure(jsonObject.getInt("curedCount"));
        province.setDead(jsonObject.getInt("deadCount"));
        return province;
    }

    public static List<Province> provinceParse(String json) {
        List<Province> provinces = new ArrayList<Province>();
        Province province;
        JSONArray myJsonArray = JSONArray.fromObject(json);
        for(int i=0;i < myJsonArray.size();i++)
        {
            JSONObject jsonObject = myJsonArray.getJSONObject(i);
            if(jsonObject != null){
                province = new Province();
                province.setName(jsonObject.optString("provinceName"));
                String day = jsonObject.getString("modifyTime");
                Date date = new Date(Long.parseLong(day));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = format.format(date);
                province.setDay(str);
                province.setIp(jsonObject.optInt("currentConfirmedCount"));
                province.setSp(jsonObject.optInt("suspectedCount"));
                province.setCure(jsonObject.optInt("curedCount"));
                province.setDead(jsonObject.optInt("deadCount"));
                provinces.add(province);
            }
        }
        return provinces;
    }

}