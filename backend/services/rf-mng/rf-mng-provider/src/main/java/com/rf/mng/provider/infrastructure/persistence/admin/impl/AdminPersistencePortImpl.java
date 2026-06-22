package com.rf.mng.provider.infrastructure.persistence.admin.impl;

import com.rf.mng.provider.application.port.persistence.admin.AdminPersistencePort;
import com.rf.mng.provider.application.port.persistence.admin.data.AdminData;
import com.rf.mng.provider.application.port.persistence.admin.record.AdminRecord;
import com.rf.mng.provider.application.query.admin.AdminPageQuery;
import com.rf.mng.provider.infrastructure.persistence.admin.entity.AdminEntity;
import com.rf.mng.provider.infrastructure.persistence.platform.admin.mapper.AdminMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员持久化端口实现。
 */
@Repository
public class AdminPersistencePortImpl implements AdminPersistencePort {

    /** 管理员 Mapper。 */
    @Resource
    private AdminMapper adminMapper;

    /**
     * 按用户名查询管理员。
     *
     * @param username 用户名
     * @return 管理员记录，不存在时返回空
     */
    @Override
    public AdminRecord getByUsername(String username) {
        return toRecord(adminMapper.selectByUsername(username));
    }

    /**
     * 按 ID 查询管理员。
     *
     * @param id 管理员 ID
     * @return 管理员记录，不存在时返回空
     */
    @Override
    public AdminRecord getById(Long id) {
        return toRecord(adminMapper.selectById(id));
    }

    /**
     * 统计管理员数量。
     *
     * @param query 查询条件
     * @return 数量
     */
    @Override
    public long count(AdminPageQuery query) {
        return adminMapper.count(query);
    }

    /**
     * 分页查询管理员。
     *
     * @param query 查询条件
     * @return 管理员记录列表
     */
    @Override
    public List<AdminRecord> page(AdminPageQuery query) {
        int offset = Math.max(query.getPage() - 1, 0) * query.getSize();
        List<AdminEntity> entities = adminMapper.page(query, offset, query.getSize());
        return entities.stream().map(this::toRecord).toList();
    }

    /**
     * 新增管理员。
     *
     * @param data 管理员写入数据
     * @return 影响行数
     */
    @Override
    public int insert(AdminData data) {
        AdminEntity entity = toEntity(data);
        int result = adminMapper.insert(entity);
        data.setId(entity.getId());
        return result;
    }

    /**
     * 更新管理员基础信息。
     *
     * @param data 管理员写入数据
     * @return 影响行数
     */
    @Override
    public int update(AdminData data) {
        return adminMapper.update(toEntity(data));
    }

    /**
     * 更新管理员 TOTP 密钥。
     *
     * @param id 管理员 ID
     * @param otpSecret TOTP 密钥，空值表示禁用
     * @return 影响行数
     */
    @Override
    public int updateOtpSecret(Long id, String otpSecret) {
        return adminMapper.updateOtpSecret(id, otpSecret);
    }

    /**
     * 删除管理员。
     *
     * @param id 管理员 ID
     * @return 影响行数
     */
    @Override
    public int deleteById(Long id) {
        return adminMapper.deleteById(id);
    }

    /**
     * 转换管理员实体。
     *
     * @param data 管理员写入数据
     * @return 管理员实体
     */
    private AdminEntity toEntity(AdminData data) {
        AdminEntity entity = new AdminEntity();
        entity.setId(data.getId());
        entity.setUsername(data.getUsername());
        entity.setRealName(data.getRealName());
        entity.setPassword(data.getPassword());
        entity.setOtpSecret(data.getOtpSecret());
        entity.setEnabled(data.getEnabled());
        entity.setRole(data.getRole());
        return entity;
    }

    /**
     * 转换管理员读取记录。
     *
     * @param entity 管理员实体
     * @return 管理员记录
     */
    private AdminRecord toRecord(AdminEntity entity) {
        if (entity == null) {
            return null;
        }
        AdminRecord record = new AdminRecord();
        record.setId(entity.getId());
        record.setUsername(entity.getUsername());
        record.setRealName(entity.getRealName());
        record.setPassword(entity.getPassword());
        record.setOtpSecret(entity.getOtpSecret());
        record.setEnabled(entity.getEnabled());
        record.setRole(entity.getRole());
        record.setGmtCreate(entity.getGmtCreate());
        record.setGmtModified(entity.getGmtModified());
        return record;
    }
}
