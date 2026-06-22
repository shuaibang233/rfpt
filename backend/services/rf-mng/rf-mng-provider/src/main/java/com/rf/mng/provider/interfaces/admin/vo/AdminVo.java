package com.rf.mng.provider.interfaces.admin.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 管理员前端展示对象。
 */
@Data
public class AdminVo implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** 管理员 ID。 */
    private Long id;

    /** 用户名。 */
    private String username;

    /** 真实姓名。 */
    private String realName;

    /** 是否启用：0-否，1-是。 */
    private Integer enabled;

    /** 角色编码。 */
    private Integer role;

    /** 是否已启用 TOTP。 */
    private Boolean totpEnabled;

    /** 创建时间。 */
    private LocalDateTime gmtCreate;

    /** 修改时间。 */
    private LocalDateTime gmtModified;
}
