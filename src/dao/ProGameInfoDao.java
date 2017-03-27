package dao;


import JavaBean.BasProGameInfo;
import JavaBean.ProGameInfo;

import java.util.List;

/**
 * Created by 123 on 2017/2/18.
 */
public interface ProGameInfoDao {
    public void insertGame(BasProGameInfo ts);
    public List<String> selectGame(BasProGameInfo gname);
}
