package dao;

import JavaBean.PerOrganize;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public interface PerOrganizeDao {
    public void insertPerOrgani(PerOrganize perOrganize);
    public List<PerOrganize> selectPerOrgan(String ouuid);
    public void updatePerOrgan(PerOrganize perOrganize);
}
