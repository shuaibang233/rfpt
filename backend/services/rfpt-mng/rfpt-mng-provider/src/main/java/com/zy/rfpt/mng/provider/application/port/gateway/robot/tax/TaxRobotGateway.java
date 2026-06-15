package com.zy.rfpt.mng.provider.application.port.gateway.robot.tax;

/**
 * 税务机器人网关。
 */
public interface TaxRobotGateway {

    /**
     * 触发社保缴费任务执行。
     *
     * @param taxNo 纳税人识别号
     * @param siteType 站点类型
     */
    void triggerSocialSecurityPayment(String taxNo, String siteType);
}
