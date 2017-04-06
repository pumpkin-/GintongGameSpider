package dao;

import JavaBean.ComShareholder;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public interface ComShareholderDao {
    public void insertComShareholder(ComShareholder comShareholder);
    public void updateComShareholder(ComShareholder comShareholder);
    public List<ComShareholder> selectComShareholder(String uuid);
}
