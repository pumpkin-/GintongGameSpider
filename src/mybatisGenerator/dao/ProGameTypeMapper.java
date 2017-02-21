package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.ProGameType;
import mybatisGenerator.javaBean.ProGameTypeExample;
import org.apache.ibatis.annotations.Param;

public interface ProGameTypeMapper {
    int countByExample(ProGameTypeExample example);

    int deleteByExample(ProGameTypeExample example);

    int insert(ProGameType record);

    int insertSelective(ProGameType record);

    List<ProGameType> selectByExample(ProGameTypeExample example);

    int updateByExampleSelective(@Param("record") ProGameType record, @Param("example") ProGameTypeExample example);

    int updateByExample(@Param("record") ProGameType record, @Param("example") ProGameTypeExample example);
}