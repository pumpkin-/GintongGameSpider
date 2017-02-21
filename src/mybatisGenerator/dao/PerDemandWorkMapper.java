package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerDemandWork;
import mybatisGenerator.javaBean.PerDemandWorkExample;
import org.apache.ibatis.annotations.Param;

public interface PerDemandWorkMapper {
    int countByExample(PerDemandWorkExample example);

    int deleteByExample(PerDemandWorkExample example);

    int insert(PerDemandWork record);

    int insertSelective(PerDemandWork record);

    List<PerDemandWork> selectByExample(PerDemandWorkExample example);

    int updateByExampleSelective(@Param("record") PerDemandWork record, @Param("example") PerDemandWorkExample example);

    int updateByExample(@Param("record") PerDemandWork record, @Param("example") PerDemandWorkExample example);
}