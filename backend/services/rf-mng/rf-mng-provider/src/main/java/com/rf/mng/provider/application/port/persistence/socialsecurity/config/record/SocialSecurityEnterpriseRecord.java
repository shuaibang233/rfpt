package com.rf.mng.provider.application.port.persistence.socialsecurity.config.record;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 社保缴费企业读取记录。
 */
@Data
public class SocialSecurityEnterpriseRecord {
    private Long id;
    private String taxNo;
    private String enterpriseName;
    private String regionCode;
    private String securityAccountName;
    private String status;
    private String remark;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
