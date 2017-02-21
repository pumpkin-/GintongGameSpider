package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerKnowledge;
import mybatisGenerator.javaBean.PerKnowledgeExample;
import org.apache.ibatis.annotations.Param;

public interface PerKnowledgeMapper {
    int countByExample(PerKnowledgeExample example);

    int deleteByExample(PerKnowledgeExample example);

    int insert(PerKnowledge record);

    int insertSelective(PerKnowledge record);

    List<PerKnowledge> selectByExample(PerKnowledgeExample example);

    int updateByExampleSelective(@Param("record") PerKnowledge record, @Param("example") PerKnowledgeExample example);

    int updateByExample(@Param("record") PerKnowledge record, @Param("example") PerKnowledgeExample example);
}