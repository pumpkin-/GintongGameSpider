package dao.impl;

import JavaBean.OrgEvaInfo;
import dao.OrgEvaInfoDao;

/**
 * Created by lenovo on 2017/3/21.
 */
public class OrgEvaInfoImpl extends BaseDaoImpl implements OrgEvaInfoDao{
    public OrgEvaInfoImpl(){
        this.setNs("com.gintongame.mapping.OrgEvaInfoMapper.");
    }
    @Override
    public void insertSingle(OrgEvaInfo orgEvaInfo) {
        this.getSqlSession().insert(this.getNs()+"insertSingle",orgEvaInfo);
    }
}
