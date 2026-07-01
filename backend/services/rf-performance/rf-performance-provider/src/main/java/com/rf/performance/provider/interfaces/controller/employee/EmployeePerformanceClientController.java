package com.rf.performance.provider.interfaces.controller.employee;

import cn.hutool.core.bean.BeanUtil;
import com.rf.performance.provider.application.command.performance.employee.EmployeePerformanceConfirmCommand;
import com.rf.performance.provider.application.command.performance.employee.EmployeePerformanceFeedbackCommand;
import com.rf.performance.provider.application.manager.performance.employee.EmployeePerformanceClientManager;
import com.rf.performance.provider.application.result.performance.employee.EmployeePerformanceClientResult;
import com.rf.performance.provider.common.web.EmployeePerformanceRequestContext;
import com.rf.performance.provider.interfaces.controller.employee.param.EmployeePerformanceFeedbackCtrlParam;
import com.rf.performance.provider.interfaces.controller.employee.vo.EmployeePerformanceRecordVo;
import com.zy.common.core.bo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.List;

/**
 * 员工端绩效控制器。
 */
@RestController
@RequestMapping("/performance/employee/records")
public class EmployeePerformanceClientController {

    /**
     * 员工端绩效应用编排。
     */
    @Resource
    private EmployeePerformanceClientManager employeePerformanceClientManager;

    /**
     * 员工端绩效请求上下文。
     */
    @Resource
    private EmployeePerformanceRequestContext employeePerformanceRequestContext;

    /**
     * 查询当前员工绩效记录。
     *
     * @param request HTTP 请求
     * @return 当前员工绩效记录列表
     */
    @GetMapping("/mine")
    public Result<List<EmployeePerformanceRecordVo>> listMine(@RequestParam(required = false, defaultValue = "false") Boolean includeHistory,
                                                              HttpServletRequest request) {
        String mobile = employeePerformanceRequestContext.requireMobile(request);
        List<EmployeePerformanceClientResult> results = employeePerformanceClientManager.listMine(mobile, Boolean.TRUE.equals(includeHistory));
        return Result.success(BeanUtil.copyToList(results, EmployeePerformanceRecordVo.class));
    }

    /**
     * 确认绩效。
     *
     * @param recordId 员工绩效记录 ID
     * @param request HTTP 请求
     * @return 空结果
     */
    @PostMapping("/{recordId}/confirm")
    public Result<Void> confirm(@PathVariable Long recordId,
                                HttpServletRequest request) {
        EmployeePerformanceConfirmCommand command = new EmployeePerformanceConfirmCommand();
        command.setRecordId(recordId);
        command.setMobile(employeePerformanceRequestContext.requireMobile(request));
        command.setIpAddress(employeePerformanceRequestContext.clientIp(request));
        command.setUserAgent(employeePerformanceRequestContext.userAgent(request));
        employeePerformanceClientManager.confirm(command);
        return Result.success();
    }

    /**
     * 提交绩效反馈。
     *
     * @param recordId 员工绩效记录 ID
     * @param param 反馈参数
     * @param request HTTP 请求
     * @return 空结果
     */
    @PostMapping("/{recordId}/feedback")
    public Result<Void> feedback(@PathVariable Long recordId,
                                 @RequestBody EmployeePerformanceFeedbackCtrlParam param,
                                 HttpServletRequest request) {
        EmployeePerformanceFeedbackCommand command = new EmployeePerformanceFeedbackCommand();
        command.setRecordId(recordId);
        command.setMobile(employeePerformanceRequestContext.requireMobile(request));
        command.setFeedbackContent(param == null ? null : param.getFeedbackContent());
        command.setIpAddress(employeePerformanceRequestContext.clientIp(request));
        command.setUserAgent(employeePerformanceRequestContext.userAgent(request));
        employeePerformanceClientManager.feedback(command);
        return Result.success();
    }
}
