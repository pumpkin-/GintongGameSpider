package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerFamilyInfo;
import mybatisGenerator.javaBean.PerFamilyInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerFamilyInfoMapper {
    int countByExample(PerFamilyInfoExample example);

    int deleteByExample(PerFamilyInfoExample example);

    int insert(PerFamilyInfo record);

    int insertSelective(PerFamilyInfo record);

    List<PerFamilyInfo> selectByExample(PerFamilyInfoExample example);

    int updateByExampleSelective(@Param("record") PerFamilyInfo record, @Param("example") PerFamilyInfoExample example);

    int updateByExample(@Param("record") PerFamilyInfo record, @Param("example") PerFamilyInfoExample example);
}