package com.rf.mng.provider.infrastructure.persistence.socialsecurity.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 社保缴费任务批次汇总实体。
 */
@Data
public class SocialSecurityPaymentTaskSummaryEntity implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** 批次编号。 */
    private Long batchId;

    /** 任务总数。 */
    private Integer totalCount;

    /** 待领取数量。 */
    private Integer pendingCount;

    /** 执行中数量。 */
    private Integer processingCount;

    /** 成功数量。 */
    private Integer successCount;

    /** 失败数量。 */
    private Integer failedCount;

    /** 取消数量。 */
    private Integer canceledCount;
}
