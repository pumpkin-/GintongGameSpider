package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerGameInfo;
import mybatisGenerator.javaBean.PerGameInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerGameInfoMapper {
    int countByExample(PerGameInfoExample example);

    int deleteByExample(PerGameInfoExample example);

    int insert(PerGameInfo record);

    int insertSelective(PerGameInfo record);

    List<PerGameInfo> selectByExampleWithBLOBs(PerGameInfoExample example);

    List<PerGameInfo> selectByExample(PerGameInfoExample example);

    int updateByExampleSelective(@Param("record") PerGameInfo record, @Param("example") PerGameInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PerGameInfo record, @Param("example") PerGameInfoExample example);

    int updateByExample(@Param("record") PerGameInfo record, @Param("example") PerGameInfoExample example);
}