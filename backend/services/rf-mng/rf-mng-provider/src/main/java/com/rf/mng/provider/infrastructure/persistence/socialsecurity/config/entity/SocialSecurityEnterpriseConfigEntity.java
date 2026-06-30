package com.rf.mng.provider.infrastructure.persistence.socialsecurity.config.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 社保缴费企业配置实体。
 */
@Data
public class SocialSecurityEnterpriseConfigEntity {
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
