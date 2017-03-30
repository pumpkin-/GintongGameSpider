package dao.impl;

import JavaBean.BasBusinessInfo;
import JavaBean.PerSkillInfo;
import dao.BasBusinessInfoDao;
import dao.PerSkillInfoDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public class PerSkillInfoDaoImpl extends BaseDaoImpl implements PerSkillInfoDao {
    public PerSkillInfoDaoImpl(){
        this.setNs("com.gintongame.mapping.PerSkillInfoMapper.");
    }
    @Override
    public void insertPerSkillInfo(PerSkillInfo perSkillInfo) {
        this.getSqlSession().insert(this.getNs()+"insertPerSkillInfo",perSkillInfo);
    }
}
