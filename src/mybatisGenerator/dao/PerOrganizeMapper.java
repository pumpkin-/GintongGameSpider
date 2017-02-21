package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerOrganize;
import mybatisGenerator.javaBean.PerOrganizeExample;
import org.apache.ibatis.annotations.Param;

public interface PerOrganizeMapper {
    int countByExample(PerOrganizeExample example);

    int deleteByExample(PerOrganizeExample example);

    int insert(PerOrganize record);

    int insertSelective(PerOrganize record);

    List<PerOrganize> selectByExample(PerOrganizeExample example);

    int updateByExampleSelective(@Param("record") PerOrganize record, @Param("example") PerOrganizeExample example);

    int updateByExample(@Param("record") PerOrganize record, @Param("example") PerOrganizeExample example);
}