package dao;

import JavaBean.BasOrganizeInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface BasOrganizeInfoDao extends BaseDao<List>{
    public void insertBatch(List<BasOrganizeInfo> ts);
    public void insertSingle(BasOrganizeInfo ts);
}
