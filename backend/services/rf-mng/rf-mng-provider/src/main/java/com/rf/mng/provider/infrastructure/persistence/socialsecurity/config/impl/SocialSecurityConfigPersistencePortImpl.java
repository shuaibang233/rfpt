package com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.impl;

import com.rf.mng.provider.application.port.persistence.socialsecurity.config.SocialSecurityConfigPersistencePort;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.data.SocialSecurityEnterpriseData;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.data.SocialSecurityRegionSiteData;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.record.SocialSecurityEnterpriseRecord;
import com.rf.mng.provider.application.port.persistence.socialsecurity.config.record.SocialSecurityRegionSiteRecord;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityEnterpriseQuery;
import com.rf.mng.provider.application.query.socialsecurity.config.SocialSecurityRegionSiteQuery;
import com.rf.mng.provider.infrastructure.persistence.robot.socialsecurity.config.mapper.SocialSecurityConfigMapper;
import com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.entity.SocialSecurityEnterpriseConfigEntity;
import com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.entity.SocialSecurityRegionSiteConfigEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 社保缴费配置持久化实现。
 */
@Repository
public class SocialSecurityConfigPersistencePortImpl implements SocialSecurityConfigPersistencePort {

    /** 社保缴费配置 Mapper。 */
    @Resource
    private SocialSecurityConfigMapper mapper;

    @Override
    public long countEnterprise(SocialSecurityEnterpriseQuery query) {
        return mapper.countEnterprise(query);
    }

    @Override
    public List<SocialSecurityEnterpriseRecord> pageEnterprise(SocialSecurityEnterpriseQuery query) {
        int offset = (query.getPage() - 1) * query.getSize();
        return mapper.pageEnterprise(query, offset, query.getSize()).stream().map(this::toEnterpriseRecord).toList();
    }

    @Override
    public List<SocialSecurityEnterpriseRecord> listActiveEnterpriseByRegion(String regionCode) {
        return mapper.listActiveEnterpriseByRegion(regionCode).stream().map(this::toEnterpriseRecord).toList();
    }

    @Override
    public SocialSecurityEnterpriseRecord findEnterpriseById(Long id) {
        return toEnterpriseRecord(mapper.findEnterpriseById(id));
    }

    @Override
    public SocialSecurityEnterpriseRecord findEnterpriseByTaxNo(String taxNo) {
        return toEnterpriseRecord(mapper.findEnterpriseByTaxNo(taxNo));
    }

    @Override
    public int insertEnterprise(SocialSecurityEnterpriseData data) {
        SocialSecurityEnterpriseConfigEntity entity = toEnterpriseEntity(data);
        int result = mapper.insertEnterprise(entity);
        data.setId(entity.getId());
        return result;
    }

    @Override
    public int updateEnterprise(SocialSecurityEnterpriseData data) {
        return mapper.updateEnterprise(toEnterpriseEntity(data));
    }

    @Override
    public int deleteEnterpriseById(Long id) {
        return mapper.deleteEnterpriseById(id);
    }

    @Override
    public long countRegionSite(SocialSecurityRegionSiteQuery query) {
        return mapper.countRegionSite(query);
    }

    @Override
    public List<SocialSecurityRegionSiteRecord> pageRegionSite(SocialSecurityRegionSiteQuery query) {
        int offset = (query.getPage() - 1) * query.getSize();
        return mapper.pageRegionSite(query, offset, query.getSize()).stream().map(this::toRegionSiteRecord).toList();
    }

    @Override
    public SocialSecurityRegionSiteRecord findRegionSiteById(Long id) {
        return toRegionSiteRecord(mapper.findRegionSiteById(id));
    }

    @Override
    public SocialSecurityRegionSiteRecord findRegionSiteByCodeAndType(String regionCode, String siteType) {
        return toRegionSiteRecord(mapper.findRegionSiteByCodeAndType(regionCode, siteType));
    }

    @Override
    public int insertRegionSite(SocialSecurityRegionSiteData data) {
        SocialSecurityRegionSiteConfigEntity entity = toRegionSiteEntity(data);
        int result = mapper.insertRegionSite(entity);
        data.setId(entity.getId());
        return result;
    }

