package dao.impl;

import JavaBean.BasPersonInfo;
import SpiderUtils.LevenshteinDis;
import dao.BasPersonInfoDao;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class BasPersonInfoImpl extends BaseDaoImpl<List> implements BasPersonInfoDao{
    public BasPersonInfoImpl(){
        this.setNs("com.gintongame.mapping.BasPersonInfoMapper.");
    }

    public void insertBatch(List<BasPersonInfo> basperinsos) {
            this.getSqlSession().insert(this.getNs() + "insertBatch", basperinsos);

    }

    public void insert(BasPersonInfo basperinso) {
        this.getSqlSession().insert(this.getNs() + "insert", basperinso);
    }

    @Override
    public List<String> selectList(String str) {
        return this.getSqlSession().selectList(getNs() + "selectList", str);
    }
}
