package dao.impl;

import JavaBean.BasProGameInfo;
import dao.ProGameInfoDao;


/**
 * Created by 123 on 2017/2/18.
 */
public class ProGameInfoDaoImpl extends BaseDaoImpl implements ProGameInfoDao {
    public ProGameInfoDaoImpl (){
        this.setNs("com.gintongame.mapping.ProGameInfoMapper.");
    }
    @Override
    public void insertGame(BasProGameInfo ts) {
        this.getSqlSession().insert(this.getNs() + "insertGame", ts);

    }
}
