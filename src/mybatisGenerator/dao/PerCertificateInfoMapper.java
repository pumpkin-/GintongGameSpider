package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.PerCertificateInfo;
import mybatisGenerator.javaBean.PerCertificateInfoExample;
import org.apache.ibatis.annotations.Param;

public interface PerCertificateInfoMapper {
    int countByExample(PerCertificateInfoExample example);

    int deleteByExample(PerCertificateInfoExample example);

    int insert(PerCertificateInfo record);

    int insertSelective(PerCertificateInfo record);

    List<PerCertificateInfo> selectByExample(PerCertificateInfoExample example);

    int updateByExampleSelective(@Param("record") PerCertificateInfo record, @Param("example") PerCertificateInfoExample example);

    int updateByExample(@Param("record") PerCertificateInfo record, @Param("example") PerCertificateInfoExample example);
}