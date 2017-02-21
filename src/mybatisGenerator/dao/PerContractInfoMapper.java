package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerContractInfo;
import mybatisGenerator.javaBean.PerContractInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerContractInfoMapper {
    int countByExample(PerContractInfoExample example);

    int deleteByExample(PerContractInfoExample example);

    int insert(PerContractInfo record);

    int insertSelective(PerContractInfo record);

    List<PerContractInfo> selectByExample(PerContractInfoExample example);

    int updateByExampleSelective(@Param("record") PerContractInfo record, @Param("example") PerContractInfoExample example);

    int updateByExample(@Param("record") PerContractInfo record, @Param("example") PerContractInfoExample example);
}