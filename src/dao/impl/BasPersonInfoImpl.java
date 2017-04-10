package dao.impl;

import JavaBean.BasPersonInfo;
import dao.BasPersonInfoDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class BasPersonInfoImpl extends BaseDaoImpl<List> implements BasPersonInfoDao{
    public BasPersonInfoImpl(){
        this.setNs("com.gintongame.mapping.BasPersonInfoMapper.");
    }

    public void insertBatch(List<BasPersonInfo> basperinsos) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", basperinsos);

    }

    public void insert(BasPersonInfo basperinso) {
        this.getSqlSession().insert(this.getNs() + "insert", basperinso);
    }

    @Override
    public List<String> selectList(String str) {
        return this.getSqlSession().selectList(getNs() + "selectList", str);
    }

    @Override
    public void insertPerInfo(BasPersonInfo basPersonInfo) {
        this.getSqlSession().insert(this.getNs()+"insertPerInfo",basPersonInfo);
    }

    @Override
    public List<BasPersonInfo> selectPerByUrl(String url) {
        return this.getSqlSession().selectList(this.getNs()+"selectPerByUrl",url);
    }

    @Override
    public void updatePerByUrl(BasPersonInfo personInfo) {
        this.getSqlSession().update(this.getNs()+"updatePerByUrl",personInfo);
    }

}
