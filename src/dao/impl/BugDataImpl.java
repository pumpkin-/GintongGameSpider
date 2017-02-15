package dao.impl;

import JavaBean.BugData;
import dao.BugDataDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/14.
 */
public class BugDataImpl extends BaseDaoImpl<List> implements BugDataDao{
    public BugDataImpl(){
        this.setNs("com.gintongame.mapping.BugData.");
    }

    @Override
    public void insert(BugData bugdata) {
        this.getSqlSession().insert(this.getNs() + "insert", bugdata);
    }
}
