package dao.impl;

import JavaBean.ComShareholder;
import dao.ComShareholderDao;

import java.util.List;

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

    @Override
    public void updateComShareholder(ComShareholder comShareholder) {
        this.getSqlSession().update(this.getNs()+"updateComShareholder",comShareholder);
    }

    @Override
    public List<ComShareholder> selectComShareholder(String uuid) {
        return this.getSqlSession().selectList(this.getNs()+"selectComShareholder",uuid);
    }
}
