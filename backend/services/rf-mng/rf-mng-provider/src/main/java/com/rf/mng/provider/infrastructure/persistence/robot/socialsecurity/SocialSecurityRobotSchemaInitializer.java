package com.rf.mng.provider.infrastructure.persistence.robot.socialsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * 社保缴费机器人协作表结构初始化器。
 */
@Slf4j
@Component
public class SocialSecurityRobotSchemaInitializer implements ApplicationRunner {

    /** 社保缴费机器人任务表。 */
    private static final String TASK_TABLE = "tb_tax_social_security_payment_task";

    /** 机器人协作库 JDBC 访问器。 */
    private final JdbcTemplate jdbcTemplate;

    /** 是否启用机器人协作表结构初始化。 */
    @Value("${rf.robot.schema-init.enabled:true}")
    private boolean enabled;

    /**
     * 创建社保缴费机器人协作表结构初始化器。
     *
     * @param robotDataSource 机器人协作库数据源
     */
    public SocialSecurityRobotSchemaInitializer(@Qualifier("robotDataSource") DataSource robotDataSource) {
        this.jdbcTemplate = new JdbcTemplate(robotDataSource);
    }

    @Override
    public void run(ApplicationArguments args) {
        if (!enabled) {
            log.info("社保缴费机器人协作表结构初始化已关闭");
            return;
        }
        if (!tableExists(TASK_TABLE)) {
            log.warn("社保缴费机器人任务表不存在，跳过协作字段初始化，table={}", TASK_TABLE);
            return;
        }
        for (ColumnDefinition column : robotQueueColumns()) {
            addColumnIfMissing(column);
        }
        for (IndexDefinition index : robotQueueIndexes()) {
            addIndexIfMissing(index);
        }
    }

    /**
     * 判断数据表是否存在。
     *
     * @param tableName 表名
     * @return 是否存在
     */
    private boolean tableExists(String tableName) {
        Long count = jdbcTemplate.queryForObject("""
                SELECT COUNT(1)
                FROM information_schema.TABLES
                WHERE TABLE_SCHEMA = DATABASE()
                  AND TABLE_NAME = ?
                """, Long.class, tableName);
        return count != null && count > 0;
    }

    /**
     * 缺失时新增字段。
     *
     * @param column 字段定义
     */
    private void addColumnIfMissing(ColumnDefinition column) {
        if (columnExists(TASK_TABLE, column.name())) {
            return;
        }
        jdbcTemplate.execute("ALTER TABLE `" + TASK_TABLE + "` ADD COLUMN " + column.ddl());
        log.info("社保缴费机器人任务表字段已补齐，column={}", column.name());
    }

    /**
     * 判断字段是否存在。
     *
     * @param tableName 表名
     * @param columnName 字段名
     * @return 是否存在
     */
    private boolean columnExists(String tableName, String columnName) {
        Long count = jdbcTemplate.queryForObject("""
                SELECT COUNT(1)
                FROM information_schema.COLUMNS
                WHERE TABLE_SCHEMA = DATABASE()
                  AND TABLE_NAME = ?
                  AND COLUMN_NAME = ?
                """, Long.class, tableName, columnName);
        return count != null && count > 0;
    }

    /**
     * 缺失时新增索引。
     *
     * @param index 索引定义
     */
    private void addIndexIfMissing(IndexDefinition index) {
        if (indexExists(TASK_TABLE, index.name())) {
            return;
        }
        jdbcTemplate.execute("ALTER TABLE `" + TASK_TABLE + "` " + index.ddl());
        log.info("社保缴费机器人任务表索引已补齐，index={}", index.name());
    }

    /**
     * 判断索引是否存在。
     *
     * @param tableName 表名
     * @param indexName 索引名
     * @return 是否存在
     */
    private boolean indexExists(String tableName, String indexName) {
        Long count = jdbcTemplate.queryForObject("""
                SELECT COUNT(1)
                FROM information_schema.STATISTICS
                WHERE TABLE_SCHEMA = DATABASE()
                  AND TABLE_NAME = ?
                  AND INDEX_NAME = ?
                """, Long.class, tableName, indexName);
        return count != null && count > 0;
    }

    /**
     * 获取机器人队列字段定义。
     *
     * @return 字段定义列表
     */
    private List<ColumnDefinition> robotQueueColumns() {
        return List.of(
                new ColumnDefinition("site_type", "`site_type` varchar(32) NOT NULL DEFAULT 'default' COMMENT '站点类型' AFTER `region_code`"),
                new ColumnDefinition("worker_id", "`worker_id` varchar(64) DEFAULT NULL COMMENT '领取任务的机器人编号' AFTER `max_retry_count`"),
                new ColumnDefinition("claimed_at", "`claimed_at` datetime DEFAULT NULL COMMENT '机器人领取时间' AFTER `worker_id`"),
                new ColumnDefinition("heartbeat_at", "`heartbeat_at` datetime DEFAULT NULL COMMENT '机器人心跳时间' AFTER `claimed_at`"),
                new ColumnDefinition("started_at", "`started_at` datetime DEFAULT NULL COMMENT '机器人开始执行时间' AFTER `heartbeat_at`"),
                new ColumnDefinition("finished_at", "`finished_at` datetime DEFAULT NULL COMMENT '机器人完成时间' AFTER `started_at`"),
                new ColumnDefinition("result_payload", "`result_payload` json DEFAULT NULL COMMENT '机器人回写结果明细' AFTER `finished_at`")
        );
    }

    /**
     * 获取机器人队列索引定义。
     *
     * @return 索引定义列表
     */
    private List<IndexDefinition> robotQueueIndexes() {
        return List.of(
                new IndexDefinition("idx_task_status_id", "ADD INDEX `idx_task_status_id` (`task_status`, `id`)"),
                new IndexDefinition("idx_worker_status", "ADD INDEX `idx_worker_status` (`worker_id`, `task_status`)"),
                new IndexDefinition("idx_batch_status", "ADD INDEX `idx_batch_status` (`batch_id`, `task_status`)")
        );
    }

    /**
     * 字段定义。
     *
     * @param name 字段名
     * @param ddl 字段 DDL
     */
    private record ColumnDefinition(String name, String ddl) {
    }

    /**
     * 索引定义。
     *
     * @param name 索引名
     * @param ddl 索引 DDL
     */
    private record IndexDefinition(String name, String ddl) {
    }
}
