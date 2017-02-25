package dao;

import JavaBean.BasBusinessInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public  interface BasBusinessInfoDao {
    public void insertBusInfo(BasBusinessInfo busInfo);
    public List<String> selectBusInfo(String uuid);
}
