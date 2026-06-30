package com.rf.mng.provider.application.command.socialsecurity.config;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 社保缴费地区站点保存命令。
 */
@Data
public class SocialSecurityRegionSiteSaveCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** 主键编号。 */
    private Long id;
    /** 地区编码。 */
    private String regionCode;
    /** 站点类型。 */
    private String siteType;
    /** 电子税务局入口地址。 */
    private String etaxEntryUrl;
    /** 统一身份认证域名。 */
    private String tpassBaseUrl;
    /** 登录成功地址特征。 */
    private String loginSuccessUrl;
    /** 登录按钮文案。 */
    private String loginButtonText;
    /** 地方特色基础地址。 */
    private String gt4BaseUrl;
    /** 申报缴费查询地址。 */
    private String declarationQueryUrl;
    /** 申报缴费菜单编号。 */
    private String declarationQueryMenuId;
    /** 社保缴费流程 JSON。 */
    private String socialSecurityPaymentFlowJson;
    /** 状态：active/disabled。 */
    private String status;
    /** 备注。 */
    private String remark;
}
