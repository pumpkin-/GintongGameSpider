package dao.impl;

import JavaBean.PerWorkInfo;
import dao.PerWorkInfoDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class PerWorkInfoDaoImpl extends BaseDaoImpl<List> implements PerWorkInfoDao {
    public PerWorkInfoDaoImpl(){
        this.setNs("com.gintongame.mapping.PerWorkInfoMapper.");
    }
    @Override
    public void insertPerWorkInfo(PerWorkInfo perWorkInfo) {
        this.getSqlSession().insert(this.getNs()+"insertPerWorkInfo",perWorkInfo);
    }

    @Override
    public List<PerWorkInfo> selectListBySource(String source) {
        return this.getSqlSession().selectList(this.getNs()+"selectPerWorkInfoBySource",source);
    }
}
