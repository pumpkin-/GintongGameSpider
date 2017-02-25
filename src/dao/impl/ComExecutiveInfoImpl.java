package dao.impl;

import JavaBean.ComExecutiveInfo;
import dao.ComExecutiveInfoDao;

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
}
