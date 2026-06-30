package com.rf.mng.provider.application.command.socialsecurity.config;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 社保缴费企业保存命令。
 */
@Data
public class SocialSecurityEnterpriseSaveCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** 主键编号。 */
    private Long id;
    /** 纳税人识别号。 */
    private String taxNo;
    /** 企业名称。 */
    private String enterpriseName;
    /** 地区编码。 */
    private String regionCode;
    /** 社保账户名。 */
    private String securityAccountName;
    /** 状态：active/disabled。 */
    private String status;
    /** 备注。 */
    private String remark;
}
