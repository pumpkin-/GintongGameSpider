package dao;

import JavaBean.OrgKnowledge;

import java.util.List;

/**
 * Created by lenovo on 2017/2/22.
 */
public interface OrgKnowledgeDao extends BaseDao<List>{
    public void insert(OrgKnowledge orgKnowledge);
}
