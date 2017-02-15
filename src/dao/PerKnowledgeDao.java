package dao;

import JavaBean.PerKnowledge;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface PerKnowledgeDao extends BaseDao<List>{
    public void insertBatch(List<PerKnowledge> ts);
    public void insert(PerKnowledge ts);
}
