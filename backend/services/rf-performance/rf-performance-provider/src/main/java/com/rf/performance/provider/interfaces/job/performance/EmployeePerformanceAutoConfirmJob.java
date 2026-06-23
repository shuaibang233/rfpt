package com.rf.performance.provider.interfaces.job.performance;

import com.rf.performance.provider.application.manager.performance.employee.EmployeePerformanceClientManager;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 员工绩效超期自动确认 XXL-JOB。
 */
@Slf4j
@Component
public class EmployeePerformanceAutoConfirmJob {

    /**
     * 员工端绩效应用编排。
     */
    @Resource
    private EmployeePerformanceClientManager employeePerformanceClientManager;

    /**
     * 自动确认超期未操作的绩效记录。
     */
    @XxlJob("employeePerformanceAutoConfirmJob")
    public void execute() {
        try {
            int processed = employeePerformanceClientManager.autoConfirmExpiredRecords(500);
            if (processed > 0) {
                log.info("员工绩效自动确认完成, processed={}", processed);
            }
        } catch (Exception ex) {
            log.warn("员工绩效自动确认任务异常", ex);
            throw ex;
        }
    }
}
