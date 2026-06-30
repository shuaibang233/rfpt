package com.rf.mng.provider.interfaces.socialsecurity.param.config;

import lombok.Data;

/**
 * 社保缴费企业保存参数。
 */
@Data
public class SocialSecurityEnterpriseSaveCtrlParam {
    private Long id;
    private String taxNo;
    private String enterpriseName;
    private String regionCode;
    private String securityAccountName;
    private String status;
    private String remark;
}
