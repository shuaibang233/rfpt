package com.rf.performance.provider.interfaces.controller.employee.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 员工端绩效登录参数。
 */
@Data
public class EmployeePerformanceLoginCtrlParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 短信验证码。
     */
    private String smsCode;
}
