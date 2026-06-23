package com.rf.mng.provider.application.port.persistence.socialsecurity;

import com.rf.mng.provider.application.port.persistence.socialsecurity.data.SocialSecurityPaymentTaskData;
import com.rf.mng.provider.application.port.persistence.socialsecurity.record.SocialSecurityPaymentTaskRecord;
import com.rf.mng.provider.application.port.persistence.socialsecurity.record.SocialSecurityPaymentTaskSummaryRecord;
import com.rf.mng.provider.application.query.socialsecurity.SocialSecurityPaymentTaskQuery;

import java.util.List;

/**
 * 社保缴费任务持久化端口。
 */
public interface SocialSecurityPaymentTaskPersistencePort {

    /** 批量新增任务。 */
    int batchInsert(List<SocialSecurityPaymentTaskData> records);

    /** 按编号查询任务。 */
    SocialSecurityPaymentTaskRecord findById(Long id);

    /** 标记待重试并等待机器人重新领取。 */
    int markRetry(Long id);

    /** 按批次编号汇总任务状态。 */
    List<SocialSecurityPaymentTaskSummaryRecord> listSummaryByBatchIds(List<Long> batchIds);

    /** 按条件统计任务数。 */
    long count(SocialSecurityPaymentTaskQuery query);

    /** 按条件分页查询任务。 */
    List<SocialSecurityPaymentTaskRecord> page(SocialSecurityPaymentTaskQuery query);

}
