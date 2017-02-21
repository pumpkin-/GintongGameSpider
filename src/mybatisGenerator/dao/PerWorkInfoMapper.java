package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerWorkInfo;
import mybatisGenerator.javaBean.PerWorkInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerWorkInfoMapper {
    int countByExample(PerWorkInfoExample example);

    int deleteByExample(PerWorkInfoExample example);

    int insert(PerWorkInfo record);

    int insertSelective(PerWorkInfo record);

    List<PerWorkInfo> selectByExampleWithBLOBs(PerWorkInfoExample example);

    List<PerWorkInfo> selectByExample(PerWorkInfoExample example);

    int updateByExampleSelective(@Param("record") PerWorkInfo record, @Param("example") PerWorkInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PerWorkInfo record, @Param("example") PerWorkInfoExample example);

    int updateByExample(@Param("record") PerWorkInfo record, @Param("example") PerWorkInfoExample example);
}