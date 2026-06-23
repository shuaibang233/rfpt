package com.rf.performance.provider.interfaces.controller.employee.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 员工端绩效确认参数。
 */
@Data
public class EmployeePerformanceConfirmCtrlParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 短信验证码。
     */
    private String smsCode;
}
