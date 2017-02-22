package dao;

import JavaBean.ProGameType;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProGameTypeDao {
    public  void insertType(ProGameType type);
}