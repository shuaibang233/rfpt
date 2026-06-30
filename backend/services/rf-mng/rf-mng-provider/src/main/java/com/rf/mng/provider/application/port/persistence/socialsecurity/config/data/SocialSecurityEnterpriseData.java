package com.rf.mng.provider.application.port.persistence.socialsecurity.config.data;

import lombok.Data;

/**
 * 社保缴费企业写入数据。
 */
@Data
public class SocialSecurityEnterpriseData {
    private Long id;
    private String taxNo;
    private String enterpriseName;
    private String regionCode;
    private String securityAccountName;
    private String status;
    private String remark;
}
