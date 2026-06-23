-- 社保缴费机器人协作队列改造人工兜底脚本。
-- 数据库：rf_robot
-- 说明：正式环境默认由 rf-mng 启动时的 Java 初始化逻辑幂等补齐字段和索引；
-- 如需人工执行，请先确认字段和索引不存在，本脚本不使用存储过程。

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD COLUMN `site_type` varchar(32) NOT NULL DEFAULT 'default' COMMENT '站点类型' AFTER `region_code`,
  ADD COLUMN `worker_id` varchar(64) DEFAULT NULL COMMENT '领取任务的机器人编号' AFTER `max_retry_count`,
  ADD COLUMN `claimed_at` datetime DEFAULT NULL COMMENT '机器人领取时间' AFTER `worker_id`,
  ADD COLUMN `heartbeat_at` datetime DEFAULT NULL COMMENT '机器人心跳时间' AFTER `claimed_at`,
  ADD COLUMN `started_at` datetime DEFAULT NULL COMMENT '机器人开始执行时间' AFTER `heartbeat_at`,
  ADD COLUMN `finished_at` datetime DEFAULT NULL COMMENT '机器人完成时间' AFTER `started_at`,
  ADD COLUMN `result_payload` json DEFAULT NULL COMMENT '机器人回写结果明细' AFTER `finished_at`;

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD INDEX `idx_task_status_id` (`task_status`, `id`),
  ADD INDEX `idx_worker_status` (`worker_id`, `task_status`),
  ADD INDEX `idx_batch_status` (`batch_id`, `task_status`);

-- 机器人领取任务示例：更新成功 1 行才表示领取成功，避免多机器人重复执行。
-- UPDATE tb_tax_social_security_payment_task
-- SET task_status = 'PROCESSING',
--     worker_id = ?,
--     claimed_at = NOW(),
--     heartbeat_at = NOW(),
--     started_at = NOW()
-- WHERE id = ?
--   AND task_status = 'PENDING';
