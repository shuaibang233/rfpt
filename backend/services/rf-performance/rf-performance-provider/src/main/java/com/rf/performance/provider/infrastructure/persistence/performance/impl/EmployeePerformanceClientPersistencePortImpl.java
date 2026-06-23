package com.rf.performance.provider.infrastructure.persistence.performance.impl;

import cn.hutool.core.bean.BeanUtil;
import com.rf.performance.provider.application.port.persistence.performance.EmployeePerformanceClientPersistencePort;
import com.rf.performance.provider.application.port.persistence.performance.data.employee.PerformanceConfirmLogData;
import com.rf.performance.provider.application.port.persistence.performance.data.employee.PerformanceFeedbackData;
import com.rf.performance.provider.application.port.persistence.performance.data.employee.PerformanceSmsEvidenceData;
import com.rf.performance.provider.application.port.persistence.performance.record.employee.EmployeePerformanceClientRecord;
import com.rf.performance.provider.infrastructure.persistence.performance.entity.employee.PerformanceConfirmLogEntity;
import com.rf.performance.provider.infrastructure.persistence.performance.entity.employee.PerformanceFeedbackEntity;
import com.rf.performance.provider.infrastructure.persistence.performance.entity.employee.PerformanceSmsEvidenceEntity;
import com.rf.performance.provider.infrastructure.persistence.performance.mapper.EmployeePerformanceClientMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工端绩效持久化端口实现。
 */
@Repository
public class EmployeePerformanceClientPersistencePortImpl implements EmployeePerformanceClientPersistencePort {

    /**
     * 员工端绩效 Mapper。
     */
    @Resource
    private EmployeePerformanceClientMapper employeePerformanceClientMapper;

    /**
     * 查询指定任务下首次确认待自动确认记录。
     *
     * @param taskIds 绩效任务 ID
     * @param limit 最大数量
     * @return 员工绩效记录
     */
    @Override
    public List<EmployeePerformanceClientRecord> listPendingFirstConfirmRecordsByTaskIds(List<Long> taskIds, int limit) {
        if (taskIds == null || taskIds.isEmpty()) {
            return List.of();
        }
        return employeePerformanceClientMapper.listPendingFirstConfirmRecordsByTaskIds(taskIds, limit);
    }

    /**
     * 查询指定任务下二次确认待自动确认记录。
     *
     * @param taskIds 绩效任务 ID
     * @param limit 最大数量
     * @return 员工绩效记录
     */
    @Override
    public List<EmployeePerformanceClientRecord> listPendingSecondConfirmRecordsByTaskIds(List<Long> taskIds, int limit) {
        if (taskIds == null || taskIds.isEmpty()) {
            return List.of();
        }
        return employeePerformanceClientMapper.listPendingSecondConfirmRecordsByTaskIds(taskIds, limit);
    }

    /**
     * 按手机号查询员工绩效记录。
     *
     * @param mobile 员工手机号
     * @return 员工绩效记录
     */
    @Override
    public List<EmployeePerformanceClientRecord> listByMobile(String mobile) {
        return employeePerformanceClientMapper.listByMobile(mobile);
    }

    /**
     * 按 ID 和手机号查询员工绩效记录。
     *
     * @param id 员工绩效记录 ID
     * @param mobile 员工手机号
     * @return 员工绩效记录
     */
    @Override
    public EmployeePerformanceClientRecord getByIdAndMobile(Long id, String mobile) {
        return employeePerformanceClientMapper.getByIdAndMobile(id, mobile);
    }

    /**
     * 新增短信验证留痕。
     *
     * @param data 短信验证留痕写入数据
     * @return 短信验证留痕 ID
     */
    @Override
    public Long insertSmsEvidence(PerformanceSmsEvidenceData data) {
        PerformanceSmsEvidenceEntity entity = BeanUtil.copyProperties(data, PerformanceSmsEvidenceEntity.class);
        employeePerformanceClientMapper.insertSmsEvidence(entity);
        return entity.getId();
    }

    /**
     * 查询最新短信验证留痕。
     *
     * @param mobile 手机号
     * @param scene 短信场景
     * @return 短信验证留痕
     */
    @Override
    public PerformanceSmsEvidenceData getLatestSmsEvidence(String mobile, String scene) {
        PerformanceSmsEvidenceEntity entity = employeePerformanceClientMapper.getLatestSmsEvidence(mobile, scene);
        if (entity == null) {
            return null;
        }
        return BeanUtil.copyProperties(entity, PerformanceSmsEvidenceData.class);
    }

    /**
     * 标记短信验证通过。
     *
     * @param data 短信验证留痕写入数据
     * @return 是否更新成功
     */
    @Override
    public boolean markSmsVerified(PerformanceSmsEvidenceData data) {
        PerformanceSmsEvidenceEntity entity = BeanUtil.copyProperties(data, PerformanceSmsEvidenceEntity.class);
        return employeePerformanceClientMapper.markSmsVerified(entity) > 0;
    }

    /**
     * 新增确认留痕。
     *
     * @param data 确认留痕写入数据
     * @return 是否新增成功
     */
    @Override
    public boolean insertConfirmLog(PerformanceConfirmLogData data) {
        PerformanceConfirmLogEntity entity = BeanUtil.copyProperties(data, PerformanceConfirmLogEntity.class);
        return employeePerformanceClientMapper.insertConfirmLog(entity) > 0;
    }

    /**
     * 批量新增确认留痕。
     *
     * @param dataList 确认留痕写入数据
     * @return 影响行数
     */
    @Override
    public int batchInsertConfirmLog(List<PerformanceConfirmLogData> dataList) {
        List<PerformanceConfirmLogEntity> entities = BeanUtil.copyToList(dataList, PerformanceConfirmLogEntity.class);
        return employeePerformanceClientMapper.batchInsertConfirmLog(entities);
    }

    /**
     * 更新员工绩效记录为已确认。
     *
     * @param id 员工绩效记录 ID
     * @param mobile 员工手机号
     * @param confirmStatus 确认状态
     * @return 是否更新成功
     */
    @Override
    public boolean markConfirmed(Long id, String mobile, String confirmStatus) {
        return employeePerformanceClientMapper.markConfirmed(id, mobile, confirmStatus) > 0;
    }

    /**
     * 批量自动确认。
     *
     * @param ids 员工绩效记录 ID
     * @param confirmStatus 确认状态
     * @return 影响行数
     */
    @Override
    public int batchMarkAutoConfirmed(List<Long> ids, String confirmStatus) {
        return employeePerformanceClientMapper.batchMarkAutoConfirmed(ids, confirmStatus);
    }

    /**
     * 新增员工反馈。
     *
     * @param data 反馈写入数据
     * @return 是否新增成功
     */
    @Override
    public boolean insertFeedback(PerformanceFeedbackData data) {
        PerformanceFeedbackEntity entity = BeanUtil.copyProperties(data, PerformanceFeedbackEntity.class);
        entity.setIsDeleted(0);
        return employeePerformanceClientMapper.insertFeedback(entity) > 0;
    }

    /**
     * 更新员工绩效记录为已反馈。
     *
     * @param id 员工绩效记录 ID
     * @param mobile 员工手机号
     * @return 是否更新成功
     */
    @Override
    public boolean markFeedbackSubmitted(Long id, String mobile) {
        return employeePerformanceClientMapper.markFeedbackSubmitted(id, mobile) > 0;
    }
}
