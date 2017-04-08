package dao.impl;

import JavaBean.BasPersonInfo;
import JavaBean.DateInfo;
import JavaBean.PerKnowledge;


import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderUtils;
import JavaBean.BasKnowledgeInfo;
import dao.BasKnowledgeInfoDao;


import java.text.ParseException;
import java.util.*;

/**
 * Created by lenovo on 2017/2/10.
 */
public class BasKnowledgeInfoDaoImpl extends BaseDaoImpl<List> implements BasKnowledgeInfoDao {
    private static int fg=0;

    public BasKnowledgeInfoDaoImpl(){
        this.setNs("com.gintongame.mapping.BasKnowledgeInfoMapper.");
    }

    /**
     * c
     * @param basKnowledgeInfos
     */
    @Deprecated
    @Override
    public void insertBatch(List<BasKnowledgeInfo> basKnowledgeInfos) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", basKnowledgeInfos);
    }

    public class FormatEexception extends Exception
    {
        public FormatEexception(String msg)
        {
            super(msg);
        }
    }



    public Map<Integer,List> insertBatchAutoDedup(List<BasKnowledgeInfo> basKnowledgeInfos,List<BasPersonInfo> basPersonInfos,List<PerKnowledge> perKnowledges) throws SpiderUtils.FormatEexception, ParseException, FormatEexception {
        Map<Integer,List> map= null;
        try {
            map = LevenshteinDis.isExist(basKnowledgeInfos, basPersonInfos, perKnowledges);
            if(((List<Integer>) map.get(4)).get(0)!=0) {
                this.getSqlSession().insert(this.getNs() + "insertBatch", basKnowledgeInfos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 单条插入数据
     * @param basKnowledgeInfo
     * @throws FormatEexception
     */
    public void insert(BasKnowledgeInfo basKnowledgeInfo) throws FormatEexception {
        this.getSqlSession().insert(getNs() + "insert", basKnowledgeInfo);
    }


    /**
     * 批量插入数据
     * @param date
     * @return
     */
    public List<BasKnowledgeInfo> selectList(DateInfo date) {
        return this.getSqlSession().selectList(getNs() + "selectList", date);
    }

    public List<BasKnowledgeInfo> select(){
        return this.getSqlSession().selectList(getNs() + "select");
    }

//    @Override
    public List<String> selectBySource(String source) {
        return this.getSqlSession().selectList(this.getNs()+"selectBySource",source);
    }


}
