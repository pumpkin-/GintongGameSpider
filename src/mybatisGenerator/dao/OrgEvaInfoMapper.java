package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgEvaInfo;
import mybatisGenerator.javaBean.OrgEvaInfoExample;
import org.apache.ibatis.annotations.Param;

public interface OrgEvaInfoMapper {
    int countByExample(OrgEvaInfoExample example);

    int deleteByExample(OrgEvaInfoExample example);

    int insert(OrgEvaInfo record);

    int insertSelective(OrgEvaInfo record);

    List<OrgEvaInfo> selectByExample(OrgEvaInfoExample example);

    int updateByExampleSelective(@Param("record") OrgEvaInfo record, @Param("example") OrgEvaInfoExample example);

    int updateByExample(@Param("record") OrgEvaInfo record, @Param("example") OrgEvaInfoExample example);
}