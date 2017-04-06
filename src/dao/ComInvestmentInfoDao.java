package dao;

import JavaBean.ComInvestmentInfo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public interface ComInvestmentInfoDao {
    public void insertInvestmentInfo(ComInvestmentInfo comInvestmentInfo);
    public List<ComInvestmentInfo> selectInvestmentInfo(String uuid);
    public void updateInvestmentInfo(ComInvestmentInfo comInvestmentInfo);
}
