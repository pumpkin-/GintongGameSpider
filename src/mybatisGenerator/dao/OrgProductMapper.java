package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgProduct;
import mybatisGenerator.javaBean.OrgProductExample;
import org.apache.ibatis.annotations.Param;

public interface OrgProductMapper {
    int countByExample(OrgProductExample example);

    int deleteByExample(OrgProductExample example);

    int insert(OrgProduct record);

    int insertSelective(OrgProduct record);

    List<OrgProduct> selectByExample(OrgProductExample example);

    int updateByExampleSelective(@Param("record") OrgProduct record, @Param("example") OrgProductExample example);

    int updateByExample(@Param("record") OrgProduct record, @Param("example") OrgProductExample example);
}