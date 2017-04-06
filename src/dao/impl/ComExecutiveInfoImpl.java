package dao.impl;

import JavaBean.ComExecutiveInfo;
import dao.ComExecutiveInfoDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public class ComExecutiveInfoImpl extends BaseDaoImpl implements ComExecutiveInfoDao{
    public ComExecutiveInfoImpl (){
        this.setNs("com.gintongame.mapping.ComExecutiveInfoMapper.");
    }
    @Override
    public void insertExecutiveInfo(ComExecutiveInfo executiveInfo) {
        this.getSqlSession().insert(this.getNs()+"insertComExecutive",executiveInfo);
    }

    @Override
    public void updateExecutiveInfo(ComExecutiveInfo executiveInfo) {
        this.getSqlSession().update(this.getNs()+"updateComExecutive",executiveInfo);
    }

    @Override
    public List<ComExecutiveInfo> selectExecutiveInfo(String uuid) {
        return this.getSqlSession().selectList(this.getNs()+"selectComExecutive",uuid);
    }
}
