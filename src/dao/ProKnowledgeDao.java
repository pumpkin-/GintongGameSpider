package dao;

import JavaBean.BasPersonInfo;
import JavaBean.DateInfo;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import SpiderUtils.SpiderUtils;
import dao.impl.ProKnowledgeImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface ProKnowledgeDao extends BaseDao<List> {

    public void insertBatch(List<ProKnowledge> ts);
    public void insert(ProKnowledge ts) throws ProKnowledgeImpl.FormatEexception;
    public Map<Integer,List> insertBatchAutoDedup(List<ProKnowledge> proKnowledges,List<BasPersonInfo> basPersonInfos,List<PerKnowledge> perKnowledges) throws ProKnowledgeImpl.FormatEexception, ParseException, SpiderUtils.FormatEexception;
    public List<ProKnowledge> selectList(DateInfo date);
    public List<ProKnowledge> select();
    public List<String> selectBySource(String source);
}
