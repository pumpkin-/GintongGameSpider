package dao.impl;

import JavaBean.ComChangInfo;
import dao.ComChangeInfoDao;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public class ComChangeInfoImpl extends BaseDaoImpl implements ComChangeInfoDao {
    public ComChangeInfoImpl(){
        this.setNs("com.gintongame.mapping.ComChangeInfoMapper.");
    }
    @Override
    public void insertChangeInfo(ComChangInfo comChangInfo) {
        this.getSqlSession().insert(this.getNs()+"insertChangeInfo",comChangInfo);
    }

    @Override
    public List<ComChangInfo> selectChangeInfo(String uuid) {
        return this.getSqlSession().selectList(this.getNs()+"selectChangeInfo",uuid);
    }

    @Override
    public void updateChangeInfo(ComChangInfo comChangInfo) {
        this.getSqlSession().update(this.getNs()+"updateChangeInfo",comChangInfo);
    }
}
