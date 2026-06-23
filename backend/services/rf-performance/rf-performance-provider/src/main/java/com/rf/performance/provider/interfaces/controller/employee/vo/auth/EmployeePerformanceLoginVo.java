package com.rf.performance.provider.interfaces.controller.employee.vo.auth;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 员工端绩效登录返回对象。
 */
@Data
public class EmployeePerformanceLoginVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 手机号。
     */
    private String mobile;
}
