package com.rf.mng.provider.application.result.admin;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员 TOTP 密钥结果。
 */
@Data
public class AdminTotpResult implements Serializable {

    /** 序列化版本号。 */
    @Serial
    private static final long serialVersionUID = 1L;

    /** TOTP 原始密钥。 */
    private String secret;

    /** TOTP 二维码 URI。 */
    private String qrCodeUri;

    /** 用户名。 */
    private String username;
}
