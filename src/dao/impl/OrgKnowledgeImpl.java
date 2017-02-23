package dao.impl;

import JavaBean.OrgKnowledge;
import dao.OrgKnowledgeDao;

import java.util.List;

/**
 * Created by lenovo on 2017/2/22.
 */
public class OrgKnowledgeImpl extends BaseDaoImpl<List> implements OrgKnowledgeDao{

    public OrgKnowledgeImpl(){
        this.setNs("com.gintongame.mapping.OrgKnowledgeMapper.");
    }

    @Override
    public void insert(OrgKnowledge orgKnowledge) {
        this.getSqlSession().insert(this.getNs()+"insert",orgKnowledge);
    }
}
