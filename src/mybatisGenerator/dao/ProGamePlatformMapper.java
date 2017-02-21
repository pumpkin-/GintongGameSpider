package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.ProGamePlatform;
import mybatisGenerator.javaBean.ProGamePlatformExample;
import org.apache.ibatis.annotations.Param;

public interface ProGamePlatformMapper {
    int countByExample(ProGamePlatformExample example);

    int deleteByExample(ProGamePlatformExample example);

    int insert(ProGamePlatform record);

    int insertSelective(ProGamePlatform record);

    List<ProGamePlatform> selectByExample(ProGamePlatformExample example);

    int updateByExampleSelective(@Param("record") ProGamePlatform record, @Param("example") ProGamePlatformExample example);

    int updateByExample(@Param("record") ProGamePlatform record, @Param("example") ProGamePlatformExample example);
}