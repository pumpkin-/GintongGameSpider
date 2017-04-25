package dao.impl;

import JavaBean.QiYeCha;
import dao.QiYeChaDao;

/**
 * Created by admin on 2017/4/23.
 */
public class QiYeChaImpl extends BaseDaoImpl implements QiYeChaDao {
    public QiYeChaImpl(){
        this.setNs("com.gintongame.mapping.QiYeChaMapper.");
    }


    @Override
    public void insertName(QiYeCha qiYeCha) {
        this.getSqlSession().insert(this.getNs()+"insert",qiYeCha);
    }
}
