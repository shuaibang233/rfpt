package com.rf.mng.provider.application.query.socialsecurity.config;

import com.zy.common.core.bo.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社保缴费企业分页查询。
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SocialSecurityEnterpriseQuery extends PageQuery {

    /** 纳税人识别号。 */
    private String taxNo;
    /** 企业名称。 */
    private String enterpriseName;
    /** 地区编码。 */
    private String regionCode;
    /** 状态。 */
    private String status;
}
