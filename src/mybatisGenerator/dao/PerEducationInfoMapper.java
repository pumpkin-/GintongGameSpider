package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerEducationInfo;
import mybatisGenerator.javaBean.PerEducationInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerEducationInfoMapper {
    int countByExample(PerEducationInfoExample example);

    int deleteByExample(PerEducationInfoExample example);

    int insert(PerEducationInfo record);

    int insertSelective(PerEducationInfo record);

    List<PerEducationInfo> selectByExampleWithBLOBs(PerEducationInfoExample example);

    List<PerEducationInfo> selectByExample(PerEducationInfoExample example);

    int updateByExampleSelective(@Param("record") PerEducationInfo record, @Param("example") PerEducationInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PerEducationInfo record, @Param("example") PerEducationInfoExample example);

    int updateByExample(@Param("record") PerEducationInfo record, @Param("example") PerEducationInfoExample example);
}