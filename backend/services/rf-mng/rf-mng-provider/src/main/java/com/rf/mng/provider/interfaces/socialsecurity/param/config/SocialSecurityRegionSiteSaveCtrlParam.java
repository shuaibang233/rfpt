package com.rf.mng.provider.interfaces.socialsecurity.param.config;

import lombok.Data;

/**
 * 社保缴费地区站点保存参数。
 */
@Data
public class SocialSecurityRegionSiteSaveCtrlParam {
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
}
