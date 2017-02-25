package dao.impl;

import JavaBean.PerOrganize;
import dao.PerOrganizeDao;

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
}
