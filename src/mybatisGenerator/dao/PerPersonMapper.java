package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerPerson;
import mybatisGenerator.javaBean.PerPersonExample;
import org.apache.ibatis.annotations.Param;

public interface PerPersonMapper {
    int countByExample(PerPersonExample example);

    int deleteByExample(PerPersonExample example);

    int insert(PerPerson record);

    int insertSelective(PerPerson record);

    List<PerPerson> selectByExample(PerPersonExample example);

    int updateByExampleSelective(@Param("record") PerPerson record, @Param("example") PerPersonExample example);

    int updateByExample(@Param("record") PerPerson record, @Param("example") PerPersonExample example);
}