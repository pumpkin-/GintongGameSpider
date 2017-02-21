package dao.impl;

import JavaBean.OrgProduct;
import dao.OrgProductDao;

/**
 * Created by 123 on 2017/2/21.
 */
public class OrgProductDaoImpl extends BaseDaoImpl implements OrgProductDao{
    public OrgProductDaoImpl() {
        this.setNs("com.gintongame.mapping.OrgProductMapper.");
    }

    @Override
    public void insertOPDuct(OrgProduct ts) {
        this.getSqlSession().insert(this.getNs() + "insertOPDuct", ts);
    }
}
