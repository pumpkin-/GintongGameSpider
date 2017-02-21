package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.ProGameInfo;
import mybatisGenerator.javaBean.ProGameInfoExample;
import mybatisGenerator.javaBean.ProGameInfoWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface ProGameInfoMapper {
    int countByExample(ProGameInfoExample example);

    int deleteByExample(ProGameInfoExample example);

    int insert(ProGameInfoWithBLOBs record);

    int insertSelective(ProGameInfoWithBLOBs record);

    List<ProGameInfoWithBLOBs> selectByExampleWithBLOBs(ProGameInfoExample example);

    List<ProGameInfo> selectByExample(ProGameInfoExample example);

    int updateByExampleSelective(@Param("record") ProGameInfoWithBLOBs record, @Param("example") ProGameInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ProGameInfoWithBLOBs record, @Param("example") ProGameInfoExample example);

    int updateByExample(@Param("record") ProGameInfo record, @Param("example") ProGameInfoExample example);
}