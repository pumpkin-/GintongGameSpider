package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerEvaInfo;
import mybatisGenerator.javaBean.PerEvaInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerEvaInfoMapper {
    int countByExample(PerEvaInfoExample example);

    int deleteByExample(PerEvaInfoExample example);

    int insert(PerEvaInfo record);

    int insertSelective(PerEvaInfo record);

    List<PerEvaInfo> selectByExample(PerEvaInfoExample example);

    int updateByExampleSelective(@Param("record") PerEvaInfo record, @Param("example") PerEvaInfoExample example);

    int updateByExample(@Param("record") PerEvaInfo record, @Param("example") PerEvaInfoExample example);
}