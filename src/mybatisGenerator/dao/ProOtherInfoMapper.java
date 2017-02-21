package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.ProOtherInfo;
import mybatisGenerator.javaBean.ProOtherInfoExample;
import org.apache.ibatis.annotations.Param;

public interface ProOtherInfoMapper {
    int countByExample(ProOtherInfoExample example);

    int deleteByExample(ProOtherInfoExample example);

    int insert(ProOtherInfo record);

    int insertSelective(ProOtherInfo record);

    List<ProOtherInfo> selectByExampleWithBLOBs(ProOtherInfoExample example);

    List<ProOtherInfo> selectByExample(ProOtherInfoExample example);

    int updateByExampleSelective(@Param("record") ProOtherInfo record, @Param("example") ProOtherInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ProOtherInfo record, @Param("example") ProOtherInfoExample example);

    int updateByExample(@Param("record") ProOtherInfo record, @Param("example") ProOtherInfoExample example);
}