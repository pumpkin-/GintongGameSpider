package dao.impl;

import JavaBean.ComInvestmentInfo;
import dao.ComInvestmentInfoDao;

import java.util.List;

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

    @Override
    public List<ComInvestmentInfo> selectInvestmentInfo(String uuid) {
        return this.getSqlSession().selectList(this.getNs()+"selectComInvestment",uuid);
    }

    @Override
    public void updateInvestmentInfo(ComInvestmentInfo comInvestmentInfo) {
        this.getSqlSession().update(this.getNs()+"updateComInvestment",comInvestmentInfo);
    }
}
