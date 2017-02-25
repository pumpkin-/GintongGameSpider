package dao.impl;

import JavaBean.ComShareholder;
import dao.ComShareholderDao;

/**
 * Created by lenovo on 2017/2/23.
 */
public class ComShareholderImpl extends BaseDaoImpl implements ComShareholderDao {
    public ComShareholderImpl (){
        this.setNs("com.gintongame.mapping.ComShareholderMapper.");
    }
    @Override
    public void insertComShareholder(ComShareholder comShareholder) {
        this.getSqlSession().insert(this.getNs()+"insertComShareholder",comShareholder);
    }
}
