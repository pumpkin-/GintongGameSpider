package dao;

import JavaBean.ComExecutiveInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public interface ComExecutiveInfoDao {
    public void insertExecutiveInfo(ComExecutiveInfo executiveInfo);
    public void updateExecutiveInfo(ComExecutiveInfo executiveInfo);
    public List<ComExecutiveInfo> selectExecutiveInfo(String uuid);
}
