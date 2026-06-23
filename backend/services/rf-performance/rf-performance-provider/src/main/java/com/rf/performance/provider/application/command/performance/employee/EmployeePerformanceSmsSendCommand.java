package com.rf.performance.provider.application.command.performance.employee;

import lombok.Data;

/**
 * 员工端绩效短信发送命令。
 */
@Data
public class EmployeePerformanceSmsSendCommand {

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 短信场景。
     */
    private String scene;

    /**
     * 图形验证码凭证。
     */
    private String captchaTraceId;

    /**
     * 请求 IP。
     */
    private String ipAddress;

    /**
     * 浏览器 User-Agent。
     */
    private String userAgent;
}
