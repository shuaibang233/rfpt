package com.rf.mng.provider.application.result.socialsecurity.config;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 社保缴费企业结果。
 */
@Data
public class SocialSecurityEnterpriseResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
