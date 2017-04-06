package dao.impl;

import JavaBean.ComShareholderTeam;
import dao.ComShareholderTeamDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public class ComShareholderTeamImpl extends BaseDaoImpl implements ComShareholderTeamDao{
    public ComShareholderTeamImpl (){
        this.setNs("com.gintongame.mapping.ComShareholderTeamMapper.");
    }
    @Override
    public void insertShareholderTeam(ComShareholderTeam comShareholderTeam) {
        this.getSqlSession().insert(this.getNs()+"insertComShareholderTeam",comShareholderTeam);
    }

    @Override
    public void updateShareholderTeam(ComShareholderTeam comShareholderTeam) {
        this.getSqlSession().update(this.getNs()+"updateComShareholderTeam",comShareholderTeam);
    }

    @Override
    public List<ComShareholderTeam> selectShareholderTeam(String uuid) {
        return this.getSqlSession().selectList(this.getNs()+"selectComShareholderTeam",uuid);
    }
}
