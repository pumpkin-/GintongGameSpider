package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.BasOrganizeInfo;
import mybatisGenerator.javaBean.BasOrganizeInfoExample;
import mybatisGenerator.javaBean.BasOrganizeInfoWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface BasOrganizeInfoMapper {
    int countByExample(BasOrganizeInfoExample example);

    int deleteByExample(BasOrganizeInfoExample example);

    int insert(BasOrganizeInfoWithBLOBs record);

    int insertSelective(BasOrganizeInfoWithBLOBs record);

    List<BasOrganizeInfoWithBLOBs> selectByExampleWithBLOBs(BasOrganizeInfoExample example);

    List<BasOrganizeInfo> selectByExample(BasOrganizeInfoExample example);

    int updateByExampleSelective(@Param("record") BasOrganizeInfoWithBLOBs record, @Param("example") BasOrganizeInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BasOrganizeInfoWithBLOBs record, @Param("example") BasOrganizeInfoExample example);

    int updateByExample(@Param("record") BasOrganizeInfo record, @Param("example") BasOrganizeInfoExample example);
}