package dao.impl;

import JavaBean.BasPersonInfo;
import JavaBean.DateInfo;
import JavaBean.PerKnowledge;


import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderUtils;
import dao.ProKnowledgeDao;
import JavaBean.ProKnowledge;
import org.apache.commons.lang3.StringUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/2/10.
 */
public class ProKnowledgeImpl extends BaseDaoImpl<List> implements ProKnowledgeDao {
    private static int fg=0;

    public ProKnowledgeImpl(){
        this.setNs("com.gintongame.mapping.ProKnowledgeMapper.");
    }

    /**
     * c
     * @param proKnowledges
     */
    @Deprecated
    @Override
    public void insertBatch(List<ProKnowledge> proKnowledges) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", proKnowledges);
    }

    public class FormatEexception extends Exception
    {
        public FormatEexception(String msg)
        {
            super(msg);
        }
    }



    public Map<Integer,List> insertBatchAutoDedup(List<ProKnowledge> proKnowledges,List<BasPersonInfo> basPersonInfos,List<PerKnowledge> perKnowledges) throws SpiderUtils.FormatEexception, ParseException, FormatEexception {
        Map<Integer,List> map= null;
        try {
            map = LevenshteinDis.isExist(proKnowledges, basPersonInfos, perKnowledges);
            if(((List<Integer>) map.get(4)).get(0)!=0) {
                this.getSqlSession().insert(this.getNs() + "insertBatch", proKnowledges);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 单条插入数据
     * @param proKnowledge
     * @throws FormatEexception
     */
    public void insert(ProKnowledge proKnowledge) throws FormatEexception {
        this.getSqlSession().insert(getNs() + "insert", proKnowledge);
    }


    /**
     * 批量插入数据
     * @param date
     * @return
     */
    public List<ProKnowledge> selectList(DateInfo date) {
        return this.getSqlSession().selectList(getNs() + "selectList", date);
    }

    public List<ProKnowledge> select(){
        return this.getSqlSession().selectList(getNs() + "select");
    }

//    @Override
    public List<String> selectBySource(String source) {
        return this.getSqlSession().selectList(this.getNs()+"selectBySource",source);
    }


}
