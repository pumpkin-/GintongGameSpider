package dao.impl;

import JavaBean.BasBusinessInfo;
import JavaBean.PerEducationInfo;
import dao.BasBusinessInfoDao;
import dao.PerEducationInfoDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public class PerEducationInfoDaoImpl extends BaseDaoImpl implements PerEducationInfoDao {
    public PerEducationInfoDaoImpl(){
        this.setNs("com.gintongame.mapping.PerEducationInfoMapper.");
    }
    @Override
    public void insertPerEducationInfo(PerEducationInfo perEducationInfo) {
        this.getSqlSession().insert(this.getNs()+"insertPerEducationInfo",perEducationInfo);
    }
}
