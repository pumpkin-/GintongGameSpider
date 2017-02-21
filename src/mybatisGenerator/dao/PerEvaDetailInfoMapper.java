package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerEvaDetailInfo;
import mybatisGenerator.javaBean.PerEvaDetailInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerEvaDetailInfoMapper {
    int countByExample(PerEvaDetailInfoExample example);

    int deleteByExample(PerEvaDetailInfoExample example);

    int insert(PerEvaDetailInfo record);

    int insertSelective(PerEvaDetailInfo record);

    List<PerEvaDetailInfo> selectByExample(PerEvaDetailInfoExample example);

    int updateByExampleSelective(@Param("record") PerEvaDetailInfo record, @Param("example") PerEvaDetailInfoExample example);

    int updateByExample(@Param("record") PerEvaDetailInfo record, @Param("example") PerEvaDetailInfoExample example);
}