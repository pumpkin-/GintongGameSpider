package dao.impl;

import JavaBean.ComShareholderTeam;
import dao.ComShareholderTeamDao;

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
}
