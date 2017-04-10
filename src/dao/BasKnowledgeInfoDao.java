package dao;

import JavaBean.BasPersonInfo;
import JavaBean.DateInfo;
import JavaBean.PerKnowledge;
import JavaBean.BasKnowledgeInfo;
import SpiderUtils.SpiderUtils;
import dao.impl.BasKnowledgeInfoDaoImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface BasKnowledgeInfoDao extends BaseDao<List> {

    public void insertBatch(List<BasKnowledgeInfo> ts);
    public void insert(BasKnowledgeInfo ts) throws BasKnowledgeInfoDaoImpl.FormatEexception;
    public Map<Integer,List> insertBatchAutoDedup(List<BasKnowledgeInfo> basKnowledgeInfos,List<BasPersonInfo> basPersonInfos,List<PerKnowledge> perKnowledges) throws BasKnowledgeInfoDaoImpl.FormatEexception, ParseException, SpiderUtils.FormatEexception;
    public List<BasKnowledgeInfo> selectList(DateInfo date);
    public List<BasKnowledgeInfo> select();
    public List<String> selectBySource(String source);
}
