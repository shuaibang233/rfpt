package com.rf.performance.provider.infrastructure.persistence.performance.mapper;

import com.rf.performance.provider.application.port.persistence.performance.record.employee.EmployeePerformanceClientRecord;
import com.rf.performance.provider.infrastructure.persistence.performance.entity.employee.PerformanceConfirmLogEntity;
import com.rf.performance.provider.infrastructure.persistence.performance.entity.employee.PerformanceFeedbackEntity;
import com.rf.performance.provider.infrastructure.persistence.performance.entity.employee.PerformanceSmsEvidenceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工端绩效 Mapper。
 */
@Mapper
public interface EmployeePerformanceClientMapper {

    /**
     * 查询指定任务下首次确认待自动确认记录。
     *
     * @param taskIds 绩效任务 ID
     * @param limit 最大数量
     * @return 员工绩效记录
     */
    List<EmployeePerformanceClientRecord> listPendingFirstConfirmRecordsByTaskIds(@Param("taskIds") List<Long> taskIds,
                                                                              @Param("limit") int limit);

    /**
     * 查询指定任务下二次确认待自动确认记录。
     *
     * @param taskIds 绩效任务 ID
     * @param limit 最大数量
     * @return 员工绩效记录
     */
    List<EmployeePerformanceClientRecord> listPendingSecondConfirmRecordsByTaskIds(@Param("taskIds") List<Long> taskIds,
                                                                               @Param("limit") int limit);

    /**
     * 按手机号查询员工绩效记录。
     *
     * @param mobile 员工手机号
     * @return 员工绩效记录
     */
    List<EmployeePerformanceClientRecord> listByMobile(String mobile);

    /**
     * 按 ID 和手机号查询员工绩效记录。
     *
     * @param id 员工绩效记录 ID
     * @param mobile 员工手机号
     * @return 员工绩效记录
     */
    EmployeePerformanceClientRecord getByIdAndMobile(@Param("id") Long id, @Param("mobile") String mobile);

    /**
     * 新增短信验证留痕。
     *
     * @param entity 短信验证留痕实体
     * @return 影响行数
     */
    int insertSmsEvidence(PerformanceSmsEvidenceEntity entity);

    /**
     * 查询最新短信验证留痕。
     *
     * @param mobile 手机号
     * @param scene 短信场景
     * @return 短信验证留痕
     */
    PerformanceSmsEvidenceEntity getLatestSmsEvidence(@Param("mobile") String mobile, @Param("scene") String scene);

    /**
     * 标记短信验证通过。
     *
     * @param entity 短信验证留痕实体
     * @return 影响行数
     */
    int markSmsVerified(PerformanceSmsEvidenceEntity entity);

    /**
     * 新增确认留痕。
     *
     * @param entity 确认留痕实体
     * @return 影响行数
     */
    int insertConfirmLog(PerformanceConfirmLogEntity entity);

    /**
     * 批量新增确认留痕。
     *
     * @param entities 确认留痕实体
     * @return 影响行数
     */
    int batchInsertConfirmLog(@Param("entities") List<PerformanceConfirmLogEntity> entities);

    /**
     * 更新员工绩效记录为已确认。
     *
     * @param id 员工绩效记录 ID
     * @param mobile 员工手机号
     * @param confirmStatus 确认状态
     * @return 影响行数
     */
    int markConfirmed(@Param("id") Long id, @Param("mobile") String mobile, @Param("confirmStatus") String confirmStatus);

    /**
     * 批量自动确认。
     *
     * @param ids 员工绩效记录 ID
     * @param confirmStatus 确认状态
     * @return 影响行数
     */
    int batchMarkAutoConfirmed(@Param("ids") List<Long> ids, @Param("confirmStatus") String confirmStatus);

    /**
     * 新增员工反馈。
     *
     * @param entity 员工反馈实体
     * @return 影响行数
     */
    int insertFeedback(PerformanceFeedbackEntity entity);

    /**
     * 更新员工绩效记录为已反馈。
     *
     * @param id 员工绩效记录 ID
     * @param mobile 员工手机号
     * @return 影响行数
     */
    int markFeedbackSubmitted(@Param("id") Long id, @Param("mobile") String mobile);
}
