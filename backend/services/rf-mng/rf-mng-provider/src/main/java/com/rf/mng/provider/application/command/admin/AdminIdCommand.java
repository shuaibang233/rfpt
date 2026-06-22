package com.rf.mng.provider.application.command.admin;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员 ID 操作命令。
 */
@Data
public class AdminIdCommand implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** 管理员 ID。 */
    private Long id;
}
