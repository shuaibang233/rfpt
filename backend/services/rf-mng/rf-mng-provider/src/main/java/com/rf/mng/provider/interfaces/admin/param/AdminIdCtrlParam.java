package com.rf.mng.provider.interfaces.admin.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员 ID 请求参数。
 */
@Data
public class AdminIdCtrlParam implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** 管理员 ID。 */
    private Long id;

    /** 兼容 TOTP 接口使用的用户 ID。 */
    private Long userId;
}
