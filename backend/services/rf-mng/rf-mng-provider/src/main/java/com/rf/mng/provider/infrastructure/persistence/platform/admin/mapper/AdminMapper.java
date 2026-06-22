package com.rf.mng.provider.infrastructure.persistence.platform.admin.mapper;

import com.rf.mng.provider.infrastructure.persistence.admin.entity.AdminEntity;
import com.rf.mng.provider.application.query.admin.AdminPageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员 Mapper。
 */
public interface AdminMapper {

    /**
     * 按用户名查询管理员。
     *
     * @param username 用户名
     * @return 管理员实体
     */
    AdminEntity selectByUsername(@Param("username") String username);

    /**
     * 按 ID 查询管理员。
     *
     * @param id 管理员 ID
     * @return 管理员实体
     */
    AdminEntity selectById(@Param("id") Long id);

    /**
     * 统计管理员数量。
     *
     * @param query 查询条件
     * @return 数量
     */
    long count(@Param("query") AdminPageQuery query);

    /**
     * 分页查询管理员。
     *
     * @param query 查询条件
     * @param offset 偏移量
     * @param limit 条数
     * @return 管理员实体列表
     */
    List<AdminEntity> page(@Param("query") AdminPageQuery query, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 新增管理员。
     *
     * @param entity 管理员实体
     * @return 影响行数
     */
    int insert(AdminEntity entity);

    /**
     * 更新管理员。
     *
     * @param entity 管理员实体
     * @return 影响行数
     */
    int update(AdminEntity entity);

    /**
     * 更新 TOTP 密钥。
     *
     * @param id 管理员 ID
     * @param otpSecret TOTP 密钥
     * @return 影响行数
     */
    int updateOtpSecret(@Param("id") Long id, @Param("otpSecret") String otpSecret);

    /**
     * 删除管理员。
     *
     * @param id 管理员 ID
     * @return 影响行数
     */
    int deleteById(@Param("id") Long id);
}
