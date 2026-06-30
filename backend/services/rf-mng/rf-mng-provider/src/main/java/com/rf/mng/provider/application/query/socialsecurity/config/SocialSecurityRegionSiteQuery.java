package com.rf.mng.provider.application.query.socialsecurity.config;

import com.zy.common.core.bo.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社保缴费地区站点分页查询。
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SocialSecurityRegionSiteQuery extends PageQuery {

    /** 地区编码。 */
    private String regionCode;
    /** 站点类型。 */
    private String siteType;
    /** 状态。 */
    private String status;
}
