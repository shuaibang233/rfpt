package com.rf.mng.provider.application.manager.admin;

import com.rf.mng.provider.application.command.admin.AdminIdCommand;
import com.rf.mng.provider.application.command.admin.AdminSaveCommand;
import com.rf.mng.provider.application.query.admin.AdminPageQuery;
import com.rf.mng.provider.application.result.admin.AdminResult;
import com.rf.mng.provider.application.result.admin.AdminTotpResult;
import com.zy.common.core.bo.PageResp;

/**
 * 管理员应用管理器。
 */
public interface AdminManager {

    /**
     * 分页查询管理员。
     *
     * @param query 查询参数
     * @return 管理员分页
     */
    PageResp<AdminResult> page(AdminPageQuery query);

    /**
     * 新增管理员。
     *
     * @param command 保存命令
     * @return 管理员结果
     */
    AdminResult save(AdminSaveCommand command);

    /**
     * 更新管理员。
     *
     * @param command 保存命令
     * @return 管理员结果
     */
    AdminResult update(AdminSaveCommand command);

    /**
     * 删除管理员。
     *
     * @param command ID 命令
     */
    void delete(AdminIdCommand command);

    /**
     * 生成管理员 TOTP 密钥。
     *
     * @param command ID 命令
     * @return TOTP 密钥结果
     */
    AdminTotpResult generateTotp(AdminIdCommand command);

    /**
     * 禁用管理员 TOTP。
     *
     * @param command ID 命令
     */
    void disableTotp(AdminIdCommand command);
}
