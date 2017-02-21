package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgFrameworkInfo;
import mybatisGenerator.javaBean.OrgFrameworkInfoExample;
import org.apache.ibatis.annotations.Param;

public interface OrgFrameworkInfoMapper {
    int countByExample(OrgFrameworkInfoExample example);

    int deleteByExample(OrgFrameworkInfoExample example);

    int insert(OrgFrameworkInfo record);

    int insertSelective(OrgFrameworkInfo record);

    List<OrgFrameworkInfo> selectByExample(OrgFrameworkInfoExample example);

    int updateByExampleSelective(@Param("record") OrgFrameworkInfo record, @Param("example") OrgFrameworkInfoExample example);

    int updateByExample(@Param("record") OrgFrameworkInfo record, @Param("example") OrgFrameworkInfoExample example);
}