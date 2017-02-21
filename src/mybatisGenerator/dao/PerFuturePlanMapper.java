package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerFuturePlan;
import mybatisGenerator.javaBean.PerFuturePlanExample;
import org.apache.ibatis.annotations.Param;

public interface PerFuturePlanMapper {
    int countByExample(PerFuturePlanExample example);

    int deleteByExample(PerFuturePlanExample example);

    int insert(PerFuturePlan record);

    int insertSelective(PerFuturePlan record);

    List<PerFuturePlan> selectByExample(PerFuturePlanExample example);

    int updateByExampleSelective(@Param("record") PerFuturePlan record, @Param("example") PerFuturePlanExample example);

    int updateByExample(@Param("record") PerFuturePlan record, @Param("example") PerFuturePlanExample example);
}