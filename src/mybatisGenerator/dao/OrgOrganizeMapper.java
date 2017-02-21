package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgOrganize;
import mybatisGenerator.javaBean.OrgOrganizeExample;
import org.apache.ibatis.annotations.Param;

public interface OrgOrganizeMapper {
    int countByExample(OrgOrganizeExample example);

    int deleteByExample(OrgOrganizeExample example);

    int insert(OrgOrganize record);

    int insertSelective(OrgOrganize record);

    List<OrgOrganize> selectByExample(OrgOrganizeExample example);

    int updateByExampleSelective(@Param("record") OrgOrganize record, @Param("example") OrgOrganizeExample example);

    int updateByExample(@Param("record") OrgOrganize record, @Param("example") OrgOrganizeExample example);
}