package dao;

import JavaBean.ComChangInfo;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public interface ComChangeInfoDao {
    public void insertChangeInfo(ComChangInfo comChangInfo);
    public List<ComChangInfo> selectChangeInfo(String uuid);
    public void updateChangeInfo(ComChangInfo comChangInfo);
}
