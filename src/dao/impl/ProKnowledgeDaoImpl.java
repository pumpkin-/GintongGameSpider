package dao.impl;

import JavaBean.*;
import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderUtils;
import dao.BasKnowledgeInfoDao;
import dao.ProKnowledgeDao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/10.
 */
public class ProKnowledgeDaoImpl extends BaseDaoImpl<List> implements ProKnowledgeDao {
    private static int fg=0;

    public ProKnowledgeDaoImpl(){
        this.setNs("com.gintongame.mapping.ProKnowledgeMapper.");
    }


    @Override
    public void insert(ProKnowledge proKnowledge) {
        this.getSqlSession().insert(this.getNs()+"insert",proKnowledge);
    }
}
