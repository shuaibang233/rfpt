package com.rf.performance.provider.interfaces.controller.employee.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 员工端绩效短信发送参数。
 */
@Data
public class EmployeePerformanceSmsSendCtrlParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
}
