package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.BasPersonInfo;
import mybatisGenerator.javaBean.BasPersonInfoExample;
import mybatisGenerator.javaBean.BasPersonInfoWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface BasPersonInfoMapper {
    int countByExample(BasPersonInfoExample example);

    int deleteByExample(BasPersonInfoExample example);

    int insert(BasPersonInfoWithBLOBs record);

    int insertSelective(BasPersonInfoWithBLOBs record);

    List<BasPersonInfoWithBLOBs> selectByExampleWithBLOBs(BasPersonInfoExample example);

    List<BasPersonInfo> selectByExample(BasPersonInfoExample example);

    int updateByExampleSelective(@Param("record") BasPersonInfoWithBLOBs record, @Param("example") BasPersonInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BasPersonInfoWithBLOBs record, @Param("example") BasPersonInfoExample example);

    int updateByExample(@Param("record") BasPersonInfo record, @Param("example") BasPersonInfoExample example);
}