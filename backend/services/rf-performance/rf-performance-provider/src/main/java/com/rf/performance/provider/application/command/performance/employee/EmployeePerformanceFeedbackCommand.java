package com.rf.performance.provider.application.command.performance.employee;

import lombok.Data;

/**
 * 员工端绩效反馈命令。
 */
@Data
public class EmployeePerformanceFeedbackCommand {

    /**
     * 员工绩效记录 ID。
     */
    private Long recordId;

    /**
     * 登录手机号。
     */
    private String mobile;

    /**
     * 反馈内容。
     */
    private String feedbackContent;

    /**
     * 请求 IP。
     */
    private String ipAddress;

    /**
     * 浏览器 User-Agent。
     */
    private String userAgent;
}
