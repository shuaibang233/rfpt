package com.rf.performance.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 员工绩效服务应用。
 */
@EnableDubbo
@SpringBootApplication
public class RfPerformanceApplication {

    /**
     * 应用入口。
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(RfPerformanceApplication.class, args);
    }
}
