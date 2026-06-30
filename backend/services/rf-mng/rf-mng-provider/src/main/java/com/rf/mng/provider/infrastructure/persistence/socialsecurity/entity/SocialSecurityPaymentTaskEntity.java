package com.rf.mng.provider.infrastructure.persistence.socialsecurity.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 社保缴费任务实体。
 */
@Data
public class SocialSecurityPaymentTaskEntity implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** 主键编号。 */
    private Long id;
    /** 批次编号。 */
    private Long batchId;
    /** 纳税人识别号。 */
    private String taxNo;
    /** 企业名称。 */
    private String enterpriseName;
    /** 社保账号名称。 */
    private String securityAccountName;
    /** 地区编码。 */
    private String regionCode;
    /** 站点类型，机器人领取任务后用于选择站点。 */
    private String siteType;
    /** 费款所属月份。 */
    private String periodMonth;
    /** 任务状态，对应 task_status。 */
    private String status;
    /** 应缴总额，对应 tax_total_amount。 */
    private BigDecimal payableAmount;
    /** WPM 合计金额。 */
    private BigDecimal wpmTotalAmount;
    /** 一致性校验状态。 */
    private String compareStatus;
    /** 缴费状态。 */
    private String paymentStatus;
    /** 完税凭证状态。 */
    private String certificateStatus;
    /** BMS 反馈状态。 */
    private String bmsFeedbackStatus;
    /** BMS 反馈阶段。 */
    private String bmsFeedbackStage;
    /** BMS 反馈错误信息。 */
    private String bmsFeedbackErrorMessage;
    /** 诊断目录。 */
    private String diagnosticDir;
    /** 失败编码。 */
    private String errorCode;
    /** 失败原因。 */
    private String errorMessage;
    /** 是否可重试。 */
    private Boolean retryable;
    /** 重试次数。 */
    private Integer retryCount;
    /** 最大重试次数。 */
    private Integer maxRetryCount;
    /** 领取任务的机器人编号。 */
    private String workerId;
    /** 机器人领取时间。 */
    private LocalDateTime claimedAt;
    /** 机器人心跳时间。 */
    private LocalDateTime heartbeatAt;
    /** 机器人开始执行时间。 */
    private LocalDateTime startedAt;
    /** 机器人完成时间。 */
    private LocalDateTime finishedAt;
    /** 机器人回写任务结果，对应 result_body。 */
    private String resultPayload;
    /** 一致性校验结果 JSON。 */
    private String compareResultPayload;
    /** 缴费结果 JSON。 */
    private String paymentResultPayload;
    /** 凭证结果 JSON。 */
    private String certificateResultPayload;
    /** BMS 反馈结果 JSON。 */
    private String bmsFeedbackResultPayload;
    /** 创建管理员ID。 */
    private Long createAdminId;
    /** 创建管理员名称。 */
    private String createAdminName;
    /** 创建时间。 */
    private LocalDateTime gmtCreate;
    /** 修改时间。 */
    private LocalDateTime gmtModified;
}
