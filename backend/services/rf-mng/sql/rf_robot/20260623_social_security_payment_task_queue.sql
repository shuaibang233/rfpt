-- 社保缴费机器人协作队列改造。
-- 数据库：rf_robot
-- 说明：普通 DDL 脚本，不使用存储过程，不使用检查查询，不使用动态 SQL。
-- 现有表已包含 started_at、finished_at、result_body、idx_batch_status，本脚本只补协作领取字段和必要索引。
-- 注意：本脚本按当前线上表结构执行一次；重复执行会因字段或索引已存在而报错。

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD COLUMN `site_type` varchar(32) NOT NULL DEFAULT 'default' COMMENT '站点类型' AFTER `region_code`;

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD COLUMN `worker_id` varchar(64) DEFAULT NULL COMMENT '领取任务的机器人编号' AFTER `max_retry_count`;

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD COLUMN `claimed_at` datetime DEFAULT NULL COMMENT '机器人领取时间' AFTER `worker_id`;

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD COLUMN `heartbeat_at` datetime DEFAULT NULL COMMENT '机器人心跳时间' AFTER `claimed_at`;

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD INDEX `idx_task_status_id` (`task_status`, `id`);

ALTER TABLE `tb_tax_social_security_payment_task`
  ADD INDEX `idx_worker_status` (`worker_id`, `task_status`);
