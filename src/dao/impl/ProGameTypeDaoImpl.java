package dao.impl;

import dao.ProGameTypeDao;
import JavaBean.ProGameType;

/**
 * Created by 123 on 2017/2/21.
 */
public class ProGameTypeDaoImpl extends BaseDaoImpl implements ProGameTypeDao {
    public ProGameTypeDaoImpl() {
        this.setNs("com.gintongame.mapping.ProGameTypeMapper.");
    }


    public void insertType(ProGameType type) {
        this.getSqlSession().insert(this.getNs() + "insertType", type);
    }



}

