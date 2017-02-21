package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerProduct;
import mybatisGenerator.javaBean.PerProductExample;
import org.apache.ibatis.annotations.Param;

public interface PerProductMapper {
    int countByExample(PerProductExample example);

    int deleteByExample(PerProductExample example);

    int insert(PerProduct record);

    int insertSelective(PerProduct record);

    List<PerProduct> selectByExample(PerProductExample example);

    int updateByExampleSelective(@Param("record") PerProduct record, @Param("example") PerProductExample example);

    int updateByExample(@Param("record") PerProduct record, @Param("example") PerProductExample example);
}