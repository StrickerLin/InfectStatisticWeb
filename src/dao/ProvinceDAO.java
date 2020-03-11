package dao;

import pojo.Province;

import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: dao.ProvinceDAO
 * @Author: Date: 2020/3/11
 * project name: InfectStatisticWeb
 * @Version:
 * @Description:
 */
public interface ProvinceDAO {
    public void insert(Province province);
    public void delete(Province province);
    public void update(Province province);
    public List<Province> list();
}