package dao.impl;

import JavaBean.ProGamePlatform;
import dao.ProGamePlatformDao;

/**
 * Created by gao on 2017/2/22.
 */
public class ProGamePlatformDaoImpl extends BaseDaoImpl implements ProGamePlatformDao {

    public ProGamePlatformDaoImpl() {
        this.setNs("com.gintongame.mapping.ProGamePlatformMapper.");
    }
    @Override
    public void insertPlatform(ProGamePlatform pf) {
        this.getSqlSession().insert(this.getNs() + "insertPlatform", pf);
    }
}
