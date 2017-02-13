package dao.impl;

import Mybatis.MybatisUtils;
import dao.BaseDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


/**
 * Created by lenovo on 2017/2/9.
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private SqlSession session;

    public void BaseDaoImpl()  {

    }

    public SqlSession getSqlSession() {
        try {
            session = MybatisUtils.newSqlSessionInstance();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return session;
    }
    private String ns; // 命名空间

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }
    @Override
    public int insert(T entity) {
        return this.getSqlSession().insert(ns+"insert",entity);
    }

    @Override
    public int update(T entity) {
        return this.getSqlSession().update(ns + "update", entity);
    }

    @Override
    public int delete(Serializable entity) {
        return this.getSqlSession().delete(ns + "delete", entity);
    }

    @Override
    public int find(Serializable entity) {
        return this.getSqlSession().selectOne(ns + "find", entity);
    }
}
