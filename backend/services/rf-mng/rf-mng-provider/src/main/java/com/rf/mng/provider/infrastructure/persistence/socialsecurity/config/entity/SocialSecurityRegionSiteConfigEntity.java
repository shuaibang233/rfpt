package com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 社保缴费地区站点配置实体。
 */
@Data
public class SocialSecurityRegionSiteConfigEntity {
    private Long id;
    private String regionCode;
    private String siteType;
    private String etaxEntryUrl;
    private String tpassBaseUrl;
    private String loginSuccessUrl;
    private String loginButtonText;
    private String gt4BaseUrl;
    private String declarationQueryUrl;
    private String declarationQueryMenuId;
    private String socialSecurityPaymentFlowJson;
    private String status;
    private String remark;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
