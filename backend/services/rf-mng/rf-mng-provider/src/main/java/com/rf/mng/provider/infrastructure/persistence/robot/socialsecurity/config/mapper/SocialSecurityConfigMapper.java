package com.rf.mng.provider.infrastructure.persistence.robot.socialsecurity.config.mapper;

import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityEnterpriseQuery;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityRegionSiteQuery;
import com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.entity.SocialSecurityEnterpriseConfigEntity;
import com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.entity.SocialSecurityRegionSiteConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 社保缴费配置 Mapper。
 */
@Mapper
public interface SocialSecurityConfigMapper {

    long countEnterprise(@Param("query") SocialSecurityEnterpriseQuery query);

    List<SocialSecurityEnterpriseConfigEntity> pageEnterprise(@Param("query") SocialSecurityEnterpriseQuery query,
                                                             @Param("offset") int offset,
                                                             @Param("limit") int limit);

    List<SocialSecurityEnterpriseConfigEntity> listActiveEnterpriseByRegion(@Param("regionCode") String regionCode);

    SocialSecurityEnterpriseConfigEntity findEnterpriseById(@Param("id") Long id);

    SocialSecurityEnterpriseConfigEntity findEnterpriseByTaxNo(@Param("taxNo") String taxNo);

    int insertEnterprise(SocialSecurityEnterpriseConfigEntity entity);

    int updateEnterprise(SocialSecurityEnterpriseConfigEntity entity);

    int deleteEnterpriseById(@Param("id") Long id);

    long countRegionSite(@Param("query") SocialSecurityRegionSiteQuery query);

    List<SocialSecurityRegionSiteConfigEntity> pageRegionSite(@Param("query") SocialSecurityRegionSiteQuery query,
                                                              @Param("offset") int offset,
                                                              @Param("limit") int limit);

    SocialSecurityRegionSiteConfigEntity findRegionSiteById(@Param("id") Long id);

    SocialSecurityRegionSiteConfigEntity findRegionSiteByCodeAndType(@Param("regionCode") String regionCode,
                                                                      @Param("siteType") String siteType);

    int insertRegionSite(SocialSecurityRegionSiteConfigEntity entity);

    int updateRegionSite(SocialSecurityRegionSiteConfigEntity entity);

    int deleteRegionSiteById(@Param("id") Long id);
}
