package com.rf.performance.provider.application.command.performance.employee;

import lombok.Data;

/**
 * 员工端绩效登录命令。
 */
@Data
public class EmployeePerformanceLoginCommand {

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 短信验证码。
     */
    private String smsCode;

    /**
     * 请求 IP。
     */
    private String ipAddress;

    /**
     * 浏览器 User-Agent。
     */
    private String userAgent;
}
