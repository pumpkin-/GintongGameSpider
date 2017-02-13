package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/2/9.
 */
public interface BaseDao<T> {
    public int insert(T entity);
    public int update(T entity);
    public int delete(Serializable entity);
    public int find(Serializable entity);
}
