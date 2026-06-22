package com.rf.performance.provider.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 员工绩效 H5 登录配置。
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "rf.performance.h5.auth")
public class PerformanceH5AuthProperties {

    /**
     * 登录 Cookie 名称。
     */
    private String cookieName = "RF_PERFORMANCE_MOBILE";

    /**
     * 登录 Cookie 有效秒数。
     */
    private Integer cookieMaxAgeSeconds = 7 * 24 * 60 * 60;
}
