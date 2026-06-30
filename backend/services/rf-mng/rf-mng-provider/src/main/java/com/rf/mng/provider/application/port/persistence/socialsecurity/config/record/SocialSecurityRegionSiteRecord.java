package com.rf.mng.provider.application.port.persistence.socialsecurity.config.record;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 社保缴费地区站点读取记录。
 */
@Data
public class SocialSecurityRegionSiteRecord {
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
