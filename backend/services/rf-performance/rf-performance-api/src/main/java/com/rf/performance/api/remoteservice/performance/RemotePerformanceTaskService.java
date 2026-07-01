package com.rf.performance.api.remoteservice.performance;

import com.rf.performance.api.dto.performance.PerformanceTaskDto;
import com.rf.performance.api.param.performance.PerformanceTaskCreateParam;
import com.rf.performance.api.query.performance.PerformanceTaskPageParam;
import com.zy.common.core.bo.PageResp;
import com.zy.common.core.exception.BusinessException;

/**
 * 绩效任务 RPC 服务。
 */
public interface RemotePerformanceTaskService {

    /**
     * 创建绩效任务。
     *
     * @param param 绩效任务创建入参
     * @return 绩效任务信息
     */
    PerformanceTaskDto createTask(PerformanceTaskCreateParam param) throws BusinessException;

    /**
     * 分页查询绩效任务。
     *
     * @param param 绩效任务分页查询入参
     * @return 绩效任务分页
     */
    PageResp<PerformanceTaskDto> pageTasks(PerformanceTaskPageParam param);

    /**
     * 启用绩效任务。
     *
     * @param taskId 绩效任务 ID
     */
    void enableTask(Long taskId) throws BusinessException;

    /**
     * 停用绩效任务。
     *
     * @param taskId 绩效任务 ID
     */
    void disableTask(Long taskId) throws BusinessException;

    /**
     * 删除绩效任务。
     *
     * @param taskId 绩效任务 ID
     */
    void deleteTask(Long taskId) throws BusinessException;
}
