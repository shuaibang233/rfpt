package com.rf.performance.provider.application.command.performance.employee;

import lombok.Data;

/**
 * 员工端绩效确认命令。
 */
@Data
public class EmployeePerformanceConfirmCommand {

    /**
     * 员工绩效记录 ID。
     */
    private Long recordId;

    /**
     * 登录手机号。
     */
    private String mobile;

    /**
     * 请求 IP。
     */
    private String ipAddress;

    /**
     * 浏览器 User-Agent。
     */
    private String userAgent;
}
