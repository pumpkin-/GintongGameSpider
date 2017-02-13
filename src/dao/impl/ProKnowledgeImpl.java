package dao.impl;

import dao.ProKnowledgeDao;
import JavaBean.ProKnowledge;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class ProKnowledgeImpl extends BaseDaoImpl<List> implements ProKnowledgeDao {
    public ProKnowledgeImpl(){
        this.setNs("com.gintongame.mapping.ProKnowledgeMapper.");
    }

    @Override
    public void insertBatch(List<ProKnowledge> proKnowledges) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", proKnowledges);
    }

    public List<String> selectList(String str) {
        return this.getSqlSession().selectList(getNs() + "selectList", str);
    }
}
