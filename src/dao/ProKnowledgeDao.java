package dao;

import JavaBean.*;
import SpiderUtils.SpiderUtils;
import dao.impl.BasKnowledgeInfoDaoImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/10.
 */
public interface ProKnowledgeDao extends BaseDao<List> {
    public void insert(ProKnowledge proKnowledge);
}
