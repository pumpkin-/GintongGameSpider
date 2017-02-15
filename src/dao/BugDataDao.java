package dao;

import JavaBean.BugData;
import JavaBean.PerKnowledge;

import java.util.List;

/**
 * Created by lenovo on 2017/2/14.
 */
public interface BugDataDao extends BaseDao<List>{
    public void insert(BugData ts);
}
