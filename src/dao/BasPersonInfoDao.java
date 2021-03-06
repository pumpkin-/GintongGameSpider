package dao;

import JavaBean.BasPersonInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface BasPersonInfoDao extends BaseDao<List>{
    public void insertBatch(List<BasPersonInfo> basperinsos);
    public void insert(BasPersonInfo ts);
    public List<String> selectList(String ts);
    public void insertPerInfo(BasPersonInfo basPersonInfo);
    public List<BasPersonInfo> selectPerByUrl(String url);
    public void updatePerByUrl(BasPersonInfo personInfo);
}
