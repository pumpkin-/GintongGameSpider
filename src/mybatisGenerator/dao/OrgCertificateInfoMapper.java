package mybatisGenerator.dao;

import java.util.List;
import mybatisGenerator.javaBean.OrgCertificateInfo;
import mybatisGenerator.javaBean.OrgCertificateInfoExample;
import org.apache.ibatis.annotations.Param;

public interface OrgCertificateInfoMapper {
    int countByExample(OrgCertificateInfoExample example);

    int deleteByExample(OrgCertificateInfoExample example);

    int insert(OrgCertificateInfo record);

    int insertSelective(OrgCertificateInfo record);

    List<OrgCertificateInfo> selectByExample(OrgCertificateInfoExample example);

    int updateByExampleSelective(@Param("record") OrgCertificateInfo record, @Param("example") OrgCertificateInfoExample example);

    int updateByExample(@Param("record") OrgCertificateInfo record, @Param("example") OrgCertificateInfoExample example);
}