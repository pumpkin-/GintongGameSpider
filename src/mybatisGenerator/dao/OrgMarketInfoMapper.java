package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgMarketInfo;
import mybatisGenerator.javaBean.OrgMarketInfoExample;
import org.apache.ibatis.annotations.Param;

public interface OrgMarketInfoMapper {
    int countByExample(OrgMarketInfoExample example);

    int deleteByExample(OrgMarketInfoExample example);

    int insert(OrgMarketInfo record);

    int insertSelective(OrgMarketInfo record);

    List<OrgMarketInfo> selectByExample(OrgMarketInfoExample example);

    int updateByExampleSelective(@Param("record") OrgMarketInfo record, @Param("example") OrgMarketInfoExample example);

    int updateByExample(@Param("record") OrgMarketInfo record, @Param("example") OrgMarketInfoExample example);
}