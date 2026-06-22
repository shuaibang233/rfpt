package com.rf.mng.provider.interfaces.admin.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员保存请求参数。
 */
@Data
public class AdminSaveCtrlParam implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** 管理员 ID，新增时为空。 */
    private Long id;

    /** 用户名。 */
    private String username;

    /** 真实姓名。 */
    private String realName;

    /** 明文密码，编辑时为空表示不修改。 */
    private String password;

    /** 是否启用：0-否，1-是。 */
    private Integer enabled;

    /** 角色编码。 */
    private Integer role;
}
