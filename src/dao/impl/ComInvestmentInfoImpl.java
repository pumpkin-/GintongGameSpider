package dao.impl;

import JavaBean.ComInvestmentInfo;
import dao.ComInvestmentInfoDao;

/**
 * Created by lenovo on 2017/2/23.
 */
public class ComInvestmentInfoImpl extends BaseDaoImpl implements ComInvestmentInfoDao{
    public ComInvestmentInfoImpl (){
        this.setNs("com.gintongame.mapping.ComInvestmentInfoMapper.");
    }
    @Override
    public void insertInvestmentInfo(ComInvestmentInfo comInvestmentInfo) {
        this.getSqlSession().insert(this.getNs()+"insertComInvestment",comInvestmentInfo);
    }
}
