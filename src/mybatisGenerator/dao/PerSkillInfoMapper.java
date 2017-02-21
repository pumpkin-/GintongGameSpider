package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerSkillInfo;
import mybatisGenerator.javaBean.PerSkillInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerSkillInfoMapper {
    int countByExample(PerSkillInfoExample example);

    int deleteByExample(PerSkillInfoExample example);

    int insert(PerSkillInfo record);

    int insertSelective(PerSkillInfo record);

    List<PerSkillInfo> selectByExampleWithBLOBs(PerSkillInfoExample example);

    List<PerSkillInfo> selectByExample(PerSkillInfoExample example);

    int updateByExampleSelective(@Param("record") PerSkillInfo record, @Param("example") PerSkillInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PerSkillInfo record, @Param("example") PerSkillInfoExample example);

    int updateByExample(@Param("record") PerSkillInfo record, @Param("example") PerSkillInfoExample example);
}