package com.rf.mng.provider.interfaces.admin.param;

import com.zy.common.core.bo.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理员分页请求参数。
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AdminPageCtrlParam extends PageQuery {

    /** 用户名。 */
    private String username;

    /** 真实姓名。 */
    private String realName;

    /** 角色编码。 */
    private Integer role;
}
