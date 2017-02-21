package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgDemandMap;
import mybatisGenerator.javaBean.OrgDemandMapExample;
import org.apache.ibatis.annotations.Param;

public interface OrgDemandMapMapper {
    int countByExample(OrgDemandMapExample example);

    int deleteByExample(OrgDemandMapExample example);

    int insert(OrgDemandMap record);

    int insertSelective(OrgDemandMap record);

    List<OrgDemandMap> selectByExampleWithBLOBs(OrgDemandMapExample example);

    List<OrgDemandMap> selectByExample(OrgDemandMapExample example);

    int updateByExampleSelective(@Param("record") OrgDemandMap record, @Param("example") OrgDemandMapExample example);

    int updateByExampleWithBLOBs(@Param("record") OrgDemandMap record, @Param("example") OrgDemandMapExample example);

    int updateByExample(@Param("record") OrgDemandMap record, @Param("example") OrgDemandMapExample example);
}