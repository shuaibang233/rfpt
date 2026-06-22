package com.rf.mng.provider.application.port.persistence.admin;

import com.rf.mng.provider.application.port.persistence.admin.data.AdminData;
import com.rf.mng.provider.application.port.persistence.admin.record.AdminRecord;
import com.rf.mng.provider.application.query.admin.AdminPageQuery;

import java.util.List;

/**
 * 管理员持久化端口。
 */
public interface AdminPersistencePort {

    /**
     * 按用户名查询管理员。
     *
     * @param username 用户名
     * @return 管理员记录，不存在时返回空
     */
    AdminRecord getByUsername(String username);

    /**
     * 按 ID 查询管理员。
     *
     * @param id 管理员 ID
     * @return 管理员记录，不存在时返回空
     */
    AdminRecord getById(Long id);

    /**
     * 统计管理员数量。
     *
     * @param query 查询条件
     * @return 数量
     */
    long count(AdminPageQuery query);

    /**
     * 分页查询管理员。
     *
     * @param query 查询条件
     * @return 管理员记录列表
     */
    List<AdminRecord> page(AdminPageQuery query);

    /**
     * 新增管理员。
     *
     * @param data 管理员写入数据
     * @return 影响行数
     */
    int insert(AdminData data);

    /**
     * 更新管理员基础信息。
     *
     * @param data 管理员写入数据
     * @return 影响行数
     */
    int update(AdminData data);

    /**
     * 更新管理员 TOTP 密钥。
     *
     * @param id 管理员 ID
     * @param otpSecret TOTP 密钥，空值表示禁用
     * @return 影响行数
     */
    int updateOtpSecret(Long id, String otpSecret);

    /**
     * 删除管理员。
     *
     * @param id 管理员 ID
     * @return 影响行数
     */
    int deleteById(Long id);
}
