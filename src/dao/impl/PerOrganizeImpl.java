package dao.impl;

import JavaBean.PerOrganize;
import dao.PerOrganizeDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public class PerOrganizeImpl extends BaseDaoImpl implements PerOrganizeDao{
    public PerOrganizeImpl (){
        this.setNs("com.gintongame.mapping.PerOrganizeMapper.");
    }
    @Override
    public void insertPerOrgani(PerOrganize perOrganize) {
        this.getSqlSession().insert(this.getNs()+"insertPerOrgan",perOrganize);
    }

    @Override
    public List<PerOrganize> selectPerOrgan(String ouuid) {
        return this.getSqlSession().selectList(this.getNs()+"selectPerOrgan",ouuid);
    }

    @Override
    public void updatePerOrgan(PerOrganize perOrganize) {
        this.getSqlSession().update(this.getNs()+"updatePerOrgan",perOrganize);
    }
}
