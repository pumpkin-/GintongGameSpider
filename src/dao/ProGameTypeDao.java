package dao;

import JavaBean.ProGameType;


import org.apache.ibatis.annotations.Param;

//import JavaBean.ProGameTypeExample;

public interface ProGameTypeDao {
    public  void insertType(ProGameType type);
}