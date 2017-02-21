package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.BugData;
import mybatisGenerator.javaBean.BugDataExample;
import org.apache.ibatis.annotations.Param;

public interface BugDataMapper {
    int countByExample(BugDataExample example);

    int deleteByExample(BugDataExample example);

    int insert(BugData record);

    int insertSelective(BugData record);

    List<BugData> selectByExampleWithBLOBs(BugDataExample example);

    List<BugData> selectByExample(BugDataExample example);

    int updateByExampleSelective(@Param("record") BugData record, @Param("example") BugDataExample example);

    int updateByExampleWithBLOBs(@Param("record") BugData record, @Param("example") BugDataExample example);

    int updateByExample(@Param("record") BugData record, @Param("example") BugDataExample example);
}