package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgStaffStat;
import mybatisGenerator.javaBean.OrgStaffStatExample;
import org.apache.ibatis.annotations.Param;

public interface OrgStaffStatMapper {
    int countByExample(OrgStaffStatExample example);

    int deleteByExample(OrgStaffStatExample example);

    int insert(OrgStaffStat record);

    int insertSelective(OrgStaffStat record);

    List<OrgStaffStat> selectByExample(OrgStaffStatExample example);

    int updateByExampleSelective(@Param("record") OrgStaffStat record, @Param("example") OrgStaffStatExample example);

    int updateByExample(@Param("record") OrgStaffStat record, @Param("example") OrgStaffStatExample example);
}