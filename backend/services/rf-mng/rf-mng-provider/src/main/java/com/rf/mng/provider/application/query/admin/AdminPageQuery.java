package com.rf.mng.provider.application.query.admin;

import com.zy.common.core.bo.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理员分页查询。
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AdminPageQuery extends PageQuery {

    /** 用户名。 */
    private String username;

    /** 真实姓名。 */
    private String realName;

    /** 角色编码。 */
    private Integer role;
}
