package dao.impl;

import JavaBean.BasBusinessInfo;
import dao.BasBusinessInfoDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public class BasBusinessInfoImpl extends BaseDaoImpl implements BasBusinessInfoDao {
    public BasBusinessInfoImpl (){
        this.setNs("com.gintongame.mapping.BasBusinessInfoMapper.");
    }
    @Override
    public void insertBusInfo(BasBusinessInfo busInfo) {
        this.getSqlSession().insert(this.getNs()+"insertBusiness",busInfo);
    }

    @Override
    public List<String> selectBusInfo(String uuid) {
        return this.getSqlSession().selectList(this.getNs() + "selectBusinessId", uuid);
    }

    @Override
    public void updateBusInfo(BasBusinessInfo businfo) {
        this.getSqlSession().update(this.getNs()+"updateBusiness",businfo);
    }

}
