package dao.impl;

import dao.BasOrganizeInfoDao;
import JavaBean.BasOrganizeInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class BasOrganizeInfoImpl extends BaseDaoImpl<List> implements BasOrganizeInfoDao {
    public BasOrganizeInfoImpl(){
        this.setNs("com.gintongame.mapping.BasOrganizeInfoMapper.");
    }


    public void insertBatch(List<BasOrganizeInfo> basorganizeinfos) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", basorganizeinfos);
}

    @Override
    public void insertSingle(BasOrganizeInfo ts) {
        this.getSqlSession().insert(this.getNs() + "insertSingle", ts);
    }

    public List<String> selcetOrganId(String uuid) {
        return this.getSqlSession().selectList(this.getNs() + "selectOrganId", uuid);
    }
    @Override
    public List<BasOrganizeInfo> selectList(String ts) {
        return this.getSqlSession().selectList(this.getNs()+"selectList"+ts);
    }

    @Override
    public void updateSingle(BasOrganizeInfo ts) {
        this.getSqlSession().update(this.getNs()+"updateOrgan",ts);
    }

}
