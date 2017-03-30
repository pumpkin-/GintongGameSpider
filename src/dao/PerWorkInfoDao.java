package dao;

import JavaBean.PerWorkInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public  interface PerWorkInfoDao {
    public void insertPerWorkInfo(PerWorkInfo perWorkInfo);
    public List<PerWorkInfo> selectListBySource(String source);
}
