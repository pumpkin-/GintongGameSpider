package dao;

import JavaBean.ComShareholderTeam;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public interface ComShareholderTeamDao {
    public void insertShareholderTeam(ComShareholderTeam comShareholderTeam);
    public void updateShareholderTeam(ComShareholderTeam comShareholderTeam);
    public List<ComShareholderTeam> selectShareholderTeam(String uuid);
}
