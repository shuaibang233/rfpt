package com.rf.performance.provider.interfaces.controller.employee.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 员工端绩效反馈参数。
 */
@Data
public class EmployeePerformanceFeedbackCtrlParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 反馈内容。
     */
    private String feedbackContent;
}
