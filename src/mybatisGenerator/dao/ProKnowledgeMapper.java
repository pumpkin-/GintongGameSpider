package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.ProKnowledge;
import mybatisGenerator.javaBean.ProKnowledgeExample;
import org.apache.ibatis.annotations.Param;

public interface ProKnowledgeMapper {
    int countByExample(ProKnowledgeExample example);

    int deleteByExample(ProKnowledgeExample example);

    int insert(ProKnowledge record);

    int insertSelective(ProKnowledge record);

    List<ProKnowledge> selectByExampleWithBLOBs(ProKnowledgeExample example);

    List<ProKnowledge> selectByExample(ProKnowledgeExample example);

    int updateByExampleSelective(@Param("record") ProKnowledge record, @Param("example") ProKnowledgeExample example);

    int updateByExampleWithBLOBs(@Param("record") ProKnowledge record, @Param("example") ProKnowledgeExample example);

    int updateByExample(@Param("record") ProKnowledge record, @Param("example") ProKnowledgeExample example);
}