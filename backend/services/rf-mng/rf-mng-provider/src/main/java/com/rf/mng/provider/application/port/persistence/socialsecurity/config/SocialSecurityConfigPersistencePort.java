package com.rf.mng.provider.application.port.persistence.socialsecurity.config;

import com.rf.mng.provider.application.port.persistence.socialsecurity.config.data.SocialSecurityEnterpriseData;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.data.SocialSecurityRegionSiteData;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.record.SocialSecurityEnterpriseRecord;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.record.SocialSecurityRegionSiteRecord;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityEnterpriseQuery;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityRegionSiteQuery;

import java.util.List;

/**
 * 社保缴费配置持久化端口。
 */
public interface SocialSecurityConfigPersistencePort {

    long countEnterprise(SocialSecurityEnterpriseQuery query);

    List<SocialSecurityEnterpriseRecord> pageEnterprise(SocialSecurityEnterpriseQuery query);

    List<SocialSecurityEnterpriseRecord> listActiveEnterpriseByRegion(String regionCode);

    SocialSecurityEnterpriseRecord findEnterpriseById(Long id);

    SocialSecurityEnterpriseRecord findEnterpriseByTaxNo(String taxNo);

    int insertEnterprise(SocialSecurityEnterpriseData data);

    int updateEnterprise(SocialSecurityEnterpriseData data);

    int deleteEnterpriseById(Long id);

    long countRegionSite(SocialSecurityRegionSiteQuery query);

    List<SocialSecurityRegionSiteRecord> pageRegionSite(SocialSecurityRegionSiteQuery query);

    SocialSecurityRegionSiteRecord findRegionSiteById(Long id);

    SocialSecurityRegionSiteRecord findRegionSiteByCodeAndType(String regionCode, String siteType);

    int insertRegionSite(SocialSecurityRegionSiteData data);

    int updateRegionSite(SocialSecurityRegionSiteData data);

    int deleteRegionSiteById(Long id);
}
