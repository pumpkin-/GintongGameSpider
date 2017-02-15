package dao;

import JavaBean.ProKnowledge;

import java.util.List;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface ProKnowledgeDao extends BaseDao<List> {

    public void insertBatch(List<ProKnowledge> ts);
    public void insert(ProKnowledge ts);

}
