package dao.impl;

import dao.PerKnowledgeDao;
import JavaBean.PerKnowledge;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public class PerKnowledgeImpl extends BaseDaoImpl<List> implements PerKnowledgeDao {
    public PerKnowledgeImpl(){
        this.setNs("com.gintongame.mapping.PerKnowledgeMapper.");
    }

    public void insertBatch(List<PerKnowledge> perknowledges) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", perknowledges);
    }

    public void insert(PerKnowledge perknowledge) {
        this.getSqlSession().insert(this.getNs() + "insert", perknowledge);
    }
}