    @Override
    public int updateRegionSite(SocialSecurityRegionSiteData data) {
        return mapper.updateRegionSite(toRegionSiteEntity(data));
    }

    @Override
    public int deleteRegionSiteById(Long id) {
        return mapper.deleteRegionSiteById(id);
    }

    private SocialSecurityEnterpriseConfigEntity toEnterpriseEntity(SocialSecurityEnterpriseData data) {
        SocialSecurityEnterpriseConfigEntity entity = new SocialSecurityEnterpriseConfigEntity();
        entity.setId(data.getId());
        entity.setTaxNo(data.getTaxNo());
        entity.setEnterpriseName(data.getEnterpriseName());
        entity.setRegionCode(data.getRegionCode());
        entity.setSecurityAccountName(data.getSecurityAccountName());
        entity.setStatus(data.getStatus());
        entity.setRemark(data.getRemark());
        return entity;
    }

    private SocialSecurityEnterpriseRecord toEnterpriseRecord(SocialSecurityEnterpriseConfigEntity entity) {
        if (entity == null) {
            return null;
        }
        SocialSecurityEnterpriseRecord record = new SocialSecurityEnterpriseRecord();
        record.setId(entity.getId());
        record.setTaxNo(entity.getTaxNo());
        record.setEnterpriseName(entity.getEnterpriseName());
        record.setRegionCode(entity.getRegionCode());
        record.setSecurityAccountName(entity.getSecurityAccountName());
        record.setStatus(entity.getStatus());
        record.setRemark(entity.getRemark());
        record.setGmtCreate(entity.getGmtCreate());
        record.setGmtModified(entity.getGmtModified());
        return record;
    }

    private SocialSecurityRegionSiteConfigEntity toRegionSiteEntity(SocialSecurityRegionSiteData data) {
        SocialSecurityRegionSiteConfigEntity entity = new SocialSecurityRegionSiteConfigEntity();
        entity.setId(data.getId());
        entity.setRegionCode(data.getRegionCode());
        entity.setSiteType(data.getSiteType());
        entity.setEtaxEntryUrl(data.getEtaxEntryUrl());
        entity.setTpassBaseUrl(data.getTpassBaseUrl());
        entity.setLoginSuccessUrl(data.getLoginSuccessUrl());
        entity.setLoginButtonText(data.getLoginButtonText());
        entity.setGt4BaseUrl(data.getGt4BaseUrl());
        entity.setDeclarationQueryUrl(data.getDeclarationQueryUrl());
        entity.setDeclarationQueryMenuId(data.getDeclarationQueryMenuId());
        entity.setSocialSecurityPaymentFlowJson(data.getSocialSecurityPaymentFlowJson());
        entity.setStatus(data.getStatus());
        entity.setRemark(data.getRemark());
        return entity;
    }

    private SocialSecurityRegionSiteRecord toRegionSiteRecord(SocialSecurityRegionSiteConfigEntity entity) {
        if (entity == null) {
            return null;
        }
        SocialSecurityRegionSiteRecord record = new SocialSecurityRegionSiteRecord();
        record.setId(entity.getId());
        record.setRegionCode(entity.getRegionCode());
        record.setSiteType(entity.getSiteType());
        record.setEtaxEntryUrl(entity.getEtaxEntryUrl());
        record.setTpassBaseUrl(entity.getTpassBaseUrl());
        record.setLoginSuccessUrl(entity.getLoginSuccessUrl());
        record.setLoginButtonText(entity.getLoginButtonText());
        record.setGt4BaseUrl(entity.getGt4BaseUrl());
        record.setDeclarationQueryUrl(entity.getDeclarationQueryUrl());
        record.setDeclarationQueryMenuId(entity.getDeclarationQueryMenuId());
        record.setSocialSecurityPaymentFlowJson(entity.getSocialSecurityPaymentFlowJson());
        record.setStatus(entity.getStatus());
        record.setRemark(entity.getRemark());
        record.setGmtCreate(entity.getGmtCreate());
        record.setGmtModified(entity.getGmtModified());
        return record;
    }
}
