package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgContractInfo;
import mybatisGenerator.javaBean.OrgContractInfoExample;
import org.apache.ibatis.annotations.Param;

public interface OrgContractInfoMapper {
    int countByExample(OrgContractInfoExample example);

    int deleteByExample(OrgContractInfoExample example);

    int insert(OrgContractInfo record);

    int insertSelective(OrgContractInfo record);

    List<OrgContractInfo> selectByExample(OrgContractInfoExample example);

    int updateByExampleSelective(@Param("record") OrgContractInfo record, @Param("example") OrgContractInfoExample example);

    int updateByExample(@Param("record") OrgContractInfo record, @Param("example") OrgContractInfoExample example);
}