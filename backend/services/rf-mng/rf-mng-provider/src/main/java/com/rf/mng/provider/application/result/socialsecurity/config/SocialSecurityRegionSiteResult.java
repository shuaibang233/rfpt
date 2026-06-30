package com.rf.mng.provider.application.result.socialsecurity.config;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 社保缴费地区站点结果。
 */
@Data
public class SocialSecurityRegionSiteResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
